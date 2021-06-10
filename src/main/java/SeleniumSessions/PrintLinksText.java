package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintLinksText {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");
		
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("total links: " + listLinks.size());
		
		for(int i=0; i<listLinks.size(); i++) {
			if(listLinks.get(i).getText().contains(" ")) {
				System.out.println(listLinks.get(i).getText());
			}			
		}
		
		driver.quit();
	}

}
