package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Import_Screen_Validation_Test extends BaseTest{
	private Import_Screen_Validation_Page importValidationPage;

	@BeforeClass
	public void setupPage() {
		importValidationPage = new Import_Screen_Validation_Page(driver);
	}
	
	@Test(priority =  1, description = "Kiểm tra toàn bộ nội dung tiêu đề của màn hình")
	public void checkAllTitle() {
		importValidationPage.checkAllTile();
	}
}
