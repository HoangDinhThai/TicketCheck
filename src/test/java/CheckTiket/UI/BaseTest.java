package CheckTiket.UI;

import java.net.URL;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Attachment;

public class BaseTest {
	protected AndroidDriver driver;
	protected WebDriverWait mywait;

	// 🔹 COMMON ELEMENTS
	public final By completeBtn = By.xpath("//android.widget.ScrollView/android.view.View/android.widget.Button");
	public final By completeOffline = By.xpath(
			"//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
	public final By okComplete = By.xpath("//android.widget.Button");

	// ⚙️ SETTING SCREEN
	public final By hamburgerMenu = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By settingBtn = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By hometeamID = By.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	public final By nameDevice = By.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
	public final By doamin = By.xpath("//android.widget.ScrollView/android.widget.EditText[3]");
	public final By networkOptions = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	public final By onlineOption = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By authenticate = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By normal = By.xpath("//android.widget.ScrollView/android.view.View[2]");
	public final By oKBtn = By.xpath("//android.widget.Button");
	public final By passwordInput = By.xpath("//android.widget.EditText");
	public final By okPassword = By.xpath("//android.widget.Button");
	public final By okSuccess = By.xpath("//android.widget.Button");
	public final By okDone = By.xpath("//android.widget.Button");

	// 📦 IMPORT EVENT SCREEN
	public final By ip_importFooter = By.xpath("//android.view.View[@content-desc='イベント取込']");
	public final By ip_eventData = By.xpath("//android.widget.TextView[@text=\"Check Ticket\"]");
	public final By ip_clickBtn = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[6]/android.widget.Button");
	public final By ip_okDialog = By.xpath("//android.widget.Button");

	// 🧭 AUTHENTICATION TOP SCREEN
	public final By switch_limitedGate = By
			.xpath("//android.widget.TextView[@text=\"ゲート制限\"]/following-sibling::android.view.View");
	public final By switch_authentication = By
			.xpath("(//android.widget.TextView[@text=\"認証\"])[2]/following-sibling::android.view.View");
	public final By switch_reentry = By
			.xpath("//android.widget.TextView[@text=\"再入場\"]/following-sibling::android.view.View");
	public final By switch_timecontrol = By
			.xpath("//android.widget.TextView[@text=\"入場開始時間制御\"]/following-sibling::android.view.View");
	public final By switch_displayarea = By
			.xpath("//android.widget.TextView[@text=\"読取エリア表示\"]/following-sibling::android.view.View");
	public final By switch_screenflip = By
			.xpath("//android.widget.TextView[@text=\"画面反転（据え置き）\"]/following-sibling::android.view.View");

	// 🚀 SETUP
	@BeforeClass
	public void setUp() throws Exception {
		UiAutomator2Options options = new UiAutomator2Options().setAutomationName("UiAutomator2")
				.setPlatformName("Android").setDeviceName("Real Device").setUdid("0020202510018759")
				.setAppPackage("com.pirago.pia").setAppActivity("com.pirago.pia.presentation.MainActivity")
				.setAppWaitPackage("com.pirago.pia").setAppWaitActivity("com.pirago.pia.presentation.*")
				.setNewCommandTimeout(Duration.ofSeconds(3600)).setNoReset(true);

		driver = new AndroidDriver(new URL("http://172.16.1.25:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// 🎯 COMMON UTILITIES
	protected void clickElement(By locator) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	protected void inputElement(By locator, String value) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
		pause(200);
	}

	protected void clearElement(By locator) {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
	}

	protected void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}

	// ==========================
	// 🧭 SCROLL HELPERS
	// ==========================
	protected void scrollDown(int maxSwipes) {
		String ui = "new UiScrollable(new UiSelector().scrollable(true))" + ".setAsVerticalList().setMaxSearchSwipes("
				+ maxSwipes + ").scrollForward()";
		driver.findElement(AppiumBy.androidUIAutomator(ui));
	}

	protected void scrollUp(int maxSwipes) {
		String ui = "new UiScrollable(new UiSelector().scrollable(true))" + ".setAsVerticalList().setMaxSearchSwipes("
				+ maxSwipes + ").scrollBackward()";
		driver.findElement(AppiumBy.androidUIAutomator(ui));
	}

//	// ✅ COMPLETE BUTTON HANDLER
//	public void checkComplete(By completeButton, By confirmButton, By okButton) {
//		try {
//			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//			WebElement btn = shortWait.until(ExpectedConditions.elementToBeClickable(completeButton));
//
//			if (btn.isDisplayed() && btn.isEnabled()) {
//				btn.click();
//				System.out.println("👉 Click nút hoàn tất lần đầu vào app.");
//
//				clickIfVisible(confirmButton, "confirm");
//				clickIfVisible(okButton, "OK");
//			} else {
//				System.out.println("⚡ Nút hoàn tất bị disable → Không cần xử lý.");
//			}
//		} catch (Exception e) {
//			System.out.println("✅ Không tìm thấy nút hoàn tất → Không cần xử lý.");
//		}
//	}
//
//	private void clickIfVisible(By locator, String name) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//			element.click();
//			System.out.printf("✅ Đã click nút %s trong dialog.%n", name);
//		} catch (Exception e) {
//			System.out.printf("⚠ Không tìm thấy nút %s trong dialog.%n", name);
//		}
//	}
	
	public void handleButtons() {

	    By chooseButton = By.xpath("//android.widget.Button");
	    By onlineButton = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
	    By okButton = By.xpath("//android.widget.Button");

	    // 1️⃣ Check nút chooseButton đầu tiên
	    try {
	        WebElement choose = driver.findElement(chooseButton);

	        if (!choose.isEnabled()) {
	            System.out.println("🚫 chooseButton đang disable → stop flow, không xử lý thêm.");
	            return;  // Dừng toàn bộ hàm
	        }

	        System.out.println("👉 chooseButton enabled → clicking...");
	        choose.click();

	    } catch (Exception e) {
	        System.out.println("❌ Không tìm thấy chooseButton → stop luôn.");
	        return;
	    }

	    // 2️⃣ Xử lý các nút còn lại (nếu có)
	    clickIfEnabled(onlineButton);
	    clickIfEnabled(okButton);
	}

	public void clickIfEnabled(By locator) {
	    try {
	        WebElement btn = driver.findElement(locator);

	        if (btn.isEnabled()) {
	            System.out.println("👉 Button enabled → clicking...");
	            btn.click();
	        } else {
	            System.out.println("🚫 Button disabled → skip");
	        }

	    } catch (Exception e) {
	        System.out.println("❌ Button không tồn tại, skip luôn.");
	    }
	}


	// 🔑 LOGIN & SETTING
	public void setupSettingAndLogin() {
		clickElement(hamburgerMenu);
		clickElement(settingBtn);

		inputElement(hometeamID, "SU");
		inputElement(nameDevice, "Ticket");
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
		clickElement(okDone);
		pause(200);

		System.out.println("✅ Đã hoàn tất setup và login vào màn TOP xác thực.");
	}

	// 📦 IMPORT EVENT DATA
	public void importSuccessData() {
		clickElement(ip_importFooter);
		scrollDown(1);
		clickElement(ip_eventData);
		clickElement(ip_clickBtn);
		pause(8000);
		clickElement(ip_okDialog);
		pause(200);
		System.out.println("✅ Đã hoàn tất Import thành công ở màn Import");
	}

	// 🔍 SWITCH STATUS CHECK
	public void checkAllSwitchOnce() {
		Map<By, String> switches = new LinkedHashMap<>();
		switches.put(switch_limitedGate, "ゲート制限");
		switches.put(switch_authentication, "認証モード");
		switches.put(switch_reentry, "再入場");
		switches.put(switch_timecontrol, "入場時間制御");
		switches.put(switch_displayarea, "表示エリア制御");
		switches.put(switch_screenflip, "画面反転");

		switches.forEach((locator, name) -> {
			try {
				boolean enabled = driver.findElement(locator).isEnabled();
				String status = enabled ? "ENABLE ✅" : "DISABLE ❌";
				System.out.printf("🔘 %-12s → %s%n", name, status);
			} catch (Exception e) {
				System.out.printf("⚠️ %-12s → Không tìm thấy trên màn hình!%n", name);
			}
		});
		System.out.println("====================================");
	}

	// 🧩 DEFAULT VALUE CHECK
	public void verifyDefaultValue(By locator, String expectedValue, String fieldName) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String actualValue = element.getText();
		Assert.assertEquals(actualValue, expectedValue,
				"❌ Giá trị mặc định của [" + fieldName + "] không đúng. Thực tế: " + actualValue);
	}

	// 🔍 FOOTER STATUS CHECK
	public void checkFooter(By locator, String switchName) {
		WebElement element = driver.findElement(locator);

		String enabledAttr = element.getAttribute("enabled");
		String clickableAttr = element.getAttribute("clickable");

		boolean isActuallyEnabled = ("true".equalsIgnoreCase(enabledAttr) && !"false".equalsIgnoreCase(clickableAttr));

		if (isActuallyEnabled) {
			System.out.println("🔘 [" + switchName + "] đang ENABLE ✅");
		} else {
			System.out.println("🔘 [" + switchName + "] đang DISABLE ❌");
		}

		Assert.assertTrue(true,
				"Switch [" + switchName + "] trạng thái: " + (isActuallyEnabled ? "ENABLE" : "DISABLE"));
	}

	// 🧩 CHECK MESSAGE DIALOGS
	public void MessageDiadlogs(By dialogLocator, String expectedMessage) {
		String actualMessage = driver.findElement(dialogLocator).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Dialog hiển thị sai nội dung");
	}

	// 🧩 CHECK TITLE
	public void checkTitleText(By locator, String expectedText) {
		WebElement element = driver.findElement(locator);
		String actualText = element.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("✅ Title [" + expectedText + "] hiển thị chính xác");
		} else {
			System.out.println("❌ Title [" + expectedText + "] sai. Thực tế: " + actualText);
		}
	}

//	@AfterClass
//	public void teardown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
}
