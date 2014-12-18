package headfirst.combining.observer.test;

import headfirst.combining.observer.GummiEnte;
import headfirst.combining.observer.Quakfaehig;
import headfirst.combining.observer.Quakologe;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class QuakologeTest {
	private Quakologe quakologe;
	private Quakfaehig ente;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		quakologe= new Quakologe();
		ente = new GummiEnte();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAktualisieren() throws Exception {
		quakologe.aktualisieren(ente);
		assertEquals("Quakologe: Gummiente hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Quakologe",quakologe.toString());
	}
}