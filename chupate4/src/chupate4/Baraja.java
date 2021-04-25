package chupate4;

import org.pmoo.packlaboratorio7.Baraja;
import org.pmoo.packlaboratorio7.Carta;

public class Baraja {
	//Atributos
	private ListaCartas listaInicial;
	private ListaCartas listaEchadas;
	private static Baraja miBaraja=null;
	//Constructora
	private Baraja() {
        this.listaEchadas= new ListaCartas();
        this.listaInicial= new ListaCartas();
    }
	//Metodos
    public static Baraja getMiBaraja() {
        if(Baraja.miBaraja == null) {
            Baraja.miBaraja=new Baraja();
        }
        return(Baraja.miBaraja);
    }
	
	public void repartir() {
		ListaJugadores.getMiListaJugadores().repartir();
	}
	public void anadirJugadores() {
		boolean correcto=false;
		int cuantos=0;
		System.out.println("Escribe cuantos jugadores van a jugar la partida: ");
		System.out.println("**El numero de jugadores de la prtida debe ser entre 2 y 10.**");
		//este while es para pedir un numero valido
		while (!correcto) {
			cuantos=Teclado.getMiTeclado().leerEntero();
			if (cuantos>=2 && cuantos<=10) {
				correcto=true;
			}else {//
				System.out.println("El número introducido no es válido, por favor introduce otro");
			}
		}
		//este while es para añadir los jugadores
		int cont=0;
		while (cont<cuantos) {
			System.out.println("Escribe el nombre del jugador "+(cont+1));
			String nombre=Teclado.getMiTeclado().leerString();
			Jugador j=new Jugador(nombre, cont);
			ListaJugadores.getMiListaJugadores().anadirJugador(j);
		}
	}
	
    public void barajear() {
        this.listaInicial.mezclar();
    }

    public void darVueltaCartas() {
        ListaCartas listaAux;
        Carta ulti;

        ulti=this.listaEchadas.ultimaCarta();
        listaAux=listaInicial;
        listaInicial=listaEchadas;
        listaInicial.mezclar();
        listaEchadas=listaAux;

        this.listaEchadas.anadirCarta(ulti);
        this.listaInicial.eliminarCarta(ulti);
    }
    
    public Carta robar() {
		Carta carta;
		
		if (this.listaInicial.cantidadCartas()==0) {
			Baraja.getMiBaraja().darVueltaCartas();
		}
		
		carta= this.listaInicial.ultimaCarta();
		this.listaInicial.eliminarCarta(carta);
		
		return(carta);
	}
	
	public void echarCarta(Carta pCarta) {
		this.listaEchadas.anadirCarta(Carta);
		pCarta.tirarCarta();
	}
	
	public Carta ultimaCarta() {
		this.listaEchadas.ultimaCarta();
	}
}