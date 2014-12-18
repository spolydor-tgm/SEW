package headfirst.combining.observer.test;

import headfirst.combining.observer.GummiEnte;
import headfirst.combining.observer.Quakologe;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class GummiEnteTest {

	private GummiEnte gummiEnte;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		gummiEnte = new GummiEnte();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testQuaken() throws Exception {
		gummiEnte.quaken();
		assertEquals("Quietsch", outContent.toString().trim());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {
		gummiEnte.registriereBeobachter(new Quakologe());
		gummiEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Gummiente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {
		gummiEnte.registriereBeobachter(new Quakologe());
		gummiEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Gummiente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Gummiente", gummiEnte.toString());
	}
}