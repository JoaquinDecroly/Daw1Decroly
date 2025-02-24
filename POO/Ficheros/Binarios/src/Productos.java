import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Productos {
    private int codigo; // Código del producto (entero)
    private String nombre; // Nombre del producto
    private int cantidad; // Cantidad disponible
    private double precio; // Precio del producto

    // Lista de productos
    private static List<Productos> productos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Constructor
    public Productos(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo; // Asignamos el código directamente
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
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Binarios\\resources\\almacen.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            productos.clear(); // Limpiamos la lista de productos antes de cargar nuevos datos

            while (true) {
                try {
                    // Leer cada campo del producto
                    int codigo = dis.readInt(); // Código como int
                    String nombre = dis.readUTF(); // Nombre como String
                    int cantidad = dis.readInt(); // Cantidad como int
                    double precio = dis.readDouble(); // Precio como double

                    // Crear un nuevo objeto Producto y añadirlo a la lista
                    productos.add(new Productos(codigo, nombre, cantidad, precio));
                } catch (IOException e) {
                    // Salimos del bucle cuando no hay más datos para leer
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    // Método para escribir datos en el archivo
    public static void escribirDatos() {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Joaquin\\Documents\\Daw1Decroly\\Ficheros\\Binarios\\resources\\almacen.dat");
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (Productos producto : productos) {
                // Escribimos cada campo del producto en el archivo
                dos.writeInt(producto.getCodigo()); // Código como int
                dos.writeUTF(producto.getNombre()); // Nombre como String
                dos.writeInt(producto.getCantidad()); // Cantidad como int
                dos.writeDouble(producto.getPrecio()); // Precio como double
            }

        } catch (IOException e) {
            System.err.println("Error al escribir datos: " + e.getMessage());
        }
    }

    // Método para añadir un producto
    public static void añadirProducto() {
        System.out.print("Código del producto: ");
        int codigo = sc.nextInt(); // Leer código como entero
        sc.nextLine(); // Limpiar buffer
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad del producto: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer

        // Añadir el producto a la lista
        productos.add(new Productos(codigo, nombre, cantidad, precio));
        System.out.println("Producto añadido exitosamente.");
    }

    // Método para eliminar un producto por código
    public static void eliminarProducto() {
        System.out.print("Código del producto a eliminar: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

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

    // Método para mostrar productos
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