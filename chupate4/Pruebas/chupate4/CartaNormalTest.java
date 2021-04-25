package chupate4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaNormalTest {
	CartaNormal c1;
	@BeforeEach
	void setUp() throws Exception {
		c1=new CartaNormal("azul",7);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEscribirCarta() {
		c1.escribirCarta();
	}

}
