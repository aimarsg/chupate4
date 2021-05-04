package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.*
;public class BarajaTest {
	Baraja b1;
	Jugador j1,j2,j3,j4;
	ListaJugadores l1;
	CartaNormal c1,c2,c3;
	ChupateCuatro cc4;
	@Before
	public void setUp() throws Exception {
	j1=new Jugador("Alberto",1);
	j2=new Jugador("Ander",2);
	j3=new Jugador("Aleja",3);
	j4=new Jugador("Alvaro",4);
	
	c1=new CartaNormal("azul","8");
	c2=new CartaNormal("amarillo","8");
	c3=new CartaNormal("verde", "6");
	cc4=new ChupateCuatro("negro");
	
	
	}

	@After
	public void tearDown() throws Exception {
		Baraja.getMiBaraja().resetearListas();
	}

	@Test
	public void testAnadirJugadores() {
		/* int cuantos;
		cuantos=Baraja.getMiBaraja().preguntarNumJugadores();
		
		Baraja.getMiBaraja().anadirJugadores(cuantos);
		assertEquals(ListaJugadores.getMiListaJugadores().cantidadJugadores(),cuantos);
		*/
	}

	@Test
	public void testDarVueltaCartas() {
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c1);
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c2);
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),0);
		Baraja.getMiBaraja().darVueltaCartas();
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),1);
	}

	@Test
	public void testRobar() {
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c1);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c2);
		Baraja.getMiBaraja().robar();
		Baraja.getMiBaraja().robar();
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),0);
		
		
		Baraja.getMiBaraja().resetearListas();
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(cc4);
		assertEquals(Baraja.getMiBaraja().cartasDisponibles(), 0);
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c1);
		assertEquals(Baraja.getMiBaraja().cartasDisponibles(), 1);
		assertEquals(Baraja.getMiBaraja().robar(),cc4);
	}

	@Test
	public void testUltimaCarta() {
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(c1);
		assertEquals(Baraja.getMiBaraja().ultimaCarta(),c1);
	}

	
	@Test
	public void testSacarPrimeraCarta() {
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c1);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c2);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(cc4);
		Baraja.getMiBaraja().sacarPrimeraCarta();
		
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),1);
		assertTrue(Baraja.getMiBaraja().ultimaCarta() instanceof CartaNormal);
		
		Baraja.getMiBaraja().eliminarUnaCartaEchadaParaPruebas(c2);
		Baraja.getMiBaraja().eliminarUnaCartaEchadaParaPruebas(cc4);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(cc4);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(c3);
		Baraja.getMiBaraja().sacarPrimeraCarta();
		
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),2);
		assertTrue(Baraja.getMiBaraja().ultimaCarta() instanceof CartaNormal);
	}
	@Test
	public void terminarPartida() {
		Baraja.getMiBaraja().terminarPartidaParaPruebas();//verificar que las listas estan vacias
		assertEquals(ListaJugadores.getMiListaJugadores().cantidadJugadores(),0);
		assertEquals(Baraja.getMiBaraja().cantidadCartasListaInicial(),0);
		assertEquals(Baraja.getMiBaraja().cartasDisponibles(),-1);// es -1 porque el metodo hace 0-1+0=-1
		
	}

}
