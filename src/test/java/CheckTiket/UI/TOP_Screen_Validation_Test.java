package CheckTiket.UI;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TOP_Screen_Validation_Test extends BaseTest {
	private TOP_Screen_Validation_Page topValidation_Page;

	public final By footerImport = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]");
	public final By footerAuthen = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]");

	@BeforeClass
	public void setupPage() {
		topValidation_Page = new TOP_Screen_Validation_Page(driver);
	}

	@Test(priority = 1, description = "Check footer bị disable")
	public void checkFooter() {
		topValidation_Page.checkDisableFooter();
	}
}
