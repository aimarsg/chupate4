package chupate4;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.*;

public class Bloqueo extends EspecialesColor{



	public Bloqueo(String pColor) {
		super(pColor);
	}
	
	public void tirarCarta() {
		ListaJugadores.getMiListaJugadores().saltarTurno();
	}
	
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		String c=this.getColor();
		if (c.equals("azul")) {
			System.out.println(ansi().bg(Color.BLUE).a("X").reset());
		}else {
			if (c.equals("verde")) {
				System.out.println(ansi().bg(Color.GREEN).a("X").reset());
			}else {
				if (c.equals("rojo")) {
					System.out.println(ansi().bg(Color.RED).a("X").reset());
				}else {
						System.out.println(ansi().bg(Color.YELLOW).a("X").reset());
					}
				}
			}
		AnsiConsole.systemUninstall();
	}

	
	public boolean sePuedeEchar() {
		boolean puede =false;
		if(!super.sePuedeEchar()) {
			if(Baraja.getMiBaraja().ultimaCarta() instanceof Bloqueo) {
				puede=true;
			}
		}
		return puede;
	}
}
