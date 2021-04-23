package chupate4;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {
	private ArrayList<Jugador> lista;
	private static ListaJugadores miListaJugadores=null;
	private static int idJugadorActual;
	private boolean sentido=true;
	
	public ListaJugadores(int pIdJugadorActual) {
		this.lista=new ArrayList<Jugador>();
	}
	private Iterator<Jugador> getIterator(){
		return(this.lista.iterator());
	}
	
	public void anadirJugador(Jugador pJugador) {
		this.lista.add(pJugador);
	}
	
	public void eliminarJugador(Jugador pJugador) {
		this.lista.remove(pJugador);
	}
	
	public Jugador buscarJugadorPorId(int pIdJugador) {
		Jugador j=null;
		Iterator<Jugador>itr=this.getIterator();
		boolean enc=false;
		
		while(itr.hasNext()) {
			j=itr.next();
			if(j.tieneEsteId(pIdJugador)) {
				enc=true;
			}
		}
		if(!enc) {
			return(null);
		}
		return(j);
		
	}
	
}
