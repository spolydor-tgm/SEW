package slots;

import general.*;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author Tony
 * @version 1.0
 */
public class SlotsBotFunctions {

	static int token_left = 0;
	static int token_used = 0;
	static WebDriver driver = null;
	static OverwatchGUI end;

	public static void startBot(String browser, String name, String pw,
			int tokens, String bet) {
		token_left = tokens;
		token_used = 0;

		Thread t = new Thread() {
			@Override
			public void run() {
				end = new OverwatchGUI();
				end.repaint();
			}
		};
		t.start();

		// end = new OverwatchGUI();

		// end.repaint();

		// end = new OverwatchGUI();
		// end.setSize(250, 300);
		// end.setResizable(false);
		// end.setVisible(true);
		// end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		switch (browser) {
		case "Chrome":
			File file = new File("files/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getPath());
			try {
				driver = new ChromeDriver();
			} catch (Exception e) {
				//@debug
				//System.out.println("chrome error");
				JOptionPane.showMessageDialog(null, "Couldn't find Chrome on this PC.\nPlease make sure you have Google Chrome installed.", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(10);
			}
			connect(driver, name, pw);
			gamble(driver, bet, tokens);
			break;

		case "Firefox":
			driver = new FirefoxDriver();
			connect(driver, name, pw);
			gamble(driver, bet, tokens);
			break;

		case "IE":
			// File file = new File(
			// "D:/Schule/Jahrgang 4/SEW/Eclipse/TC_Casino_Bot/src/mainBot/IEDriverServer.exe");
			// System.setProperty("webdriver.ie.driver",
			// file.getAbsolutePath());
			// driver = new InternetExplorerDriver();
			// gamble(driver, name, pw, tokens);
			break;
		}
	}

	public static void connect(WebDriver driver, String name, String pw) {
		driver.get("http://www.torn.com/");
		driver.findElement(By.name("player")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.name("btnLogin")).click();
	}

	public static void gamble(WebDriver driver, String bet, int tokens) {
		try {

			driver.get("http://www.torn.com/loader.php?sid=slots");

			Thread.sleep(10000);
			try {
				switch (bet) {
				case "100":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-100"))
								.click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				case "1K":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-1k")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				case "10K":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-10k")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				case "100K":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-100k")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				case "1M":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-1m")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				case "10M":
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-10m")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);
						Thread.sleep(6000);
					}
					break;
				default:
					for (int i = 0; i < tokens; i++) {
						driver.findElement(By.cssSelector("li.betbtn.btn-10")).click();
						token_left--;
						token_used++;
						end.updateCount(token_used, token_left);

						Thread.sleep(6000);
					}
					break;
				}
			} catch (ElementNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Couldn't find the bet button\nGot enough money?");
			}
			JOptionPane.showMessageDialog(null,"The Bot finished now\nBot tired...\nBot going to sleep ... zZz");
			killDriver();
		} catch (InterruptedException e) {
			System.out
					.println("Fatal Error occured, please show this log to 84N3:");
			e.printStackTrace();
		} catch (WebDriverException f) {
			JOptionPane.showMessageDialog(null,"Please don't close the browser before the bot has finished wasting your money!\n"
									+ "Now it crashed, and you'll have to start a new run!");
			// f.printStackTrace();
		}
	}

	public static void killDriver() {
		try {
			driver.quit();
		} catch (NullPointerException e) {

		}

	}

	public static int getToken_used() {
		return token_used;
	}
	
	public static int getToken_left() {
		return token_left;
	}
}
