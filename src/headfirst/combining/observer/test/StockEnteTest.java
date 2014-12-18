package headfirst.combining.observer.test;

import headfirst.combining.observer.Quakologe;
import headfirst.combining.observer.StockEnte;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class StockEnteTest {

	private StockEnte stockEnte;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		stockEnte = new StockEnte();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testQuaken() throws Exception {
		stockEnte.quaken();
		assertEquals("Quak", outContent.toString().trim());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {
		stockEnte.registriereBeobachter(new Quakologe());
		stockEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Stockente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {
		stockEnte.registriereBeobachter(new Quakologe());
		stockEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Stockente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Stockente", stockEnte.toString());
	}
}