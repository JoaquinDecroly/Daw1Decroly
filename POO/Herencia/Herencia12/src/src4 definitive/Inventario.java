import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Inventario {
    static int contM = 0;
    static Mascotas[] mascotas;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        Inventario inventario = new Inventario();
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
                    System.out.println("Adiós...");
                    break;
                case "1":
                    mostrarListaAnimales();
                    break;
                case "2":
                    System.out.println("Introduce el nombre del animal:");
                    String nombre1 = scanner.nextLine();
                    mostrarDatosAnimalConcreto(scanner);
                    break;
                case "3":
                    mostrarDatosTodosLosAnimales();
                    break;
                case "4":
                    insertarAnimal(scanner);
                    agregarMascota(null);
                    break;
                case "5":
                    eliminarMascota(null);
                    break;
                case "6":
                    vaciarInventarioMascotas();
                    break;
                default:
                    break;
            }
        } while (!option.equals("0"));
    }

    // Métodos
    private static int insertarAnimal(Scanner scanner) {
        if (contM >= mascotas.length) {
            System.out.println("No hay espacio para agregar más mascotas.");
            return contM;
        }

        System.out.println("Introduce el nombre del animal:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce la fecha de nacimiento (dd/MM/yyyy):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Introduce la fecha de muerte (dd/MM/yyyy) o presiona Enter si no aplica:");
        String fechaMuerteInput = scanner.nextLine();
        LocalDate fechaMuerte;
        if (fechaMuerteInput.isEmpty()) {
            fechaMuerte = null;
        } else {
            fechaMuerte = LocalDate.parse(fechaMuerteInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        System.out.println("Elige el tipo de animal a añadir: ");
        System.out.println("1. Loro");
        System.out.println("2. Canario");
        System.out.println("3. Perro");
        System.out.println("4. Gato");
        String tipoInput = scanner.nextLine();

        Tipo tipo;
        if (tipoInput.equals("1")) {
            tipo = Tipo.LORO;
        } else if (tipoInput.equals("2")) {
            tipo = Tipo.CANARIO;
        } else if (tipoInput.equals("3")) {
            tipo = Tipo.PERRO;
        } else if (tipoInput.equals("4")) {
            tipo = Tipo.GATO;
        } else {
            System.out.println("Tipo de animal no válido.");
            return contM;
        }

        System.out.println("Introduce el estado de tu animalito: ");
        String estado = scanner.nextLine();

        System.out.println("Introduce el color del animal:");
        System.out.println("1. blanco" +
                "2. negro" +
                "3. gris" +
                "4. otro");
        String colorInput = scanner.nextLine();
        Color color = null;

        if (colorInput.equals("1")) {
            color = Color.BLANCO;
        } else if (colorInput.equals("2")) {
            color = Color.NEGRO;
        } else if (colorInput.equals("3")) {
            color = Color.GRIS;
        } else if (colorInput.equals("4")) {
            color = Color.OTRO;
        } else {
            System.out.println("No es una opción válida.");
        }

        System.out.println("Tu mascota tiene el pelo largo?");
        Boolean peloLargo = scanner.nextBoolean();
        if (peloLargo) {
            peloLargo = true;
        } else {
            peloLargo = false;
        }

        int edad = calcularEdad(fechaNacimiento);
        Mascotas mascota = null;

        if (tipo == Tipo.LORO || tipo == Tipo.CANARIO) {
            System.out.println("Vuela?");
            boolean isVuela = scanner.nextBoolean();
        }

        System.out.println("Que forma del pico tiene?");
        String pico = scanner .nextLine();

        switch (tipo) {
            case LORO: {
                boolean isVuela;
                if (isVuela = true) {
                    isVuela = true;
                } else {
                    isVuela = false;
                }
                mascota = new Loro(nombre, edad, estado, fechaNacimiento, fechaMuerte, isVuela, pico, estado, peloLargo);
            }
            break;

            case CANARIO: {
                boolean isVuela;
                if (isVuela = true) {
                    isVuela = true;
                } else {
                    isVuela = false;
                }
                mascota = new Canario(nombre, edad, estado, fechaNacimiento, fechaMuerte, isVuela, pico, color, peloLargo);
            }
            break;

            case PERRO:
                mascota = new Perro(nombre, calcularEdad(fechaNacimiento), estado, fechaNacimiento, fechaMuerte, colorInput, peloLargo);
                break;
            case GATO:
                mascota = new Gato(nombre, calcularEdad(fechaNacimiento), estado, fechaNacimiento, fechaMuerte, color, peloLargo);
                break;
        }

        mascotas[contM] = mascota;
        contM++;
        System.out.println("Animal agregado con éxito.");
        return contM;
    }

    public static int calcularEdad(LocalDate fechaNacimiento) {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public static void agregarMascota(Mascotas mascota) {
        if (contM < mascotas.length) {
            mascotas[contM] = mascota;
            contM++;
        } else {
            System.out.println("No hay espacio para agregar más mascotas");
        }
    }

    public static void eliminarMascota(Mascotas mascota) {
        int index = -1;
        for (int i = 0; i < contM; i++) {
            if (mascotas[i].equals(mascota)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("No se encontró la mascota a eliminar");
            return;
        }
    }

    public void recolocarArrayyMacotas(Mascotas mascota) {
        int index = -1;
        // Desplazar elementos a la izquierda.
        for (int i = index; i < contM; i++) {
            mascotas[i] = mascotas[i + 1];
        }
        // Último elemento es null
        mascotas[contM - 1] = null;
        contM--;
    }

    public static void vaciarInventarioMascotas() {
        for (int i = 0; i < mascotas.length; i++) {
            mascotas[i] = null;
            contM++;
        }
    }

    public void mostrarInventarioMacotas() {
        for (int i = 0; i < mascotas.length; i++) {
            String info = "";
            info = String.format("Mascota" + i++ + "{ , Nombre= %s, Tipo= %s, estado= %s, fechaNacimiento= %s, edad= %s,", mascotas[i].getNombre(), mascotas[i].getTipo(), mascotas[i].getEstado(), mascotas[i].getFechaNacimiento(), calcularEdad(mascotas[i].getFechaNacimiento()));
            System.out.println(info);
        }
    }

    private static void mostrarListaAnimales() {
        for (int i = 0; i < contM; i++) {
            System.out.println("Nombre: " + mascotas[i].getNombre() + ", Tipo: " + mascotas[i].getTipo());
        }
    }

    private static void mostrarDatosAnimalConcreto(Scanner scanner) {
        System.out.println("Introduce el nombre del animal:");
        String nombre = scanner.nextLine();
        for (int i = 0; i < contM; i++) {
            if (mascotas[i].getNombre().equals(nombre)) {
                System.out.println(mascotas[i]);
                return;
            }
        }
        System.out.println("No se encontró el animal con ese nombre.");
    }

    private static void mostrarDatosTodosLosAnimales() {
        for (int i = 0; i < contM; i++) {
            System.out.println(mascotas[i]);
        }
    }
}