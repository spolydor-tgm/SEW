package headfirst.combining.observer.test;

import headfirst.combining.observer.LockPfeife;
import headfirst.combining.observer.Quakologe;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class LockPfeifeTest {

	private LockPfeife lockPfeife;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() throws Exception {
		lockPfeife = new LockPfeife();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testQuaken() throws Exception {
		lockPfeife.quaken();
		assertEquals("Kwaak", outContent.toString().trim());
	}

	@Test
	public void testRegistriereBeobachter() throws Exception {
		lockPfeife.registriereBeobachter(new Quakologe());
		lockPfeife.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Lockpfeife hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {
		lockPfeife.registriereBeobachter(new Quakologe());
		lockPfeife.benachrichtigeBeobachtende();
		assertEquals("Quakologe: Lockpfeife hat gerade gequakt.", outContent.toString().trim());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("Lockpfeife", lockPfeife.toString());
	}
}