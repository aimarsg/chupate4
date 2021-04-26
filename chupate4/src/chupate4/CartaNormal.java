package chupate4;

public class CartaNormal extends Carta{
	//atributos
	private int numero;

	
	//constructora
	public CartaNormal(String pColor,int pNumero) {
		super(pColor);
		this.numero=pNumero;
	}
	
	//métodos
	public boolean sePuedeEchar() {
		boolean puede=false;
		Carta ultimaCarta= Baraja.getMiBaraja().listaEchadas.ultimaCarta();
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
				System.out.println( cero[k]);
				}else if(this.numero==1) {
					System.out.println(uno[k]);
				}else if(this.numero==2) {
					System.out.println(dos[k]);	
				}else if(this.numero==3) {
					System.out.println(tres[k]);
				}else if(this.numero==4) {
					System.out.println(cuatro[k]);
				}else if(this.numero==5) {
					System.out.println(cinco[k]);
				}else if(this.numero==6) {
					System.out.println(seis[k]);
				}else if(this.numero==7) {
					System.out.println(siete[k]);
				}else if(this.numero==8) {
					System.out.println(ocho[k]);
				}else if(this.numero==9) {
					System.out.println(nueve[k]);
		}
			System.out.println("");
			k++;
	}
		 System.out.println("");
		 
	}
	public boolean tieneMismoNumeroString(String pString) {
		
		boolean mismo=false;
		int num=Integer.parseInt(pString);
		if(this.numero==num) {
			mismo=true;
		}
		return mismo;
	}
	public boolean tieneMismoNumeroInt(int pNum) {
		boolean mismo=false;
		if(this.numero==pNum) {
			mismo=true;
		}
		return mismo;
	}
	
	public boolean tieneMismoNumero(Carta pCarta) {
		boolean mismo=false;
		if (pCarta instanceof CartaNormal && (((CartaNormal)pCarta).tieneMismoNumeroInt(this.numero))) {
				mismo=true;
			}
		return mismo;
		}
	
	
	}

