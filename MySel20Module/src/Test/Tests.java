package Test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 * @author Patrick Kocsis
 * @version 04.03.15
 */
public class Tests {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://schools-and-quakes.org/");

	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.findElement(By.id("HLtrigger")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("modlgn-username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.id("modlgn-passwd")).sendKeys("adminasd");
		Thread.sleep(2000);
		driver.findElement(By.name("Submit")).click();
		WebElement resultsDiv = driver.findElement(By.className("logout-button"));
		boolean success=false;
		if (resultsDiv.isDisplayed()) {
			success=true;
		}
		assertTrue(success == true);

	}

	public void testForum() throws InterruptedException {

		Thread.sleep(2000);
		driver.navigate().to("https://schools-and-quakes.org/index.php/forum/index");
		Thread.sleep(2000);
		driver.navigate().to("https://schools-and-quakes.org/index.php/forum/siteheelp");

	}

}
