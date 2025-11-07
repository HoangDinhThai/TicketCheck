package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authen_Screen_Validation_Test extends BaseTest {
	private Authen_Screen_Validation_Page authenValidationPage;

	@BeforeClass
	public void setupPage() {
		authenValidationPage = new Authen_Screen_Validation_Page(driver);
	}

	@Test(priority = 1, description = "Display switchs")

	public void checkDisplayswiths() {
		authenValidationPage.setupSettingAndLogin();
		authenValidationPage.importSuccessData();
		authenValidationPage.checkDispalySwitchWithAuthenNormal();
		authenValidationPage.checkDispalySwitchWithTicketCheck();
		authenValidationPage.checkDispalySwitchWithAuthenUrgent();
	}
}
