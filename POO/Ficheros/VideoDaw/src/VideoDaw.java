import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoDaw {
    private static ArrayList<GestionVideoDaw> franquicias = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    crearYRegistrarVideoClub();
                    break;
                case 2:
                    registrarPelicula();
                    break;
                case 3:
                    crearYRegistrarCliente();
                    break;
                case 4:
                    alquilarArticulo();
                    break;
                case 5:
                    devolverArticulo();
                    break;
                case 6:
                    darBajaCliente();
                    break;
                case 7:
                    darBajaArticulo();
                    break;
                case 8:
                    salir = true;
                    break;
                default:
            System.out.println("Opción no válida. Por favor, selecciona una opción válida.");

                    break;
            }

        }

        System.out.println("¡Gracias por usar VideoDAW!");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear y registrar VideoClub en la franquicia.");
        System.out.println("2. Registrar película en videoclub.");
        System.out.println("3. Crear y registrar cliente en videoclub.");
        System.out.println("4. Alquilar.");
        System.out.println("5. Devolver.");
        System.out.println("6. Dar de baja cliente.");
        System.out.println("7. Dar de baja artículo.");
        System.out.println("8. Salir.");
        System.out.print("Selecciona una opción: ");
    }

    private static int leerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void crearYRegistrarVideoClub() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            System.out.print("Dirección del videoclub: ");
            String direccion = scanner.nextLine();

            if (buscarVideoClubPorCIF(cif) != null) {
                throw new VideoclubDuplicadoException("El videoclub con CIF " + cif + " ya existe.");
            }

            GestionVideoDaw videoClub = new GestionVideoDaw(cif, direccion, LocalDateTime.now());
            franquicias.add(videoClub);
            System.out.println("Videoclub registrado exitosamente en la franquicia.");

        } catch (VideoclubDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarPelicula() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            System.out.print("Código de la película (ej. P-0001): ");
            String cod = scanner.nextLine();
            System.out.print("Título de la película: ");
            String titulo = scanner.nextLine();
            System.out.print("Género de la película: ");
            GeneroPelicula genero = GeneroPelicula.valueOf(scanner.nextLine().toUpperCase());

            Pelicula pelicula = new Pelicula(cod, titulo, LocalDate.now(), genero);
            videoClub.registrarArticulo(pelicula);
            System.out.println("Película registrada exitosamente en el videoclub.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearYRegistrarCliente() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            String dni;
            do {
                System.out.print("DNI del cliente: ");
                dni = scanner.nextLine();
                if (!esDNIValido(dni)) {
                    System.out.println("Error: El DNI proporcionado no es válido.");
                }
            } while (!esDNIValido(dni));

            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Dirección del cliente: ");
            String direccion = scanner.nextLine();
            LocalDate fechaNacimiento;
            do {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaInput = scanner.nextLine();
                try {
                    fechaNacimiento = LocalDate.parse(fechaInput);
                    if (edad(fechaNacimiento) < 18) {
                        System.out.println("Error: La persona debe ser mayor de edad.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Fecha no válida.");
                    fechaNacimiento = null;
                }
            } while (fechaNacimiento == null || edad(fechaNacimiento) < 18);

            Cliente cliente = new Cliente(dni, nombre, direccion, fechaNacimiento, generarNumSocio());
            videoClub.registrarCliente(cliente);
            System.out.println("Cliente registrado exitosamente en el videoclub.");

        } catch (DNINoValidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClienteDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void alquilarArticulo() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            System.out.print("DNI del cliente: ");
            String dni = scanner.nextLine();
            Cliente cliente = videoClub.buscarClientePorDNI(dni);

            if (cliente == null) {
                throw new ClienteNoEncontradoException("Cliente no encontrado.");
            }

            System.out.print("Código del artículo a alquilar: ");
            String codArticulo = scanner.nextLine();
            Articulo articulo = videoClub.buscarArticuloPorCod(codArticulo);

            if (articulo == null) {
                throw new ArticuloNoEncontradoException("Artículo no encontrado.");
            }

            videoClub.alquilarArticulo(cliente, articulo);
            System.out.println("Artículo alquilado exitosamente por el cliente.");

        } catch (ArticuloYaAlquiladoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArticuloNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void devolverArticulo() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            System.out.print("DNI del cliente: ");
            String dni = scanner.nextLine();
            Cliente cliente = videoClub.buscarClientePorDNI(dni);

            if (cliente == null) {
                throw new ClienteNoEncontradoException("Cliente no encontrado.");
            }

            System.out.print("Código del artículo a devolver: ");
            String codArticulo = scanner.nextLine();
            Articulo articulo = videoClub.buscarArticuloPorCod(codArticulo);

            if (articulo == null) {
                throw new ArticuloNoEncontradoException("Artículo no encontrado.");
            }

            videoClub.devolverArticulo(cliente, articulo);
            System.out.println("Artículo devuelto exitosamente por el cliente.");

        } catch (DevolucionExcedidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArticuloNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void darBajaCliente() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            System.out.print("DNI del cliente a dar de baja: ");
            String dni = scanner.nextLine();
            videoClub.darBajaCliente(dni);
            System.out.println("Cliente dado de baja exitosamente del videoclub.");

        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void darBajaArticulo() {
        try {
            System.out.print("CIF del videoclub: ");
            String cif = scanner.nextLine();
            GestionVideoDaw videoClub = buscarVideoClubPorCIF(cif);

            if (videoClub == null) {
                throw new IllegalArgumentException("Videoclub no encontrado.");
            }

            System.out.print("Código del artículo a dar de baja: ");
            String cod = scanner.nextLine();
            videoClub.darBajaArticulo(cod);
            System.out.println("Artículo dado de baja exitosamente del videoclub.");

        } catch (ArticuloNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static GestionVideoDaw buscarVideoClubPorCIF(String cif) {
        for (GestionVideoDaw videoClub : franquicias) {
            if (videoClub.getCIF().equals(cif)) {
                return videoClub;
            }
        }
        return null;
    }

    private static String generarNumSocio() {
        return "S-" + String.format("%04d", franquicias.size() + 1);
    }

    private static boolean esDNIValido(String dni) {
        return dni.length() == 9 && Character.isLetter(dni.charAt(8));
    }

    private static int edad(LocalDate fechaNacimiento) {
        LocalDate ahora = LocalDate.now();
        return ahora.getYear() - fechaNacimiento.getYear();
    }
}
