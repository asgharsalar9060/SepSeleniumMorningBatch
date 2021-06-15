package WaitConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");

		By email = By.name("username");
		By password = By.name("password");
		By loginButton = By.xpath("//input[@type='submit' and @value='Login']");

		getElementWithWait(driver, email, 6).sendKeys("AsgharSalar");
		driver.findElement(password).sendKeys("Salar@123");
		driver.findElement(loginButton).click();

	}

	public static WebElement getElementWithWait(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		for (int i = 0; i < timeout; i++) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (Exception e) {
				System.out.println("Waiting for element to be present --> " + i + " Seconds");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		return element;
	}
	
	public static boolean isElementDisplayed(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		boolean flag = false;
		for (int i = 0; i < timeout; i++) {
			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("Waiting for element to be present --> " + i + " Seconds");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		return flag;
	}

}
