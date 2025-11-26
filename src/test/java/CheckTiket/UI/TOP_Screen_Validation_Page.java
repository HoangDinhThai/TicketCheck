package CheckTiket.UI;

import java.time.Duration;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TOP_Screen_Validation_Page extends BaseTest {
	public TOP_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// 🔍 ELEMENT FOOTER
	public final By footerImport = By.xpath("//android.widget.TextView[@text=\"イベント取込\"]");
	public final By footerAuthen = By.xpath("//android.widget.TextView[@text=\"認証\"]");

	// 🔍 ELEMENT TITLE
	public final By eventInfoTitle = By.xpath("//android.widget.TextView[@text=\"イベント情報\"]");
	public final By topTitle = By.xpath("(//android.widget.TextView[@text=\"TOP\"])[1]");
	public final By eventNameTitle = By.xpath("//android.widget.TextView[@text=\"イベント名\"]");
	public final By eventDayTitle = By.xpath("//android.widget.TextView[@text=\"開催日付\"]");
	public final By totalTicketTitle = By.xpath("//android.widget.TextView[@text=\"認証データ\"]");
	public final By memberDataTitle = By.xpath("//android.widget.TextView[@text=\"会員データ\"]");
	public final By configInfoTitle = By.xpath("//android.widget.TextView[@text=\"設定情報\"]");
	public final By homeTeamIDTitle = By.xpath("//android.widget.TextView[@text=\"ホームチームID\"]");
	public final By terminalNumTitle = By.xpath("//android.widget.TextView[@text=\"端末番号\"]");
	public final By domainTitle = By.xpath("//android.widget.TextView[@text=\"接続先\"]");
	public final By noAttendanceDataTitle = By.xpath("//android.widget.TextView[@text=\"来場実績データはありません\"]");
	public final By attendanceDateTitle = By.xpath("");
	public final By finishedBtn = By.xpath("//android.widget.TextView[@text=\"終了処理\"]");

	public void checkStatusFooter() {
		checkFooter(footerImport, "Footer Import");
		pause(200);
		checkFooter(footerAuthen, "Footer Authen");
		pause(200);
	}

	// ==== Common check method ====
	public void verifyAllTitlesDisplayed() {
		checkTitleText(eventInfoTitle, "イベント情報");
		checkTitleText(topTitle, "TOP");
		checkTitleText(eventNameTitle, "イベント名");
		checkTitleText(eventDayTitle, "開催日付");
		checkTitleText(totalTicketTitle, "認証データ");
		checkTitleText(memberDataTitle, "会員データ");
		checkTitleText(configInfoTitle, "設定情報");
		checkTitleText(homeTeamIDTitle, "ホームチームID");
		checkTitleText(terminalNumTitle, "端末番号");
		checkTitleText(domainTitle, "接続先");
		scrollDown(1);
		checkTitleText(noAttendanceDataTitle, "来場実績データはありません");
		checkTitleText(finishedBtn, "終了処理");
	}
}
