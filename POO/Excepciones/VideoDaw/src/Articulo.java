
import java.time.LocalDate;

public class Articulo {
int cod = 1;
String titulo;
LocalDate fechaRegistro;
LocalDate fechaBaja;

    public Articulo(LocalDate fechaBaja, LocalDate fechaRegistro, String titulo) {
        this.fechaBaja = fechaBaja;
        this.fechaRegistro = fechaRegistro;
        this.titulo = titulo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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


    public String generarSiguienteCodigo() {
        return String.format("P-%04d", cod++);
    }
    

}
