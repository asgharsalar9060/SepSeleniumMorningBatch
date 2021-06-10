package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	public static WebElement element;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.engagebay.com/login");
		
//		element = driver.findElement(By.xpath("//input[@name='email']"));		
//		element.sendKeys("azgharsalar@gmail.com");
//		
//		element = driver.findElement(By.name("password"));
//		element.sendKeys("Salar@123");
//		
//		driver.findElement(By.xpath("//button[contains(text(),'LogIn')]")).click();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("azgharsalar@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("Salar@123");
		driver.findElement(By.xpath("//button[contains(text(),'LogIn')]")).click();
		
	}

}
