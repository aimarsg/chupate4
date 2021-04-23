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
		if(this.getColor()=="azul") {
			if(this.numero==0) {
				
			}
		}
	}
}
