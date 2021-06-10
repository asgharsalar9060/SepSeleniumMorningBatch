package ImplicitAndExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EngageBayLoginPageExplicitlyWait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.titleContains("EngageBay - Login"));
		
		System.out.println(driver.getTitle());
		
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.urlContains("https://app.engagebay.com/login"));
		
		System.out.println(driver.getCurrentUrl());
		
		By emailId = By.xpath("//input[@name='email']");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		
		WebElement email = driver.findElement(emailId);
		email.sendKeys("azgharsalar@gmail.com");
		
//		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));
	
	
		driver.quit();
		
		
		
		
		
		
	}

}
