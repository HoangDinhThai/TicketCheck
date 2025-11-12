package CheckTiket.UI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Setting_Screen_Validation_Page extends BaseTest {
	// Để sử dụng POM
	public Setting_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// ==========================
	// 🔍 ELEMENT HAMBURGER
	// ==========================
	public final By Hamburger_Icon = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By Hamburger_Setting = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By Hamburger_Maintenance = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By Hamburger_Close = By.xpath("//android.widget.ScrollView/android.view.View[3]");
	
	// ==========================
	// 🔍 ELEMENT TITLE
	// ==========================
	public final By Title_Title = By.xpath("//android.widget.TextView[@text=\"設定\"]");
	public final By Title_HomeTeamID = By.xpath("//android.widget.TextView[@text=\"ホームチームID\"]");
	public final By Title_TerminalNumber = By.xpath("//android.widget.TextView[@text=\"端末番号\"]");
	public final By Title_Domain = By.xpath("//android.widget.TextView[@text=\"接続先\"]");
	public final By Title_Network = By.xpath("//android.widget.TextView[@text=\"ネットワーク\"]");
	public final By Title_AuthenticationMode = By.xpath("//android.widget.TextView[@text=\"認証モード\"]");
	public final By Title_AuthenticationMedia = By.xpath("//android.widget.TextView[@text=\"認証媒体\"]");
	public final By Title_EmergencyAuthentication = By.xpath("//android.widget.TextView[@text=\"緊急認証時の表示\"]");
	public final By Title_ReceiptOutput = By.xpath("//android.widget.TextView[@text=\"レシート出力\"]");
	public final By Title_TestPrint = By.xpath("//android.widget.TextView[@text=\"テストプリント\"]");
	public final By Title_ServerAuthentication = By.xpath("//android.widget.TextView[@text=\"管理サーバ認証\"]");
	
	// ==========================
	// 🔍 ELEMENT PLACEHOLDER
	// ==========================
	public final By Placeholder_HomeTeamID = By.xpath("//android.widget.TextView[@text=\"ホームチームIDを入力\"]");
	public final By Placeholder_TerminalNumber = By.xpath("//android.widget.TextView[@text=\"端末番号を入力\"]");
	public final By Placeholder_Domain = By.xpath("//android.widget.TextView[@text=\"接続先を入力\"]");
	public final By Placeholder_Network = By.xpath("//android.widget.TextView[@text=\"ネットワークを選択\"]");
	public final By Placeholder_AuthenticationMode = By.xpath("//android.widget.TextView[@text=\"認証モードを選択\"]");
	public final By Placeholder_EmergencyAuthentication = By.xpath("//android.widget.TextView[@text=\"緊急認証時の表示を選択\"]");
	
	public void verifyAllTitlesDisplayed() {
		checkTitleText(Title_Title, "設定");
		checkTitleText(Title_HomeTeamID, "ホームチームID");
		checkTitleText(Title_TerminalNumber, "端末番号");
		checkTitleText(Title_Domain, "接続先");
		checkTitleText(Title_Network, "ネットワーク");
		checkTitleText(Title_AuthenticationMode, "認証モード");
		checkTitleText(Title_AuthenticationMedia, "認証媒体");
		scrollDown(1);
		checkTitleText(Title_EmergencyAuthentication, "緊急認証時の表示");
		checkTitleText(Title_ReceiptOutput, "レシート出力");
		checkTitleText(Title_TestPrint, "テストプリント");
		checkTitleText(Title_ServerAuthentication, "管理サーバー認証");
		pause(2000);
    }
	
	public void verifyAllPlaceholderDisplayed() {
		scrollUp(1);
		checkPlaceHolderText(Placeholder_HomeTeamID, "ホームチームIDを入力");
		checkPlaceHolderText(Placeholder_TerminalNumber, "端末番号を入力");
		checkPlaceHolderText(Placeholder_Domain, "接続先を入力");
		checkPlaceHolderText(Placeholder_Network, "ネットワークを選択");
		checkPlaceHolderText(Placeholder_AuthenticationMode, "認証モードを選択");
		scrollDown(1);
		checkPlaceHolderText(Placeholder_EmergencyAuthentication, "緊急認証時の表示を選択");
    }
	
	public void checkTitleText(By locator, String expectedText) {
		WebElement element = driver.findElement(locator);
		String actualText = element.getText();
		
		if (actualText.equals(expectedText)) {
			System.out.println("✅ Title [" + expectedText + "] hiển thị chính xác");
		}
		else {
			System.out.println("❌ Title [" + expectedText + "] sai. Thực tế: " + actualText);
		}
	}
	
	public void checkPlaceHolderText(By locator, String expectedText) {
		WebElement element = driver.findElement(locator);
		String actualText = element.getText();
		
		if (actualText.equals(expectedText)) {
			System.out.println("✅ Placeholder [" + expectedText + "] hiển thị chính xác");
		}
		else {
			System.out.println("❌ Placeholder [" + expectedText + "] sai. Thực tế: " + actualText);
		}
	}
	
	public void clickSetting() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Setting);
		pause(200);
	}
	
	public void checkStatusTextFiled() {
		
	}
	
}
