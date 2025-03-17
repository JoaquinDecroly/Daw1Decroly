import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Productos {
    private static int nextCodigo = 1; // Variable estática para generar códigos únicos
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    // Lista de productos
    private static List<Productos> productos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Constructor
    public Productos(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
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
        try (BufferedReader br = new BufferedReader(new FileReader("resources/productos.dat"))) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/productos.dat"))) {
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

        productos.add(new Productos(nextCodigo++, nombre, cantidad, precio));
        System.out.println("Producto añadido exitosamente.");
    }

    // Método para eliminar un producto por código
    public static void eliminarProducto() {
        System.out.print("Código del producto a eliminar: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        productos.removeIf(producto -> producto.getCodigo() == codigo);
        System.out.println("Producto eliminado exitosamente.");
    }

    // Método para mostrar todos los productos
    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
            return;
        }

        for (Productos producto : productos) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("-----------------------------");
        }
    }
}