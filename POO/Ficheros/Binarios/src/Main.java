import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Ruta del archivo donde se guardarán los datos
        File file = new File("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Binarios\\resources\\almacen.dat");

        // Cargar datos al iniciar el programa
        Productos.cargarDatos();

        int opcion;

        do {
            // Mostrar el menú principal
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
                        // Opción 1: Crear producto
                        Productos.añadirProducto();
                        break;

                    case 2:
                        // Opción 2: Mostrar productos existentes
                        String productosStr = Productos.mostrarProductos();
                        if (productosStr.isEmpty()) {
                            System.out.println("No hay productos registrados.");
                        } else {
                            System.out.println(productosStr);
                        }
                        break;

                    case 3:
                        // Opción 3: Eliminar producto por código
                        Productos.eliminarProducto();
                        break;

                    case 4:
                        // Opción 4: Guardar productos en el fichero
                        Productos.escribirDatos();
                        System.out.println("Cambios guardados en el fichero 'almacen.dat'.");
                        break;

                    case 5:
                        // Opción 5: Salir
                        System.out.println("Saliendo del programa...");
                        Productos.escribirDatos(); // Guardar cambios antes de salir
                        break;

                    default:
                        // Manejo de opciones no válidas
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                // Manejo de errores de entrada (por ejemplo, si el usuario introduce letras en lugar de números)
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                sc.next(); // Limpiar el buffer
                opcion = 0; // Mantener el bucle activo
            }
        } while (opcion != 5); // El programa seguirá ejecutándose hasta que el usuario seleccione la opción 5
    }
}