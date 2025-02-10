package IntroExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double vector[] = new double[5];
            int i = 0;

            while (i < vector.length) {
                try {
                    System.out.println("Valor " + (i + 1) + " :");
                    vector[i] = scanner.nextDouble(); 
                    i++;
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de error: " + e.getClass().getName());
                    e.printStackTrace();
                    scanner.next(); 
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido el siguiente error: " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}