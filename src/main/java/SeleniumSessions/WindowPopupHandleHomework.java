package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopupHandleHomework {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.findElement(By.id("button1")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWinId = it.next();
		System.out.println("Parent Window Id: " + parentWinId);
		
		String childWinId = it.next();
		System.out.println("Child Window Id: " + childWinId);
		
		driver.switchTo().window(childWinId);
		driver.manage().window().maximize();
		System.out.println("New Browser Window Title: " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(parentWinId);
		System.out.println("Parent Browser Window Title " + driver.getTitle());
		Thread.sleep(3000);
		
		
		driver.findElement(By.id("button1")).click();
		
		Set<String> handles2 = driver.getWindowHandles();
		
		Iterator<String> it2 = handles2.iterator();
		
		String parentWinId2 = it2.next();
		System.out.println("Parent Window Id: " + parentWinId2);
		
		String childWinId2 = it2.next();
		System.out.println("Child Window Id: " + childWinId2);
		
		driver.switchTo().window(childWinId2);
		driver.manage().window().maximize();
		System.out.println("Child2 Window Title: " + driver.getTitle());
		Thread.sleep(3000);	
		
		driver.close();
		
		driver.switchTo().window(parentWinId2);
		System.out.println("Parent Window Title: " + driver.getTitle());
	
		Thread.sleep(3000);
		
		driver.quit();
	
	}

}
