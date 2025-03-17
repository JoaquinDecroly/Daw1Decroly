import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Cargar datos al inicio del programa
        Productos.cargarDatos();

        System.out.println("Bienvenido al sistema de gestión de productos");
        System.out.println("----------------------------------------------");

        while (!salir) {
            System.out.println("\nMenú principal:");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Productos.añadirProducto();
                    break;
                case "2":
                    Productos.mostrarProductos();
                    break;
                case "3":
                    Productos.eliminarProducto();
                    break;
                case "4":
                    Productos.escribirDatos();
                    System.out.println("Cambios guardados exitosamente.");
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }

        // Guardar datos antes de salir
        Productos.escribirDatos();
        scanner.close();
    }
}