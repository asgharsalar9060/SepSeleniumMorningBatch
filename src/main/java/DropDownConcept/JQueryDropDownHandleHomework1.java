package DropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandleHomework1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("justAnInputBox1")).click();

		// selectMultiSelectionWithCascadeOption(driver, "choice 2");// select 1 value
		 selectMultiSelectionWithCascadeOption(driver, "choice 1", "choice 2", "choice 3", "choice 4", "choice 5", "choice 6");// select multiple value
		//selectMultiSelectionWithCascadeOption(driver, "ALL");

		// driver.quit();

	}

	public static void selectMultiSelectionWithCascadeOption(WebDriver driver, String... value) {
		List<WebElement> cascadeOptionSelect = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']//ul/li/span[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < cascadeOptionSelect.size(); i++) {
				System.out.println(cascadeOptionSelect.get(i).getText());
				String text = cascadeOptionSelect.get(i).getText();

				for (int k = 0; k < value.length; k++) {
					if (text.equals(value[k])) {
						cascadeOptionSelect.get(i).click();
						break;
					}
				}
			}
		} else {
			try {
				for (int all = 0; all < cascadeOptionSelect.size(); all++) {
					cascadeOptionSelect.get(all).click();
				}
			} catch (Exception e) {

			}
		}
	}

}
