package act2;

import java.util.Scanner;
public class Calificacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
			System.out.println("Introduce tu nota 1-10:");
			
			int nota = entrada.nextInt();
			
			if (nota < 5) {
				System.out.println("Insuficiente");
				
			}else if ( nota <6) { 
				System.out.println("Suficiente");
	
			}else if ( nota <9) {
				System.out.println ("Notable");
			}else {
					System.out.println ("Sobresaliente");}
	}

}
