package DropDownConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php");
		
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year"));
		
//		Select select = new Select(month);
//		select.selectByVisibleText("Jan");
//		
//		Select select2 = new Select(day);
//		select2.selectByVisibleText("4");
//		
//		Select select3 = new Select(year);
//		select3.selectByVisibleText("2000");
		
		selectValueFromDropDown(month, "Jan");
		selectValueFromDropDown(day, "9");
		selectValueFromDropDown(year, "2020");
	
		
	}
	
	/**
	 * This method is used to select the value from a drop down on the basis of given text
	 * @param element
	 * @param value
	 */
	
	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	
	
	

}
