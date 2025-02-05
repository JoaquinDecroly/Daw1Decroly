package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        //1
        int a = -1;

       
        try {
             System.out.println("Introduce un valor para la incógnita A: ");
                a = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("Se ha producido el siguiente error: "+e.getClass().getName());
            e.printStackTrace();
        }
              
        }
    }

