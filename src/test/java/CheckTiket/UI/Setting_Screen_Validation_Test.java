package CheckTiket.UI;

import org.testng.annotations.BeforeClass;

public class Setting_Screen_Validation_Test extends BaseTest{
	private Setting_Screen_Validation_Page settingValidationPage;
	
	@BeforeClass
	 public void setupPage() {
		settingValidationPage = new Setting_Screen_Validation_Page(driver);
    }
}
