package DropDownConceptPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php");
		
		String month = "//select[@id='month']/option";
		String day = "//select[@id='day']/option";
		String year = "//select[@id='year']/option";
		
		DropDownUtil.selectDropDownWithoutSelect(driver, month, "Jul");
		DropDownUtil.selectDropDownWithoutSelect(driver, day, "11");
		DropDownUtil.selectDropDownWithoutSelect(driver, year, "1997");
		
	}	
}
