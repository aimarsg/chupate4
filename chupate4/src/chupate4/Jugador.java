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
	
	//otros metodos
	
	public void cogerCarta(int pCuantas) {
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
			try {
				int pos=0;
				String numero="";
				while (pos<cartaString.length()) {
					if (cartaString.charAt(pos) == ' ') {
						pos=cartaString.length();
					}else {
						numero=numero+cartaString.charAt(pos);
					}
					pos=pos+1;
					}
				boolean todoNumeros=true;
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
				if (!todoNumeros||this.cantidadCartas()<Integer.parseInt(numero)) {
					throw new PosicionNoValida();
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
							//
						}
					}else {
						//
					}
				}
			}catch(PosicionNoValida e) {
				 System.out.println("La posicion no es valida o no has escrito un numero, escribe otra posicion: ");
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
		
		if ((pString.charAt(cont)=='u'||pString.charAt(cont)=='U')&&(pString.charAt(cont+1)=='n'||pString.charAt(cont+1)=='N')&&(pString.charAt(cont+2)=='O'||pString.charAt(cont+2)=='o')) {
			System.out.println("Ha dicho UNO");
		}else {
			System.out.println("No has dicho uno,�Te chupas dos!");
			this.cogerCarta(2);
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
	
	public boolean jugarTurno() {
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		System.out.println("Es el turno de "+this.nombre+".");
		System.out.println("Tienes "+this.cantidadCartas()+" cartas: ");
		this.escribirMano();
		if (!this.puedeEcharCarta()) {
			this.cogerCarta(1);
		}
		if (this.puedeEcharCarta()) {
			this.tirarCarta();
		}
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