import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Inventario {
    private static int contM = 0;
    private static Mascotas[] mascotas = new Mascotas[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos para crear un animal al iniciar el programa
        contM = insertarAnimal(scanner);

        String option;
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
                    System.out.println("Un placer. Hasta pronto...");
                    break;
                case "1":
                    mostrarListaAnimales();
                    break;
                case "2":
                    mostrarDatosAnimalConcreto(scanner);
                    break;
                case "3":
                    mostrarDatosTodosLosAnimales();
                    break;
                case "4":
                    contM = insertarAnimal(scanner);
                    break;
                case "5":
                    contM = eliminarAnimal(scanner);
                    break;
                case "6":
                    contM = vaciarInventario();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!option.equals("0"));
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

        System.out.println("Introduce el color del animal:");
        String colorInput = scanner.nextLine();
        Color color;
        if (colorInput.equalsIgnoreCase("blanco")) {
            color = Color.BLANCO;
        } else if (colorInput.equalsIgnoreCase("negro")) {
            color = Color.NEGRO;
        } else if (colorInput.equalsIgnoreCase("marron")) {
            color = Color.MARRON;
        } else if (colorInput.equalsIgnoreCase("gris")) {
            color = Color.GRIS;
        } else {
            color = Color.OTRO;
        }

        int edad = calcularEdad(fechaNacimiento);
        Mascotas mascota = null;

        switch (tipo) {
            case LORO:
                mascota = new Loro(nombre, edad, Estado.ACTIVO, fechaNacimiento, fechaMuerte, color, true, true);
                break;
            case CANARIO:
                mascota = new Canario(nombre, edad, Estado.ACTIVO, fechaNacimiento, fechaMuerte, color, true, true);
                break;
            case PERRO:
                mascota = new Perro(nombre, edad, Estado.ACTIVO, fechaNacimiento, fechaMuerte, color);
                break;
            case GATO:
                mascota = new Gato(nombre, edad, Estado.ACTIVO, fechaNacimiento, fechaMuerte, color);
                break;
        }

        mascotas[contM] = mascota;
        contM++;
        System.out.println("Animal agregado con éxito.");
        return contM;
    }

    private static int eliminarAnimal(Scanner scanner) {
        System.out.println("Introduce el nombre del animal a eliminar:");
        String nombreEliminar = scanner.nextLine();
        int index = -1;

        for (int i = 0; i < contM; i++) {
            if (mascotas[i].getNombre().equals(nombreEliminar)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("No se encontró la mascota a eliminar.");
            return contM;
        }

        for (int i = index; i < contM - 1; i++) {
            mascotas[i] = mascotas[i + 1];
        }

        mascotas[contM - 1] = null; // Eliminar referencia al último elemento
        contM--;
        System.out.println("Mascota eliminada con éxito.");
        return contM;
    }

    private static int vaciarInventario() {
        for (int i = 0; i < contM; i++) {
            mascotas[i] = null;
        }
        contM = 0;
        System.out.println("Inventario vaciado.");
        return contM;
    }

    private static int calcularEdad(LocalDate fechaNacimiento) {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }
}
