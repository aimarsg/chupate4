package chupate4;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

public class ChupateCuatro extends CartaCambioColor {
	
	public ChupateCuatro(String pColor) {
		super(pColor);
		
	}

	public void tirarCarta(){
		System.out.print("[ ");
		this.escribirCarta();
		System.out.println("]");
		System.out.println("El siguiente jugador"+ListaJugadores.getMiListaJugadores().siguienteJugador().getNombre()+" roba 4 cartas!");
		System.out.println("Se le salta el turno a "+ListaJugadores.getMiListaJugadores().siguienteJugador().getNombre());
		ListaJugadores.getMiListaJugadores().siguienteJugador().cogerCarta(4);
		System.out.println(" Tendrá "+ListaJugadores.getMiListaJugadores().siguienteJugador().cantidadCartas()+ "cartas. ");
		String nColor=this.preguntarColor();
		this.setColor(nColor);
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
		System.out.println("Se ha cambiado el color a "+nColor);
		ListaJugadores.getMiListaJugadores().saltarTurno();
		
		
}
	public String preguntarColor() {
		System.out.println("¿A que color quieres cambiar?");
		String color =Teclado.getMiTeclado().leerString();
		
		return color;
	}
		
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
			 	System.out.print(ansi().bg(Color.RED).a("+4").reset()+" ");
			}else if(super.getColor()=="amarillo") {
				System.out.print(ansi().bg(Color.YELLOW).a("+4").reset()+" ");
			}else if(super.getColor()=="azul") {
				System.out.print(ansi().bg(Color.BLUE).a("+4").reset()+" ");
			}else if(super.getColor()=="verde"){
				System.out.print(ansi().bg(Color.GREEN).a("+4").reset()+" ");
			}else {
				System.out.print(ansi().bg(Color.WHITE).fg(Color.BLACK).a("+4").reset()+" ");
	}

	    AnsiConsole.systemUninstall();
	}

}

