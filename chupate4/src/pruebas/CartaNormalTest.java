package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.CartaNormal;

public class CartaNormalTest {
	CartaNormal c;

	@Before
	public void setUp() throws Exception {
		c=new CartaNormal("rojo", "1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSePuedeEchar() {
		assertTrue("rojo"=="ROJO");
	}

	@Test
	public void testEscribirCarta() {
		c.escribirCarta();
	}

	@Test
	public void testDevolverString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTirarCarta() {
		fail("Not yet implemented");
	}

	@Test
	public void testCartaNormal() {
		fail("Not yet implemented");
	}

	@Test
	public void testTieneMismoNumeroString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTieneMismoNumeroCarta() {
		fail("Not yet implemented");
	}

}
