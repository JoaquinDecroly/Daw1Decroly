import java.util.Scanner;

public class CadenasTexto3 {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

        System.out.print("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        
        System.out.print("Introduce el primer apellido: ");
        String apellido1 = entrada.nextLine();
        
        System.out.print("Introduce el segundo apellido: ");
        String apellido2 = entrada.nextLine();

        String inicialNombre = nombre.substring(0, 3).toUpperCase();
        String inicialApellido1 = apellido1.substring(0, 3).toUpperCase();
        String inicialApellido2 = apellido2.substring(0, 3).toUpperCase();

        String iniciales = inicialNombre + inicialApellido1 + inicialApellido2;

        System.out.println("Iniciales: " + iniciales);
    }
}