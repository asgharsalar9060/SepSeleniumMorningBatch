package DropDownConceptPractice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownUtilTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/r.php");
		
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year"));
		
		String date = "Jan-19-2001";
		String datVal[] = date.split("-");
		
		DropDownUtil.getDropDownHandle(month, datVal[0]);
		DropDownUtil.getDropDownHandle(day, datVal[1]);
		DropDownUtil.getDropDownHandle(year, datVal[2]);
		
		ArrayList<String> monthList = DropDownUtil.getDropDownValues(month);
		System.out.println(monthList);
		
		ArrayList<String> dayList = DropDownUtil.getDropDownValues(day);
		System.out.println(dayList);
		
		ArrayList<String> yearList = DropDownUtil.getDropDownValues(year);
		System.out.println(yearList);
		
	}

}
