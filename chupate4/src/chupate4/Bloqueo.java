package chupate4;


public class Bloqueo extends EspecialesColor{



	public Bloqueo(String pColor) {
		super(pColor);
	}
	
	public void tirarCarta() {
		ListaJugadores.getMiListaJugadores().saltarTurno();
	}
	
	public void escribirCarta() {

	}
	public String devolverString() {
		return("bloqueo  "+super.getColor());
	}
	
	public boolean sePuedeEchar() {
		boolean puede =false;
		if(!super.sePuedeEchar()) {
			if(Baraja.getMiBaraja().ultimaCarta() instanceof Bloqueo) {
				puede=true;
			}
		}
		return puede;
	}
}
