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
		return r;
	}
	
	public String leerString () {
		String r = sc.nextLine();
		return r;
	}
}
