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
import chupate4.PosicionNoValida;
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
	Jugador j1,j2,j3,j4;
	ListaCartas l;
	ListaJugadores lista;
	ChupateCuatro carta1;
	

	@Before
	public void setUp() throws Exception {
		lista=ListaJugadores.getMiListaJugadores();
		 j1=new Jugador("Juan",1);
		 j2=new Jugador("Juan2",2);
		 j3=new Jugador("Juan3",3);
		 j4=new Jugador("Juan4",4);
		lista.anadirJugador(j1);
		lista.anadirJugador(j2);
		lista.anadirJugador(j3);
		lista.anadirJugador(j4);
		ListaCartas l=new ListaCartas();
		carta1=new ChupateCuatro("negro");
		l.anadirCarta(carta1);
		lista.buscarJugadorPorId(1).anadir(carta1);
	
	}

	@After
	public void tearDown() throws Exception {
		ListaJugadores.getMiListaJugadores().resetearListaJugadores();
		
		
		
	}

	@Test
	public void testTirarCarta() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecirUno() {
		j1.decirUno("1 dos");
		assertTrue(lista.buscarJugadorPorId(1).cantidadCartas()==3);
		lista.buscarJugadorPorId(2).anadir(carta1);
		j2.decirUno("1 uno");
		assertTrue(lista.buscarJugadorPorId(1).cantidadCartas()==1);
		
	}

	@Test
	public void testJugarTurno() {
		fail("Not yet implemented");
	}

}
