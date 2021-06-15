package WaitConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");
		
		waitForTitle(driver, 10);
		System.out.println(driver.getTitle());
		
		waitForUrl(driver, 10);		
		System.out.println(driver.getCurrentUrl());
		
		waitForElementWithExplicitWait(driver, 10, By.name("username")).sendKeys("AsgharSalar");
		
		//WebElement emailId = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Salar@123");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
		loginBtn.click();
		
		driver.quit();	
	}
	
	public static WebElement waitForElementWithExplicitWait(WebDriver driver, int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static boolean waitForUrl(WebDriver driver, int timeout) {
		WebDriverWait wait2 = new WebDriverWait(driver, timeout);
		boolean bln = wait2.until(ExpectedConditions.urlContains("https://classic.freecrm.com/index.html"));
		return bln;
	}
	
	public static boolean waitForTitle(WebDriver driver, int timeout) {
		WebDriverWait wait1 = new WebDriverWait(driver, timeout);
		boolean bln = wait1.until(ExpectedConditions.titleContains("Free CRM - CRM software for customer relationship management, sales, and support."));
		return bln;
	}
	

}
