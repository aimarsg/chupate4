package chupate4;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class CartaNormal extends Carta{
	//atributos
	private String numero;

	
	//constructora
	public CartaNormal(String pColor,String pNumero) {
		super(pColor);
		this.numero=pNumero;
	}
	
	//métodos
	public void tirarCarta() {}
	
	public boolean sePuedeEchar() {
		boolean puede=false;
		if(!super.sePuedeEchar()) {
			Carta ultimaCarta= Baraja.getMiBaraja().ultimaCarta();
			if(ultimaCarta instanceof CartaNormal) {
				if (((CartaNormal)ultimaCarta).tieneMismoNumero(this.numero)) {
					puede=true;
				}
			}
		}
		return puede;
	}
	
	public void escribirCarta() {
		AnsiConsole.systemInstall();
		//System.out.println(ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset() );
		//AnsiConsole.out().println("Hello World");

		System.out.println(ansi().a(this.numero).bg(Color.RED).fg(Color.WHITE));
		
		AnsiConsole.systemUninstall();
	
	
		String cero[]={" ##### ", // H=0
					   " #   # ", // H=1
                       " #   # ", // H=2
                       " #   # ", // H=3
                       " #   # ", // H=4
                       " #   # ", // H=5
                       " ##### ",
		};// H=6
		
       

                       
		

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
	
	public boolean tieneMismoNumero(Carta pCarta) {
		boolean mismo=false;
		if (pCarta instanceof CartaNormal) {
			if (((CartaNormal)pCarta).tieneMismoNumero(this.numero)) {
				mismo=true;
				}
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

