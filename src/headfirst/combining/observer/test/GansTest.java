package headfirst.combining.observer.test;

import headfirst.combining.observer.Gans;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class GansTest {

	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testSchnattern() throws Exception {
		new Gans().schnattern();
		assertEquals("Schnatter", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Gans", new Gans().toString());
	}
}