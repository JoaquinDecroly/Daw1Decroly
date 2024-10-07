package act2;

import java.util.Scanner;

public class NoNulo2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int positivos = 0;
        int negativos = 0;
        boolean hayNegativos = false;

        System.out.println("Introduzca una secuencia de números no nulos (0 para terminar y ver resultados):");

        while (true) {
            System.out.print("Número: ");
            numero = entrada.nextInt();

            if (numero == 0) {
                break; // exit the loop when 0 is entered
            }

            if (numero > 0) {
                positivos++;
            } else {
                negativos++;
                hayNegativos = true; // we've found a negative number
            }
        }

        // only print the results if at least one number was entered
        if (positivos + negativos > 0) {
            System.out.println("Resultados:");
            if (hayNegativos) {
                System.out.println("Hay números negativos.");
            } else {
                System.out.println("No hay números negativos.");
            }
            System.out.println("Números positivos: " + positivos);
            System.out.println("Números negativos: " + negativos);
        } else {
            System.out.println("No se han introducido números.");
        }
    }
}           

