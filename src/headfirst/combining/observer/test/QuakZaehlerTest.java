package headfirst.combining.observer.test;

import headfirst.combining.observer.GummiEnte;
import headfirst.combining.observer.QuakZaehler;
import headfirst.combining.observer.Quakfaehig;
import headfirst.combining.observer.Quakologe;
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
		quakZaehler.registriereBeobachter(new Quakologe());
		quakZaehler.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Gummiente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {
		quakZaehler.registriereBeobachter(new Quakologe());
		quakZaehler.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Gummiente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals(ente.toString(),quakZaehler.toString());
	}
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}