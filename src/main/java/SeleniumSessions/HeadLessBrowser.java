package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		
//		WebDriver driver = new ChromeDriver(co);
		
		WebDriverManager.chromedriver().setup();	
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\OneDrive\\Documents\\JavaTraining\\SepSeleniumMorningBatch\\Drivers\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	}

}
