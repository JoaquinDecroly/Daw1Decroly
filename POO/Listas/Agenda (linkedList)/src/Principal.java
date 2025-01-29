import java.util.Scanner;

public class Principal {  
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Agenda agenda = new Agenda();
            String opcion = "";
            String nombreFormateado = "";
            System.out.println("-----Bienvenido-----");
                System.out.println("Seleccione una opcion:");
            do {
               
             
                System.out.println("-------------------------------");
                System.out.println("1. Añadir contacto.");
                System.out.println("2. Buscar contacto.");
                System.out.println("3. Eliminar contacto.");
                System.out.println("4. Listar contactos.");
                System.out.println("5. Listar Agenda");
                System.out.println("6. Salir.");
                System.out.println("-------------------------------");
                opcion = scanner.nextLine();
    
                switch (opcion) {
                    case "1": 
                    String nombre = "";                                  
                    do {
                        System.out.print("Ingrese el nombre del contacto: ");
                        nombre = scanner.nextLine();
                        nombreFormateado = Contacto.formatearNombre(nombre);
                    } while (nombreFormateado == null);
                                      
                        String telefono = "";
                        do {
                            System.out.print("Ingrese el teléfono: ");
                            telefono = scanner.nextLine(); 
                        } while (!Contacto.validarMovilER(telefono) == true);
                        
                       String correo = "";
                        do {
                           System.out.println("Ingrese el correo: ");
                            correo = scanner.nextLine();
                        } while (!Contacto.validaEmail(correo) == true);    
                        
                        Contacto c = new Contacto(nombreFormateado, telefono, correo);
                        agenda.añadirContacto(c);
                        break;
                    case "2":
                    scanner = new Scanner(System.in);
                    agenda.listarContactos();
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        nombre = scanner.nextLine();
                        agenda.buscaContacto(nombre);
                        break;
                    case "3":
                    agenda.listarContactos();
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    if (agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                    case "4":
                   agenda.listarContactos();
                    case "5":
                    agenda.numeroContactos();
                        break;
                    case "6":
                    System.out.println("Hasta la vista...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                    break;
                    }
            } while (!opcion.equals("6"));
    
        }
    }

