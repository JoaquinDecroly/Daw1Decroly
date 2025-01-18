import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String opcion = "";

        do {
            System.out.println("1. Añadir contacto.");
            System.out.println("2. Eliminar contacto.");
            System.out.println("3. Listar contactos.");
            System.out.println("4. Buscar contacto.");
            System.out.println("5. Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Elija el tipo de contacto que quiere añadir: ");
                    System.out.println("1. Persona");
                    System.out.println("2. Empresa");
                    String opcion2 = scanner.nextLine();

                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();

                    if (opcion2.equals("1")) {
                        System.out.print("Cumpleaños (dd/MM/yyyy): ");
                        String cumpleañosStr = scanner.nextLine();
                        LocalDate cumpleaños = LocalDate.parse(cumpleañosStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        ContactoPersona persona = new ContactoPersona(nombre, telefono, cumpleaños);
                        if (agenda.añadirContacto(persona)) {
                            System.out.println("El contacto fue añadido con éxito.");
                        } else {
                            System.out.println("El contacto ya existe.");
                        }
                    } else if (opcion2.equals("2")) {
                        System.out.print("Página Web: ");
                        String paginaWeb = scanner.nextLine();
                        ContactoEmpresa empresa = new ContactoEmpresa(nombre, telefono, paginaWeb);
                        if (agenda.añadirContacto(empresa)) {
                            System.out.println("El contacto fue añadido con éxito.");
                        } else {
                            System.out.println("El contacto ya existe.");
                        }
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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!opcion.equals("5"));
    }
}
