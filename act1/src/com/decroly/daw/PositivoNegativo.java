package com.decroly.daw;

import java.util.Scanner;

public class PositivoNegativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        double num = scanner.nextDouble();

        String resultado = (num >= 0) ? "positivo" : "negativo";

        System.out.println("El número es " + resultado);
    }
}
	


		
		
		
		
		
		
		
		
		
		
