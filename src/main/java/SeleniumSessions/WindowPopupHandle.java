package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopupHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		driver.findElement(By.id("button1")).click();
		
		Set<String> handles = driver.getWindowHandles();//give a collection of window IDs -- set does not maintain any index orders also 
		//set can't hold duplicate values unlike list
		
		Iterator<String> ite = handles.iterator();//iterator works like loop but it gets the value from those collections that
		//do not maintain orders such as index[0], index[1]...
		
		String parentWindowId = ite.next();
		System.out.println("parent window id: " + parentWindowId);
		
		String childWindowId = ite.next();
		System.out.println("child window id: " + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("child window title " + driver.getTitle());
		
		driver.close();//close the child window popup
		
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title " + driver.getTitle());
		
		driver.quit();
		
	}

}
