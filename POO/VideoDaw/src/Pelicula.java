
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
private String cod;
private String título;
private Genero genero;
private LocalDate fechaRegistro;
private LocalDate fechaBaja;
private LocalDateTime fechaAlquiler;
private boolean isAlquilada;

//constructor
    public Pelicula(String cod, LocalDate fechaRegistro, Genero genero, String título) {
        this.cod = cod;
        this.fechaRegistro = fechaRegistro;
        this.genero = genero;
        this.título = título;
        this.fechaBaja = null;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    //getters y setters
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    //metodos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("cod=").append(cod);
        sb.append(", t\u00edtulo=").append(título);
        sb.append(", genero=").append(genero);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", isAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }



}
