import java.util.ArrayList;
import java.util.Iterator;

public class Main {
public static void main(String[] args) {
  ArrayList<Producto> productos = new ArrayList<>(5);
  
  productos.add(new Producto("P1", 10));
  productos.add(new Producto("P2", 20));
  productos.add(new Producto("P3", 30));
  productos.add(new Producto("P4", 40));
  productos.add(new Producto("P5", 50));
  
//   for (Producto p : productos) {
//       System.out.println(p);
//   }

  Iterator<Producto> itera = productos.iterator();
  Producto p;
  while (itera.hasNext()) {
    p = itera.next();
    System.out.println(p.getNombre() + " " + p.getCantidad());
  }

  productos.remove(("P1", 10));
}
}
