package chupate4;

public abstract class EspecialesColor extends Carta{
	
	public EspecialesColor(String pColor) {
		super(pColor);
	}
	public abstract void escribirCarta();
	
	public boolean sePuedeEchar() {
		return(super.sePuedeEchar());
	}
	

}
