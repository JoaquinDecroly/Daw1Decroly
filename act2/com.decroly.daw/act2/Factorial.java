package act2;

import java.util.Scanner;

public class Factorial {
    public static long factorial(int num) {
        long resultado1 = 1;
        for (int i = 1; i <= num; i++) {
            resultado1 *= i;
        }
        return resultado1;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = entrada.nextInt();
        long resultado = factorial(num);
        System.out.println(num + "! = " + resultado);
    }
}