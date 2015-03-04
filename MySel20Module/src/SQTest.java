import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


/**
 * @author Patrick Kocsis
 * @version 02.03.15
 */
public class SQTest {

		public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();

			// Go to the Google Suggest home page
			driver.get("https://schools-and-quakes.org/");

			// Enter the query string "Cheese"
			driver.findElement(By.id("HLtrigger")).click();
			try {
				Thread.sleep(2000);
				driver.findElement(By.id("modlgn-username")).sendKeys("admin");
				Thread.sleep(2000);
				driver.findElement(By.id("modlgn-passwd")).sendKeys("adminasd");
				Thread.sleep(2000);
				driver.findElement(By.name("Submit")).click();
				Thread.sleep(2000);
				driver.navigate().to("https://schools-and-quakes.org/index.php/forum/index");
				Thread.sleep(2000);
				driver.navigate().to("https://schools-and-quakes.org/index.php/forum/siteheelp");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Sleep until the div we want is visible or 5 seconds is over
			long end = System.currentTimeMillis() + 5000;
			while (System.currentTimeMillis() < end) {
				WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

				// If results have been returned, the results are displayed in a drop down.
				if (resultsDiv.isDisplayed()) {
					break;
				}
			}

			// And now list the suggestions
			List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

			for (WebElement suggestion : allSuggestions) {
				System.out.println(suggestion.getText());
			}

			driver.quit();

		}
}
