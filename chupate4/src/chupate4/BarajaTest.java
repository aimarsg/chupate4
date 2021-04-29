package chupate4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BarajaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CrearBarajatest() {
		Baraja.getMiBaraja().crearBaraja();
		Baraja.getMiBaraja().escribirBaraja();
	}

}
