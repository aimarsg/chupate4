package chupate4;

public class CartaNormal extends Carta{
	//atributos
	private int numero;
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	//constructora
	public CartaNormal(String pColor,int pNumero) {
		super(pColor);
		this.numero=pNumero;
	}
	
	//métodos
	public boolean sePuedeEchar() {
		boolean puede=false;
		Carta ultimaCarta= Baraja.getMiBaraja().listaEchadas.get(Baraja.getMiBaraja().listaEchadas.cantidadCartas);
		if(this.getColor()==ultimaCarta.getColor()) {
			puede=true;
		}if(ultimaCarta instanceof CartaNormal && ultimaCarta.tieneMismoNumero(this.numero)) {
			puede=true;
		}
		return puede;
	}
	
	public void escribirCarta() {
		
	
		String cero[]={" ##### ", // H=0
					   " #   # ", // H=1
                       " #   # ", // H=2
                       " #   # ", // H=3
                       " #   # ", // H=4
                       " #   # ", // H=5
                       " ##### "};// H=6

 String uno[]={"   #   ",
               "  ##   ",
               "   #   ",
               "   #   ",
               "   #   ",
               "   #   ",
               " ##### "};

 String dos[]={" ##### ",
               "     # ",
               "     # ",
               " ##### ",
               " #     ",
               " #     ",
               " ##### "};

 String tres[]={" ##### ",
                "     # ",
                "     # ",
                " ##### ",
                "     # ",
                "     # ",
                " ##### "};

 String cuatro[]={" #   # ",
                  " #   # ",
                  " #   # ",
                  " ##### ",
                  "     # ",
                  "     # ",
                  "     # "};

 String cinco[]={" ##### ",
                 " #     ",
                 " #     ",
                 " ##### ",
                 "     # ",
                 "     # ",
                 " ##### "};

 String seis[]={" ##### ",
                " #     ",
                " #     ",
                " ##### ",
                " #   # ",
                " #   # ",
                " ##### "};

 String siete[]={" ##### ",
                 "     # ",
                 "     # ",
                 "  #### ",
                 "     # ",
                 "     # ",
                 "     # "};

 String ocho[]={ " ##### ",
                 " #   # ",
                 " #   # ",
                 " ##### ",
                 " #   # ",
                 " #   # ",
                 " ##### "};

 String nueve[]={" ##### ",
                 " #   # ",
                 " #   # ",
                 " ##### ",
                 "     # ",
                 "     # ",
                 "     # "};
 
		 System.out.println("");
		 int k=0;
		 while(k<=6) {
			 
		 
			if(this.numero==0) {
				System.out.println( ANSI_RED + cero[k] + ANSI_RESET);
				}else if(this.numero==1) {
					System.out.println(ANSI_RED+uno[k]+ANSI_RESET);
				}else if(this.numero==2) {
					System.out.println(ANSI_RED+dos[k]+ANSI_RESET);	
				}else if(this.numero==3) {
					System.out.println(ANSI_RED+tres[k]+ANSI_RESET);
				}else if(this.numero==4) {
					System.out.println(ANSI_RED+cuatro[k]+ANSI_RESET);
				}else if(this.numero==5) {
					System.out.println(ANSI_RED+cinco[k]+ANSI_RESET);
				}else if(this.numero==6) {
					System.out.println(ANSI_RED+seis[k]+ANSI_RESET);
				}else if(this.numero==7) {
					System.out.println(ANSI_RED+siete[k]+ANSI_RESET);
				}else if(this.numero==8) {
					System.out.println(ANSI_RED+ocho[k]+ANSI_RESET);
				}else if(this.numero==9) {
					System.out.println(ANSI_RED+nueve[k]+ANSI_RESET);
		}
			System.out.println("");
			k++;
	}
		 System.out.println("");
		 System.out.println(ANSI_REDANSI_RESET);
	}
	public boolean tieneMismoNumero(int pNumero) {
		boolean mismo=false;
		if(this.numero==pNumero) {
			mismo=true;
		}
		return mismo;
	}
	
	public boolean tieneMismoNumero(Carta pCarta) {
		boolean mismo=false;
		if (pCarta instanceof CartaNormal && (pCarta.tieneMismoNumero(this.numero))) {
				mismo=true;
			}
		return mismo;
		}
	}

