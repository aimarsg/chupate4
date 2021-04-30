package chupate4;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

public class ChupateDos extends EspecialesColor {
	public ChupateDos(String pColor) {
		super(pColor);
	}
	public void tirarCarta() {
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
		System.out.println("�El siguiente jugador roba dos cartas!");
		ListaJugadores.getMiListaJugadores().siguienteJugador().cogerCarta(2);;
		ListaJugadores.getMiListaJugadores().saltarTurno();
		
	}
	
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
		 System.out.print(ansi().bg(Color.RED).a("+2").reset()+" ");
		}else if(super.getColor()=="amarillo") {
			System.out.print(ansi().bg(Color.YELLOW).a("+2").reset()+" ");
		}else if(super.getColor()=="azul") {
			System.out.print(ansi().bg(Color.BLUE).a("+2").reset()+" ");
		}else {
			System.out.print(ansi().bg(Color.GREEN).a("+2").reset()+" ");
		}

	        AnsiConsole.systemUninstall();
		
	}
	
	public boolean sePuedeEchar() {
		boolean sePuede=true;
		if(!super.sePuedeEchar()) {
			sePuede=false;
			if (Baraja.getMiBaraja().ultimaCarta() instanceof ChupateDos) {
				sePuede=true;
			}
		}
		return(sePuede);
	}
	}

