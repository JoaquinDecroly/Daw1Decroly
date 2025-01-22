import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
public static void main(String[] args) {
  // ArrayList<Producto> productos = new ArrayList<>(5);
LinkedList<Producto> linkedList = new LinkedList<>();  
  //anadir 5 objetos producto
  Producto p1 = new Producto("P1", 10);
  Producto p2 = new Producto("P2", 20);
  Producto p3 = new Producto("P3", 30);
  Producto p4 = new Producto("P4", 40);
  Producto p5 = new Producto("P5", 50);

  linkedList.add(p1); 
  linkedList.add(p2); 
  linkedList.add(p3); 
  linkedList.add(p4); 
  linkedList.add(p5);
  
//iterator
  Iterator<Producto> itera = linkedList.iterator();
  Producto linked = null;
  System.out.println("Productos iniciales");
  while (itera.hasNext()) {
    System.out.println(itera.next());
  }
//eliminar 2 productos
   if (linkedList.contains(p1) || linkedList.contains(p2)) {
    linkedList.remove(p1);
    linkedList.remove(p2);
  }

  //imprimir producto eliminando 2 objetos
  Iterator<Producto> itera0 = linkedList.iterator();
  Producto linked0 = null;
  System.out.println("Productos despues de eliminar");  
  while (itera0.hasNext()) {
    System.out.println(itera0.next());

  //añadir objeto en medio
  Producto p50 = new Producto("P50", 60);
  linkedList.add(1, p50);

//imprimir producto despues de añadir objeto 
System.out.println("Productos despues de anadir un producto random");
Iterator<Producto> itera1 = linkedList.iterator();
  Producto linked1 = null;
  while (itera1.hasNext()) {   
    System.out.println(itera1.next());
  }

   // Ordenar la lista por nombre
        Collections.sort(linkedList);

        // Imprimir productos después de ordenar
        System.out.println("Productos despues de ordenar por valor");
        for (Producto a : linkedList) {
            System.out.println(linkedList);
            break;
        }

linkedList.clear();

System.out.println("Productos despues de eliminar");
if (linkedList.isEmpty()) {
  System.out.println("No hay productos");
} else {
  linkedList.clear();
  System.out.println("Se eliminaron los productos");
}}
}
}
