package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetText {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.engagebay.com/login");
		
		driver.findElement(By.xpath("//input[@title='Enter a valid email address.']")).sendKeys("hi@looka");
		driver.findElement(By.name("password")).sendKeys("hi@looka");
		driver.findElement(By.xpath("//button[contains(text(),'LogIn')]")).click();
		
		String errorText = driver.findElement(By.xpath("//span[contains(text(),'The username or password you entered is incorrect.')]")).getText();
		System.out.println(errorText);
	}

}
