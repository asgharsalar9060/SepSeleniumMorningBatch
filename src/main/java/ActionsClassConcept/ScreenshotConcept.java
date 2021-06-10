package ActionsClassConcept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotConcept {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.engagebay.com/login");
		
		takePageScreenshot(driver, "loginPage");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'LogIn')]"));
		
		email.sendKeys("azgharsalar@gmail.com");
		password.sendKeys("Salar@123");
		
		takeElementScreenshot(email, "email");
		takeElementScreenshot(password, "password");
		takeElementScreenshot(loginBtn, "loginBtn");
		
		takePageScreenshot(driver, "loginPageErro");
		
		driver.quit();

	}

	public static void takePageScreenshot(WebDriver driver, String fileName) {
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(SrcFile, new File("./target/screenshots/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeElementScreenshot(WebElement element, String fileName) {
		File SrcFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(SrcFile, new File("./target/screenshots/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
