package com.decroly.daw;

import java.util.Scanner;

public class OrdenAscendente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Numero1:");
			double num1 = entrada.nextDouble();
		System.out.println("Numero2:");
			double num2 = entrada.nextDouble();
		

		
		
			double numPeq = Math.min(num1, num2);
			double numMax = Math.max(num1, num2);
		System.out.println("El orden ascendente de los números es:" + numPeq + " y " +numMax);
		
		
		
	}


}