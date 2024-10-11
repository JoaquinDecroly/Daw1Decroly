package com.decroly.daw;
import java.io.InputStream;
import java.nio.file.WatchEvent;
import java.security.interfaces.ECKey;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Bienvenido al MenuCalculadora!!!");
			
		
				
		do {		

			System.out.println("1) Suma");
			System.out.println("2) Resta");
			System.out.println("3) Multiplicar");
			System.out.println("4) Dividir");
			System.out.println("5) Salir");
			
			System.out.println("Introduzca una opcion:");
			num = entrada.nextLine();
			
			entrada = new Scanner(System.in);
			
			if(num.equals("1")) {
				System.out.println("HAS ELEGIDO SUMA");
				System.out.println("Intoduce un numero:");
				double sum1 = entrada.nextInt();
				System.out.println("Introduce otro numero:");
				double sum2 = entrada.nextInt();
				double sum = sum1 + sum2;
				System.out.println("La suma es: " +sum);
				continue;
				
			}else if(num.equals("2")) {
					entrada = new Scanner(System.in);
					System.out.println("HAS ELEGIDO RESTA");
					System.out.println("Intoduce un numero:");
					double res1 = entrada.nextInt();
					System.out.println("Introduce otro numero:");
					double res2 = entrada.nextInt();
					double res = res1 - res2;
					System.out.println("La resta es: " +res);
					continue;
	
			}else if(num.equals("3")) {
					entrada = new Scanner(System.in);
					System.out.println("HAS ELEGIDO PRODUCTO");
					System.out.println("Intoduce un numero:");
					double prod1 = entrada.nextInt();
					System.out.println("Introduce otro numero:");
					double prod2 = entrada.nextInt();
					double prod = prod1 * prod2;
					System.out.println("El producto es: " +prod);
					continue;

	
			}else if(num.equals("4")) {
					System.out.println("HAS ELEGIDO DIVISION");
					System.out.println("Intoduce un numero:");
					double div1 = entrada.nextInt();
					System.out.println("Introduce otro numero:");
					double div2 = entrada.nextInt();
					double div = div1 / div2;
					System.out.println("La división es: " +div);
				

					if(div2 == 0) {
						System.err.println("INDETERMINACIÓN");
						continue;
		
					}
						
			}else if(num.equals("5")) {
				break;
			}
						
			else {
				
			}

			
		}while(!num.equals("5"));
		
		}
		
	
}


			
				
	
