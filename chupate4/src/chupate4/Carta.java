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
		int nCarta= Baraja.getMiBaraja().listaEchadas.cantidadCartas;
		if(Baraja.getMiBaraja().listaEchadas.get(nCarta).tieneMismoColor(this)) {
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
	
	public void tirarCarta() {
		Baraja.getMiBaraja().listaEchadas.anadirCarta(this);
	}
	
	public boolean tieneMismoColor(Carta pCarta) {
		boolean mismo=false;
		if(this.color==pCarta.getColor()) {
			mismo=true;
		}
		return mismo;
	}
	
	public abstract boolean tieneMismoNumero(Carta pCarta);
		
	public abstract boolean tieneMismoNumero(int pNum);
	
	public boolean tieneMismoColor(String pColor) {
		boolean tiene=false;
		if(this.color==pColor) {
			tiene=true;
		}
		return tiene;
	}
}
