import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String opcion = "";
        
            System.out.println("Seleccione una opcion:");
        do {
           
            System.out.println("1. Anadir contacto.");
            System.out.println("2. Eliminar contacto.");
            System.out.println("3. Listar contactos.");
            System.out.println("4. Buscar contacto.");
            System.out.println("5. Salir.");
            opcion = scanner.nextLine();

           
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contacto contacto = new Contacto(nombre, telefono);
                    if (agenda.añadirContacto(contacto)) {
                        System.out.println("Contacto añadido con éxito.");
                    } else {
                        System.out.println("El contacto ya existe.");
                    }
                    break;
                case "2":
                agenda.listarContactos();
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (agenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("Contacto eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case "3":
                    agenda.listarContactos();
                    break;
                case "4":
                agenda.listarContactos();
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    int posicion = agenda.buscaContacto(nombreBuscar);
                    if (posicion != -1) {
                        System.out.println("Contacto encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case "5":
                    System.out.println("Hasta la vista...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("5"));

    }
}