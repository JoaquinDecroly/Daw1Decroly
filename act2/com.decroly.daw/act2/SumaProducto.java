package act2;

import java.util.Scanner;

public class SumaProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int suma = 10 * (1 + 10) / 2; // formula for sum of arithmetic series
	        long producto = factorial(10); // calculate factorial using a recursive method

	        System.out.println("Suma de los 10 primeros números naturales: " + suma);
	        System.out.println("Producto de los 10 primeros números naturales: " + producto);
	    }

	    private static long factorial(int n) {
	        if (n == 0) {
	            return 1;
	        } else {
	            return n * factorial(n - 1);
	        }
	    }
	
	}


