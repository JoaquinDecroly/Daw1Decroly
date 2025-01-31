
import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = 0;
    int b = 0;

    try {
        
    } catch (InputMismatchException e) {
        System.err.println("Se ha producido el siguiente error: "+e.getStackTrace());
    }
    catch(ArithmeticException e){
        System.err.println("Se ha producido el siguiente error: "+e.getStackTrace());
    }
}
}
