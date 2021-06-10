package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");

		// List is the parent ArrayList
		//1. get the list of all links
		List<WebElement> linkList = driver.findElements(By.tagName("a"));// list store the value on the basis of indexing
																	 
		for (int i = 0; i < linkList.size(); i++) {
			System.out.println(linkList.get(i).getText());
		}

		System.out.println("Total number of links: " + linkList.size());

//		List<WebElement> activeLinks = new ArrayList<WebElement>();

		// 2. Iterate linklist: exclude all the links that don't have href attribute
		
//		for (int i = 0; i < linkList.size(); i++) {
//			System.out.println(linkList.get(i).getAttribute("href"));
//			if (linkList.get(i).getAttribute("href") !=null && (!linkList.get(i).getAttribute("href").contains("javascript"))) {
//				activeLinks.add(linkList.get(i));
//			}
//		}
//
//		System.out.println("Size of active links and images==>" + activeLinks.size());

		driver.quit();
	}

}
