package ExcelLibUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMLoginPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://classic.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));

		Xls_Reader reader = new Xls_Reader("./src/main/java/ExcelLibUtil/Book.xlsx");
		String sheetName = "login";
		
		int rowCount = reader.getRowCount(sheetName);

		for(int rowNum=2; rowNum<rowCount; rowNum++) {
			String loginId = reader.getCellData(sheetName, "Username", rowNum);
			String pwd = reader.getCellData(sheetName, "Password", rowNum);
			
			System.out.println(loginId + " " + pwd);
			
			username.clear();
			username.sendKeys(loginId);
			
			password.clear();
			password.sendKeys(pwd);
			
		}
	}

}
