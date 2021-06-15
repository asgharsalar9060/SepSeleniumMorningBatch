package WaitConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//applied to all elements - it's just for web element
		//dynamic
		//global
		
		System.out.println(driver.getTitle());
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));
		
		email.sendKeys("azgharsalar@gmail.com");
	
		driver.quit();
	}

}
