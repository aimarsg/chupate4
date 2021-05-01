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
		String color;
		color=Baraja.getMiBaraja().ultimaCarta().getColor();
		if(this.tieneMismoColor(color)) {
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

/*	public boolean tieneMismoColor(Carta pCarta) {
		boolean mismo=false;
		String c1,c2;
		c1=this.color;
		c2=pCarta.color;
		System.out.println(c1 + c2);
		if(c1==c2) {
			mismo=true;
		}
		return mismo;
	}
*/
	public boolean tieneMismoColor(String pColor) {
		boolean tiene=false;
		if(this.color.equals(pColor)) {
			tiene=true;
		}
		return tiene;
	}
}
