package CheckTiket.UI;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Authen_Screen_Function_Page extends BaseTest {
	// Để sử dụng POM
	public Authen_Screen_Function_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Element màn xác thực TOP
	public final By auth_authFooter = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[9]");
	public final By auth_gate1 = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authGate = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By auth_authBtn = By.xpath("//android.widget.ScrollView/android.view.View[7]/android.widget.Button");
	public final By auth_inputPassword = By.xpath("//android.widget.EditText");
	public final By auth_okPassword = By.xpath("//android.widget.Button");
	public final By auth_gateCheck = By.xpath("//android.widget.TextView[@text=\"１ゲート\"]");
	public final By auth_permission = By.xpath(
			"//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");

	@Test(priority = 1, description = "Check Ticket on 1 hour")
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
		clickElement(auth_gateCheck);
		pause(200);
		clickElement(auth_permission);
		pause(2000);
		clickElement(auth_gateCheck);

//			// Bổ sung logic lặp quét trong 1 giờ
//			long oneHourMs = 60L * 60L * 1000L;
//			long endTime = System.currentTimeMillis() + oneHourMs;
		//
//			boolean firstTime = true;
		//
//			while (System.currentTimeMillis() < endTime) {
//				if (firstTime) {
//					try {
//						clickElement(auth_permission);
//						pause(2000);
//					} catch (Exception e) {
//						System.out.println("Permission button không có hoặc đã cấp quyền rồi.");
//					}
//					firstTime = false;
//				}
		//
//				clickElement(auth_gateCheck);
//				System.out.println("Đã click GateCheck để quét vé.");
//				pause(2000);
//			}
		//
//			System.out.println("Hoàn thành lặp quét trong 1 giờ.");
	}
}
