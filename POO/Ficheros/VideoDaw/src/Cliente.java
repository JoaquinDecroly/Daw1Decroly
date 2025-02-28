import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {
    private String numSocio;
    private LocalDate fechaBaja;
    private ArrayList<Articulo> articulosAlquilados;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio) throws DNINoValidoException {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.articulosAlquilados = new ArrayList<>();
    }

    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public ArrayList<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }

    public void alquilar(Articulo articulo) {
        articulosAlquilados.add(articulo);
    }

    public void devolver(Articulo articulo) {
        articulosAlquilados.remove(articulo);
    }

    public void mostrarArticulosAlquilados() {
        System.out.println("Artículos alquilados por " + nombre + ":");
        if (articulosAlquilados.isEmpty()) {
            System.out.println("No hay artículos alquilados.");
        } else {
            for (Articulo articulo : articulosAlquilados) {
                System.out.println(articulo);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de socio: " + numSocio +
                (fechaBaja != null ? ", Fecha Baja: " + fechaBaja : "");
    }
}