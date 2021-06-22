package WindowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		
		driver.findElement(By.xpath("//i[@class='icon-linkedin']")).click();
		
		Thread.sleep(2000);
		
		//we can switch to another window by getWindowHandles which it returns Set of String
		//it returns Set of String because each window's ID is unique 
		//Set is the collection that stores only and only unique values
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id: " + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id: " + childWindowId);
		
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
