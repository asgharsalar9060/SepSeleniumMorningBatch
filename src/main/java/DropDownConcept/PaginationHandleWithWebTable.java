package DropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationHandleWithWebTable {

	static WebDriver driver;

	public static void selectContact(String name) {
		String checkBoxXpath = "//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@name='contact_id']";
		driver.findElement(By.xpath(checkBoxXpath)).click();
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://classic.freecrm.com/index.html");

		Thread.sleep(4000);

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));

		Actions action = new Actions(driver);

		action.sendKeys(username, "AsgharSalar").build().perform();
		action.sendKeys(password, "Salar@123").build().perform();
		action.click(loginButton).build().perform();

		driver.switchTo().frame("mainpanel");

		WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		action.click(contact).build().perform();

		Thread.sleep(3000);

		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));

		int i = 0;
		while (true) {
			if (driver.findElements(By.linkText("tote toto")).size() == 1) {
				selectContact("tote toto");
				break;
			} else {
				try {
					pages.get(i).click();
				} catch (Exception e) {
					System.out.println("Pagination is over...");
				}
				pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
			}
			i++;
		}

	}

}
