package chupate4;

public class CartaCambioColor extends Carta{
	//atributos
	
	//constructora
	public CartaCambioColor(String pColor) {
		super(pColor);
	}
	
	public String preguntarColor() {
		System.out.println("¿A qué color quieres cambiar?");
		String color =Teclado.getMiTeclado().leerString();
		return color;
	}
	public boolean sePuedeEchar() {
		return (super.sePuedeEchar());
	}
	public void escribirCarta() {
		
	}
	
	public void tirarCarta() {
		String nColor =this.preguntarColor();
		super.setColor(nColor);
		
	}
	
}