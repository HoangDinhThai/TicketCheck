package CheckTiket.UI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Authen_Screen_Validation_Page extends BaseTest {
	// Dùng cho POM
	public Authen_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void verifyDefaultValue(By locator, String expectedValue, String fieldName) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String actualValue = element.getText();
		Assert.assertEquals(actualValue, expectedValue,
				"❌ Giá trị mặc định của [" + fieldName + "] không đúng. Thực tế: " + actualValue);
	}
	
	// Element của màn Setting
	public final By settingBtn = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By dialogPassword = By.xpath("//android.widget.EditText");
	public final By okDialogPassword = By.xpath("//android.widget.Button");
	public final By authenticate = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By ugrent = By.xpath("//android.widget.ScrollView/android.view.View[3]");
	public final By ugrent_options = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By ugrent_OK = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By okDone = By.xpath("//android.widget.Button");

	// Element để vào màn xác thực TOP
	public final By auth_authFooter = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[9]");
	public final By auth_useAuthen = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By auth_useTicketCheck = By.xpath("//android.widget.TextView[@text=\"チケットチェック\"]");
	public final By auth_gate1 = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authGate = By.xpath("//android.widget.ScrollView/android.view.View[2]");

	// Element chuyển sang màn TOP
	public final By footerTOP = By.xpath("//android.widget.TextView[@text=\"TOP\"]");

	public void checkDispalySwitchWithAuthenNormal() {
		clickElement(auth_authFooter);
		pause(200);
		clickElement(auth_gate1);
		pause(200);
		clickElement(auth_authGate);
		pause(200);
		scrollDown(1);
		checkAllSwitchOnce();
	}

	public void checkDispalySwitchWithAuthenUrgent() {
		clickElement(hamburgerMenu);
		pause(200);
		clickElement(settingBtn);
		pause(200);
		inputElement(dialogPassword, "jl");
		pause(100);
		clickElement(okDialogPassword);
		pause(200);
		clickElement(authenticate);
		pause(200);
		clickElement(ugrent);
		pause(200);
		clickElement(ugrent_options);
		pause(200);
		clickElement(ugrent_OK);
		pause(200);
		scrollDown(1);
		clickElement(oKBtn);
		pause(200);
		clickElement(okDone);
		pause(200);
		checkAllSwitchOnce();
		System.out.println("");
	}

	public void checkDispalySwitchWithTicketCheck() {
		scrollUp(1);
		clickElement(auth_useAuthen);
		pause(200);
		clickElement(auth_useTicketCheck);
		pause(200);
		scrollDown(1);
		checkAllSwitchOnce();
	}

	public void changeScreen() {
		clickElement(footerTOP);
		pause(200);
		inputElement(dialogPassword, "jl");
		pause(100);
		clickElement(okDialogPassword);
		pause(200);
	}
}
