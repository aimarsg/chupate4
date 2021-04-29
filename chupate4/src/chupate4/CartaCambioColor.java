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
			 System.out.println(ansi().bg(Color.RED).a("C").reset());
			}else if(super.getColor()=="amarillo") {
				System.out.println(ansi().bg(Color.YELLOW).a("C").reset());
			}else if(super.getColor()=="azul") {
				System.out.println(ansi().bg(Color.BLUE).a("C").reset());
			}else if(super.getColor()=="verde"){
				System.out.println(ansi().bg(Color.GREEN).a("C").reset());
			}else {
				System.out.println(ansi().bg(Color.BLACK).a("C").reset());
	}

	    AnsiConsole.systemUninstall();
	}
	
	public void tirarCarta() {
		this.escribirCarta();
		String nColor =this.preguntarColor();
		super.setColor(nColor);
		this.escribirCarta();
		System.out.println("Se ha cambiado el color a "+nColor);
	}
	
}
