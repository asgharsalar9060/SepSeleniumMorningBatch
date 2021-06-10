package DropDownConceptPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {

	/**
	 * This method is used to select value from drop down on the basis of given text
	 * @param element
	 * @param value
	 */
	
	public static void getDropDownHandle(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	/**
	 * This method is used to get all the values in the drop down
	 * @param element
	 * @return 
	 */
	
	public static ArrayList<String> getDropDownValues(WebElement element) {
		System.out.println("***************************************");
		Select select = new Select(element);
		List<WebElement> dropList = select.getOptions();
		
		System.out.println(" total number of values in drop down: " + dropList.size());
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i=0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			arr.add(text);
		}
		return arr;
	}
	
	/**
	 * This method is used to select the values from drop down without select class
	 * @param driver
	 * @param locator
	 * @param value
	 */
	
	public static void selectDropDownWithoutSelect(WebDriver driver, String locator, String value) {
		List<WebElement> dropList = driver.findElements(By.xpath(locator));
		
		System.out.println(dropList.size());
		
		for(int i=0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			System.out.println(text);
			if(text.equals(value)) {
				dropList.get(i).click();
				break;
			}
		}
		
	}
	
}
