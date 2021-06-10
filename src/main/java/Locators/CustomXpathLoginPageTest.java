package Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathLoginPageTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://app.engagebay.com/login");
		Thread.sleep(4000);

		By username = By.xpath("//input[@name='email']");
		By password = By.xpath("//input[@name='password']");
		By loginButton = By.xpath("//button[contains(text(),'LogIn')]");

		CustomXpathLoginPage lp = new CustomXpathLoginPage(driver);
		
		lp.doSendKeys(username, "azgharsalar@gmail.com");
		lp.doSendKeys(password, "Salar@123");
		lp.doClick(loginButton);

		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

		By contacts = By.xpath("(//a[text()='Contacts'])[1]");

		lp.clickOnContacts(driver, contacts);

		By contactClick = By.xpath("//span[text()='Ali Kali']//ancestor::td//preceding-sibling::td//child::div[@class='be-checkbox']//child::label");

		lp.clickOnContacts(driver, contactClick);
		
		
		
		
		
		
		
	}

}
