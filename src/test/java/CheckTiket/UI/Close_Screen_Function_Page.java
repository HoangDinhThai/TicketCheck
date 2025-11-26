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
	
	// 🔍 ELEMENT HAMBURGER
	public final By hamburgerIcon = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By hamburgerClose = By.xpath("//android.widget.ScrollView/android.view.View[3]");
	
	// 🔍 ELEMENT CLOSE
	public final By titleClose = By.xpath("(//android.widget.TextView[@text=\"アプリ終了\"])[1]");
	public final By contentClose = By.xpath("//android.widget.TextView[@text=\"アプリを終了しても良いですか？\"]");
	public final By exitClose = By.xpath("//android.widget.Button");
	public final By closeClose = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");
	
	public void closeSuccess() {
		clickElement(hamburgerIcon);
		pause(200);
		clickElement(hamburgerClose);
		pause(200);
		checkTitleText(titleClose, "アプリ終了");
		pause(200);
		checkTitleText(contentClose, "アプリを終了しても良いですか？");
		pause(200);
		clickElement(exitClose);
		pause(200);
	}
}
