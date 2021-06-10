package DropDownConceptPractice;

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
		
		getDropDownHandle(month, "Jul");
		getDropDownHandle(day, "17");
		getDropDownHandle(year, "2000");
		
	}
	
	public static void getDropDownHandle(WebElement element, String value) {
		System.out.println("*******************************");
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}
