import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
           

            switch (opcion) {
                case 1:
                   
                    System.out.println("Funcionalidad de Planeta");
                    break;
                case 2:
                    
                    System.out.println("Funcionalidad de Satélite");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Planeta");
        System.out.println("2. Satélite");
        System.out.println("3. Salir");
        System.out.print("Ingresa tu opción: ");
    }
}