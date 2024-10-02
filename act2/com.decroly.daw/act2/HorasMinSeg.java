package act2;

import java.util.Scanner;  
public class HorasMinSeg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Pedir hora, minutos, segundos
		 Scanner entrada = new Scanner(System.in);
		 
		  	int hora = entrada.nextInt();
		 	int min = entrada.nextInt();
		 	int seg = entrada.nextInt();
		 
		 	while (true) {
	            System.out.println("Introduce la hora (0-23):");
	            hora = entrada.nextInt();
	            if (hora < 0 || hora > 23) {
	                System.out.println("Hora inválida. Intente de nuevo.");
	                continue;
	            }

	            System.out.println("Introduce los minutos (0-59):");
	            min = entrada.nextInt();
	            if (min < 0 || min > 59) {
	                System.out.println("Minutos inválidos. Intente de nuevo.");
	                continue;
	            }

	            System.out.println("Introduce los segundos (0-59):");
	            seg = entrada.nextInt();
	            if (seg < 0 || seg > 59) {
	                System.out.println("Segundos inválidos. Intente de nuevo.");
	                continue;
	            }

	            break;
	        }
		 	//Sumar segundo
		 	seg++;
		 	
		 	//Ajustar valores
		 	if (hora >= 24) { 
		 		hora = 0;
		 	}
		 	if (min >= 60) {
		 		seg++;
		 		min = 0;
		 	}
		 	if (seg >= 60) {
		 		min++;
		 		seg = 0;
		 	}
		 	
		 	
		 	System.out.println("La hora es-->" + hora + ":" + min + ":" + seg);
	}
		 	
	}




