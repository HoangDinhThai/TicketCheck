package CheckTiket.UI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Maintainance_Screen_Validation_Page extends BaseTest {
	// Để sử dụng POM
	public Maintainance_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Các element cần sử dụng
	public final By hamburgerMenu = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By maintainancebBtn = By.xpath("//android.widget.TextView[@text=\"メンテナンス\"]");
	public final By mbInput = By
			.xpath("//android.widget.TextView[@text='動作に必要な最低空き容量']/following-sibling::android.widget.EditText");
	public final By okmaintainanceBtn = By
			.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.Button");
	public final By mbErrorMessage = By.xpath("//android.widget.TextView[@text=\"最低空き容量を200MB以上にしてください\"]");
	public final By authenInput = By
			.xpath("//android.widget.TextView[@text='一度に送信する最大認証件数']/following-sibling::android.widget.EditText");
	public final By authenErrorMessage = By.xpath("//android.widget.TextView[@text=\"一度に送信する最大認証件数を10以上にしてください\"]");
	public final By timeoutInput = By
			.xpath("//android.widget.TextView[@text='タイムアウト']/following-sibling::android.widget.EditText");
	public final By soundDropdown = By
			.xpath("//android.widget.TextView[@text='認証結果音の音量（0～10）']/following-sibling::android.widget.TextView");
	public final By returnScreen = By
			.xpath("//android.widget.TextView[@text='待受け画面表示時間']/following-sibling::android.widget.EditText");
	public final By banAuthen = By
			.xpath("//android.widget.TextView[@text='認証NG時の読取禁止時間']/following-sibling::android.widget.EditText");

	public void checkDefault() {
		clickElement(hamburgerMenu);
		pause(200);
		clickElement(maintainancebBtn);
		pause(200);
		scrollDown(1);
		verifyDefaultValue(mbInput, "200", "動作に必要な最低空き容量");
	    verifyDefaultValue(timeoutInput, "10", "タイムアウト");
	    verifyDefaultValue(authenInput, "100", "一度に送信する最大認証件数");
	    scrollDown(1);
	    verifyDefaultValue(soundDropdown, "9", "認証結果音の音量（0～10）");
	    verifyDefaultValue(returnScreen, "0", "待受け画面表示時間");
	    verifyDefaultValue(banAuthen, "0", "認証NG時の読取禁止時間");
	    System.out.println("✅ Tất cả giá trị default đều chính xác.");
	}

	public void checkMBMessage() {
		scrollUp(1);
		inputElement(mbInput, "1");
		pause(200);
		scrollDown(1);
		clickElement(okmaintainanceBtn);
		pause(200);
		String actualMessage = driver.findElement(mbErrorMessage).getText();
		String expectedMessage = "最低空き容量を200MB以上にしてください";
		Assert.assertEquals(actualMessage, expectedMessage, "Message hiển thị không đúng nội dung");
	}

	public void checkAuthenMessage() {
		inputElement(authenInput, "1");
		pause(200);
		clickElement(okmaintainanceBtn);
		pause(200);
		String actualMessage = driver.findElement(authenErrorMessage).getText();
		String expectedMessage = "一度に送信する最大認証件数を10以上にしてください";
		Assert.assertEquals(actualMessage, expectedMessage, "Message hiển thị không đúng nội dung");
	}

	public void checkRequired() {
		scrollUp(1);
		clearElement(mbInput);
		pause(200);
		scrollDown(1);
		clearElement(timeoutInput);
		pause(200);
		clearElement(authenInput);
		pause(200);
		scrollDown(1);
		boolean isDisable = driver.findElement(okmaintainanceBtn).isDisplayed();
		Assert.assertTrue(isDisable, "Nút OK đã disable");
	}
}
