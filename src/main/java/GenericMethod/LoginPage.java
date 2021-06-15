package GenericMethod;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to create the WebElement on the basis of By locator
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			//JSUtil.flash(element, driver);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the web element");
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This method is used to click on the element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while clicking on the web element");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method clicks on the element using actions class
	 * @param locator
	 */
	
	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		action.click(element).perform();
	}

	/**
	 * This method is used to pass value to the web element
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured passing value to the web element");
			System.out.println(e.getMessage());
		}	
	}
	
	/**
	 * This method sends keys using actions class
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		action.sendKeys(element, value).perform();
	}
	
	//ExplicitWaitUtils
	
	/**
	 * This method is used to wait for the visibility of all elements to be present
	 * @param elements
	 * @param timeout
	 */
	public void visibilityOfAllElements(List<WebElement> elements, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	/**
	 * This method is used to wait with Fluent Wait for the visibility of all elements to be present
	 * @param driver
	 * @param locator
	 * @return
	 */
	public List<WebElement> visibilityOfAllElementsWithFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(5))
								.pollingEvery(Duration.ofSeconds(1))
								.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));						
	}

	/**
	 * This method is used to wait for element to be present
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementToBePresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}
	
	/**
	 * This method is used to wait with Fluent Wait for element to be present
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement waitForElementToBePresentWithFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(5))
								.pollingEvery(Duration.ofSeconds(1))
								.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));						
	}
	
	/**
	 * This method is used to wait for element to be clickable
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
	}
	
	/**
	 * This method is used to wait for element to be present
	 * @param locator
	 * @param timeout
	 */
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}
	
	/**
	 * This method is used to wait for element to be visible but it works with web element
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	/**
	 * This method is used to wait for element to be visible but it works with locator
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementVisibilityLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator);
	}
	
	/**
	 * This method is used to wait for title to be present
	 * @param title
	 * @param timeout
	 * @return
	 */
	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	/**
	 * This method is used to wait for url
	 * @param url
	 * @param timeout
	 * @return
	 */
	public String waitForUrl(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method is used to wait for JS alert to be present
	 * @param timeout
	 * @return
	 */
	public boolean waitForAlertToBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());//it's just for JS alerts not others
		return true;
	}
	
	/**
	 * This method is used to wait for frame to be present
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public void waitForFrame(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		//return getElement(locator); 
	}
	
	/**
	 * This method is used to wait with Fluent Wait for frame to be present
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebDriver waitForFrameWithFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(5))
								.pollingEvery(Duration.ofSeconds(1))
								.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));						
	}

}
