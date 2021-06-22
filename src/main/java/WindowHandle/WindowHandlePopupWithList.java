package WindowHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlePopupWithList {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");

		driver.findElement(By.xpath("//i[@class='icon-linkedin']")).click();

		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();
		
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowId = handlesList.get(0);
		String childWindowId = handlesList.get(1);
		
		driver.switchTo().window(childWindowId);
		System.out.println("child window title: " + driver.getTitle());	
		driver.close();
		
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title: " + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
	}

}
