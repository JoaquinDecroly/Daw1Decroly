package com.decroly.daw;
import java.util.Scanner;

public class MayoroIgual {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Numero 1: ");
        	int num1 = entrada.nextInt();

        System.out.print("Numero 2: ");
        	int num2 = entrada.nextInt();

        	int resolucion = ((num1 - num2) >> 31) & 1;

        		String salida = (resolucion == 0) ? "Los numeros son iguales" : (resolucion == 1) ? "El Numero 1 es mayor" : "El Numero 2 es mayor";

        System.out.println(salida);
    }
}