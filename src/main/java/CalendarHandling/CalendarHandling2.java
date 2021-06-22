package CalendarHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling2 {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://seleniumpractise.blogspot.com/2016/");

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		// selectDate("27");

		By calendar = By.cssSelector("table.ui-datepicker-calendar a");
		selectDate("23", calendar);

	}

	public static void selectDate(String day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

	public static void selectDate(String day, By locator) {
		List<WebElement> dateList = driver.findElements(locator);

		System.out.println(dateList.size());

		for (WebElement e : dateList) {
			String date = e.getText();
			//System.out.println(date);
			if (date.equals(day)) {
				e.click();
				break;
			}
		}
	}

}
