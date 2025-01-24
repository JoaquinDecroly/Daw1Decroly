import java.util.Scanner;

public class Principal {
public static void main(String[] args) {
    String option = "";
    Scanner scanner = new Scanner(System.in);

    do {
        System.out.println("1. Añadir Contacto\r\n" + 
                        "2. Buscar Contacto\r\n" + 
                        "3. Eliminar Contacto\r\n" + 
                        "4. Visualizar Agenda\r\n" + 
                        "5. Número de contactos de mi agenda\r\n" + 
                        "6. Salir");
    } while (!option.equals("6"));
}
}
