package pruebas;
import chupate4.ListaCartas;
import chupate4.Carta;
import chupate4.CartaNormal;
import chupate4.Bloqueo;
import chupate4.CartaCambioColor;
import chupate4.ChupateCuatro;
import chupate4.ChupateDos;
import chupate4.EspecialesColor;
import chupate4.CambioSentido;
import chupate4.PosicionNoValidaException;
import chupate4.Baraja;
import chupate4.Teclado;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.Jugador;
import chupate4.ListaJugadores;

public class JugadorTest {
	Jugador j1,j2,j3,j4,j8085;
	ListaCartas l;
	ListaJugadores lista;
	ChupateCuatro carta1;
	CambioSentido cambios;
	CartaNormal normal;
	CartaCambioColor cambiocolor;
	Bloqueo bloqueo;
	

	@Before
	public void setUp() throws Exception {
		lista=ListaJugadores.getMiListaJugadores();
		 j1=new Jugador("Juan",1);
		 j2=new Jugador("Juan2",2);
		 j3=new Jugador("Juan3",3);
		 j4=new Jugador("Juan4",4);
		 j8085=new Jugador("jose",5);
		lista.anadirJugador(j1);
		lista.anadirJugador(j2);
		lista.anadirJugador(j3);
		lista.anadirJugador(j4);
		ListaCartas l=new ListaCartas();
		carta1=new ChupateCuatro("negro");
		cambios= new CambioSentido("azul");
		normal=new CartaNormal("rojo", "1");
		cambiocolor= new CartaCambioColor("amarillo");
		bloqueo= new Bloqueo("verde");
		
		l.anadirCarta(carta1);
		lista.buscarJugadorPorId(1).anadir(carta1);
		lista.buscarJugadorPorId(1).anadir(cambios);
		lista.buscarJugadorPorId(1).anadir(normal);
		lista.buscarJugadorPorId(1).anadir(cambiocolor);
		lista.buscarJugadorPorId(2).anadir(bloqueo);
	
	}

	@After
	public void tearDown() throws Exception {
		ListaJugadores.getMiListaJugadores().resetearListaJugadores();
		
		
		
	}

	@Test
	public void jugarTurno() throws InterruptedException {
		assertEquals(j8085.cantidadCartas(),0);
		j8085.anadir(cambios);
		Baraja.getMiBaraja().resetearListas();
		Baraja.getMiBaraja().anadirUnaCartaEchadaParaPruebas(normal);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(bloqueo);
		j8085.jugarTurno();
//
	}

	@Test
	public void testDecirUno() {
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(bloqueo);
		Baraja.getMiBaraja().anadirCartaInicialParaPruebas(normal);
		j1.decirUno("1 dos");
		assertEquals(lista.buscarJugadorPorId(1).cantidadCartas(),4);
		lista.buscarJugadorPorId(2).anadir(carta1);
		j2.decirUno("1 uno");
		assertEquals(lista.buscarJugadorPorId(1).cantidadCartas(),1);
		j2.decirUno("1");
		assertEquals(lista.buscarJugadorPorId(1).cantidadCartas(),3);
	}

	@Test
	public void testJugarTurno() {
		fail("Not yet implemented");
	}

}
