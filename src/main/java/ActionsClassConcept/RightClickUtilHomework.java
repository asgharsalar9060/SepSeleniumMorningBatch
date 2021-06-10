package ActionsClassConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickUtilHomework {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		String edit = "//ul/li[contains(@class,'context-menu-icon-edit')]/span";
		String cut = "//ul/li[contains(@class,'context-menu-icon-cut')]/span";
		String copy = "//ul/li[contains(@class,'context-menu-icon-copy')]/span";
		String paste = "//ul/li[contains(@class,'context-menu-icon-paste')]/span";
		String delete = "//ul/li[contains(@class,'context-menu-icon-delete')]/span";
		String quit = "//ul/li[contains(@class,'context-menu-icon-quit')]/span";

		RightClickUtilTest.getRightClickMeText(driver, edit);
		RightClickUtilTest.getRightClickMeText(driver, cut);
		RightClickUtilTest.getRightClickMeText(driver, copy);
		RightClickUtilTest.getRightClickMeText(driver, paste);
		RightClickUtilTest.getRightClickMeText(driver, delete);
		RightClickUtilTest.getRightClickMeText(driver, quit);

		driver.quit();
	}

	

}
