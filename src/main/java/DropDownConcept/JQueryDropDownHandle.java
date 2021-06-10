package DropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("justAnInputBox")).click();

		// all of these values go to one String
		// Array which we put as parameter in
		// selectChoiceValues method below

		// selectChoiceValues(driver, "choice 2 1", " choice 2 3", "choice 6 2 2");//select multiple values
		// selectChoiceValues(driver, "choice 2 1");//select 1 value
		selectChoiceValues(driver, "All");// select all values

		driver.quit();

	}

	/**
	 * This method is used to:
	 * 1. select multiple values...
	 * 2. select single value...
	 * 3. select all value...
	 * @param driver
	 * @param value
	 */
	// 3 dots concept: used for many-to-one mapping. it gives a String Array in which we can put multiple values 
	public static void selectChoiceValues(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']//ul/li/span[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < choiceList.size(); i++) {
				System.out.println(choiceList.get(i).getText());
				String text = choiceList.get(i).getText();

				for (int k = 0; k < value.length; k++) {
					if (text.equals(value[k])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		}
		// select all the values
		else {
			try {
				for (int all = 0; all < choiceList.size(); all++) {
					choiceList.get(all).click();
				}
			} catch (Exception e) {

			}
		}
	}

}
