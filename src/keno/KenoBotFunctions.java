package keno;

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
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author Tony
 * @version 1.0
 */
public class KenoBotFunctions {

	static int amount;
	static int token_left = 0;
	static int token_used = 0;
	static boolean everyTurn;
	static WebDriver driver = null;
	static OverwatchGUI end;

	public static void startBot(String browser, String name, String pw,int tokens, String bet, String amount, boolean generateEveryTurn) {
		KenoBotFunctions.amount = Integer.parseInt(amount);
		KenoBotFunctions.everyTurn = generateEveryTurn;
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
			driver = new ChromeDriver();
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
		try {
			driver.get("http://www.torn.com/");
			driver.findElement(By.name("player")).sendKeys(name);
			driver.findElement(By.name("password")).sendKeys(pw);
			driver.findElement(By.name("btnLogin")).click();
			driver.get("http://www.torn.com/loader.php?sid=keno");
		} catch (WebDriverException e) {
			driver.quit();
			JOptionPane.showMessageDialog(null,
					"Please don't close the browser(or change the website) \nbefore the bot has finished wasting your money!\n"
							+ "Now it crashed, and you have to start a new run!");
			// f.printStackTrace();
			System.exit(0);
		}
		
	}

	public static void gamble(WebDriver driver, String bet, int tokens) {
		try {

			Thread.sleep(8000);

			setBet(bet);
			
			int[] numbers = generateNumbers(amount); //Initial generation
			
			for (int i = 0; i <= tokens; i++) {
				if(everyTurn==true)
				numbers = generateNumbers(amount);

				for (int j = 0; j < numbers.length; j++) {
					driver.findElement(By.id("keno_item_" + numbers[j])).click();
				}

				driver.findElement(By.id("playBtn")).click();

				token_left--;
				token_used++;
				end.updateCount(token_used, token_left);
				Thread.sleep(10000);
				driver.findElement(By.id("clearBtn"));
				Thread.sleep(1000);
			}
			JOptionPane
					.showMessageDialog(null,
							"The Bot finished now\nBot tired...\nBot going to sleep ... zZz");
			driver.quit();
			System.exit(0);
		} catch (InterruptedException e) {
			System.out.println("Fatal Error occured, please show this log to 84N3:");
			e.printStackTrace();
		} catch (WebDriverException f) {
			JOptionPane.showMessageDialog(null,
							"Please don't close the browser before the bot has finished wasting your money!\n"
									+ "Now it crashed, and you have to start a new run!");
			// f.printStackTrace();
			System.exit(0);
		}

	}
	
	public static void setBet(String bet) {
		try {
			String test= driver.findElement(By.id("betAmount")).getText();
			//System.out.println(test);
			switch (bet) {
			case "100":
				for (int i = 0; i < 1; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			case "1K":
				for (int i = 0; i < 2; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			case "10K":
				for (int i = 0; i < 3; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			case "100K":
				for (int i = 0; i < 4; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			case "1M":
				for (int i = 0; i < 5; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			case "10M":
				for (int i = 0; i < 6; i++) {
					driver.findElement(By.id("amountPlus")).click();
				}
				break;
			default:
				//for (int i = 0; i < 7; i++) {
				//	driver.findElement(By.id("amountPlus")).click();
				//}
				break;
			}
		} catch (ElementNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Couldn't find the bet button\nSite already loaded?\nIf you think you shouldn't get this message\nplease contact 84N3");
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
	
	public static void debugBetAmount() {
		String test= driver.findElement(By.id("betAmount")).getText();
		System.out.println(test);
	}
	
	public static int[] generateNumbers(int amount){
		int[] nbs = new int[amount];
		int[] verw = new int[amount];
		int hilfe =999;
		int i =0;
		boolean nochFrei = true;
		
		while(i<hilfe) {
			int neu = (int) (Math.random() * (80 - 1) + 1);

			//check schon verwendet
			for (int j = 0; j < verw.length; j++) {
				if(verw[j]==neu) {
					nochFrei = false;
				}
			}
			
			//wenn nicht dann zu beiden hinzufuegen
			if(nochFrei==true) {
				nbs[i] = neu;
				verw[i] = neu;
				i++;
				if(i==amount)
					i=9999;
			}
			nochFrei=true;
		}
		return nbs;
	}
}
