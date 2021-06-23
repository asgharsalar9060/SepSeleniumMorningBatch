package DropDownConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandleWithGenericFuncton {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//Thread.sleep(3000);

		By industry = By.xpath("//select[@id='Form_submitForm_Industry']");
		By country = By.xpath("//select[@id='Form_submitForm_Country']");

//		Select select1 = new Select(driver.findElement(industry));
//		select1.selectByVisibleText("Education");
//		
//		Select select2 = new Select(driver.findElement(country));
//		select2.selectByVisibleText("India");
		
//		selectByVisibleText(country, "India");
//		selectByVisibleText(industry, "Education");
		
		doSelectByValue(industry, Dropdown.VALUE.toString(), "Education");
		//doSelectByValue(country, Dropdown.INDEX.toString(), "1");
		doSelectByValue(country, Dropdown.VISIBLETEXT.toString(), "Afghanistan");
	}
	
	public static void doSelectByValue(By locator, String type, String value) {
		Select select = new Select(getElement(locator));
		
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;

		default:
			System.out.println("please pass the correct selection criteria");
			break;
		}
	}
	
	

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void selectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void selectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
}
