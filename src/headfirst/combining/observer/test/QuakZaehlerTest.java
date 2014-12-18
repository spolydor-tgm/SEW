package headfirst.combining.observer.test;

import headfirst.combining.observer.GummiEnte;
import headfirst.combining.observer.QuakZaehler;
import headfirst.combining.observer.Quakfaehig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class QuakZaehlerTest {

	private Quakfaehig ente;
	private QuakZaehler quakZaehler;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		ente = new GummiEnte();
		System.setOut(new PrintStream(outContent));
		quakZaehler = new QuakZaehler(ente);
	}

	@Test
	public void testQuaken() throws Exception {
		quakZaehler.quaken();
		assertEquals("Quietsch",outContent.toString().trim());
	}

	@Test
	public void testGetQuaks() throws Exception {
		quakZaehler.quaken();
		assertEquals(2,quakZaehler.getQuaks());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {

	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {

	}

	@Test
	public void testToString() throws Exception {

	}
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}