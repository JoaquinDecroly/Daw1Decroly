import java.time.LocalDate;
import java.time.LocalDateTime;

public class Videojuego extends Articulo {
    private GeneroVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Videojuego(String cod, String titulo, LocalDate fechaRegistro, GeneroVideojuego genero) {
        super(cod, titulo, fechaRegistro);
        this.genero = genero;
        this.isAlquilada = false;
    }

    public GeneroVideojuego getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void alquilar(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = true;
    }

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


