package com.decroly.daw;

import java.util.Scanner;

public class N10sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		int sum = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero N: ");
		
		for (int i = 0; i < 10; i++) {
		System.out.print("Introduce el número " + (i + 1) + ": ");
		int num = entrada.nextInt();
		sum += num;
	    }
	    System.out.println("La suma de los 10 números es: " + sum);
	    }
		}

	
