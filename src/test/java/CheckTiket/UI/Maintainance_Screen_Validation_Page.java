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
	
	// 🔍 ELEMENT TITLE
	public final By mainTitle = By.xpath("//android.widget.TextView[@text=\"メンテナンス\"]");
	public final By pre_codeTitle = By.xpath("//android.widget.TextView[@text=\"アプリコード\"]");
	public final By infomationTitle = By.xpath("//android.widget.TextView[@text=\"マスタ詳細情報\"]");
	public final By eventmasterTitle = By.xpath("//android.widget.TextView[@text=\"イベントマスタ\"]");
	public final By numberTitle = By.xpath("(//android.widget.TextView[@text=\"件数\"])[1]");
	public final By final_updateTitle = By.xpath("(//android.widget.TextView[@text=\"最終更新\"])[1]");
	public final By ticket_authentication_masterTitle = By.xpath("//android.widget.TextView[@text=\"チケット認証マスタ\"]");
	public final By gate_masterTitle = By.xpath("//android.widget.TextView[@text=\"会場席種ゲートマスタ\"]");
	public final By club_masterTitle = By.xpath("//android.widget.TextView[@text=\"クラブマスタ\"]");
	public final By other_settingsTitle = By.xpath("//android.widget.TextView[@text=\"その他設定\"]");
	public final By mbTitle = By.xpath("//android.widget.TextView[@text=\"動作に必要な最低空き容量\"]");
	public final By timeoutTitle = By.xpath("//android.widget.TextView[@text=\"タイムアウト\"]");
	public final By maximumTitle = By.xpath("//android.widget.TextView[@text=\"一度に送信する最大認証件数\"]");
	public final By soundTitle = By.xpath("//android.widget.TextView[@text=\"認証結果音の音量（0～10）\"]");
	public final By returnTitle = By.xpath("//android.widget.TextView[@text=\"待受け画面表示時間\"]");
	public final By banTitle = By.xpath("//android.widget.TextView[@text=\"認証NG時の読取禁止時間\"]");

	// 🔍 ELEMENT HAMBURGER
	public final By Hamburger_Icon = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By Hamburger_Maintance = By.xpath("//android.widget.TextView[@text=\"メンテナンス\"]");
	public final By okBtn = By.xpath("//android.widget.ScrollView/android.view.View[5]/android.widget.Button");
	
	// 🔍 ELEMENT MESSAGE ERROR
	public final By mbMessage = By.xpath("//android.widget.TextView[@text=\"最低空き容量を200MB以上にしてください\"]");
	public final By authenInput = By
			.xpath("//android.widget.TextView[@text='一度に送信する最大認証件数']/following-sibling::android.widget.EditText");
	public final By authenMessage = By.xpath("//android.widget.TextView[@text=\"一度に送信する最大認証件数を10以上にしてください\"]");

	// 🔍 ELEMENT INPUT
	public final By mbInput = By
			.xpath("//android.widget.TextView[@text='動作に必要な最低空き容量']/following-sibling::android.widget.EditText");
	public final By timeoutInput = By
			.xpath("//android.widget.TextView[@text='タイムアウト']/following-sibling::android.widget.EditText");
	public final By soundDropdown = By
			.xpath("//android.widget.TextView[@text='認証結果音の音量（0～10）']/following-sibling::android.widget.TextView");
	public final By returnScreen = By
			.xpath("//android.widget.TextView[@text='待受け画面表示時間']/following-sibling::android.widget.EditText");
	public final By banAuthen = By
			.xpath("//android.widget.TextView[@text='認証NG時の読取禁止時間']/following-sibling::android.widget.EditText");

	public void checkAllTitle() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Maintance);
		pause(200);
		checkTitleText(mainTitle, "メンテナンス");
		checkTitleText(pre_codeTitle, "アプリコード");
		checkTitleText(infomationTitle, "マスタ詳細情報");
		checkTitleText(eventmasterTitle, "イベントマスタ");
		checkTitleText(numberTitle, "件数");
		checkTitleText(final_updateTitle, "最終更新");
		checkTitleText(ticket_authentication_masterTitle, "チケット認証マスタ");
		checkTitleText(gate_masterTitle, "会場席種ゲートマスタ");
		scrollDown(1);
		checkTitleText(club_masterTitle, "クラブマスタ");
		checkTitleText(other_settingsTitle, "その他設定");
		checkTitleText(mbTitle, "動作に必要な最低空き容量");
		checkTitleText(timeoutTitle, "タイムアウト");
		checkTitleText(maximumTitle, "一度に送信する最大認証件数");
		scrollDown(1);
		checkTitleText(soundTitle, "認証結果音の音量（0～10）");
		checkTitleText(returnTitle, "待受け画面表示時間");
		checkTitleText(banTitle, "認証NG時の読取禁止時間");
	}
	
	public void checkDefaultValue() {
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
		clickElement(okBtn);
		pause(200);
		String actualMessage = driver.findElement(mbMessage).getText();
		String expectedMessage = "最低空き容量を200MB以上にしてください";
		Assert.assertEquals(actualMessage, expectedMessage, "Message hiển thị không đúng nội dung");
	}

	public void checkAuthenMessage() {
		inputElement(authenInput, "1");
		pause(200);
		clickElement(okBtn);
		pause(200);
		String actualMessage = driver.findElement(authenMessage).getText();
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
		boolean isDisable = driver.findElement(okBtn).isDisplayed();
		Assert.assertTrue(isDisable, "Nút OK đã disable");
	}
	
	public void settingSuccess() {
		scrollUp(1);
		inputElement(mbInput, "2000");
		scrollDown(1);
		inputElement(timeoutInput, "10");
		inputElement(authenInput, "50");
		pause(200);
		clickElement(okBtn);
		pause(200);
	}
}
