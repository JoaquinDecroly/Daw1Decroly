import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Productos {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    // Lista de productos
    private static List<Productos> productos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Constructor
    public Productos(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo++;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para cargar datos desde el archivo
    public static void cargarDatos() {
        try (FileReader reader = new FileReader("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Unicode\\resources\\almacen.dat");
        BufferedReader br = new BufferedReader(reader)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int codigo = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    productos.add(new Productos(codigo, nombre, cantidad, precio));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Método para escribir datos en el archivo
    public static void escribirDatos() {
        try (FileWriter writer = new FileWriter("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Unicode\\resources\\almacen.dat");
        BufferedWriter bw = new BufferedWriter(writer)) {
            for (Productos producto : productos) {
                bw.write(producto.getCodigo() + "," + producto.getNombre() + "," + producto.getCantidad() + "," + producto.getPrecio());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir datos: " + e.getMessage());
        }
    }

    // Método para añadir un producto
    public static void añadirProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Cantidad del producto: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // Limpiar el buffer

        productos.add(new Productos(1, nombre, cantidad, precio));
        System.out.println("Producto añadido exitosamente.");
    }

    // Método para eliminar un producto por código
    public static void eliminarProducto() {
        System.out.print("Código del producto a eliminar: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        boolean productoEncontrado = false;

        // Iterar sobre la lista de productos
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                // Eliminar el producto de la lista
                productos.remove(i);
                productoEncontrado = true;
                System.out.println("Producto eliminado exitosamente.");
                break; // Salir del bucle después de eliminar el producto
            }
        }

        // Si no se encontró ningún producto con ese código
        if (!productoEncontrado) {
            System.out.println("No se encontró ningún producto con el código " + codigo + ".");
        }
    }


      public static String mostrarProductos() {
        StringBuilder productosStr = new StringBuilder();
        for (Productos producto : productos) {
            productosStr.append("Código: ").append(producto.getCodigo())
                    .append(", Nombre: ").append(producto.getNombre())
                    .append(", Cantidad: ").append(producto.getCantidad())
                    .append(", Precio: ").append(producto.getPrecio())
                    .append("\n");
        }
        return productosStr.toString();
}
    }
    

