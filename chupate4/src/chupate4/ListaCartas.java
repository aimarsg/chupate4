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
	
	//el string que se recibe en este metodo es un numero que esta entre 1 y el numero total de cartas

	int posnum=Integer.parseInt(pString)-1;
	return this.lista.get(posnum);
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
