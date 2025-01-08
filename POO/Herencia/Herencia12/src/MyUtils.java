
import java.util.Scanner;

public class MyUtils{

public static void main(String[] args) {
    String option = "";
    Scanner scanner = new Scanner(System.in);

    do {
        System.out.println("Bienvenido al veterinario");
        System.out.println("--------------");
        System.out.println("1. Mostrar lista de animales (tipo y nombre)");
        System.out.println("2. Mostrar datos de animal concreto");
        System.out.println("3. Mostrar datos de todos los animales");
        System.out.println("4. Insertar animal en el inventario");
        System.out.println("5. Eliminar animal del inventario");
        System.out.println("6. Vaciar el inventario");
        System.out.println("0. Salir");
        option = scanner.nextLine();

        switch (option) {
            case "0":
                
                break;
            case "1":

            break;
            case "2":
    System.out.println("Introduce el nombre del animal");
    String nombre = scanner.nextLine();
    for (int i = 0; i < 10; i++) {
        if (Inventario.getMascotas[i].getNombre().equals(nombre)) {
            System.out.println(Inventario.getMascotas[i].getNombre());
            System.out.println(Inventario.getMascotas[i].getTipo());
        }
    }
    break;
case "3":
    for (int i = 0; i < 10; i++) {
        System.out.println(Inventario.getMascotas[i].getNombre());
        System.out.println(Inventario.getMascotas[i].getTipo());
    }
    break;
case "4":
    System.out.println("Introduce el nombre del animal");
    String nombreNuevo = scanner.nextLine();
    System.out.println("Introduce el tipo del animal");
    String tipoNuevo = scanner.nextLine();
    Inventario.agregarMascota(nombreNuevo, tipoNuevo);
    break;
case "5":
    System.out.println("Introduce el nombre del animal");
    String nombreEliminar = scanner.nextLine();
    Inventario.eliminarMascota(nombreEliminar);
    break;
case "6":
    Inventario.vaciarInventario();
    break;
            default:
                throw new AssertionError();
        }
        if (option == "1") {
            for (int i = 0; i < 10; i++) {
                System.out.println(Inventario.getMascotas[i].getNombre());
                System.out.println(Inventario.getMascotas[i].getTipo());
            }
        elseif(option == "2"){
           
        }elseif(option == "3"){
          System.out.println("Introduce el nombre del animal");
            for (int i = 0; i < 10; i++) {
                
            }   
            
        }
        } else {
            
        }
    } while (!option.equals("0"));
}
}
