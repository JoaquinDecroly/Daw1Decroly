package act2;

import java.util.Scanner;

public class Edad2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = entrada.nextInt();

        System.out.println((edad >= 18)  & (edad < 18)? "Eres mayor de edad." : "Eres Menor de edad");
    }
}
