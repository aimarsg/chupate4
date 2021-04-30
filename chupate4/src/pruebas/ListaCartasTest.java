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

}
