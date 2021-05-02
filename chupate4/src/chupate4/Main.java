package chupate4;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Para jugar una partida al juego UNO, pulse 1");
		System.out.println("Para acceder al menu y conocer las normas del juego, pulse 2");
		int i=Teclado.getMiTeclado().leerEntero(1, 2);
		if(i==1) {
		Baraja.getMiBaraja().jugarPartida();
		}else {
			 imprimirDatos();
			
		}
	}
	public static void imprimirDatos(){
		//String dirActual = System.getProperty("user.dir");
		//String pathIn = dirActual +File.separator + "reglas.txt";
		InputStream fich = null;
		//try {
			ClassLoader classLoader = Main.class.getClassLoader();
			fich = classLoader.getResourceAsStream("reglas.txt");
			
			//fich = new FileInputStream(pathIn);
		/*} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner sc = new Scanner(fich);
		while (sc.hasNextLine()){
			String linea = sc.nextLine();
			System.out.println(linea);
			}
		sc.close();
		Main.main(null);
		}

}
