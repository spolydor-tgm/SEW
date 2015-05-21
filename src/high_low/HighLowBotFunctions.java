package high_low;

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
public class HighLowBotFunctions {

	static int token_left = 0;
	static int token_used = 0;
	static WebDriver driver = null;
	static OverwatchGUI end;

	public static void startBot(String browser, String name, String pw, int tokens, String bet, int rounds) {
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
			JOptionPane.showMessageDialog(null, "Couldn't find Firefox on this PC.\nPlease make sure you have Mozilla Firefox installed.", "Error", JOptionPane.ERROR_MESSAGE);
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
		driver.get("http://www.torn.com/loader.php?sid=highlow");
	}

	public static void gamble(WebDriver driver, String bet, int tokens) {
		try {
			
			Thread.sleep(12000);

			debugSelect();
			
			//setBet(bet);
//			
//			for (int i = 0; i <= tokens; i++) {
//				// gamble
//
//				token_left--;
//				token_used++;
//				end.updateCount(token_used, token_left);
//				Thread.sleep(10000);
//				driver.findElement(By.id("clearBtn"));
//				Thread.sleep(1000);
//			}
//			JOptionPane
//					.showMessageDialog(null,
//							"The Bot finished now\nBot tired...\nBot going to sleep ... zZz");
//			driver.quit();
//			System.exit(0);
		} catch (InterruptedException e) {
			System.out.println("Fatal Error occured, please show this log to 84N3:");
			e.printStackTrace();
		} catch (WebDriverException f) {
			JOptionPane.showMessageDialog(null,
							"Please don't close the browser before the bot has finished wasting your money!\n"
									+ "Now it crashed, and you have to start a new run!");
			// f.printStackTrace();
			killDriver();
			System.exit(0);
		}

	}
	
	public static void setBet(String bet) {
		
		try {
			driver.findElement(By.cssSelector("#bet-choice-button > span.ui-selectmenu-status")).click();
			switch (bet) {
			case "100":
				driver.findElement(By.xpath("//a[contains(text(),'$100')]")).click();
				break;
			case "1K":
				driver.findElement(By.xpath("//a[contains(text(),'$1,000')]")).click();
				break;
			case "10K":
				driver.findElement(By.xpath("//a[contains(text(),'$10,000')]")).click();
				break;
			case "100K":
				driver.findElement(By.xpath("//a[contains(text(),'$100,000')]")).click();
				break;
			case "1M":
				driver.findElement(By.xpath("//a[contains(text(),'$1,000,000')]")).click();
				break;
			case "10M":
				driver.findElement(By.xpath("//a[contains(text(),'$10,000,000')]")).click();
				break;
			default: //Entspricht 10 als bet
				driver.findElement(By.xpath("//a[contains(text(),'$10')]")).click();
				break;
			}
		} catch (ElementNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Couldn't find the bet button\nSite already loaded?\nIf you think you shouldn't get this message\nplease contact Tony");
		}
	}

	public static void killDriver() {
		try {
			driver.quit();
		} catch (NullPointerException e) {

		}

	}
	
	public static void debugSelect() {
		driver.findElement(By.cssSelector("#bet-choice-button > span.ui-selectmenu-status")).click();
		driver.findElement(By.xpath("//a[contains(text(),'$100')]")).click();
	}

	public static int getToken_used() {
		return token_used;
	}
	
	public static int getToken_left() {
		return token_left;
	}
}
