package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//1. open browser
		
		driver.get("https://www.google.com");//2. enter url
		
		String title = driver.getTitle();//3. get title
		System.out.println(title);
		
		//4. Validation point
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//System.out.println(driver.getPageSource());
		
		driver.quit();//close the browser -- Session ID is null
		//driver.close();//close the browser -- invalid session id
		
		
		System.out.println(driver.getTitle());//Session ID is null. Using WebDriver after calling quit()?
	}
	

}
