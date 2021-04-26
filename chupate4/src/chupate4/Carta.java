package chupate4;

public abstract class Carta {
	//atributos
	private String color;
	
	//constructora
	public Carta(String pColor) {
		this.color=pColor;
	}
	
	//métodos
	public boolean sePuedeEchar() {
		boolean puede=false;
		
		if(Baraja.getMiBaraja().ultimaCarta().tieneMismoColor(this)) {
			puede=true;
		}
		return puede;
	}
	
	protected String getColor() {
		return this.color;
	}
	
	protected void setColor(String pColor) {
		this.color=pColor;
	}
	
	public abstract void escribirCarta();
	
	
	public abstract void tirarCarta(); // este metodo lo que hace es realizar las acciones que desencadena tirar esa carta. Cambio de sentido, bloquear...

	public boolean tieneMismoColor(Carta pCarta) {
		boolean mismo=false;
		if(this.color==pCarta.getColor()) {
			mismo=true;
		}
		return mismo;
	}
	
	
	public abstract boolean tieneMismoNumero(Carta pCarta);
		
	public abstract boolean tieneMismoNumeroString(String pString);
	public abstract boolean tieneMismoNumeroInt(int pNum);
	
	
	public boolean tieneMismoColor(String pColor) {
		boolean tiene=false;
		if(this.color.equals(pColor)) {
			tiene=true;
		}
		return tiene;
	}
}
