package CheckTiket.UI;

import java.net.URL;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	protected AndroidDriver driver;
	protected WebDriverWait mywait;

	// Element màn Setting
	public final By completeBtn = By.xpath("//android.widget.ScrollView/android.view.View/android.widget.Button");
	public final By completeOffline = By.xpath(
			"//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
	public final By okComplete = By.xpath("//android.widget.Button");
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

	// Element màn Import event data
	public final By ip_importFooter = By.xpath("By.xpath(\"//android.view.View[@content-desc='イベント取込']\");");
	public final By ip_eventData = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[1]");
	public final By ip_clickBtn = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[6]/android.widget.Button");
	public final By ip_okDialog = By.xpath("//android.widget.Button");

	// Element màn xác thực TOP
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

	@BeforeClass
	public void setUp() throws Exception {
		UiAutomator2Options options = new UiAutomator2Options().setAutomationName("UiAutomator2")
				.setPlatformName("Android").setDeviceName("Real Device").setUdid("0020202510018759")
				.setAppPackage("com.pirago.pia").setAppActivity("com.pirago.pia.presentation.MainActivity")
				.setAppWaitPackage("com.pirago.pia").setAppWaitActivity("com.pirago.pia.presentation.*")
				.setNewCommandTimeout(Duration.ofSeconds(3600)).setNoReset(true);
		URL url = new URL("http://172.16.1.25:4723/wd/hub");

		driver = new AndroidDriver(url, options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void checkComplete(By completeButton, By confirmButton, By okButton) {
		try {
			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement btn = shortWait.until(ExpectedConditions.elementToBeClickable(completeButton));

			if (btn.isDisplayed() && btn.isEnabled()) {
				btn.click();
				System.out.println("👉 Đã click nút hoàn tất lần đầu vào app.");

				// Xử lý dialog đầu tiên (chọn nút confirm)
				try {
					WebDriverWait dialogWait = new WebDriverWait(driver, Duration.ofSeconds(5));
					WebElement confirmBtn = dialogWait.until(ExpectedConditions.elementToBeClickable(confirmButton));
					confirmBtn.click();
					System.out.println("✅ Đã click nút confirm trong dialog.");
				} catch (Exception e) {
					System.out.println("⚠ Không tìm thấy nút confirm trong dialog.");
				}

				// Xử lý dialog xác nhận thành công (OK)
				try {
					WebDriverWait okWait = new WebDriverWait(driver, Duration.ofSeconds(5));
					WebElement okBtn = okWait.until(ExpectedConditions.elementToBeClickable(okButton));
					okBtn.click();
					System.out.println("🎉 Đã click nút OK để đóng dialog xác nhận thành công.");
				} catch (Exception e) {
					System.out.println("⚠ Không tìm thấy nút OK trong dialog xác nhận.");
				}

			} else {
				System.out.println("⚡ Nút hoàn tất bị disable → Không cần xử lý.");
			}
		} catch (Exception e) {
			System.out.println("✅ Không tìm thấy nút hoàn tất → Không cần xử lý.");
		}
	}

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

	protected void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Vuốt xuống (thấy phần dưới)
	protected void scrollDown(int maxSwipes) {
		String ui = "new UiScrollable(new UiSelector().scrollable(true))" + ".setAsVerticalList()"
				+ ".setMaxSearchSwipes(" + maxSwipes + ")" + ".scrollForward()";
		driver.findElement(AppiumBy.androidUIAutomator(ui));
	}

	// Vuốt lên (thấy phần trên)
	protected void scrollUp(int maxSwipes) {
		String ui = "new UiScrollable(new UiSelector().scrollable(true))" + ".setAsVerticalList()"
				+ ".setMaxSearchSwipes(" + maxSwipes + ")" + ".scrollBackward()";
		driver.findElement(AppiumBy.androidUIAutomator(ui));
	}

	// Hàm clear giá trị trong các element
	protected void clearElement(By locator) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}

	// Hàm Login thành công
	public void setupSettingAndLogin() {
//		scrollDown(1);
//		checkComplete(completeBtn, completeOnline, okComplete);
//		pause(2000);
		clickElement(hamburgerMenu);
		pause(200);
		clickElement(settingBtn);
		pause(200);

		// Nhập thông tin cần thiết
		inputElement(hometeamID, "VC");
		inputElement(nameDevice, "Ticket");
		inputElement(doamin, "pia.pirago.work");

		// Cấu hình các lựa chọn mạng, xác thực
		clickElement(networkOptions);
		clickElement(onlineOption);
		clickElement(authenticate);
		clickElement(normal);

		// Cuộn xuống và xác nhận
		scrollDown(1);
		clickElement(oKBtn);

		// Nhập mật khẩu xác thực
		inputElement(passwordInput, "123456");
		clickElement(okPassword);
		pause(2000);
		clickElement(okDone);
		pause(2000); // chờ màn TOP hiển thị

		System.out.println("✅ Đã hoàn tất setup và login vào màn TOP xác thực.");
	}

	// Hàm Import thành công
	public void importSuccessData() {
		clickElement(ip_importFooter);
		pause(200);
		clickElement(ip_eventData);
		pause(200);
		clickElement(ip_clickBtn);
		pause(8000);
		clickElement(ip_okDialog);
		pause(200);

		System.out.println("✅ Đã hoàn tất Import thành công ở màn Import");
	}

	// Hàm dùng chung để kiểm tra trạng thái của switch bất kì
	public void checkAllSwitchOnce() {
		Map<By, String> switches = new LinkedHashMap<>();
		switches.put(switch_limitedGate, "ゲート制限");
		switches.put(switch_authentication, "認証モード");
		switches.put(switch_reentry, "再入場");
		switches.put(switch_timecontrol, "入場時間制御");
		switches.put(switch_displayarea, "表示エリア制御");
		switches.put(switch_screenflip, "画面反転");

		for (Map.Entry<By, String> entry : switches.entrySet()) {
			String name = entry.getValue();
			try {
				WebElement element = driver.findElement(entry.getKey());
				boolean isEnabled = element.isEnabled();
				String status = isEnabled ? "ENABLE ✅" : "DISABLE ❌";
				System.out.printf("🔘 %-12s → %s%n", name, status);
			} catch (Exception e) {
				System.out.printf("⚠️ %-12s → Không tìm thấy trên màn hình!%n", name);
			}
		}
		System.out.println("====================================");
	}

	// Hàm check giá trị default của màn Maintainence
	public void verifyDefaultValue(By locator, String expectedValue, String fieldName) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String actualValue = element.getText();
		Assert.assertEquals(actualValue, expectedValue,
				"❌ Giá trị mặc định của [" + fieldName + "] không đúng. Thực tế: " + actualValue);
	}

//	@AfterClass(alwaysRun = true)
//	public void tearDown() {
//		if (driver != null)
//			driver.quit();
//	}
}
