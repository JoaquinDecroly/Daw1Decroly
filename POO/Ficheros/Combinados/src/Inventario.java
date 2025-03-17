import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {

    private static int cont = 0;

     //path a la carpeta Recursos del proyecto
		final static String pathFile = "src\\Recursos";
		
		//Nombre del fichero Binario
		final  static String fileNameBinario = "almacen.dat";
		
		//Nombre del fichero UNICODE
		final static String fileNameUnicode = "productos.csv";

    private static LinkedList<Producto> productos;
    public static void main(String[] args) {
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
            
                switch (opcion) {
                    case 1:
                    if (cont == 0) {
                    escribirFicheroUnicode(pathFile, fileNameUnicode); 
                    MyUtils.main(args);
                    escribirFicheroBinarioExamen(pathFile, fileNameBinario);  
                    cont++;
                    }
                    else {
                        mostrarProductos();
                    }
                   
                    break;
                case 2:
                    eliminarProducto(scanner); 
                    break;
                case 3:
                    guardarInventario(); 
                    System.out.println("Inventario guardado. Saliendo...");
                    break;
                case 4:
                    registrarProducto(scanner); 
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

    //mostrar productos
    private static void mostrarProductos(){    
    if(productos == null || productos.isEmpty()){
        System.out.println("No hay productos");
        return;
    }
    for(Producto p : productos){
        System.out.println(p.getReferencia() + " - " + p.getDescripcion()); 
    }
}
 
// Eliminar producto según referencia
private static void eliminarProducto(Scanner scanner) {
    if (productos.isEmpty()) {
        System.out.println("No hay productos en el inventario.");
        return;
    }

    System.out.println("Productos disponibles:");
    for (Producto p : productos) {
        System.out.println(p.getReferencia() + " - " + p.getDescripcion());
    }

    System.out.println("Ingrese la referencia del producto a eliminar:");
    String referencia = scanner.nextLine();

    boolean encontrado = false;
    for (Producto p : productos) {
        if (p.getReferencia().equals(referencia)) {
            productos.remove(p);
            System.out.println("Producto eliminado correctamente.");
            encontrado = true;
            break; 
        }
    }

    if (!encontrado) {
        System.out.println("Producto no encontrado. No se pudo eliminar.");
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
        System.out.println("Ingrese el nombre del producto");
         String nombre = scanner.nextLine();
         scanner.nextLine(); 
         System.out.println("Ingrese la descripcion del producto");
         String descripcion = scanner.nextLine();
         scanner.nextLine(); 
         System.out.print("Ingrese el tipo: ");
         String tipo = scanner.nextLine();
         scanner.nextLine(); 
         System.out.println("Ingrese la cantidad del producto");
         int cantidad = scanner.nextInt();
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
 
         productos.add(new Producto(referencia, nombre, descripcion, tipo, cantidad, precio, descuento, IVA, aplicarDto));         
         System.out.println("Producto registrado exitosamente.");
 } 
     }




  // Método para escribir datos unicode
    public static void escribirFicheroUnicode(String pathFile, String fileNameUnicode) {
        try (FileWriter writer = new FileWriter(pathFile + fileNameBinario, false);
        BufferedWriter bw = new BufferedWriter(writer)) {
            for (Producto p : productos) {
                bw.write(p.getReferencia() + "," + p.getNombre() + "," + p.getDescripcion() + "," + p.getTipo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir datos: " + e.getMessage());
        }
    }

    private static void escribirFicheroBinarioExamen(final String pathFile, String fileNameBinario) {
		//Escritura de fichero binario
		try(FileOutputStream fichero = new FileOutputStream(pathFile+fileNameBinario, false);
				DataOutputStream escritor = new DataOutputStream(fichero);)
		{
			
			Producto p1 = new Producto(5,25.75,15,21,false);
			Producto p2 = new Producto(15,55.95,5,21,true);
			Producto p3 = new Producto(100,3.25,0,21,false);
			Producto p4 = new Producto(300,0.95,0,21,false);
			Producto p5 = new Producto(27,5.25,13,21,true);
			
			
			LinkedList<Producto> productos = new LinkedList<>();
			
			productos.add(p1);
			productos.add(p2);
			productos.add(p3);
			productos.add(p4);
			productos.add(p5);
			
			
			for(Producto p : productos)
			{

				escritor.writeInt(p.getCantidad());
				escritor.writeDouble(p.getPrecio());
				escritor.writeInt(p.getDescuento());
				escritor.writeInt(p.getIVA());
				escritor.writeBoolean(p.isAplicarDto());
			}
	
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error al I/O");
			System.out.println(e.getMessage());
			
		}catch(Exception e)
		{
			System.out.println("Ha ocurrido un error inesperado");
			System.out.println(e.getMessage());

		}
}

    private static void guardarInventario(){
        escribirFicheroBinarioExamen(pathFile, fileNameBinario);
        escribirFicheroUnicode(pathFile, fileNameUnicode);
    }
		}
    
 

