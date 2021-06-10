package DropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandleHomework2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("justAnInputBox")).click();

		// multiSelection(driver, "choice 1");// select single value
		// multiSelection(driver, "choice 1", "choice 2", "choice 3");// select multi
		// values
		multiSelection(driver, "all");

	}

	public static void multiSelection(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']//ul/li/span[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("alL")) {
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
		} else {
			try {
				for (int all = 0; all < choiceList.size(); all++) {
					choiceList.get(all).click();
				}
			} catch (Exception e) {

			}
		}

	}

}
