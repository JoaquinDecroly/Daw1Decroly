
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pelicula extends Articulo {
GeneroPelicula genero;
LocalDateTime fechaAlquiler;
boolean isAlquilada;

List<Pelicula> peliculas = new ArrayList<>();

    public Pelicula(LocalDateTime fechaAlquiler, GeneroPelicula genero, boolean isAlquilada, LocalDate fechaBaja, LocalDate fechaRegistro, String titulo) {
        super(fechaBaja, fechaRegistro, titulo);
        this.fechaAlquiler = fechaAlquiler;
        this.genero = genero;
        this.isAlquilada = isAlquilada;
    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    public void setGenero(GeneroPelicula genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isIsAlquilada() {
        return isAlquilada;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }


}
