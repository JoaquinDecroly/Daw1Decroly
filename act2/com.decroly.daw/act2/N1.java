package act2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
       
    	 Scanner entrada = new Scanner(System.in);

    	    int n = 0; 
    	    boolean isValidInput = false; 

    	    while (!isValidInput) {
    	      try {
    	        System.out.print("Introduce un número entero: ");
    	        n = entrada.nextInt();
    	        isValidInput = true; 
    	      } catch (InputMismatchException e) {
    	        System.out.println("Debes introducir un número entero.");
    	        entrada.next(); 
    	      }
    	    }

    	    System.out.println("Los números desde 1 hasta " + n + " son:");
    	    for (int i = 1; i <= n; i++) {
    	      System.out.print(i + " ");
    	    }
    	  }
    	}   