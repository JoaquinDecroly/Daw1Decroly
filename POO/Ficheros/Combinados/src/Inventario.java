import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    private static LinkedList<Producto> productos;

    //path a la carpeta Recursos del proyecto
		final static String pathFile = "Combinados\\src\\Recursos";
		
		//Nombre del fichero Binario
		final  static String fileNameBinario = "almacen.dat";
		
		//Nombre del fichero UNICODE
		final static String fileNameUnicode = "productos.csv";

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int opcion;
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

            if (opcion == 1) {
                mostrarProductos(); // Mostrar productos en el inventario
            } else if (opcion == 2) {
                eliminarProducto(scanner); // Eliminar un producto por referencia
            } else if (opcion == 3) {
                guardarProductosEnBinario(); // Guardar productos en un archivo binario
            } else if (opcion == 4) {
                registrarProducto(scanner); // Registrar un nuevo producto en el inventario
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close(); // Cerrar el escáner al salir
        
    }

    //cargar productos binario(csv)
    private static void cargarProductosCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile + "\\" + fileNameUnicode))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        String[] datos = linea.split("/");
                // Crear un nuevo objeto Producto y agregarlo a la lista
                Producto producto = new Producto(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Boolean.parseBoolean(datos[7]));
                productos.add(producto);
        // Process the line
    }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo CSV no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de número: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //cargar productos binarios desde archivo serializable
    private static void cargarProductosDesdeBinario() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFile + "\\" + fileNameBinario))) {
            while (true) {
                // Leer objetos Producto del archivo binario
                Producto producto = (Producto) ois.readObject();
                productos.add(producto);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        } catch (FileNotFoundException e) {
            System.out.println("El archivo binario no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

//mostrar productos
    private static void mostrarProductos(){
        if(productos.isEmpty()){
            System.out.println("No hay productos");
            return;
        }
        for(Producto p : productos){
            System.out.println(p.getReferencia() + " - " + p.getDescripcion()); 
    }
}

//Eliminar producto según referencia
private static void eliminarProducto(Scanner scanner){
     if(productos.isEmpty()){
            System.out.println("No hay productos");
            return;
        }
        for(Producto p : productos){
            System.out.println(p.getReferencia() + " - " + p.getDescripcion()); 
    }
    System.out.println("Ingrese la referencia del producto a eliminar");
    String referencia = scanner.nextLine();
    for(Producto p : productos){
        if(p.getReferencia().equals(referencia)){
            productos.remove(p);
            if (p.getReferencia().equals(referencia)) {
                System.out.println("Producto no eliminado");
                System.out.println("Volviendo a intentar...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.getMessage();
                }
                eliminarProducto(scanner); 
            }else{
                System.out.println("Producto eliminado correctamente");
            }  
        }
    }
}

//escribir datos en binario desde producto serializable
private static void guardarProductosEnBinario() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFile + "\\" + fileNameBinario))) {
        for (Producto p : productos) {
            oos.writeObject(p);
        }
        System.out.println("Datos escritos en archivo binario");
    } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar el archivo binario: " + e.getMessage());
    } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
    }
}

//crear productos
private static void registrarProducto(Scanner scanner){
    while (!productos.isEmpty()) {
       System.out.println("Ingrese la referencia del producto");
    String referencia = scanner.nextLine();
    for (Producto p : productos) {
       if (p.getReferencia().equals(referencia)) {
         System.out.println("La referencia ya existe. No se puede registrar.");
            return;
        } 
    }
        System.out.println("Ingrese la descripcion del producto");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese la cantidad del producto");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el tipo: ");
        String tipo = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese el precio del producto");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese el descuento: ");
        int descuento = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el IVA: ");
        int IVA = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Aplicar descuento? (true/false): ");
        boolean aplicarDto = scanner.nextBoolean();
        scanner.nextLine();
        
        productos.add(new Producto(referencia, descripcion,  tipo, cantidad, precio, descuento, IVA, aplicarDto));
        System.out.println("Producto registrado exitosamente.");
} 
    }
    
}


