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
	public int preguntarNumJugadores() {
		
		int cuantos;
		System.out.println("**El numero de jugadores de la partida debe ser entre 2 y 10.**");
		System.out.println("Escribe cuantos jugadores van a jugar la partida: ");
		//este while es para pedir un numero valido
		cuantos=Teclado.getMiTeclado().leerEntero(2, 10);
		
		return(cuantos);
	}
	public void anadirJugadores(int pCuantos) {
		
		System.out.println("En la partida va a haber " + pCuantos + " jugadores.");
		//este while es para añadir los jugadores
		Jugador j;
		int cont=0;
		String nombre;
		while (cont<pCuantos) {
			
			
				System.out.println("Escribe el nombre del jugador "+(cont+1));
				nombre=Teclado.getMiTeclado().leerString();
				
				if( nombre==null) {
					nombre=Teclado.getMiTeclado().leerString();
				}
				j=new Jugador(nombre, cont);
				ListaJugadores.getMiListaJugadores().anadirJugador(j);
				
			cont=cont+1;
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
		CambioSentido cs1,cs2,cs3,cs4;
		CartaCambioColor cc1,cc2,cc3,cc4;
		ChupateCuatro cc5,cc6;
		ChupateDos cd1,cd2,cd3,cd4;
		Bloqueo b1,b2,b3,b4;
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
		i=i+1;
		//falta a�adir las especiales
		}
		i=0;
		while(i<2) {
			b1=new Bloqueo("azul");
			b2=new Bloqueo("amarillo");
			b3=new Bloqueo("rojo");
			b4=new Bloqueo("verde");
			
			cs1=new CambioSentido("azul");
			cs2=new CambioSentido("amarillo");
			cs3=new CambioSentido("rojo");
			cs4=new CambioSentido("verde");
			
			cc1=new CartaCambioColor("negro");
			cc2=new CartaCambioColor("negro");
			cc3=new CartaCambioColor("negro");
			cc4=new CartaCambioColor("negro");
			
			cc5=new ChupateCuatro("negro");
			cc6=new ChupateCuatro("negro");
			
			cd1=new ChupateDos("azul");
			cd2=new ChupateDos("amarillo");
			cd3=new ChupateDos("rojo");
			cd4=new ChupateDos("verde");
		
			
			Baraja.getMiBaraja().listaInicial.anadirCarta(b1);
			Baraja.getMiBaraja().listaInicial.anadirCarta(b2);
			Baraja.getMiBaraja().listaInicial.anadirCarta(b3);
			Baraja.getMiBaraja().listaInicial.anadirCarta(b4);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cs1);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cs2);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cs3);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cs4);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc1);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc2);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc3);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc4);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc5);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cc6);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cd1);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cd2);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cd3);
			Baraja.getMiBaraja().listaInicial.anadirCarta(cd4);
			
			i=i+1;
		}

		}
	public void jugarPartida() {
		int cuantos;
		Baraja.getMiBaraja().crearBaraja();
		Baraja.getMiBaraja().barajear();
		cuantos= this.preguntarNumJugadores();
		Baraja.getMiBaraja().anadirJugadores(cuantos);
		Baraja.getMiBaraja().repartir();
		Baraja.getMiBaraja().sacarPrimeraCarta();
		ListaJugadores.getMiListaJugadores().jugarPartida();

		}
	public void sacarPrimeraCarta() {
		Carta primeraCarta=this.listaInicial.ultimaCarta();
		while (!(primeraCarta instanceof CartaNormal)) {
			this.listaEchadas.anadirCarta(primeraCarta);
			this.listaInicial.eliminarCarta(primeraCarta);
			primeraCarta=this.listaInicial.ultimaCarta();
		}
		System.out.println("La partida empieza con esta carta:  ");
		this.echarCarta(primeraCarta);
		this.listaInicial.eliminarCarta(primeraCarta);
	}
	public void terminarPartida() {
		Baraja.getMiBaraja().listaEchadas=new ListaCartas();
		Baraja.getMiBaraja().listaInicial=new ListaCartas();
		ListaJugadores.getMiListaJugadores().resetearListaJugadores();
		System.out.println();
		System.out.println("Para volver a jugar, pulse intro.");
		Teclado.getMiTeclado().leerString();
		Main.main(null);
		}
	
	
	//metodos solo para pruebas
	public void escribirBaraja() {
		this.listaInicial.escribirCartas();
	}
	public void anadirUnaCartaEchadaParaPruebas(Carta pCarta) {
		this.listaEchadas.anadirCarta(pCarta);
	}
	
	public void eliminarUnaCartaEchadaParaPruebas(Carta pCarta) {
		this.listaEchadas.eliminarCarta(pCarta);
	}
	
	public void resetearListas() {
		this.listaInicial=new ListaCartas();
		this.listaEchadas=new ListaCartas();
	}
	
	public int cartasDisponibles() {
		return((this.listaEchadas.cantidadCartas()-1)+this.listaInicial.cantidadCartas());
	}
	
	
	public int cantidadCartasListaInicial() {
		return this.listaInicial.cantidadCartas();
	}
	public void anadirCartaInicialParaPruebas(Carta pCarta) {
		this.listaInicial.anadirCarta(pCarta);
	}
	}