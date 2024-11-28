import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a VideoDaw");

        String dni = pedirDni(sc);
        String nombre = pedirNombre(sc);
        String fechaNacimiento = pedirFechaNacimiento(sc);

        Cliente cliente = new Cliente(dni, nombre, fechaNacimiento);

        int opcion;
        do {
            opcion = mostrarMenu(sc);
            procesarOpcion(opcion, cliente, sc);
        } while (opcion != 8);
    }

    private static String pedirDni(Scanner sc) {
        String dni;
        do {
            System.out.println("Ingrese su DNI: ");
            dni = sc.nextLine();
            if (!isDniValido(dni)) {
                System.out.println("DNI no válido. Por favor, inténtelo de nuevo.");
            }
        } while (!isDniValido(dni));
        return dni;
    }

    private static String pedirNombre(Scanner sc) {
        System.out.println("Ingrese su nombre: ");
        return sc.nextLine();
    }

    private static String pedirFechaNacimiento(Scanner sc) {
        System.out.println("Ingrese su fecha de nacimiento: ");
        return sc.nextLine();
    }

    private static int mostrarMenu(Scanner sc) {
        System.out.println("1. Crear y registrar VideoClub en la franquicia ");
        System.out.println("2. Registrar película en VideoClub: ");
        System.out.println("3. Crear y registrar cliente en VideoClub: ");
        System.out.println("4. Alquilar película: ");
        System.out.println("5. Devolver película: ");
        System.out.println("6. Dar de baja Cliente: ");
        System.out.println("7. Dar de baja Pelicula: ");
        System.out.println("8. Salir");

        return obtenerOpcionValida(sc);
    }

    private static int obtenerOpcionValida(Scanner sc) {
        int opcion = -1; // Inicializamos con un valor no válido
        boolean esValida = false;

        while (!esValida) {
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                esValida = opcion >= 1 && opcion <= 8;
                if (!esValida) {
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
                }
            } else {
                System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
                sc.next(); // Limpiar el buffer
            }
        }
        return opcion;
    }

    private static void procesarOpcion(int opcion, Cliente cliente, Scanner sc) {
        switch (opcion) {
            case 1:
                new VideoDaw(VideoDaw.getCif(), VideoDaw.getDireccion(), VideoDaw.getFechaAlta());
                break;
            case 2:
                registrarPelicula(sc);
                break;
            case 3:
                registrarCliente(sc);
                break;
            case 4:
                alquilarPelicula(sc);
                break;
            case 5:
                devolverPelicula(sc);
                break;
            case 6:
                darBajaCliente(sc);
                break;
            case 7:
                darBajaPelicula(sc);
                break;
            case 8:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static boolean isDniValido(String dni) {
        return dni != null && dni.matches("[A-Z]{1}\\d{7}[A-Z0-9]");
    }
}

    
 

