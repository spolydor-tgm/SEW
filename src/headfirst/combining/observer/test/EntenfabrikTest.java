package headfirst.combining.observer.test;

import headfirst.combining.observer.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EntenfabrikTest extends Entenfabrik {

	private Entenfabrik entenfabrik;

	@Before
	public void setUp() throws Exception {
		entenfabrik = new Entenfabrik();
	}

	@Test
	public void testErzeugeStockEnte() throws Exception {
		assertEquals(new StockEnte().toString(), entenfabrik.erzeugeStockEnte().toString());
	}

	@Test
	public void testErzeugeMoorEnte() throws Exception {
		assertEquals(new MoorEnte().toString(), entenfabrik.erzeugeMoorEnte().toString());
	}

	@Test
	public void testErzeugeLockPfeife() throws Exception {
		assertEquals(new LockPfeife().toString(), entenfabrik.erzeugeLockPfeife().toString());
	}

	@Test
	public void testErzeugeGummiEnte() throws Exception {
		assertEquals(new GummiEnte().toString(), entenfabrik.erzeugeGummiEnte().toString());
	}
}