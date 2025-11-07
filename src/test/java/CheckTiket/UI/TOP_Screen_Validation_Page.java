package CheckTiket.UI;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TOP_Screen_Validation_Page extends BaseTest {
	// Để sử dụng POM
	public TOP_Screen_Validation_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Element màn hình TOP
	public final By footerImport = By.xpath("//android.widget.TextView[@text=\"イベント取込\"]");
	public final By footerAuthen = By.xpath("//android.widget.TextView[@text=\"認証\"]");

	public void checkSwitch(By locator, String switchName) {
		WebElement element = driver.findElement(locator);
		boolean isEnabled = element.isEnabled();

		System.out.println("🔘[" + switchName + "] trạng thái: " + (isEnabled ? "ENABLE ✅" : "DISABLE ❌"));

		// Nếu switch bật → pass
		if (isEnabled) {
			Assert.assertTrue(true, "✅ Switch [" + switchName + "] đang bật (ENABLE)");
		}
		// Nếu switch tắt → fail test
		else {
			Assert.fail("❌ Switch [" + switchName + "] đang bị disable!");
		}
	}

	public void checkDisableFooter() {
		checkSwitch(footerImport, "Footer Import");
		pause(200);
		checkSwitch(footerAuthen, "Footer Authen");
		pause(200);
	}
}
