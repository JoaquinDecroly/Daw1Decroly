package com.decroly.daw;

import java.util.Scanner;

public class LongitudVolumen {
	public static void main (String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		System.out.print("¿longitudRadio?:");
		double longitudRadio = entrada.nextDouble();
		
		double lcircunferencia = 2*longitudRadio*Math.PI;
		double acirculo = Math.PI* +longitudRadio;
		double volumenesfera = (4*Math.PI*(longitudRadio*longitudRadio*longitudRadio))/3;
			System.out.println("La longitud de la circunferencia es:" +lcircunferencia);
			System.out.println("El area del circulo es:" +acirculo);
			System.out.println("El volumen de la esfera es:" +volumenesfera);
			
	}

}
