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
		Carta ultimaCarta= Baraja.getMiBaraja().listaEchadas.get(Baraja.getMiBaraja().listaEchadas.cantidadCartas);
		if(this.getColor()==ultimaCarta.getColor()) {
			puede=true;
		}if(ultimaCarta instanceof CartaNormal && ultimaCarta.tieneMismoNumero(this.numero)) {
			puede=true;
		}
		return puede;
	}
	
	public void escribirCarta() {
		String azul = "\u001B[34m";
		String rojo="\u001B[31m";
		String amarillo="\u001B[33m";
		String verde="\u001B[32m";
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
 
		 
			if(this.numero==0) {
				System.out.println(this.getColor()+cero);
				}else if(this.numero==1) {
					System.out.println(this.getColor()+uno);
				}else if(this.numero==2) {
					System.out.println(this.getColor()+dos);	
				}else if(this.numero==3) {
					System.out.println(this.getColor()+tres);
				}else if(this.numero==4) {
					System.out.println(this.getColor()+cuatro);
				}else if(this.numero==5) {
					System.out.println(this.getColor()+cinco);
				}else if(this.numero==6) {
					System.out.println(this.getColor()+seis);
				}else if(this.numero==7) {
					System.out.println(this.getColor()+siete);
				}else if(this.numero==8) {
					System.out.println(this.getColor()+ocho);
				}else if(this.numero==9) {
					System.out.println(this.getColor()+nueve);
		}
	}
}
