package com.decroly.daw;

import java.util.Scanner;

public class N10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero N: ");
		
		for(int i = 0;i < 10; i++) {
			System.out.println("Numero " + (i + 1) + ":");
			nums[i] = entrada.nextInt();
		}
		System.out.println("Los numeros del array son: ");
		for(int i = 0; i < nums.length; i++) {
		System.out.println(nums[i]);
		}
	}

}
