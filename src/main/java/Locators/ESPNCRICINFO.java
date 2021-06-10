package Locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ESPNCRICINFO {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(
				"https://www.espncricinfo.com/series/psl-2020-21-2021-1238103/islamabad-united-vs-lahore-qalandars-15th-match-1247027/full-scorecard");

		List<WebElement> playersList = driver
				.findElements(By.xpath("//tbody//tr/td[@class='batsman-cell text-truncate out']"));

		System.out.println(playersList.size());

		for (int i = 0; i < playersList.size(); i++) {
			System.out.println();
			getPlayerScoreCard(driver, playersList.get(i).getText());
		}

	}

	public static void getPlayerScoreCard(WebDriver driver, String playerName) {
		List<WebElement> playerScoreInfoList = driver
				.findElements(By.xpath("//a[contains(text(),'Usman Khawaja')]//parent::td//following-sibling::td"));

		if (playerName.length() <= 8) {
			System.out.println(playerName + "\t" + "\t");
		} else {
			System.out.println(playerName + "\t");
		}

		for (int i = 0; i < playerScoreInfoList.size(); i++) {
			System.out.print(playerScoreInfoList.get(i).getText() + "\t");
		}
	}

}
