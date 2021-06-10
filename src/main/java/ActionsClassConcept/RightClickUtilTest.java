package ActionsClassConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightClickUtilTest {
	
	public static void getRightClickMeText(WebDriver driver, String locator) {

		WebElement rightClickMe = driver.findElement(By.className("context-menu-one"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe).build().perform();

		List<WebElement> dropList = driver.findElements(By.xpath(locator));
		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			System.out.println(text);
		}
	}

}
