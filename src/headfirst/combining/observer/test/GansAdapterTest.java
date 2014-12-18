package headfirst.combining.observer.test;

import headfirst.combining.observer.Gans;
import headfirst.combining.observer.GansAdapter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GansAdapterTest {

	private GansAdapter gansAdapter;

	@Before
	public void setUp() throws Exception {
		gansAdapter = new GansAdapter(new Gans());
	}

	@Test
	public void testQuaken() throws Exception {

	}

	@Test
	public void testRegistriereBeobachter() throws Exception {

	}

	@Test
	public void testBenachrichtigeBeobachtende() throws Exception {

	}

	@Test
	public void testToString() throws Exception {
		assertEquals("sich als Ente ausgebende Gans", gansAdapter.toString());
	}
}