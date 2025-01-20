import java.util.Objects;

public class Producto implements Comparable<Producto>  {
int cantidad;
String nombre;

    public Producto(String nombre, int cantidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }
  
  @Override
public int compareTo(Producto p) {
    return Integer.compare(this.cantidad, p.getCantidad());
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass())
        return false;
    Producto producto = (Producto) obj;
    return cantidad == producto.cantidad && Objects.equals(nombre, producto.nombre);
}

@Override
public int hashCode() {
    return Objects.hash(cantidad, nombre);
}

@Override
public String toString() {
    return "Producto [cantidad=" + cantidad + ", nombre=" + nombre + "]";
}   


}
