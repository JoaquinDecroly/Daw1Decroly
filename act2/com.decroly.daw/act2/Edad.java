package act2;

import java.util.Scanner;

public class Edad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();

        System.out.println((edad >= 18)? "Eres mayor de edad." : "");
    }
}
