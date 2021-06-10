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

public class CustomXpathLoginPage {

	WebDriver driver;

	public CustomXpathLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the webelement...");
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured while logging in...");
			System.out.println(e.getMessage());
		}
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while clicking on webelement...");
			System.out.println(e.getMessage());
		}
	}

	public void clickOnContacts(WebDriver driver, By locator) {

		List<WebElement> contactCount = driver.findElements(By.tagName("a"));
		
		for (int i = 0; i < contactCount.size(); i++) {
			System.out.println(contactCount.get(i).getText());
//			if (!contactCount.get(i).getAttribute("a").contains(" ")) {
//				
//			}
		}
		driver.findElement(locator).click();
	}
}
