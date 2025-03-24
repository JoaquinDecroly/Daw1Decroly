import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyUtils {
     //path a la carpeta Recursos del proyecto
		final static String pathFile = "src\\Recursos";
		
		//Nombre del fichero Binario
		final  static String fileNameBinario = "almacen.dat";
		
		//Nombre del fichero UNICODE
		final static String fileNameUnicode = "productos.csv";

    //lectura fichero binario
     static void LecturaFicheroBinario(){
        List<Producto> productosLeidos = new LinkedList<>();
        boolean eof = false;

        try (FileInputStream fichero = new FileInputStream("src\\Recursos\\almacen.dat"); DataInputStream lector = new DataInputStream(fichero)) {
            

            while(!eof){
                int cantidad = lector.readInt();
                double precio = lector.readDouble();
                int descuento = lector.readInt();
                int iva = lector.readInt();
                boolean aplicarDto = lector.readBoolean();
                Producto p = new Producto(cantidad, precio, descuento, iva, aplicarDto);
                productosLeidos.add(p);
            }
            
        } catch (EOFException e) {
            eof = true;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        for (Producto p : productosLeidos) {
            System.out.println(p);
        }
    
    }


//Escritura ficheros binario
     static void EscrituraFicheroBinario(){
        List<Producto> productos = new LinkedList<>();

        try (FileOutputStream fichero = new FileOutputStream("src\\Recursos\\almacen.dat", false); DataOutputStream escritor = new DataOutputStream(fichero)) {

            for (Producto p : productos) {
                escritor.writeInt(p.getCantidad());
                escritor.writeDouble(p.getPrecio());
                escritor.writeInt(p.getDescuento());
                escritor.writeInt(p.getIVA());
                escritor.writeBoolean(p.isAplicarDto());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//     //Leer fichero unicode
//     	 static void LecturaFicheroUnicode() {

//             LinkedList<Producto> lineas = null;

//             if(pathFile != null && fileNameUnicode != null)
// 		{
			
// try (FileReader file= new FileReader("src\\Recursos\\productos.csv", false);
//     BufferedReader br = new BufferedReader(file)) {
//     lineas = new LinkedList<>();
// 	String linea;
//     try {
//         while ((linea = br.readLine()) != null) {
//             String[] datos = linea.split("/");
//             Producto p = new Producto(datos[0], datos[1], datos[2], datos[3]);
//             lineas.add(p);
//         }
    
// 	}catch (FileNotFoundException e) {
//             System.out.println("El archivo CSV no se encontró: " + e.getMessage());
//         } catch (IOException e) {
//             System.out.println("Error al leer el archivo CSV: " + e.getMessage());
//         } catch (NumberFormatException e) {
//             System.out.println("Error en el formato de número: " + e.getMessage());
//         } catch (Exception e) {
//             System.out.println("Error inesperado: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }catch (IOException ex) {
//         }finally{
// 		System.out.println("Se han cargado los productos del archivo CSV");
// 		}
// 	}
// }
// Leer fichero unicode
static void LecturaFicheroUnicode() {
    LinkedList<Producto> lineas = new LinkedList<>(); // Inicializar la lista

    if (pathFile != null && fileNameUnicode != null) {
        try (FileReader file = new FileReader("src\\Recursos\\productos.csv");
             BufferedReader br = new BufferedReader(file)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("/");
                if (datos.length == 4) { // Asegurarse de que hay 4 elementos
                    Producto p = new Producto(datos[0], datos[1], datos[2], datos[3]);
                    lineas.add(p);
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo CSV no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Se han cargado los productos del archivo CSV");
        }
    } else {
        System.out.println("Ruta del archivo o nombre del archivo no válidos.");
    }
}

//Escribir fichero Unicode
  static void escribirFicheroUnicode() {
    LinkedList<Producto> productos = null;
    productos = new LinkedList<>();    
    try (FileWriter writer = new FileWriter("src\\Recursos\\productos.csv", false);
        BufferedWriter bw = new BufferedWriter(writer)) {
            for (Producto p : productos) {
                bw.write(p.getReferencia() + "/" + p.getNombre() + "/" + p.getDescripcion() + "/" + p.getTipo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir datos: " + e.getMessage());
        }
    }




    /////////////////////////////////////////////////////////
    ////demas metodos/////////////
    ////
      //mostrar productos
     static void mostrarProductos(){    
        LinkedList<Producto> productos = null;
        productos = new LinkedList<>();
        try {
             if(productos.isEmpty()){
                 System.out.println("No hay productos");
                 return;
             }
        } catch (NullPointerException e) {
         System.out.println("No hay productos ");
         return;
        }
         for(Producto p : productos){
             System.out.println(p.getReferencia() + " / " + p.getDescripcion()); 
     }
 }
 
 //Eliminar producto según referencia
  static void eliminarProducto(Scanner scanner){
    LinkedList<Producto> productos = null;
    productos = new LinkedList<>();
      if(productos.isEmpty()){
             System.out.println("No hay productos");
             return;
         }
         for(Producto p : productos){
             System.out.println(p.getReferencia() + " / " + p.getDescripcion()); 
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

 //crear productos
  static void registrarProducto(Scanner scanner){
    LinkedList<Producto> productos = null;
    productos = new LinkedList<>();
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

     static void guardarInventario(){
        EscrituraFicheroBinario();
        escribirFicheroUnicode();
    }

    static void cargarDatos(){
        LecturaFicheroBinario();
        LecturaFicheroUnicode();
    }

		
    }
