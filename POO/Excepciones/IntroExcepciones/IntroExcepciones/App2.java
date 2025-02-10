package IntroExcepciones;



import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    try {
        System.out.println("Valor 1: ");
        int a = scanner.nextInt();
        System.out.println("Valor 2: ");
        int b = scanner.nextInt();
        int div = a/b;

    } catch (InputMismatchException e) {
        System.err.println("Se ha producido el siguiente error: "+e.getClass().getName());
        e.printStackTrace();
    }
    catch(ArithmeticException e){
        System.err.println("Se ha producido el siguiente error: " +e.getClass().getName());
        e.printStackTrace();
    }
}
}