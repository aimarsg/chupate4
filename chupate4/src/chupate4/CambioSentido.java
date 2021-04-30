package chupate4;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.*;

public class CambioSentido extends EspecialesColor{
	public CambioSentido(String pColor) {
		super(pColor);
	}
	public void tirarCarta() {
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
		System.out.println("Se ha cambiado el sentido");
		ListaJugadores.getMiListaJugadores().cambiarSentido();
	}
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
		 System.out.print(ansi().bg(Color.RED).a("</>").reset()+" ");
		}else if(super.getColor()=="amarillo") {
			System.out.print(ansi().bg(Color.YELLOW).a("</>").reset()+" ");
		}else if(super.getColor()=="azul") {
			System.out.print(ansi().bg(Color.BLUE).a("</>").reset()+" ");
		}else {
			System.out.print(ansi().bg(Color.GREEN).a("</>").reset()+" ");
		}

	        AnsiConsole.systemUninstall();
		
	}
	public boolean sePuedeEchar() {
		boolean sePuede=true;
		if(!super.sePuedeEchar()) {
			sePuede=false;
			if (Baraja.getMiBaraja().ultimaCarta() instanceof CambioSentido) {
				sePuede=true;
			}
		}
		return(sePuede);
	}
	
}
