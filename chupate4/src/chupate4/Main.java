package chupate4;

import java.io.*;
import java.util.Scanner;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.*;

public class Main {
	
	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		System.out.println(ansi().eraseScreen());
		Main.hashprint();
		AnsiConsole.systemUninstall();
		System.out.println("Para jugar una partida al juego UNO, pulse 1");
		System.out.println();
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
		
		System.out.println("Pulse intro para volver al menu.");
		Teclado.getMiTeclado().leerString();
		Main.main(null);
		}
	public static void hashprint()
    {
        int i, j, k;
       
        // declaring char 2D arrays and initializing
        // with hash-printed digits
          String UUUU[]={" #     # ", // H=0
                         " #     # ", // H=1
                         " #     # ", // H=2
                         " #     # ", // H=3
                         " #     # ", // H=4
                         " #     # ", // H=5
                         " ####### "};// H=6
       
       
     
      
          String laN[]={" #  	 # ",
                        " ##     # ",
                        " # # 	 # ",
                        " #  #	 # ",
                        " #   #	 # ",
                        " #    # # ",
                        " #   	 # "};
       
          
       
          String ooooo[]={" ####### ",
                          " #     # ",
                          " #     # ",
                          " #     # ",
                          " #     # ",
                          " #     # ",
                          " ####### "};

                System.out.println("");
                AnsiConsole.systemInstall();
                k = 1;
                j = 0;  //controls H of each digit
                while (k <= 7)  //controls height
                {
                    for (i = 0; i < 1; i ++)  //reads each digit
                    { 
                        System.out.print(ansi().fg(Color.RED).a(UUUU[j]).reset());
                        System.out.print(ansi().fg(Color.YELLOW).a(laN[j]).reset());
                        System.out.print(ansi().fg(Color.BLUE).a(ooooo[j]).reset());
                    }
                      
                    System.out.println(ansi().reset());
                    k ++;
                    j ++;
                }
                AnsiConsole.systemUninstall();
                System.out.println();
                System.out.println();
                System.out.println();
            }
	
    

}
