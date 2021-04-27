package chupate4;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {
	private ArrayList<Jugador> lista;
	private static ListaJugadores miListaJugadores=null;
	private static int idJugadorActual=0;
	private boolean sentido=true;
	
	public ListaJugadores() {
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
	public void jugarPartida() {
		Jugador j;
		boolean terminar=false;
		while (!terminar) {
			j=this.buscarJugadorPorId((ListaJugadores.idJugadorActual) % this.cantidadJugadores());
			terminar=j.jugarTurno();
			if (terminar) {
				Baraja.getMiBaraja().terminarPartida();
				System.out.println("Ha ganado "+j.getNombre());
			}
			if (sentido) {//esta comprobacion es para cuando implementemos la carta especial de cambio de sentido
				ListaJugadores.idJugadorActual=ListaJugadores.idJugadorActual+1;
			}
			else {
				ListaJugadores.idJugadorActual=ListaJugadores.idJugadorActual-1;
			}
		}
	}
	public void repartir() {//hubhub
		Iterator <Jugador> itr=this.getIterator();
		Jugador j;
		while (itr.hasNext()) {
			j=itr.next();
			j.cogerCarta(7);
		}
	}
	public int cantidadJugadores() {
		return(this.lista.size());
	}
	public static ListaJugadores getMiListaJugadores() {
		if (ListaJugadores.miListaJugadores==null) {
			ListaJugadores.miListaJugadores=new ListaJugadores();
		}
		return(ListaJugadores.miListaJugadores);
	}
	public Jugador siguienteJugador() {
		int id;
		if (sentido) {//esta comprobacion es para cuando implementemos la carta especial de cambio de sentido
			id=(ListaJugadores.idJugadorActual+1) % this.cantidadJugadores();
		}
		else {
			id=(ListaJugadores.idJugadorActual-1) % this.cantidadJugadores();
		}
		return(this.buscarJugadorPorId(id));
	}
	public void cambiarSentido() {
		if (this.sentido) {
			this.sentido=false;
		}
		else {
			this.sentido=true;
		}
	}
	public void saltarTurno() {
		if (sentido) {//esta comprobacion es para cuando implementemos la carta especial de cambio de sentido
			ListaJugadores.idJugadorActual=ListaJugadores.idJugadorActual+1;
		}
		else {
			ListaJugadores.idJugadorActual=ListaJugadores.idJugadorActual-1;
		}
	}
	
}
