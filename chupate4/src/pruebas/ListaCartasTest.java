package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.*;

public class ListaCartasTest {
	ListaCartas l1;
	CartaNormal c1,c2,c3,c4;
	CartaCambioColor ccc;
	CambioSentido cs1,cs2,cs3;
	Bloqueo b1,b2,b3;
	ChupateCuatro cc4;
	ChupateDos cc21,cc22,cc23;
	Jugador j1,j2,j3,j4;
	@Before
	public void setUp() throws Exception {
		l1=new ListaCartas();
		c1=new CartaNormal("azul","1");
		c2=new CartaNormal("amarillo","3");
		c3=new CartaNormal("rojo","5");
		c4=new CartaNormal("verde","5");
		ccc=new CartaCambioColor("negra");
		cs1= new CambioSentido("azul");
		cs2= new CambioSentido("rojo");
		cs3= new CambioSentido("rojo");
		b1= new Bloqueo("rojo");
		b2= new Bloqueo("amarillo");
		b3= new Bloqueo("amarillo");
		cc4= new ChupateCuatro("negro");
		cc21= new ChupateDos("amarillo");
		cc22= new ChupateDos("amarillo");
		cc23= new ChupateDos("verde");
		l1.anadirCarta(c1);
		l1.anadirCarta(c2);
		l1.anadirCarta(c3);
		l1.anadirCarta(c4);
		l1.anadirCarta(ccc);
		l1.anadirCarta(cs1);
		l1.anadirCarta(cs2);
		l1.anadirCarta(cs3);
		l1.anadirCarta(b1);
		l1.anadirCarta(b2);
		l1.anadirCarta(b3);
		l1.anadirCarta(cc4);
		l1.anadirCarta(cc21);
		l1.anadirCarta(cc22);
		l1.anadirCarta(cc23);
		j1=new Jugador("Adrian", 0);
		j2=new Jugador("Iker", 1);
		j3=new Jugador("Aimar", 2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUltimaCarta() {
		assertEquals(l1.ultimaCarta(),cc23);
	}

	@Test
	public void testPuedeEcharCarta() {
	Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(cs1);
	assertTrue(c1.sePuedeEchar());
	assertTrue(cs2.sePuedeEchar());
	assertTrue(ccc.sePuedeEchar());
	assertFalse(c3.sePuedeEchar());
	Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c3);
	assertTrue(c4.sePuedeEchar());
	assertFalse(c1.sePuedeEchar());
	assertTrue(cs2.sePuedeEchar());
	assertFalse(b2.sePuedeEchar());
	
	Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(b3);
	assertTrue(b1.sePuedeEchar());
	assertTrue(cc22.sePuedeEchar());
	assertFalse(c3.sePuedeEchar());
	assertTrue(cc4.sePuedeEchar());
	assertTrue(c2.sePuedeEchar());
	}

	@Test
	public void testBuscarCarta() {
		l1.escribirCartas();
		assertEquals(l1.buscarCarta("1"),c1);
		l1.buscarCarta("1").escribirCarta();
		assertEquals(l1.buscarCarta("9"),b1);
		l1.buscarCarta("9").escribirCarta();
		assertEquals(l1.buscarCarta("12"),cc4);
		l1.buscarCarta("12").escribirCarta();		
	}
	@Test
	public void testTirarCarta() {
		ListaJugadores.getMiListaJugadores().anadirJugador(j1);
		ListaJugadores.getMiListaJugadores().anadirJugador(j2);
		ListaJugadores.getMiListaJugadores().anadirJugador(j3);
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c3);
		//c4.tirarCarta(); //no tiene que ocurrir nada
		Baraja.getMiBaraja().echarCarta(c4);
		assertEquals(Baraja.getMiBaraja().ultimaCarta(),c4);
		//ccc.tirarCarta();//tiene que preguntar el color //PONER ROJO
		Baraja.getMiBaraja().echarCarta(ccc);
		assertTrue(Baraja.getMiBaraja().ultimaCarta().tieneMismoColor("rojo"));//comprueba si se ha cambiado el color
		assertEquals(ListaJugadores.getMiListaJugadores().siguienteJugador(),j2);
		cs2.tirarCarta();
		assertEquals(ListaJugadores.getMiListaJugadores().siguienteJugador(),j3); //se ha cambiado el sentido7
		b1.tirarCarta();
		assertEquals(ListaJugadores.getMiListaJugadores().siguienteJugador(),j2);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(b1);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(b2);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(b3);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c1);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c2);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c3);
		cc4.tirarCarta();
		assertEquals(j2.cantidadCartas(),4);
		
		
		assertEquals(ListaJugadores.getMiListaJugadores().siguienteJugador(),j1);
		cc22.tirarCarta();
		
		assertEquals(j1.cantidadCartas(),2);
		assertEquals(ListaJugadores.getMiListaJugadores().siguienteJugador(),j3);
	}

}
