package Locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		this xpath is used for parallel hierarchy
//		//div[@class='private-form__input-wrapper']//following::div

//		(//div[@class='input-group']//following::input)[1]
//		(//div[@class='input-group']/input)[1]
//		//div[@class='input-group']//child::input[@name='username']

//		(//div[@class='input-group']//preceding::input)[2]
//		//input[@name='username']//preceding::div
//		//input[@name='username']//parent::div
//		//div[@class='input-group']//ancestor::div

//		//span[text()='Ali Johnson']//ancestor::td//preceding-sibling::td//input
//		//span[text()='Ali Kali']//ancestor::td//preceding-sibling::td//input
//		//span[text()='Ali Kali']//ancestor::td//preceding-sibling::td//child::input
//		//span[text()='Ali Kali']//ancestor::td//preceding-sibling::td//child::div[@class='be-checkbox']//child::label
//		//div[@class='be-checkbox'])[5]
		
//		//a[contains(text(),'Usman Khawaja')]//parent::td//following-sibling::td[@class='text-left']//following-sibling::td
		
		//It's a kind of absolute xpath and we shouldn't use them
		
//		Reversing Xpath: traversing xpath --> going from child to parent --> grant parent --> great-grant-parent...
//		input[@id='username']/../../../../../../../../..
		
//		driver.findElement(By.xpath("//input[@id='username']/../../../../..")).getAttribute("id");

		driver.get("https://app.engagebay.com/login");

		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));

		Thread.sleep(3000);

		Actions action = new Actions(driver);

		action.sendKeys(username, "azgharsalar@gmail.com").build().perform();
		action.sendKeys(password, "Salar@123").build().perform();
		action.click(loginButton).build().perform();

		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		// Thread.sleep(4000);

		WebElement contacts = driver.findElement(By.xpath("(//a[text()='Contacts'])[1]"));

		action.moveToElement(contacts).click().build().perform();

		Thread.sleep(3000);
		
		selectContact(action, driver, "Ali Kali");
		selectContact(action, driver, "Jay");

	}

	public static void selectContact(Actions action, WebDriver driver, String contactName) {
		action.click(driver.findElement(By.xpath(
				"//span[text()='"+contactName+"']//ancestor::td//preceding-sibling::td//child::div[@class='be-checkbox']//child::label")))
				.build().perform();
		
//		List<WebElement> contactCount = driver.findElements(By.tagName("tr"));
//
//		for (int i = 0; i < contactCount.size(); i++) {
//			System.out.println(contactCount.get(i).getText());
//		}
	}

}
