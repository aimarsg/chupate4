package chupate4;

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
		this.listaEchadas.anadirCarta(pCarta);
		pCarta.tirarCarta();
	}
	
	public Carta ultimaCarta() {
		return(this.listaEchadas.ultimaCarta());
	}
	public void crearBaraja() {

		int i=0;
		CartaNormal c1,c2,c3,c4,c5,c6,c7,c8;
		while (i<10) {
		c1=new CartaNormal("azul",String.valueOf(i));
		c2=new CartaNormal("azul",String.valueOf(i));
		c3=new CartaNormal("amarillo",String.valueOf(i));
		c4=new CartaNormal("amarillo",String.valueOf(i));
		c5=new CartaNormal("rojo",String.valueOf(i));
		c6=new CartaNormal("rojo",String.valueOf(i));
		c7=new CartaNormal("verde",String.valueOf(i));
		c8=new CartaNormal("verde",String.valueOf(i));
		Baraja.getMiBaraja().listaInicial.anadirCarta(c1);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c2);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c3);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c4);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c5);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c6);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c7);
		Baraja.getMiBaraja().listaInicial.anadirCarta(c8);
		//falta a�adir las especiales
		}

		}
	public void jugarPartida() {
		Baraja.getMiBaraja().crearBaraja();
		Baraja.getMiBaraja().barajear();
		Baraja.getMiBaraja().anadirJugadores();
		Baraja.getMiBaraja().repartir();
		ListaJugadores.getMiListaJugadores().jugarPartida();

		}
	public void terminarPartida() {
		Baraja.getMiBaraja().listaEchadas=new ListaCartas();
		Baraja.getMiBaraja().listaInicial=new ListaCartas();
		ListaJugadores.getMiListaJugadores().resetearListaJugadores();
		}
	}