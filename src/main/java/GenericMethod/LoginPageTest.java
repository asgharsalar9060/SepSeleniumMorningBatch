package GenericMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");
		
		Thread.sleep(4000);
		
		//page objects:
		
		By email = By.name("email");
		By password = By.name("password");
		By loginBtn = By.xpath("//button[contains(text(),'LogIn')]");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.doSendKeys(email, "azgharsalar@gmail.com");
		lp.doSendKeys(password, "Salar@123");
		lp.doClick(loginBtn);
		
		
		
	}

}
