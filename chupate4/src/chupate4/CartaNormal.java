package chupate4;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

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
	public void tirarCarta() {
		System.out.println("[ ");
		this.escribirCarta();
		System.out.print("]");
	}
	
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
		
        if(super.getColor()=="rojo") {
        	System.out.print(ansi().bg(Color.RED).a(" "+this.numero+" ").reset()+" ");
        }else if(super.getColor()=="amarillo") {
            System.out.print(ansi().bg(Color.YELLOW).a(" "+this.numero+" ").reset()+" ");
        }else if(super.getColor()=="azul") {
            System.out.print(ansi().bg(Color.BLUE).a(" "+this.numero+" ").reset()+" ");
        }else {
            System.out.print(ansi().bg(Color.GREEN).a(" "+this.numero+" ").reset()+" ");
        }

        AnsiConsole.systemUninstall();
		 
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

