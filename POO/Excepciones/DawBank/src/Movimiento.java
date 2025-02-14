import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
 private static int contadorMovimientos = 0; // Contador para generar IDs únicos
    private final int id;
    private final String fecha;
    private final String tipo; // "Ingreso" o "Retirada"
    private final double cantidad;

    public Movimiento(String tipo, double cantidad) {
        this.id = ++contadorMovimientos;
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return "Movimiento [id=" + id + ", fecha=" + fecha + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
    }
}
