package chupate4;

public class Jugador {

	private String nombre;
	private ListaCartas mano;
	private int idJugador;
	
	
	//constructora
	public Jugador(String pNombre, int pIdJugador) {
		this.nombre= pNombre;
		this.idJugador= pIdJugador;
		this.mano= new ListaCartas();
	}
	
	//otros metodos/
	
	public void cogerCarta(int pCuantas) {
		if(pCuantas>Baraja.getMiBaraja().cartasDisponibles()) {
			pCuantas=Baraja.getMiBaraja().cartasDisponibles();
			System.out.println("Solo hay "+Baraja.getMiBaraja().cartasDisponibles()+ "cartas disponibles, por lo que solo se roban esas cartas.");
		}
		
		int i = 1;
		Carta carta;
		while (i<=pCuantas) {
			carta= Baraja.getMiBaraja().robar();
			this.mano.anadirCarta(carta);
			
			i=i+1;
		}
		
	}
	
	public void tirarCarta() {
		String cartaString;
		Carta carta;
		boolean tirada=false;
		System.out.println("Escribe la posicion de la carta que quieras tirar");
		cartaString=Teclado.getMiTeclado().leerString();
		
			
		do {
			System.out.println();
			try {
				int pos=0;
				String numero="";
				boolean enc=false;
				while (pos<cartaString.length()&&!enc) {
					if (cartaString.charAt(pos) == ' ') {
						enc=true;
					}else {
						numero=numero+cartaString.charAt(pos);
						pos=pos+1;
					}
					
				}
				boolean todoNumeros=true;
				if (numero.length()!=0) {
					int i = 0 ;  
					while(i<pos&&todoNumeros){           
						if (numero.charAt(i) >= '0' && numero.charAt(i) <= '9') {
							todoNumeros= true;
						}
						else {	
							todoNumeros= false;
			            	}
						i=i+1;
					}
			      }
				if (!todoNumeros||numero=="") {
					throw new PosicionNoValidaException();
				}else {
					if ((Integer.parseInt(numero)==0)||this.cantidadCartas()<Integer.parseInt(numero)) {
							throw new NumeroFueraDeRangoException();
						}
						else {
							carta= this.mano.buscarCarta(numero);
							if (carta!=null) {
								if (carta.sePuedeEchar()) {
									tirada=true;
									Baraja.getMiBaraja().echarCarta(carta);
									this.mano.eliminarCarta(carta);
									this.decirUno(cartaString);
								}else {
									throw new CartaNoSePuedeTirarException();
								}
							}else {
								throw new CartaNoEstaEnManoException();
							}
						}
					}
			}catch(PosicionNoValidaException e) {
				 System.out.println("No has escrito un numero, escribe un numero: ");
				 cartaString=Teclado.getMiTeclado().leerString();
				
			}catch(CartaNoSePuedeTirarException e) {
				System.out.println("La carta que esta en la posicion introducida no se puede tirar, escribe otra posicion: ");
				
				cartaString=Teclado.getMiTeclado().leerString();
			}catch(NumeroFueraDeRangoException e) {
				System.out.println("En tu mano tienes "+this.cantidadCartas()+", escibe un numero menor o igual que "+this.cantidadCartas()+" y mayor que 0.");
				cartaString=Teclado.getMiTeclado().leerString();
			}catch(CartaNoEstaEnManoException e){
				System.out.println("La carta introducida no esta en mano, escribe otra");
				 cartaString=Teclado.getMiTeclado().leerString();
			}
		}while(!tirada);
	}

	
	// completar
	public void decirUno(String pString) {
	//comprobar a ver si es la penultima carta
	if (this.mano.cantidadCartas()==1) {
		int cont=0;
		int contEspacio=0;  
		while (cont<pString.length() && contEspacio!=1) {
			if (pString.charAt(cont)==' ') {
					contEspacio=contEspacio+1;
			}
			cont=cont+1;
		}
		
		if (pString.length()==5) {
			if ((pString.charAt(cont)=='u'||pString.charAt(cont)=='U')&&(pString.charAt(cont+1)=='n'||pString.charAt(cont+1)=='N')&&(pString.charAt(cont+2)=='O'||pString.charAt(cont+2)=='o')) {
				System.out.println("Has dicho UNO");
			}else {
				System.out.println("No has dicho uno,te chupas dos!");
				this.cogerCarta(2);
				System.out.println("Ahora tienes "+this.cantidadCartas()+"  cartas.");
				}
		}else {
			System.out.println("No has dicho uno,te chupas dos!");
			this.cogerCarta(2);
			System.out.println("Ahora tienes "+this.cantidadCartas()+"  cartas.");
			}
		}
		
	}
	
	public void escribirMano() {
		this.mano.escribirCartas();
	}
	
	public int cantidadCartas() {
		return(this.mano.cantidadCartas());
	}
	
	public boolean tieneEsteId(int pId) {
		return(this.idJugador==pId);
	}
	
	public boolean puedeEcharCarta() {
		return(this.mano.puedeEcharCarta());
	}
	
	public boolean jugarTurno() throws InterruptedException {
	
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		System.out.println("Es el turno de "+this.nombre+".");
		System.out.println("Esta es la ultima carta echada:");
		System.out.print("[ ");
		Baraja.getMiBaraja().ultimaCarta().escribirCarta();
		System.out.println("]");
		System.out.println();
		System.out.println("Tienes "+this.cantidadCartas()+" cartas: ");
		System.out.println();
		this.escribirMano();
		System.out.println();
		if (!this.puedeEcharCarta()) {
			System.out.println();
			System.out.println("No puedes tirar ninguna de las cartas que tienes en tu mano, robas 1");
			this.cogerCarta(1);
			System.out.println("Tienes "+this.cantidadCartas()+" cartas: ");
			System.out.println();
			this.escribirMano();
		}
		if (this.puedeEcharCarta()) {
			this.tirarCarta();
		}else {
			System.out.println("No puedes tirar tras coger una carta, por lo tanto tu turno se termina.");
			
			
		}
		Thread.sleep(2000);
		if (this.mano.cantidadCartas()==0) {
			return(true);
		}else {
			return(false);
		}
		
		
	}
	public String getNombre() {
		return(this.nombre);
	}
	public void anadir(Carta pCarta) {
		this.mano.anadirCarta(pCarta);
	}
}