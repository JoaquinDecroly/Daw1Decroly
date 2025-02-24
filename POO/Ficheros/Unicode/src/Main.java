import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Unicode\\resources\\almacen.dat");
        // Cargar datos al iniciar el programa
        Productos.cargarDatos();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos existentes");
            System.out.println("3. Eliminar producto por código");
            System.out.println("4. Guardar productos en el fichero");
            System.out.println("5. Salir");

            try {
                System.out.print("Selecciona una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        Productos.añadirProducto();
                        break;
                    case 2:
                        Productos.mostrarProductos();
                        break;
                    case 3:
                        Productos.eliminarProducto();
                        break;
                    case 4:
                        Productos.escribirDatos();
                        System.out.println("Cambios guardados en el fichero almacen.dat");
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        Productos.escribirDatos(); // Guardar cambios antes de salir
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, introduce un número.");
                sc.next(); // Limpiar el buffer
                opcion = 0; // Para que no salga del bucle
            }
        } while (opcion != 5);
    }
}