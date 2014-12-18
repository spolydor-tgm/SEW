package headfirst.combining.observer.test;

import headfirst.combining.observer.Gans;
import headfirst.combining.observer.GansAdapter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class GansAdapterTest {

	private GansAdapter gansAdapter;

	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() throws Exception {
		gansAdapter = new GansAdapter(new Gans());
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testQuaken() throws Exception {
		gansAdapter.quaken();
		assertEquals("Schnatter", outContent.toString().trim());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {
		gansAdapter.registriereBeobachter(new );
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {

	}

	@Test
	public void testToString() throws Exception {
		assertEquals("sich als Ente ausgebende Gans", gansAdapter.toString());
	}
}