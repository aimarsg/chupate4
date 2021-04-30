package chupate4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class ListaCartas {
	private ArrayList<Carta> lista;

public ListaCartas() {
	this.lista=new ArrayList<Carta>();
}
private Iterator<Carta> getIterador(){
	return(this.lista.iterator());
}
public void anadirCarta(Carta pCarta) {
	this.lista.add(pCarta);
}
public void eliminarCarta(Carta pCarta) {
	this.lista.remove(pCarta);
}
public void mezclar() {
		Collections.shuffle(this.lista);	
	}
public int cantidadCartas()	{
	return(this.lista.size());
}
public boolean puedeEcharCarta() {
	Iterator<Carta> itr=this.getIterador();
	boolean enc=false;
	Carta cartaAux=null;
	while (itr.hasNext()&& !enc) {
		cartaAux=itr.next();
		if(cartaAux.sePuedeEchar()) {
			enc=true;
		}
	
	}
	return(enc);
}
public Carta ultimaCarta(){
	return(this.lista.get(this.cantidadCartas()-1));
}


public Carta buscarCarta(String pString) {
	
	// color numero "negro 2"// color 
	
	boolean enc=false;
	int cont=1;
	String pos="";
	int posnum=0;
	while(pString.length()!=cont) {
			pos=pos+pString.charAt(cont);
			
			cont=cont+1;
	}
	posnum=Integer.parseInt(pos);
	return this.lista.get(posnum);
	
	
	
	
	
		/*while (pString.charAt(pos) != ' ') {
			color=color+pString.charAt(pos);
			pos=pos+1;
		}
		System.out.println(color);
		pos=pos+1;
		
		while (pos!=pString.length()) {
			numero=numero+pString.charAt(pos);
			pos=pos+1;
		}
		System.out.println(numero);
		
		//int numero1=Integer.parseInt(numero);
		//CartaNormal carta1=new CartaNormal(color, numero1);
		//carta1.escribirCarta();
		
	
		
		Iterator <Carta> itr= this.getIterador();
		Carta cartaAux=null;
		boolean enc=false;
		while (itr.hasNext()&&!enc) {
			cartaAux=itr.next();
			if(cartaAux.tieneMismoColor(color)) {
				if(numero=="cambio sentido") {
					if(cartaAux instanceof CambioSentido){
					enc=true;
				}
			}
			else if(numero=="bloqueo") {
				if(cartaAux instanceof Bloqueo) {
					enc=true;
				}
				
			}else if(numero=="cambio color") {
				if(cartaAux instanceof CartaCambioColor) {
					enc=true;
				}
					}
				}
			}
			
			else if(numero=="chupate cuatro") {
				if(cartaAux instanceof ChupateDos) {
					enc=true;
				}
			}
			
		}
		}
		if(!enc) {
			System.out.println("no esta esa carta");
			return(null);
		}
		else{
			cartaAux.escribirCarta();
			return(cartaAux);
		}
	*/
	}
	public void escribirCartas() {
		Iterator<Carta> itr=this.getIterador();
		Carta cartaAux=null;
		System.out.println("");
		System.out.println("Estas son tus cartas:");
		System.out.println("");
		System.out.print("[ ");
		while (itr.hasNext()){
			cartaAux=itr.next();
			cartaAux.escribirCarta();
			
			}
		System.out.print("]");
		System.out.println("");
		}






}
