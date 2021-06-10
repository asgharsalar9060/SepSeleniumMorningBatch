package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAndNavigate {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// 1. open browser
		
//		driver.get("https://www.amazon.com");//with 'get' getTitle is performed when the page is fully loaded		
		
		driver.navigate().to("https://www.amazon.com");//with 'navigate - to' getTitle is performed as soon as the title is visible 		
		System.out.println(driver.getTitle());
		
		//driver.quit();
	}

}
