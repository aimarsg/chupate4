package chupate4;

import java.util.Scanner;

public class Teclado {
	private static Teclado miTeclado=null; 
	private Scanner sc;
	
	private Teclado() {
		sc= new Scanner(System.in);
	}
	public static Teclado getMiTeclado() {
		if (Teclado.miTeclado==null) {
			Teclado.miTeclado= new Teclado();
		}
		
		return (Teclado.miTeclado);
	}
	
	public int leerEntero () {
		int r = sc.nextInt();
		
		sc.nextLine();
		return r;
	}
	
	public int leerEntero (int pDesde, int pHasta) {
		int r = sc.nextInt();
		boolean todoOk=false;
		do{try {
			if (r>=pDesde && r<=pHasta) {
				todoOk=true;
			}
			else {
				throw new NumeroFueraDeRangoException();
			}
			}
		
		catch(NumeroFueraDeRangoException e){
			System.out.println("El numero introducido no esta entre " + pDesde +" y "+ pHasta + ".");
			System.out.println("Escribe otro numero:");
			r=sc.nextInt();
		}
		}
		while(!todoOk);
		
		
		sc.nextLine();
		return r;
	}
	
	public String leerString () {
		String r = sc.nextLine();
		return r;
	}
}
