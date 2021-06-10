package ActionsClassConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementHomework {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		Actions action = new Actions(driver);
		
		WebElement loginSignUp = driver.findElement(By.id("ctl00_HyperLinkLogin"));
		
		action.moveToElement(loginSignUp).build().perform();
		
		WebElement spiceClubMemebers = driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"));
		action.moveToElement(spiceClubMemebers).build().perform();
		
		driver.findElement(By.linkText("Member Login")).click();
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		System.out.println(linkList.size());
		
		for(int i=0; i<linkList.size(); i++) {
			if(linkList.get(i).getAttribute("href") != null) {
				String text = linkList.get(i).getAttribute("href");
				System.out.println(text);				
			}
		}
		
		driver.quit();
	}

}
