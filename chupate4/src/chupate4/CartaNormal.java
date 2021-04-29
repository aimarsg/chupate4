package chupate4;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.*;


public class CartaNormal extends Carta{
	//atributos
	private String numero;

	
	//constructora
	public CartaNormal(String pColor,String pNumero) {
		super(pColor);
		this.numero=pNumero;
	}
	
	//métodos
	public void tirarCarta() {}
	
	public boolean sePuedeEchar() {
		boolean puede=false;
		if(!super.sePuedeEchar()) {
			Carta ultimaCarta= Baraja.getMiBaraja().ultimaCarta();
			if(ultimaCarta instanceof CartaNormal) {
				if (((CartaNormal)ultimaCarta).tieneMismoNumero(this.numero)) {
					puede=true;
				}
			}
		}
		return puede;
	}
	
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		//SystConsole.outem.out.println(ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset() );
	
		 
	}
	public boolean tieneMismoNumero(String pString) {
		
		boolean mismo=false;
		
		if(this.numero.equals(pString)) {
			mismo=true;
		}
		return mismo;
	}
	
	public boolean tieneMismoNumero(Carta pCarta) {
		boolean mismo=false;
		if (pCarta instanceof CartaNormal) {
			if (((CartaNormal)pCarta).tieneMismoNumero(this.numero)) {
				mismo=true;
				}
			}
		return mismo;
		}
	}

