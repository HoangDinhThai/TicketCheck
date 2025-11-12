package CheckTiket.UI;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TOP_Screen_Validation_Page extends BaseTest {
	public TOP_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ==========================
	// 🔍 ELEMENT FOOTER
	// ==========================
	public final By footerImport = By.xpath("//android.widget.TextView[@text=\"イベント取込\"]");
	public final By footerAuthen = By.xpath("//android.widget.TextView[@text=\"認証\"]");

	// ==========================
	// 🔍 ELEMENT TITLE
	// ==========================
	public final By TOP_EventInformation = By.xpath("//android.widget.TextView[@text=\"イベント情報\"]");
	public final By TOP_Tilte = By.xpath("(//android.widget.TextView[@text=\"TOP\"])[1]");
	public final By TOP_EventName = By.xpath("//android.widget.TextView[@text=\"イベント名\"]");
	public final By TOP_EventDay = By.xpath("//android.widget.TextView[@text=\"開催日付\"]");
	public final By TOP_TotalTicket = By.xpath("//android.widget.TextView[@text=\"認証データ\"]");
	public final By TOP_MemberData = By.xpath("//android.widget.TextView[@text=\"会員データ\"]");
	public final By TOP_ConfigurationInformation = By.xpath("//android.widget.TextView[@text=\"設定情報\"]");
	public final By TOP_HomeTeamID = By.xpath("//android.widget.TextView[@text=\"ホームチームID\"]");
	public final By TOP_TerminalNumber = By.xpath("//android.widget.TextView[@text=\"端末番号\"]");
	public final By TOP_Domain = By.xpath("//android.widget.TextView[@text=\"接続先\"]");
	public final By TOP_NoAttendanceData = By.xpath("//android.widget.TextView[@text=\"来場実績データはありません\"]");
	public final By TOP_AttendanceDate = By.xpath("");
	public final By TOP_BtnFinished = By.xpath("//android.widget.TextView[@text=\"終了処理\"]");
	
	public void checkStatusFooter() {
		checkFooter(footerImport, "Footer Import");
		pause(200);
		checkFooter(footerAuthen, "Footer Authen");
		pause(200);
	}
	
	 // ==== Common check method ====
	public void verifyAllTitlesDisplayed() {
        checkTitleText(TOP_EventInformation, "イベント情報");
        checkTitleText(TOP_Tilte, "TOP");
        checkTitleText(TOP_EventName, "イベント名");
        checkTitleText(TOP_EventDay, "開催日付");
        checkTitleText(TOP_TotalTicket, "認証データ");
        checkTitleText(TOP_MemberData, "会員データ");
        checkTitleText(TOP_ConfigurationInformation, "設定情報");
        checkTitleText(TOP_HomeTeamID, "ホームチームID");
        checkTitleText(TOP_TerminalNumber, "端末番号");
        checkTitleText(TOP_Domain, "接続先");
        scrollDown(1);
        checkTitleText(TOP_NoAttendanceData, "来場実績データはありません");
        checkTitleText(TOP_BtnFinished, "終了処理");
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

}
