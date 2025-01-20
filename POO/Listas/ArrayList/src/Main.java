import java.util.ArrayList;
import java.util.Iterator;

public class Main {
// implements Comparable<Producto> {
public static void main(String[] args) {
  ArrayList<Producto> productos = new ArrayList<>(5);

  //anadir 5 objetos producto
  Producto p1 = new Producto("P1", 10);
  Producto p2 = new Producto("P2", 20);
  Producto p3 = new Producto("P3", 30);
  Producto p4 = new Producto("P4", 40);
  Producto p5 = new Producto("P5", 50);

  productos.add(p1); 
  productos.add(p2); 
  productos.add(p3); 
  productos.add(p4); 
  productos.add(p5);
  
//iterator
  Iterator<Producto> itera = productos.iterator();
  Producto p;
  System.out.println("Productos iniciales");
  while (itera.hasNext()) {
    p = itera.next(); 

    
    System.out.println(p.getNombre() + " " + p.getCantidad());

//eliminar 2 productos
   if (p.equals(p1) || p.equals(p2)) {
      itera.remove();
  } 
  }

  //imprimir producto eliminando 2 objetos
  System.out.println("Productos despues de eliminar");
  for (Producto producto : productos) {
    System.out.println(producto.getNombre() + " " + producto.getCantidad());
  }

  //añadir objeto en medio
  Producto p50 = new Producto("P50", 50);
productos.add(1, p50);

//imprimir producto despues de añadir objeto 
System.out.println("Productos despues de anadir un producto random");
Iterator<Producto> itera1 = productos.iterator();
  Producto producto;
  while (itera1.hasNext()) {
    producto = itera1.next(); 
   
    System.out.println(producto.getNombre() + " " + producto.getCantidad());
  }
}

// @Override
// public int hashCode() {
//   return super.hashCode();
// }

// @Override
// public boolean equals(Object obj) {
  
//   return super.equals(obj);
// }

// @Override
// public int compareTo(Producto p) {
//     return Integer.compare(p.getCantidad(), p.getCantidad());
// }

}
