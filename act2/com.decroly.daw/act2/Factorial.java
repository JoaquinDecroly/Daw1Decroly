package act2;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero entero y positivo");
			
			long N = entrada.nextLong();
			
		
		if ( N <= 0)
		{
			System.err.println("La N debe ser entero positivo");
			
		}
		else System.out.println ("Factores de" + N + ":");
				for (int i = 1; N >= i; i++) {
					if ( N % i <= 0) {
						System.out.println(i);
						
					}
				}
	}

}


	