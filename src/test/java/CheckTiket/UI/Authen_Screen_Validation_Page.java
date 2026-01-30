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

	// 🔍 ELEMENT TITLE
	public final By titleAuth = By.xpath("(//android.widget.TextView[@text=\"認証\"])[1]");
	public final By eventInfoAuth = By.xpath("//android.widget.TextView[@text=\"イベント情報\"]");
	public final By eventNameAuth = By.xpath("//android.widget.TextView[@text=\"イベント名\"]");
	public final By dateEventAuth = By.xpath("//android.widget.TextView[@text=\"開催日付\"]");
	public final By settingAuth = By.xpath("//android.widget.TextView[@text=\"設定\"]");
	public final By usemodeAuth = By.xpath("//android.widget.TextView[@text=\"利用形態\"]");
	public final By gateAuth = By.xpath("//android.widget.TextView[@text=\"設置ゲート\"]");
	public final By gatelimitAuth = By.xpath("//android.widget.TextView[@text=\"ゲート制限\"]");
	public final By certificationAuth = By.xpath("(//android.widget.TextView[@text=\"認証\"])[2]");
	public final By reentryAuth = By.xpath("//android.widget.TextView[@text=\"再入場\"]");
	public final By timecontrolAuth = By.xpath("//android.widget.TextView[@text=\"入場開始時間制御\"]");
	public final By readingAuth = By.xpath("//android.widget.TextView[@text=\"読取エリア表示\"]");
	public final By screenflipAuth = By.xpath("//android.widget.TextView[@text=\"画面反転（据え置き）\"]");
	public final By btnAuth = By.xpath("//android.widget.TextView[@text=\"読み取りモードにする\"]");
	public final By recordAuth = By.xpath("//android.widget.TextView[@text=\"認証記録\"]");
	public final By primarygateAuth = By.xpath("//android.widget.TextView[@text=\"1次ゲート\"]");
	public final By successAuth = By.xpath("(//android.widget.TextView[@text=\"認証数\"])[1]");
	public final By checkticketAuth = By.xpath("(//android.widget.TextView[@text=\"記録数\"])[1]");
	public final By failAuth = By.xpath("//android.widget.TextView[@text=\"エラー数\"]");
	public final By gatesecondAuth = By.xpath("//android.widget.TextView[@text=\"2段階認証\"]");
	public final By ticketcheckAuth = By.xpath("//android.widget.TextView[@text=\"チケットチェック\"]");

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
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]");
	public final By auth_useAuthen = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By auth_useTicketCheck = By.xpath("//android.widget.TextView[@text=\"チケットチェック\"]");
	public final By auth_gate1 = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authGate = By.xpath("//android.widget.ScrollView/android.view.View[2]");

	// Element chuyển sang màn TOP
	public final By footerTOP = By.xpath("//android.widget.TextView[@text=\"TOP\"]");

	public void checkDispalySwitchWithAuthenNormal() {
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
		scrollDown(1);
		clickElement(ugrent_options);
		pause(200);
		clickElement(ugrent_OK);
		pause(200);
		clickElement(oKBtn);
		pause(200);
		clickElement(okDone);
		pause(200);
		clickElement(auth_authFooter);
		pause(200);
		scrollDown(1);
		checkAllSwitchOnce();
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

	public void checkAllTitle() {
		clickElement(auth_authFooter);
		pause(200);
		checkTitleText(titleAuth, "認証");
		checkTitleText(eventInfoAuth, "イベント情報");
		checkTitleText(eventNameAuth, "イベント名  ");
		checkTitleText(dateEventAuth, "開催日付 ");
		checkTitleText(settingAuth, "設定");
		checkTitleText(usemodeAuth, "利用形態");
		checkTitleText(gateAuth, "設置ゲート");
		scrollDown(1);
		checkTitleText(gatelimitAuth, "ゲート制限");
		checkTitleText(certificationAuth, "認証");
		checkTitleText(reentryAuth, "再入場");
		checkTitleText(timecontrolAuth, "入場開始時間制御");
		checkTitleText(readingAuth, "読取エリア表示");
		checkTitleText(screenflipAuth, "画面反転（据え置き）");
		checkTitleText(btnAuth, "読み取りモードにする");
		scrollDown(1);
		checkTitleText(recordAuth, "認証記録");
		checkTitleText(primarygateAuth, "1次ゲート");
		checkTitleText(successAuth, "認証数");
		checkTitleText(checkticketAuth, "記録数");
		checkTitleText(failAuth, "エラー数");
		checkTitleText(gatesecondAuth, "2段階認証");
		checkTitleText(ticketcheckAuth, "チケットチェック");
	}
}
