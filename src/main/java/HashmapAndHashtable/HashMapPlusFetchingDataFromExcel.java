package HashmapAndHashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ExcelLibUtil.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMapPlusFetchingDataFromExcel {

	public static void main(String[] args) throws InterruptedException {

		// HashMap<String, String> userMap1 = new HashMap<String, String>();

//		Map<String, String> userMap = new HashMap<String, String>();
//		
//		userMap.put("admin", "admin@gmail.com_admin123");
//		userMap.put("marketer", "marketer@gmail.com_marketer123");
//		userMap.put("manager", "manager@gmail.com_manager123");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://classic.freecrm.com/index.html");
		Thread.sleep(4000);

//		driver.findElement(By.name("username")).sendKeys(userMap.get("marketer").split("_")[0]);
//		driver.findElement(By.name("password")).sendKeys(userMap.get("marketer").split("_")[1]);

		doLogin(driver, getUserMap(), "admin");

		Thread.sleep(2000);
		driver.quit();
	}

	public static Map<String, String> getUserMap() {
		Map<String, String> userMap = new HashMap<String, String>();

		userMap.put("admin", "admin@gmail.com_admin123");
		userMap.put("marketer", "marketer@gmail.com_marketer123");
		userMap.put("manager", "manager@gmail.com_manager123");

		return userMap;

	}

	public static void doLogin(WebDriver driver, Map<String, String> userMap, String userKey) {
		driver.findElement(By.name("username")).sendKeys(userMap.get(userKey).split("_")[0]);
		driver.findElement(By.name("password")).sendKeys(userMap.get(userKey).split("_")[1]);
	}

}
