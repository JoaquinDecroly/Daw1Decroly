package com.decroly.daw;

import java.util.Scanner;

public class AreCuadradoManual {

	    public static void main (String[] args) {
	        Scanner entrada = new Scanner(System.in);
	        System.out.print("Ingrese la medida del lado del cuadrado: ");
	        double lado = entrada.nextDouble();
	        double area = lado * lado;
	        System.out.println("El área del cuadrado es: " +area);

}
}
