package chupate4;

public class CambioSentido extends EspecialesColor{
	public CambioSentido(String pColor) {
		super(pColor);
	}
	public void tirarCarta() {
		ListaJugadores.getMiListaJugadores().cambiarSentido();
	}
	public void escribirCarta() {
		
	}
	public boolean sePuedeEchar() {
		boolean sePuede=true;
		if(!super.sePuedeEchar()) {
			if (Baraja.getMiBaraja().ultimaCarta() instanceof CambioSentido) {
				sePuede=true;
			}
		}
		return(sePuede);
	}
}
