package chupate4;

public class Jugador {

	private int nombre;
	private ListaCartas mano;
	private int idJugador;
	
	
	//constructora
	public Jugador(int pNombre, int pIdJugador) {
		this.nombre= pNombre;
		this.idJugador= pIdJugador;
		this.mano= new ListaCartas();
	}
	
	//otros metodos
	
	public void cogerCarta(int pCuantas) {
		int i = 1;
		Carta carta;
		while (i<=pCuantas) {
			carta= Baraja.getMiBaraja().robar;
			this.mano.anadirCarta(carta);
		}
		
	}
	
	public void tirarCarta() {
		String cartaString;
		Carta carta;
		cartaString=Teclado.getMiTeclado().leerString();
		carta= this.mano.buscarCarta(cartaString);
		if (carta.sePuedeEchar()) {
			Baraja.getMiBaraja().echarCarta(carta);
			this.mano.eliminarCarta(carta);
			this.decirUno(cartaString);
		}
	}
	
	// completar
	public void decirUno() {
		
	}
	
	public void escribirMano() {
		this.mano.escribirCartas();
	}
	
	public int cantidadCartas() {
		return(this.mano.cantidadCartas());
	}
	
	public boolean puedeEcharCarta() {
		this.mano.puedeEcharCarta();
	}
	
}
