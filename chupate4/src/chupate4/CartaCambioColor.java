package chupate4;
import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

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
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
			 	System.out.print(ansi().bg(Color.RED).a("C").reset()+" ");
			}else if(super.getColor()=="amarillo") {
				System.out.print(ansi().bg(Color.YELLOW).a("C").reset()+" ");
			}else if(super.getColor()=="azul") {
				System.out.print(ansi().bg(Color.BLUE).a("C").reset()+" ");
			}else if(super.getColor()=="verde"){
				System.out.print(ansi().bg(Color.GREEN).a("C").reset()+" ");
			}else {
				System.out.print(ansi().bg(Color.BLACK).a("C").reset()+" ");
	}

	    AnsiConsole.systemUninstall();
	}
	
	public void tirarCarta() {
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
		String nColor =this.preguntarColor();
		super.setColor(nColor);
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
		System.out.println("Se ha cambiado el color a "+nColor);
	}
	
}
