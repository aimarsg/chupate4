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
		this.escribirCarta();
		System.out.println("Se ha cambiado el sentido");
		ListaJugadores.getMiListaJugadores().cambiarSentido();
	}
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		if(super.getColor()=="rojo") {
		 System.out.println(ansi().bg(Color.RED).a("</>").reset()+" ");
		}else if(super.getColor()=="amarillo") {
			System.out.println(ansi().bg(Color.YELLOW).a("</>").reset()+" ");
		}else if(super.getColor()=="azul") {
			System.out.println(ansi().bg(Color.BLUE).a("</>").reset()+" ");
		}else {
			System.out.println(ansi().bg(Color.GREEN).a("</>").reset()+" ");
		}

	        AnsiConsole.systemUninstall();
		
	}
	public boolean sePuedeEchar() {
		boolean sePuede=true;
		if(!super.sePuedeEchar()) {
			if (Baraja.getMiBaraja().ultimaCarta() instanceof CambioSentido) {
				sePuede=true;
			}
		}
		return(sePuede);
	}
	
}
