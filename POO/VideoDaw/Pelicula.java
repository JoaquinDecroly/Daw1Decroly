
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
private String cod;
private static int contadorP = 0;
private String titulo;
private Genero genero;
private LocalDate fechaRegistro;
private LocalDate fechaBaja;
private LocalDateTime fechaAlquiler;
private boolean isAlquilada;

//constructor
    public Pelicula(String cod, LocalDate fechaRegistro, Genero genero, String título) {
        this.cod = "P-" + String.format("%04d", contadorP++);
        this.fechaRegistro = fechaRegistro;
        this.genero = genero;
        this.titulo = título;
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
        return titulo;
    }

    public void setTitulo(String título) {
        this.titulo = título;
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
    public String mostrarInfoPelicula() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("cod=").append(cod);
        sb.append(", t\u00edtulo=").append(titulo);
        sb.append(", genero=").append(genero);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", isAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }

    public void devolver(int i) {
        this.fechaAlquiler = null;
        Cliente.peliculasAlquiladas[i] = null;
    }

  


}