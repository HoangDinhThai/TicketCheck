package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Maintainance_Screen_Validation_Test extends BaseTest {
	private Maintainance_Screen_Validation_Page maintainancePage;

	@BeforeClass
	public void setupPage() {
		maintainancePage = new Maintainance_Screen_Validation_Page(driver);
	}

	@Test(priority = 1, description = "Kiểm tra các giá trị default khi vào màn hình")
	public void checkDefault() {
		maintainancePage.checkDefault();
	}

	@Test(priority = 2, description = "Cài đặt thiếu dung lượng")
	public void checkMB() {
		maintainancePage.checkMBMessage();
	}

	@Test(priority = 3, description = "Cài đặt authen")
	public void checkAuthen() {
		maintainancePage.checkAuthenMessage();
	}

	@Test(priority = 4, description = "Kiểm tra bắt buộc")
	public void checkRequired() {
		maintainancePage.checkRequired();
	}
}
