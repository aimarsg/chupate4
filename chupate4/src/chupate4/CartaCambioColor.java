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
		
		 System.out.println(ansi().bg(Color.BLACK).a("C").reset());
		

	        AnsiConsole.systemUninstall();
	}
	
	public void tirarCarta() {
		String nColor =this.preguntarColor();
		super.setColor(nColor);
		
	}
	
}
