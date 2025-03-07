import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<Libro> libros = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    String isbn;
    String autor;
    String titulo;
    LocalDate fechaPublicacion;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Libro(String isbn, String autor, String titulo, LocalDate fechaPublicacion) {
        this.isbn = generateAndValidateISBN();
        this.autor = autor;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    public static void cargarLibro() {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\daw1.COMPU-S024\\Documents\\Daw1Decroly\\POO\\Ficheros\\Serializables\\src\\resources\\Biblioteca.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            libros = (List<Libro>) ois.readObject();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al leer el fichero");
            System.out.println(ex.getMessage());
        }
    }

    public static void escribirLibro() {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\daw1.COMPU-S024\\Documents\\Daw1Decroly\\POO\\Ficheros\\Serializables\\src\\resources\\Biblioteca.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(libros);

        } catch (java.lang.Exception e) {
            System.out.println("Error al añadir el libro");
            System.out.println(e.getMessage());
        }
    }

    public static void crearLibro(){
        Scanner sc = new Scanner(System.in);
        String isbn = generateAndValidateISBN();
        System.out.println(isbn);
        System.out.println("Introduce el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Introduce el titulo del libro: ");
        String titulo = sc.nextLine();
        
        LocalDate fechaPublicacion = null;
        while (fechaPublicacion == null) {
            System.out.println("Introduce la fecha de publicacion del libro (dd/MM/yyyy): ");
            String fechaInput = sc.nextLine();
            try {
                fechaPublicacion = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, introduce una fecha en el formato correcto.");
            }
        }
    }
    

    public static void eliminarLibro() {
        System.out.println("Libros disponibles:");
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            System.out.println("ISBN: " + libro.getIsbn() + " | Título: " + libro.getTitulo());
        }

        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String isbn = sc.nextLine();

        boolean encontrado = false;
        for (int i = libros.size() - 1; i >= 0; i--) {
            Libro libro = libros.get(i);
            if (libro.getIsbn().equals(isbn)) {
                libros.remove(i);
                encontrado = true;
                System.out.println("Libro eliminado correctamente.");
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un libro con ese ISBN.");
        }
    }

    public static String generateAndValidateISBN() {
        Random random = new Random();
        StringBuilder isbnBuilder = new StringBuilder("978"); // Prefijo estándar para ISBN-13

        // Generar 9 dígitos aleatorios después del prefijo
        for (int i = 0; i < 9; i++) {
            isbnBuilder.append(random.nextInt(10));
        }

        // Calcular el dígito de control
        int checksum = calculateChecksum(isbnBuilder.toString());
        isbnBuilder.append(checksum);

        String isbn = isbnBuilder.toString();

        // Validar el ISBN generado
        if (isValidISBN(isbn)) {
            return isbn; // Retornar el ISBN si es válido
        } else {
            return "Invalid ISBN generated"; // Mensaje de error si no es válido
        }
    }

    private static int calculateChecksum(String isbn) {
        int total = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            if (i % 2 == 0) {
                total += digit; // Posición par: multiplicar por 1
            } else {
                total += digit * 3; // Posición impar: multiplicar por 3
            }
        }
        int checksum = 10 - (total % 10);
        return checksum == 10 ? 0 : checksum;
    }

    public static boolean isValidISBN(String isbn) {
        return isbn.matches("^(?:ISBN(?:-13)?:?\\ )?(?=[-0-9X]{17}$|[0-9]{13}$)97[89][-\\ ]?[0-9]{1,5}[-\\ ]?(?:[0-9]+[-\\ ]?){2}[0-9]$");
    }
}
