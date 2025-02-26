
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Videojuego extends Articulo {

  GeneroVideojuego generoVideojuego;
  LocalDateTime fechaAlquiler;
  boolean isAlquilado;

    public Videojuego(LocalDateTime fechaAlquiler, GeneroVideojuego generoVideojuego, boolean isAlquilado, LocalDate fechaBaja, LocalDate fechaRegistro, String titulo) {
        super(fechaBaja, fechaRegistro, titulo);
        this.fechaAlquiler = fechaAlquiler;
        this.generoVideojuego = generoVideojuego;
        this.isAlquilado = isAlquilado;
    }

    public GeneroVideojuego getGeneroVideojuego() {
        return generoVideojuego;
    }

    public void setGeneroVideojuego(GeneroVideojuego generoVideojuego) {
        this.generoVideojuego = generoVideojuego;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public boolean isIsAlquilado() {
        return isAlquilado;
    }

    public void setIsAlquilado(boolean isAlquilado) {
        this.isAlquilado = isAlquilado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Videojuego{");
        sb.append("generoVideojuego=").append(generoVideojuego);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", isAlquilado=").append(isAlquilado);
        sb.append('}');
        return sb.toString();
    }



}
