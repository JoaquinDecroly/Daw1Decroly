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

    public void mostrarInfoMovimiento() {
        System.out.println("ID: " + id + ", Fecha: " + fecha + ", Tipo: " + tipo + ", Cantidad: " + cantidad);
    }
}
