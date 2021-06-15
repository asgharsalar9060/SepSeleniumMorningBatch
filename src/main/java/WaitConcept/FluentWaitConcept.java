package WaitConcept;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	public static void main(String[] args) {

		// ExplicitWait:
		// 1. WebDriverWait
		// 2. FluentWait: it is the super class of web driver wait in selenium
		// a. TimeOut b. pollingPeriod c. ignoringException d. until

		// when to use?
		// for handling ajax components --> Ajax means updating specific section without
		// refreshing the entire page

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");

		final By email = By.xpath("//input[@name='username']");
		By password = By.xpath("//input[@name='password']");
		By loginButton = By.xpath("//input[@type='submit' and @value='Login']");

		waitForElementWithFluentWait(driver, email).sendKeys("AzgharSalar");
		driver.findElement(password).sendKeys("Salar@123");
		driver.findElement(loginButton).click();

	}

	//For interview: what's the purpose of inner class in fluent wait?
	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public static WebElement waitForElementWithFluentWaitAndExplicitWaiat(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
