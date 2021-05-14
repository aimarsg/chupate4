package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.*;

public class ListaJugadoresTest {
	Jugador j1,j2,j3,j4;
	ListaJugadores l1;
	@Before
	public void setUp() throws Exception {
		j1= new Jugador("Adrian", 0);
		j2= new Jugador("Aimar",1);
		j3= new Jugador("Alvaro", 2);
		j4= new Jugador("Darka", 3);
		
		l1= ListaJugadores.getMiListaJugadores();
		
		l1.anadirJugador(j1);
		l1.anadirJugador(j2);
		l1.anadirJugador(j3);
		l1.anadirJugador(j4);
	}

	@After
	public void tearDown() throws Exception {
		j1=null;
		j2=null;
		j3=null;
		j4=null;
		
		l1.resetearListaJugadores();
		
		
	}

	@Test
	public void testListaJugadores() {
		assertNotNull(l1);
	}

	@Test
	public void testAnadirJugadorYCantidadYEliminarJugador() {
		Jugador j5;
		j5= new Jugador("Iker", 4);
		
		assertEquals(l1.cantidadJugadores(),4);
		l1.anadirJugador(j5);
		assertEquals(l1.cantidadJugadores(),5);
		l1.eliminarJugador(j2);
		l1.eliminarJugador(j3);
		assertEquals(l1.cantidadJugadores(),3);
		
	}


	@Test
	public void testBuscarJugadorPorId() {
		Jugador j5;
		
		j5=l1.buscarJugadorPorId(1);
		assertTrue(j5.tieneEsteId(1));
		
		j5=l1.buscarJugadorPorId(2);
		assertFalse(j5.tieneEsteId(3));
		
		j5=l1.buscarJugadorPorId(7);
		assertNull(j5);
		
	}

	@Test
	public void testJugarPartida() {/*
		Baraja.getMiBaraja().crearBaraja();
		Baraja.getMiBaraja().barajear();
		Baraja.getMiBaraja().repartir();
		Baraja.getMiBaraja().sacarPrimeraCarta();
		l1.jugarPartida();*/
	}

	@Test
	public void testRepartir() {
		Baraja.getMiBaraja().crearBaraja();
		Baraja.getMiBaraja().barajear();
		l1.repartir();
		j1.escribirMano();
		j2.escribirMano();
		j3.escribirMano();
		j4.escribirMano();
	}


	@Test
	public void testGetMiListaJugadores() {
		assertNotNull(ListaJugadores.getMiListaJugadores());
	}

	//@Test
	public void testJugadorSeQuedaSinCartas() {
		CartaNormal carta;
		carta=new CartaNormal("azul", "8");
		
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(carta);
		l1.resetearListaJugadores();
		l1.anadirJugador(j1);
		l1.anadirJugador(j2);
		ChupateCuatro pCarta;
		pCarta= new ChupateCuatro("negro");
		j1.anadir(pCarta);
		l1.jugarPartida();
	}

	@Test
	public void testSiguienteJugadorYCambiarSentidoYSaltarTurno() {
		Jugador j5;
		
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(1));
		
		l1.cambiarSentido();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(3));
		
		l1.saltarTurno();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(2));
		
		l1.cambiarSentido();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(0));
		
		
		l1.saltarTurno();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(1));
		
		l1.eliminarJugador(j3);
		l1.eliminarJugador(j4);
		
		l1.cambiarSentido();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(0));
		
		l1.saltarTurno();
		j5= l1.siguienteJugador();
		assertTrue(j5.tieneEsteId(1));
	}

	
	
	

	@Test
	public void testResetearListaJugadores() {
		l1.resetearListaJugadores();
		assertEquals(l1.cantidadJugadores(),0);
	}
	@Test
	public void robaYNoPuede () {
		l1.resetearListaJugadores();
		CartaNormal carta,carta1,cartaJ;
		carta=new CartaNormal("azul", "8");
		carta1=new CartaNormal("roja","1");
		cartaJ=new CartaNormal("amarillo","2");
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(carta);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(carta1);
		l1.anadirJugador(j1);
		l1.anadirJugador(j2);
		j1.anadir(cartaJ);
		l1.jugarPartida();
			
	}
	@Test
	public void noHayCartasParaRobar() {
		l1.resetearListaJugadores();
		CartaNormal carta,carta1,cartaJ;
		carta=new CartaNormal("azul", "8");
		carta1=new CartaNormal("roja","1");
		cartaJ=new CartaNormal("amarillo","2");
		CartaNormal carta2=new CartaNormal("amarillo","3");
		ChupateCuatro carta4=new ChupateCuatro("negro");
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(carta);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(carta1);	
		j1.anadir(carta4);
		j1.anadir(carta2);
		j2.anadir(cartaJ);
		l1.anadirJugador(j1);
		l1.anadirJugador(j2);
		l1.jugarPartida();
	}
}
