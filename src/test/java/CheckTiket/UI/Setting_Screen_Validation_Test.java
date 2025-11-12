package CheckTiket.UI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Setting_Screen_Validation_Test extends BaseTest{
	private Setting_Screen_Validation_Page settingValidationPage;
	
	@BeforeClass
	 public void setupPage() {
		settingValidationPage = new Setting_Screen_Validation_Page(driver);
    }
	
	@Test(priority = 1, description = "Kiểm tra hiển thị tiêu đề của màn hình Setting")
	public void checkTitleDisplay() {
		settingValidationPage.clickSetting();
		settingValidationPage.verifyAllTitlesDisplayed();
	}
	
	@Test(priority = 2, description = "Kiểm tra hiển thị placeholder của màn hình Setting")
	public void checkPlaceholderDisplay() {
		settingValidationPage.verifyAllPlaceholderDisplayed();;
	}
}
