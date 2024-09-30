package com.decroly.daw;

import java.util.Scanner;

public class MillasMetros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Millas que se quieren convertir:");
		double millas = entrada.nextDouble();
		double metros = millas * 1852;
		
		System.out.println("La distancia en metros es" + metros);
	}

}
