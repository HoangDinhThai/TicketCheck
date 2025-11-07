package CheckTiket.UI;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Close_Screen_Function_Page extends BaseTest {
	public Close_Screen_Function_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Element closee

	// Element màn xác thực TOP
	public final By auth_authFooter = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[9]");
	public final By auth_gate1 = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authGate = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authBtn = By.xpath("//android.widget.ScrollView/android.view.View[7]/android.widget.Button");
	public final By auth_inputPassword = By.xpath("//android.widget.EditText");
	public final By auth_okPassword = By.xpath("//android.widget.Button");

	public void checkTicketSuccess() {
		setupSettingAndLogin();
		importSuccessData();
		pause(200);
		clickElement(auth_authFooter);
		pause(200);
		clickElement(auth_gate1);
		pause(200);
		clickElement(auth_authGate);
		pause(200);
		scrollDown(1);
		clickElement(auth_authBtn);
		pause(200);
		inputElement(auth_inputPassword, "jl");
		pause(200);
		clickElement(auth_okPassword);
		pause(200);
	}
}
