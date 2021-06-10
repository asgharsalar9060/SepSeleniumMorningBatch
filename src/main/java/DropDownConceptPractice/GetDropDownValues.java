package DropDownConceptPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/r.php");
		
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year"));
		
		getDropDownValues(month);
		getDropDownValues(day);
		getDropDownValues(year);	
	}
	
	public static void getDropDownValues(WebElement element) {
		System.out.println("***************************************");
		Select select = new Select(element);
		List<WebElement> dropList = select.getOptions();
		
		System.out.println(" total number of values in drop down: " + dropList.size());
		
		for(int i=0; i<dropList.size(); i++) {
			System.out.println(dropList.get(i).getText());
		}
	}

}
