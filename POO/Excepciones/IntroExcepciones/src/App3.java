package src;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Double> valores = new ArrayList<>(5);
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Valor " + (i+1) + ":");
                    double valor = scanner.nextDouble();
                    valores.add(valor);
                    
                }
            } catch (InputMismatchException e) {
                System.err.println("Se ha producido el siguiente error: " + e.getClass().getName());
                e.printStackTrace();
                Scanner sc = new Scanner(System.in);
                for (int i = valores.size(); i < 5; i++) {
                    System.out.println("Valor " + (i+1) + ":");
                    double valor = sc.nextDouble();
                    valores.add(valor);
                }
                sc.close();
            }
        }
    }
}

