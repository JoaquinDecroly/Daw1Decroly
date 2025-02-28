import java.time.LocalDate;
import java.time.LocalDateTime;


public class Pelicula extends Articulo {
    private GeneroPelicula genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String cod, String titulo, LocalDate fechaRegistro, GeneroPelicula genero) {
        super(cod, titulo, fechaRegistro);
        this.genero = genero;
        this.isAlquilada = false;
    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    @Override
    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public boolean isAlquilada() {
        return isAlquilada;
    }

    @Override
    public void alquilar(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = true;
    }

    @Override
    public void devolver() {
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: " + genero +
                (isAlquilada ? ", Estado: Alquilada" : ", Estado: Disponible");
    }
}
