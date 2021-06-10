package ActionsClassConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEvents {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.engagebay.com/login");
		
		Thread.sleep(4000);
		
		WebElement emailNanme = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));
		
		Actions action = new Actions(driver);
		
		action.sendKeys(emailNanme, "azgharsalar@gmail.com").build().perform();
		action.sendKeys(password, "Salar@123").build().perform();
		action.click(loginBtn).build().perform();
	}

}
