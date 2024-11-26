import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
    private String codigo; // Cambiado a String para seguir el formato P-0001
    private static int contadorPeli = 1; // Inicializar el contador en 1

    private String titulo;
    private Genero genero;

    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada; // Cambiado a un nombre más descriptivo

    // Constructor
    public Pelicula(String titulo, Genero genero, LocalDate fechaRegistro) {
      
        this.codigo = "P-" + String.format("%04d", contadorPeli++); // Generar código único
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        this.isAlquilada = false;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    // Métodos
    public void alquilar() {
        this.fechaAlquiler = LocalDateTime.now();
        this.isAlquilada = true;
    }

    public void devolver() {
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    public void mostrarInfoPelicula() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Fecha de Registro: " + fechaRegistro);
        System.out.println("Alquilada: " + (isAlquilada));

        if (isAlquilada) {
            System.out.println("Fecha de Alquiler: " + fechaAlquiler);
        }
    }

   
}