package ActionsClassConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		//action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		
		action.dragAndDrop(draggable, droppable).build().perform();
	}

}
