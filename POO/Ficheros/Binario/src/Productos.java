import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Productos {
    int codigo = 0;
    String nombre;
    int cantidad;
    Double precio;

    List <Productos> productos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Productos(int codigo, String nombre, int cantidad, Double precio) {
        this.codigo = codigo++;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }




    public int getcodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }





    private void cargarDatos() {
        try (FileReader fr = new FileReader("./../resources/productos.dat");
             BufferedReader br = new BufferedReader(fr)) {
            String linea = br.readLine();
            int index = 0;

            String [] datos = linea.split(",");
            while (linea != null && index < productos.size()) {
                if (datos.length == 4) {
                    int codigo = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    Double precio = Double.parseDouble(datos[3]);

                    index++;
                }
                linea = br.readLine();
            }

        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    public void recorrerArray() {
        if (productos != null) {
            for (Productos producto : productos) {
                if (producto != null) {
                    System.out.println("Producto " + producto.getcodigo());
                    System.out.println(getNombre());
                    System.out.println(getCantidad());
                    System.out.println(getPrecio());
                    System.out.println("----------------------");
                }
            }
        }
    }

    private void escribirDatos(){
        try (FileWriter fw = new FileWriter("./../resources/productos.dat");
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Productos producto : productos) {
                if (producto != null) {
                    añadirProducto(sc);
                }
            }
        }   catch (IOException ex) {
            System.err.println("Error leyendo archivo: " + ex.getMessage());
        }
    }


    private void añadirProducto(Scanner scanner) {
        System.out.println("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.println("Precio del producto: ");
        double precio = scanner.nextDouble();
        Productos producto = new Productos(codigo, nombre, cantidad, precio);
    }

}