package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Setting_Screen_Function_Test extends BaseTest {

	private Setting_Screen_Function_Page settingFunctionPage;

	@BeforeClass
	public void setupPage() {
		settingFunctionPage = new Setting_Screen_Function_Page(driver);
	}

	@Test(priority = 1, description = "Sai HomeTeamID & Đúng mật khẩu xác thực")
	public void testLoginFailWithInvalidHomeTeamID() {
		settingFunctionPage.loginFailWithInvalidHomeTeamID();
	}

	@Test(priority = 2, description = "Sai Domain & Đúng mật khẩu xác thực")
	public void testLoginFailWithInvalidDomain() {
		settingFunctionPage.loginFailWithInvalidDomain();
	}

	@Test(priority = 3, description = "Đúng HomeTeamID & Domain nhưng Sai mật khẩu")
	public void testLoginFailWithInvalidPassword() {
		settingFunctionPage.loginFailWithInvalidPassword();
	}

	@Test(priority = 4, description = "Đăng nhập thành công")
	public void testLoginSuccess() {
		settingFunctionPage.loginSuccess();
	}
}
