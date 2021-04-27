package chupate4;

public class CartaNormal extends Carta{
	//atributos
	private String numero;

	
	//constructora
	public CartaNormal(String pColor,String pNumero) {
		super(pColor);
		this.numero=pNumero;
	}
	
	//métodos
	public boolean sePuedeEchar() {
		boolean puede=false;
		Carta ultimaCarta= Baraja.getMiBaraja().ultimaCarta();
		if(!super.sePuedeEchar()) {
			if(ultimaCarta instanceof CartaNormal && ultimaCarta.tieneMismoNumero(this.numero)) {
				puede=true;
			}
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
			 
		 
			if(this.numero=="0") {
				System.out.print( cero[k]);
				}else if(this.numero=="1") {
					System.out.print(uno[k]);
				}else if(this.numero=="2") {
					System.out.print(dos[k]);	
				}else if(this.numero=="3") {
					System.out.print(tres[k]);
				}else if(this.numero=="4") {
					System.out.print(cuatro[k]);
				}else if(this.numero=="5") {
					System.out.print(cinco[k]);
				}else if(this.numero=="6") {
					System.out.print(seis[k]);
				}else if(this.numero=="7") {
					System.out.print(siete[k]);
				}else if(this.numero=="8") {
					System.out.print(ocho[k]);
				}else if(this.numero=="9") {
					System.out.print(nueve[k]);
		}
			System.out.println("");
			k++;
	}
		 System.out.println("");
		 
	}
	public boolean tieneMismoNumero(String pString) {
		
		boolean mismo=false;
		
		if(this.numero.equals(pString)) {
			mismo=true;
		}
		return mismo;
	}
	
	
	public boolean tieneMismoNumCarta(Carta pCarta) {
		boolean mismo=false;
		if (pCarta instanceof CartaNormal && (((CartaNormal)pCarta).tieneMismoNumero(this.numero))) {
				mismo=true;
			}
		return mismo;
		}
	public String devolverString() {
		String pString="";
		pString=this.numero;
		pString=pString+" "+this.getColor();
		return pString;
		}
	}

