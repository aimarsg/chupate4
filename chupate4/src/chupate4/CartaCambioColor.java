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
		System.out.println("A que color quieres cambiar?");
		boolean todoOk=false;	
		String color =Teclado.getMiTeclado().leerString();
		do {System.out.println();
		
			try {
				
				
				if(!color.equals("azul") && !color.equals("amarillo") && !color.equals("rojo") && !color.equals("verde")) {
					throw new ColorNoValido();
				}
				else {
					todoOk=true;
					
					}
			}
			catch(ColorNoValido e) {
				System.out.println("Escribe un color valido en minusculas");
				color=Teclado.getMiTeclado().leerString();
			}
		}while(!todoOk);
		return color;	
	}

		
		
	
	public boolean sePuedeEchar() {
		return (true);
	}
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
			 	System.out.print(ansi().bg(Color.RED).a(" C ").reset()+" ");
			}else if(super.getColor()=="amarillo") {
				System.out.print(ansi().bg(Color.YELLOW).a(" C ").reset()+" ");
			}else if(super.getColor()=="azul") {
				System.out.print(ansi().bg(Color.BLUE).a(" C ").reset()+" ");
			}else if(super.getColor()=="verde"){
				System.out.print(ansi().bg(Color.GREEN).a(" C ").reset()+" ");
			}else {
				System.out.print(ansi().bg(Color.WHITE).fg(Color.BLACK).a(" C ").reset()+" ");
	}

	    AnsiConsole.systemUninstall();
	}
	
	public void tirarCarta() {
		System.out.print("[ ");
		this.escribirCarta();
		System.out.println("]");
		String nColor =this.preguntarColor();
		super.setColor(nColor);
		System.out.print("[ ");
		this.escribirCarta();
		System.out.println("]");
		System.out.println("Se ha cambiado el color a "+nColor);
	}
	
}
