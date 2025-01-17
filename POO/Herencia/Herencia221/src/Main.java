import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String opcion = "";

        do {
            String menuPri = "1. Añadir contacto.\r\n" +
            "2. Eliminar contacto.\r\n" +
            "3. Listar contactos.\r\n" +
            "4. Buscar contacto.\r\n" +
            "5. Salir.\r\n" +
            "Seleccione una opción: ";
           
           opcion = scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case "1":
                System.out.println("Elija el tipo de contacto que quiere añadir: ");
                String opcion2 = "";
                    System.out.println("1. Persona");
                    System.out.println("2. Empresa");
                    opcion2 = scanner.nextLine();
                    
                    System.out.println("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    if (opcion2.equals("1")) {
                        System.out.println("Cumpleaños: (dd/mm/yyyy) ");
                        String cumpleaños = scanner.nextLine();
                        agenda.addPersona(nombre, telefono, cumpleaños);
                    }else if(opcion2.equals("2"))
                        System.out.println("Página Web: ");
                        String paginaWeb = scanner.nextLine();
                        agenda.addEmpresa(nombre, telefono, paginaWeb);

                

                            
                    }
                    System.out.print("Ingrese el nombre del contacto: ");
                    
                     
                    if (agenda.añadirContacto(contacto)) {
                        System.out.println("El Contacto fue añadido con éxito.");
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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("5"));

    }
}