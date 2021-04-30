package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chupate4.CartaNormal;
import chupate4.ListaCartas;

public class ListaCartasTest {
	ListaCartas l1;
	CartaNormal c1,c2,c3;
	@Before
	public void setUp() throws Exception {
		l1=new ListaCartas();
		c1=new CartaNormal("azul","1");
		c2=new CartaNormal("amarillo","3");
		c3=new CartaNormal("amarillo","5");
		l1.anadirCarta(c1);
		l1.anadirCarta(c2);
		l1.anadirCarta(c3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMezclar() {
		fail("Not yet implemented");
	}

	@Test
	public void testPuedeEcharCarta() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarCarta() {
		String frase="azul 1";
		l1.buscarCarta(frase);
		String frase2="amarillo 5";
		l1.buscarCarta(frase2);
		String frase3="amarillo 6";
		l1.buscarCarta(frase3);
	}

}
