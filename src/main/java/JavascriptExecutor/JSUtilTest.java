package JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSUtilTest {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://book.spicejet.com/LoginAgent.aspx");

		Thread.sleep(6000);
		
//		System.out.println(JSUtil.getTitleByJS(driver));
//		JSUtil.generateAlert(driver, "This is an alert!");
//		JSUtil.refreshBrowserByJS(driver);
		
//		System.out.println(JSUtil.getBrowserInfo(driver));
//		JSUtil.sendKeysUsingJSWithId(driver, "ControlGroupLoginAgentView_AgentLoginView_TextBoxUserID", "AsgharSalar");
//		JSUtil.sendKeysUsingJSWithName(driver, "ControlGroupLoginAgentView_AgentLoginView_PasswordFieldPassword", "Salar@123");
//		WebElement loginButton = driver.findElement(By.id("ControlGroupLoginAgentView_AgentLoginView_ButtonLogIn"));
//		JSUtil.clickElementByJS(loginButton, driver);
		
		WebElement content = driver.findElement(By.xpath("//div[@class='content']"));
		JSUtil.drawBorder(driver, content);
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
