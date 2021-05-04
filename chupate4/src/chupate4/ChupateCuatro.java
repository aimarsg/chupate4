package chupate4;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

public class ChupateCuatro extends CartaCambioColor {
	
	public ChupateCuatro(String pColor) {
		super(pColor);
		
	}

	public void tirarCarta(){
		String nColor=this.preguntarColor();
		this.setColor(nColor);
		System.out.print("[ ");
		this.escribirCarta();
		System.out.println("]");
		System.out.println("Se ha cambiado el color a "+nColor);
		System.out.print("[ ");
		this.escribirCarta();
		System.out.println("]");
		System.out.println(ListaJugadores.getMiListaJugadores().siguienteJugador().getNombre()+" roba 4 cartas!");
		System.out.println("Se le salta el turno a "+ListaJugadores.getMiListaJugadores().siguienteJugador().getNombre());
		ListaJugadores.getMiListaJugadores().siguienteJugador().cogerCarta(4);
		System.out.println("Tendra "+ListaJugadores.getMiListaJugadores().siguienteJugador().cantidadCartas()+ " cartas. ");
		ListaJugadores.getMiListaJugadores().saltarTurno();
		
		
}
		
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor().equals("rojo")) {
			 	System.out.print(ansi().bg(Color.RED).a("+4").reset()+" ");
			}else if(super.getColor().equals("amarillo")) {
				System.out.print(ansi().bg(Color.YELLOW).a("+4").reset()+" ");
			}else if(super.getColor().equals("azul")) {
				System.out.print(ansi().bg(Color.BLUE).a("+4").reset()+" ");
			}else if(super.getColor().equals("verde")){
				System.out.print(ansi().bg(Color.GREEN).a("+4").reset()+" ");
			}else {
				System.out.print(ansi().bg(Color.WHITE).fg(Color.BLACK).a("+4").reset()+" ");
	}

	    AnsiConsole.systemUninstall();
	}

}

