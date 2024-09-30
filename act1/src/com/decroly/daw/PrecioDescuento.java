package com.decroly.daw;

import java.util.Scanner;

public class PrecioDescuento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}Scanner entrada = new Scanner (System.in);
	{
			// TODO Auto-generated method stub

		System.out.println("Ingrese el precio de un articulo:");
		double num1 = entrada.nextDouble();
		System.out.println("Ingrese el precio real:");
		double num2 = entrada.nextDouble();
		
		System.out.println("descuento:"  +(num1-num2)/num2);
		}

}
