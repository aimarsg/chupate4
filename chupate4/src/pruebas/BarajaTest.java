package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.Baraja;
import chupate4.*
;public class BarajaTest {
	Baraja b1;
	Jugador j1,j2,j3,j4;
	ListaJugadores l1;
	@Before
	public void setUp() throws Exception {
	j1=new Jugador("Alberto",1);
	j2=new Jugador("Ander",2);
	j3=new Jugador("Aleja",3);
	j4=new Jugador("Alvaro",4);
	

	
	
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnadirJugadores() {
		Baraja.getMiBaraja().anadirJugadores();
		assertEquals(ListaJugadores.getMiListaJugadores().cantidadJugadores(),4);
	}

	@Test
	public void testDarVueltaCartas() {
		fail("Not yet implemented");
	}

	@Test
	public void testRobar() {
		fail("Not yet implemented");
	}

	@Test
	public void testUltimaCarta() {
		fail("Not yet implemented");
	}

	@Test
	public void testJugarPartida() {
		fail("Not yet implemented");
	}

}
