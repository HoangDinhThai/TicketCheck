package CheckTiket.UI;

import java.time.Duration;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Import_Screen_Validation_Page extends BaseTest {
	public Import_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// 🔍 ELEMENT TITLE
	public final By importTitle = By.xpath("(//android.widget.TextView[@text=\"イベント取込\"])[1]");
	public final By eventselectTitle = By.xpath("(//android.widget.TextView[@text=\"イベント選択\"])");
	public final By refreshBtnTitle = By.xpath("//android.widget.TextView[@text=\"更新\"]");
	public final By tabOnlineTitle = By.xpath("//android.widget.TextView[@text=\"オンライン\"]");
	public final By tabOfflineTitle = By.xpath("(//android.widget.TextView[@text=\"オフライン\"])");
	public final By importBtnTitle = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]");
	public final By dataAcquisitionTitle = By.xpath("//android.widget.TextView[@text=\"データ取得\"]");
	public final By dataLoadingTitle = By.xpath("//android.widget.TextView[@text=\"データ読込\"]");
	public final By elapsedTimeTitle = By.xpath("//android.widget.TextView[@text=\"経過時間\"]");
	public final By cancelBtnTitle = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");

	// 🔍 ELEMENT KHÁC
	public final By importFooter = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
	public final By ip_eventData = By.xpath("//android.widget.TextView[@text=\"Check Ticket\"]");
	public final By ip_clickBtn = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[4]");
	public final By ip_OkBtn = By.xpath("//android.widget.Button");

	public void checkAllTile() {
		clickElement(importFooter);
		pause(2000);
		checkTitleText(importTitle, "イベント取込");
		checkTitleText(eventselectTitle, "イベント選択");
		checkTitleText(refreshBtnTitle, "更新");
		checkTitleText(tabOnlineTitle, "オンライン");
		checkTitleText(tabOfflineTitle, "オフライン");
		checkTitleText(importBtnTitle, "このイベントを取込む");
		clickElement(ip_eventData);
		pause(200);
		clickElement(ip_clickBtn);
		checkTitleText(dataAcquisitionTitle, "データ取得");
		checkTitleText(dataLoadingTitle, "データ読込");
		// checkTitleText(elapsedTimeTitle, "経過時間");
		checkTitleText(cancelBtnTitle, "キャンセル");
		pause(45000);
		clickElement(ip_OkBtn);
	}
}
