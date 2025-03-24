import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    final static String pathFile = "src\\Recursos";
		
		//Nombre del fichero Binario
		final  static String fileNameBinario = "almacen.dat";
		
		//Nombre del fichero UNICODE
		final static String fileNameUnicode = "productos.csv";

    private static LinkedList<Producto> productos;
    public static void main(String[] args) {
        MyUtils.cargarDatos();
        int opcion;
         try(Scanner scanner = new Scanner(System.in)){ 
            do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir (inventario.dat).");
            System.out.println("4. Registrar producto en el Inventario.");
            System.out.println("0. Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                    MyUtils.mostrarProductos(); // Llama al método para mostrar productos
                    break;
                case 2:
                    MyUtils.eliminarProducto(scanner); // Llama al método para eliminar producto
                    break;
                case 3:
                    MyUtils.guardarInventario(); // Llama al método para guardar el inventario
                    System.out.println("Inventario guardado. Saliendo...");
                    break;
                case 4:
                    MyUtils.registrarProducto(scanner); // Llama al método para registrar producto
                    break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                    }
                } while (opcion != 0);
            }      
    }    
}
