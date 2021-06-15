package GenericMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageExplicitWaitExample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//We should not use implicit wait and explicit wait together
		//if we want to use explicit wait for some elements and after implicit wait, implicit wait should by nullified
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		By email = By.name("username");
		By password = By.name("password");
		By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
		By signUpLink = By.xpath("//a[text()='Sign Up']");
		By frame = By.name("mainpanel");
		By report = By.xpath("//a[text()='Reports']");

		driver.get("https://classic.freecrm.com/index.html");

		LoginPage lp = new LoginPage(driver);

//		lp.waitForTitleToBePresent("Free CRM - CRM software for customer relationship management, sales, and support.", 10);
//		System.out.println(driver.getTitle());//we can do this when we don't return anything in the method
		
		String title = lp.waitForTitleToBePresent("Free CRM - CRM software for customer relationship management, sales, and support.", 10);
		System.out.println(title);
		
		//lp.clickWhenReady(signUpLink, 5);

		//lp.waitForElementToBePresent(email, 15).sendKeys("AsgharSalar");
		lp.waitForElementToBePresentWithFluentWait(driver, email).sendKeys("AsgharSalar");
		lp.doSendKeys(password, "Salar@123");
		lp.doClick(loginButton);
		
		lp.waitForFrameWithFluentWait(driver, frame);
		//lp.waitForFrame(frame, 5);
		
		lp.doClick(report);

		//lp.waitForElementToBePresent(loginButton, 5).click();
		
		//driver.quit();

	}

}
