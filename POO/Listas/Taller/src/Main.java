import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    taller.anadeElemento();
                    break;
                case 2:
                    taller.eliminaElemento();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 3.");
            }
        } while (opcion != 3);

     
        System.out.println("\n--- Información del Taller ---");
        taller.visualizaMatriculas();
        taller.visualizaCoches();
        taller.visualizaTaller();
    }
}

