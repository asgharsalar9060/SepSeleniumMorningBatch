package GenericMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMLoginTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");
		
		//page objects:
		
		By email = By.xpath("//input[@name='username']");
		By password = By.xpath("//input[@name='password']");
		By loginBtn = By.xpath("//input[@type='submit']");
		
		FreeCRMLogin lp = new FreeCRMLogin(driver);
		
		String title = lp.waitForTitlePresent("Free CRM - CRM software for customer relationship management, sales, and support.", 20);
		System.out.println(title);
		
		lp.waitForElementPresent(email, 20);
		lp.doSendKeys(email, "AsgharSalar");
		
		lp.doSendKeys(password, "Salar@123");
		
		lp.waitForElementPresent(loginBtn, 2);
		lp.doClick(loginBtn);
		
		driver.quit();
	}

}
