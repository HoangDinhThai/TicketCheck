package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Setting_Screen_Function_Test extends BaseTest {

	private Setting_Screen_Function_Page settingFunctionPage;

	@BeforeClass
	public void setupPage() {
		settingFunctionPage = new Setting_Screen_Function_Page(driver);
	}

	@Test(priority = 1, description = "Đăng nhập thất bại với HomeTeamID không hợp lệ")
	public void loginInvalidHomeTeamID() {
		settingFunctionPage.loginInvalidHomeTeamID();
	}

	@Test(priority = 2, description = "Đăng nhập thất bại với Domain không hợp lệ")
	public void loginFailWithInvalidDomain() {
		settingFunctionPage.loginFailWithInvalidDomain();
	}

	@Test(priority = 3, description = "Đăng nhập thất bại với Password không hợp lệ ")
	public void loginFailWithInvalidPassword() {
		settingFunctionPage.loginFailWithInvalidPassword();
	}

	@Test(priority = 4, description = "Đăng nhập thất bại khi để trống Password")
	public void loginFailWithEmptyPassword() {
		settingFunctionPage.loginFailWithEmptyPassword();
	}

	@Test(priority = 5, description = "Đăng nhập thành công")
	public void loginSuccesss() {
		settingFunctionPage.loginSuccess();
	}

	@Test(priority = 6, description = "Đăng nhập thành công thay đổi HomeTeamID")
	public void loginSuccessChangeHomeTeamID() {
		settingFunctionPage.loginSuccessChangeHomeTeamID();
	}

	@Test(priority = 7, description = "Đăng nhập thành công thay đổi Domain")
	public void loginSuccessChangeDomain() {
		settingFunctionPage.loginSuccessChangeDomain();
	}

	@Test(priority = 8, description = "Đăng nhập thành công thay đổi cả 2")
	public void loginSuccessChangeBoth() {
		settingFunctionPage.loginSuccessChangeBoth();
	}
}
