package headfirst.combining.observer.test;

import headfirst.combining.observer.Entenfabrik;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Stefan Polydor
 * @version 17.12.14
 */
public class EntenfabrikTest {

	private Entenfabrik entenfabrik;

	@Before
	public void setUp() throws Exception {
		entenfabrik = new Entenfabrik();

	}

	@Test
	public void testErzeugeStockEnte() throws Exception {
		assertEquals("Stockente", entenfabrik.erzeugeStockEnte().toString());
	}

	@Test
	public void testErzeugeMoorEnte() throws Exception {
		assertEquals("Moorente", entenfabrik.erzeugeMoorEnte().toString());
	}

	@Test
	public void testErzeugeLockPfeife() throws Exception {
		assertEquals("Lockpfeife", entenfabrik.erzeugeLockPfeife().toString());
	}

	@Test
	public void testErzeugeGummiEnte() throws Exception {
		assertEquals("Gummiente", entenfabrik.erzeugeGummiEnte().toString());
	}
}
