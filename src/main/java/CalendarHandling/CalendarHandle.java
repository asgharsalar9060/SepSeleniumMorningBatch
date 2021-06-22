package CalendarHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ixigo.com/");

		driver.findElement(By.xpath("//input[@placeholder='Depart' and @type='text']")).click();

		Thread.sleep(2000);

		// startDateList

		String startMonthValue = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[1]")).getText();

		while (!startMonthValue.contains("February 2022")) {
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[1]")).click();
			startMonthValue = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[1]")).getText();
		}

		List<WebElement> startDateList = driver
				.findElements(By.xpath("(//div[@class='rd-month'])[1]/table//div[contains(@class,'day')]"));

		for (WebElement e : startDateList) {
			if (e.getText().equals("23")) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Return' and @type='text']")).click();
		Thread.sleep(2000);

		String endMonthValue = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[4]")).getText();

		while (!endMonthValue.contains("May 2022")) {
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[2]")).click();
			endMonthValue = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[4]")).getText();
		}

		// endDateList
		List<WebElement> endDateList = driver
				.findElements(By.xpath("(//div[@class='rd-month'])[4]/table//div[contains(@class,'day')]"));

		for (WebElement e : endDateList) {
			if (e.getText().equals("6")) {
				e.click();
				break;
			}
		}

	}

}
