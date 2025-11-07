package CheckTiket.UI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Close_Screen_Function_Test extends BaseTest {
	private Close_Screen_Function_Page closeFunctionPage;

	@BeforeClass
	public void setupPage() {
		closeFunctionPage = new Close_Screen_Function_Page(driver);
	}

	@Test(priority = 1, description = "Thực hiện quét vé")
	public void checkSuccessBefore () {
		scrollDown(1);
		closeFunctionPage.checkTicketSuccess();
	}
}
