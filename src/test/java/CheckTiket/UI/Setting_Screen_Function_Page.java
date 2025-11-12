package CheckTiket.UI;

import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class Setting_Screen_Function_Page extends BaseTest {
	// Để sử dụng POM
	public Setting_Screen_Function_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ===== Elements =====
	public final By completeBtn = By.xpath("//android.widget.ScrollView/android.view.View/android.widget.Button");
	public final By completeOnline = By
			.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]");
	public final By okComplete = By.xpath("//android.widget.Button");
	public final By hamburgerMenu = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By settingBtn = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By hometeamID = By.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	public final By nameDevice = By.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
	public final By doamin = By.xpath("//android.widget.ScrollView/android.widget.EditText[3]");
	public final By networkOptions = By
			.xpath("//android.widget.ScrollView/android.widget.EditText[4]/android.widget.ImageView");
	public final By onlineOption = By.xpath("//android.widget.TextView[@text=\"オンライン\"]");
	public final By authenticate = By
			.xpath("//android.widget.ScrollView/android.widget.EditText[5]/android.widget.ImageView");
	public final By normal = By.xpath("//android.widget.TextView[@text=\"通常認証\"]");
	public final By oKBtn = By.xpath("//android.widget.Button");
	public final By passwordInput = By.xpath("//android.widget.EditText");
	public final By okPassword = By.xpath("//android.widget.Button");
	public final By okSuccess = By.xpath("//android.widget.Button");
	public final By okHomeTeamID = By.xpath("//android.widget.Button");
	public final By okDoamin = By.xpath("//android.widget.Button");
	public final By okPasswordConfirm = By.xpath("//android.widget.Button");
	public final By messageOK = By.xpath("設定が完了しました。");
	public final By messageHomeTeamID = By.xpath("//android.widget.TextView[@text=\"ホームチームIDが存在しません。\"]");
	public final By messageDomain = By.xpath("//android.widget.TextView[@text=\"正しい接続先を入力してください。\"]");
	public final By messagePassword = By
			.xpath("//android.widget.TextView[@text=\"入力されたパスワードが違います。\r\nパスワードを確認してください。\"]");
	public final By cancelPassword = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");

	// ===== Actions =====
	public void loginFailWithInvalidHomeTeamID() {
		scrollDown(1);
		checkComplete(completeBtn, completeOnline, okComplete);
		pause(2000);
		clickElement(hamburgerMenu);
		pause(200);
		clickElement(settingBtn);
		inputElement(hometeamID, "22");
		inputElement(nameDevice, "HandhelpPrinter");
		inputElement(doamin, "pia.pirago.work");
		clickElement(networkOptions);
		clickElement(onlineOption);
		clickElement(authenticate);
		clickElement(normal);
		scrollDown(1);
		clickElement(oKBtn);
		inputElement(passwordInput, "hawksuat");
		clickElement(okPassword);
		pause(2000);
		String actualMessage = driver.findElement(messageHomeTeamID).getText();
		String expectedMessage = "ホームチームIDが存在しません。";
		Assert.assertEquals(actualMessage, expectedMessage, "Dialog hiển thị sai nội dung");
		clickElement(okHomeTeamID);
	}

	public void loginFailWithInvalidDomain() {
		scrollUp(1);
		inputElement(hometeamID, "SU");
		inputElement(doamin, "pia.pirago.work123");
		scrollDown(1);
		clickElement(oKBtn);
		inputElement(passwordInput, "hawksuat");
		clickElement(okPassword);
		pause(2000);
		String actualMessage = driver.findElement(messageDomain).getText();
		String expectedMessage = "正しい接続先を入力してください。";
		Assert.assertEquals(actualMessage, expectedMessage, "Dialog hiển thị sai nội dung");
		clickElement(okDoamin);
	}

	public void loginFailWithInvalidPassword() {
		scrollUp(1);
		inputElement(doamin, "pia.pirago.work");
		scrollDown(1);
		clickElement(oKBtn);
		inputElement(passwordInput, "thai2211");
		clickElement(okPassword);
		pause(2000);
		clickElement(okPasswordConfirm);
		pause(2000);
		String actualMessage = driver.findElement(messagePassword).getText();
		String expectedMessage = "入力されたパスワードが違います。\\r\\nパスワードを確認してください。";
		Assert.assertEquals(actualMessage, expectedMessage, "Dialog hiển thị sai nội dung");
		clickElement(cancelPassword);
	}

	public void loginSuccess() {
		clickElement(oKBtn);
		inputElement(passwordInput, "hawksuat");
		clickElement(okPassword);
		pause(2000);
		String actualMessage = driver.findElement(messageOK).getText();
		String expectedMessage = "設定が完了しました。";
		Assert.assertEquals(actualMessage, expectedMessage, "Dialog hiển thị sai nội dung");
		clickElement(okSuccess);
	}
}
