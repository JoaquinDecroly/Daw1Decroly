import java.util.Scanner;

public class CadenasTexto2 {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Introduce un texto: ");
    String texto1 = entrada.nextLine();
    System.out.println("Introduce otro texto: ");
    String texto2 = entrada.nextLine();


    System.out.println("Son iguales: " +texto1.equalsIgnoreCase(texto2));
}
}
