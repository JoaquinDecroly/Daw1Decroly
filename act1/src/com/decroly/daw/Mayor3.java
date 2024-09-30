package com.decroly.daw;
import java.util.Scanner;

public class Mayor3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Introduce el tercer número: ");
        double num3 = scanner.nextDouble();

        double max = Math.max(Math.max(num1, num2), num3);

        System.out.println("El número máximo es: " + max);
    }
}