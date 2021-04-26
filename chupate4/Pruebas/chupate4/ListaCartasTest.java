package chupate4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaCartasTest {
	ListaCartas l1;
	CartaNormal carta1,carta2;
	@BeforeEach
	void setUp() throws Exception {

		ListaCartas l1=new ListaCartas();
		carta1=new CartaNormal("azul",1);
		carta2=new CartaNormal("amarillo",5);
		l1.anadirCarta(carta1);
		l1.anadirCarta(carta2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMezclar() {
		fail("Not yet implemented");
	}

	@Test
	void testPuedeEcharCarta() {
		assertEquals(l1.cantidadCartas(),2);
	}

	@Test
	void testBuscarCarta() {
		String pablo="azul 1";
		l1.buscarCarta(pablo);
	}

}
