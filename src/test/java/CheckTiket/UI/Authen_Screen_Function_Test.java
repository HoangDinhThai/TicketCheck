package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authen_Screen_Function_Test extends BaseTest{
	private Authen_Screen_Function_Page authenFunctionPage;

	@BeforeClass
	public void setupPage() {
		authenFunctionPage = new Authen_Screen_Function_Page(driver);
	}

	@Test(priority = 1, description = "Quét vé thành công")
	public void checkTicketSuccess() {
		authenFunctionPage.checkTicketSuccess();
	}
}
