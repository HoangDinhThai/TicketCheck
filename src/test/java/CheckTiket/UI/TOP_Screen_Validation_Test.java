package CheckTiket.UI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOP_Screen_Validation_Test extends BaseTest {
	private TOP_Screen_Validation_Page topValidation_Page;

	@BeforeClass
	public void setupPage() {
		topValidation_Page = new TOP_Screen_Validation_Page(driver);
	}

	@Test(priority = 1, description = "Kiểm tra nội dung tiêu đề của màn TOP")
	public void checkTitle() {
		topValidation_Page.verifyAllTitlesDisplayed();
	}
	
	@Test(priority = 2, description = "Kiểm tra trạng thái các footer của màn TOP")
	public void checkStatusFooter() {
		topValidation_Page.checkStatusFooter();
	}
}
