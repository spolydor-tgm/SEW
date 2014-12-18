package headfirst.combining.observer.test;

import headfirst.combining.observer.MoorEnte;
import headfirst.combining.observer.Quakologe;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MoorEnteTest {

	private MoorEnte moorEnte;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		moorEnte = new MoorEnte();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testQuaken() throws Exception {
		moorEnte.quaken();
		assertEquals("Quak", outContent.toString().trim());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {
		moorEnte.registriereBeobachter(new Quakologe());
		moorEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Moorente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {
		moorEnte.registriereBeobachter(new Quakologe());
		moorEnte.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Moorente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Moorente", moorEnte.toString());
	}
}