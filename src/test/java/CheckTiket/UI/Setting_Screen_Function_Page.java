package CheckTiket.UI;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class Setting_Screen_Function_Page extends BaseTest {

	// ===== Constructor =====
	public Setting_Screen_Function_Page(AppiumDriver driver) {
		this.driver = (AndroidDriver) driver;
		this.mywait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// 🔍 ELEMENT TOP XỬ LÝ HOÀN TẤT
	public final By Complete_Btn = By.xpath("//android.widget.Button");
	public final By Complete_Online = By
			.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]");
	public final By Complete_BtnOK = By.xpath("//android.widget.Button");

	// 🔍 ELEMENT HAMBURGER
	public final By Hamburger_Icon = By.xpath("//android.view.View[@content-desc=\"More options\"]");
	public final By Hamburger_Setting = By.xpath("//android.widget.ScrollView/android.view.View[1]");

	// 🔍 ELEMENT INPUT
	public final By homeTeamIDInput = By
			.xpath("//android.widget.TextView[@text='ホームチームID']/following-sibling::android.widget.EditText");
	public final By terminalNumberInput = By
			.xpath("//android.widget.TextView[@text='端末番号']/following-sibling::android.widget.EditText");
	public final By domainInput = By
			.xpath("//android.widget.TextView[@text='接続先']/following-sibling::android.widget.EditText");
	public final By networkDropdown = By
			.xpath("//android.widget.TextView[@text='ネットワーク']/following-sibling::*[@clickable='true']");
	public final By networkOnline = By.xpath("//android.widget.TextView[@text=\"オンライン\"]");
	public final By networkOffline = By.xpath("//android.widget.TextView[@text=\"オフライン\"]");
	public final By authModeDropdown = By
			.xpath("//android.widget.TextView[@text=\"認証モード\"]/following-sibling::*[@clickable='true']");
	public final By authNormal = By.xpath("//android.widget.TextView[@text=\"通常認証\"]");
	public final By authEmergency = By.xpath("//android.widget.TextView[@text=\"緊急認証\"]");
	public final By emergencyDisplayDropdown = By
			.xpath("//android.widget.TextView[@text=\"緊急認証時の表示\"]/following-sibling::*[@clickable='true']");
	public final By okBtn = By.xpath("//android.widget.Button");

	// 🔍 ELEMENT DIALOG XÁC THỰC MẬT KHẨU
	public final By dlgContent = By.xpath("//android.widget.TextView[@text=\"認証するためのパスワードを入力してください\"]");
	public final By dlgPlaceholder = By.xpath("//android.widget.TextView[@text=\"パスワード\"]");
	public final By dlgInput = By.xpath("//android.widget.EditText");
	public final By dlgOK = By.xpath("//android.widget.Button");
	public final By dlgCancel = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");
	public final By dlgMessage = By.xpath("//android.widget.TextView[@text=\"設定が完了しました。\"]");
	public final By dlgOK_Success = By.xpath("//android.widget.Button");

	// 🔍 ELEMENT DIALOG UPDATE HomeTeamID
	public final By dlgHomeTeamID_Title = By.xpath("//android.widget.TextView[@text=\"確認\"]");
	public final By dlgHomeTeamID_Content = By
			.xpath("//android.widget.TextView[@text=\"ホームチームIDが変更されました。取込済みのイベントデータが削除されますがよろしいでしょうか。\"]");
	public final By dlgHomeTeamID_OK = By.xpath("//android.widget.Button");
	public final By dlgHomeTeamID_Cancel = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");
	public final By dlgHomeTeamID_Done = By.xpath("//android.widget.Button");

	// 🔍 ELEMENT DIALOG UPDATE Domain
	public final By dlgDomain_Title = By.xpath("//android.widget.TextView[@text=\"確認\"]");
	public final By dlgDomain_Content = By
			.xpath("//android.widget.TextView[@text=\"接続先が変更されました。会員情報を含めた取込済みのイベントデータが削除されますがよろしいですか？\"]");
	public final By dlgDomain_OK = By.xpath("//android.widget.Button");
	public final By dlgDomain_Cancel = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");
	public final By dlgDomain_Done = By.xpath("//android.widget.Button");

	// 🔍 ELEMENT DIALOG UPDATE Cả 2
	public final By dlgBoth_Title = By.xpath("//android.widget.TextView[@text=\"確認\"]");
	public final By dlgBoth_Content = By
			.xpath("//android.widget.TextView[@text=\"ホームチームID、接続先が変更されました。会員情報を含めた取込済みのイベントデータが削除されますがよろしいですか？\"]");
	public final By dlgBoth_OK = By.xpath("//android.widget.Button");
	public final By dlgBoth_Cancel = By.xpath("//android.widget.TextView[@text=\"キャンセル\"]");
	public final By dlgBoth_Done = By.xpath("//android.widget.Button");

	// MESSAGE
	public final By failedHomeTeamID = By.xpath("//android.widget.TextView[@text=\"ホームチームIDが存在しません。\"]");
	public final By failedDomain = By.xpath("//android.widget.TextView[@text=\"正しい接続先を入力してください。\"]");
	public final By failedPassword = By
			.xpath("//android.widget.TextView[@text=\"入力されたパスワードが違います。\r\n" + "パスワードを確認してください。\"]");
	public final By emptyPassword = By.xpath("//android.widget.TextView[@text=\"パスワードを入力してください。\"]");

	/** Case 1: Đăng nhập thất bại với HomeTeamID không hợp lệ */
	public void loginInvalidHomeTeamID() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Setting);
		inputElement(homeTeamIDInput, "22");
		inputElement(terminalNumberInput, "Ticket");
		inputElement(domainInput, "pia.pirago.work");
		clickElement(networkDropdown);
		clickElement(networkOnline);
		clickElement(authModeDropdown);
		clickElement(authNormal);
		scrollDown(1);
		clickElement(okBtn);
		inputElement(dlgInput, "hawksuat");
		clickElement(dlgOK);
		pause(2000);
		MessageDiadlogs(failedHomeTeamID, "ホームチームIDが存在しません。");
		clickElement(dlgHomeTeamID_Done);
	}

	/** Case 2: Đăng nhập thất bại với Domain không hợp lệ */
	public void loginFailWithInvalidDomain() {
		scrollUp(1);
		inputElement(homeTeamIDInput, "SU");
		inputElement(domainInput, "pia.pirago.work1");
		scrollDown(1);
		clickElement(okBtn);
		inputElement(dlgInput, "hawksuat");
		clickElement(dlgOK);
		pause(2000);
		MessageDiadlogs(failedDomain, "正しい接続先を入力してください。");
		clickElement(dlgDomain_Done);
	}

	/** Case 3: Đăng nhập thất bại với Password không hợp lệ */
	public void loginFailWithInvalidPassword() {
		scrollUp(1);
		inputElement(domainInput, "pia.pirago.work");
		scrollDown(1);
		clickElement(okBtn);
		inputElement(dlgInput, "thai2211");
		clickElement(dlgOK);
		//MessageDiadlogs(failedPassword, "入力されたパスワードが違います。パスワードを確認してください。");
		//pause(200);
		//clickElement(dlgDomain_Cancel);
		pause(200);
	}

	/** Case 4: Đăng nhập thất bại khi để trống Password */
	public void loginFailWithEmptyPassword() {
		clearElement(dlgInput);
		pause(200);
		clickElement(dlgOK);
		MessageDiadlogs(emptyPassword, "パスワードを入力してください。");
		pause(200);
		clickElement(dlgCancel);
		pause(200);
	}

	/** Case 5: Đăng nhập thành công */
	public void loginSuccess() {
		scrollUp(1);
		inputElement(homeTeamIDInput, "SU");
		pause(200);
		scrollDown(1);
		clickElement(okBtn);
		inputElement(dlgInput, "hawksuat");
		clickElement(dlgOK);
		pause(2000);
		MessageDiadlogs(dlgMessage, "設定が完了しました。");
		pause(200);
		clickElement(dlgOK_Success);
		pause(200);
	}

	/** Case 6: Đăng nhập thành công thay đổi HomeTeamID */
	public void loginSuccessChangeHomeTeamID() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Setting);
		inputElement(homeTeamIDInput, "VC");
		scrollDown(1);
		clickElement(okBtn);
		pause(200);
		checkTitleText(dlgHomeTeamID_Content, "ホームチームIDが変更されました。取込済みのイベントデータが削除されますがよろしいでしょうか。");
		clickElement(dlgHomeTeamID_OK);
		pause(200);
		inputElement(dlgInput, "123456");
		clickElement(dlgOK);
		pause(200);
		clickElement(dlgOK_Success);
		pause(200);
	}

	/** Case 7: Đăng nhập thành công thay đổi Domain */
	public void loginSuccessChangeDomain() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Setting);
		inputElement(domainInput, "pia-backup.pirago.work");
		scrollDown(1);
		clickElement(okBtn);
		pause(200);
		checkTitleText(dlgDomain_Content, "接続先が変更されました。会員情報を含めた取込済みのイベントデータが削除されますがよろしいですか？");
		clickElement(dlgDomain_OK);
		pause(200);
		inputElement(dlgInput, "123456");
		clickElement(dlgOK);
		pause(200);
		clickElement(dlgOK_Success);
		pause(200);
	}

	/** Case 8: Đăng nhập thành công thay đổi cả 2 */
	public void loginSuccessChangeBoth() {
		clickElement(Hamburger_Icon);
		pause(200);
		clickElement(Hamburger_Setting);
		inputElement(homeTeamIDInput, "SU");
		inputElement(domainInput, "pia.pirago.work");
		scrollDown(1);
		clickElement(okBtn);
		pause(200);
		checkTitleText(dlgBoth_Content, "ホームチームID、接続先が変更されました。会員情報を含めた取込済みのイベントデータが削除されますがよろしいですか？");
		clickElement(dlgBoth_OK);
		pause(200);
		inputElement(dlgInput, "hawksuat");
		clickElement(dlgOK);
		pause(200);
		clickElement(dlgOK_Success);
		pause(200);
	}

}
