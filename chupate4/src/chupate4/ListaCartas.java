package chupate4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class ListaCartas {
	private ArrayList<Carta> lista;

public ListaCartas() {
	new ArrayList<Carta>();
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
		if(cartaAux.tieneMismoColor(Baraja.ultimaCarta)||cartaAux.tieneMismoNumero(Baraja.ultimaCarta)) {
			enc=true;
		}
	
	}
	return(enc);
}

public Carta buscarCarta(string pString) {
	
}





}
