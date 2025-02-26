
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
int cod;
LocalDate fechaBaja;
List<Articulo> lista = new ArrayList<>();


    public Cliente(int cod, LocalDate fechaBaja, String dirección, String dni, LocalDate fechaNacimiento, String nombre) {
        super(dirección, dni, fechaNacimiento, nombre);
        this.cod = cod;
        this.fechaBaja = fechaBaja;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public List<Articulo> getLista() {
        return lista;
    }

    public void setLista(List<Articulo> lista) {
        this.lista = lista;
    }

    public String generarSiguienteCodigo() {
        return String.format("S-%04d", cod++);
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", dirección=" + dirección + ", cod=" + cod
                + ", fechaNacimiento=" + fechaNacimiento + ", fechaBaja=" + fechaBaja + "]";
    }


    


}
