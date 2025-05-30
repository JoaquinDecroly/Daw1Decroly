import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Movimientos {
    private int id;
    private  int contador;
    private String iban;
    private String titular;
    private LocalDate fecha;
    private double cantidad;
    private tipo tipo;

    public Movimientos(tipo tipo, double cantidad) {
        this.id = contador++;
        this.iban = CuentaBancaria.getIban();
        this.titular = CuentaBancaria.getTitular();
        this.fecha = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public Movimientos(int id, String iban, String titular, LocalDate fecha, tipo tipo, double cantidad) {
        this.id = contador++;
        this.iban = CuentaBancaria.getIban();
        this.titular = CuentaBancaria.getTitular();
        this.fecha = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.cantidad = cantidad;
        this.tipo = tipo;
    }



    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Movimientos{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", tipo=" + tipo +
                '}';
    }
}
