import java.util.LinkedList;
import java.util.List;

public class CuentaBancaria {
    private static String iban;
    private static String titular;
    private static double saldo;
    
    private List<Movimientos> movimientos;

    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new LinkedList<>();
    }

    public static String getIban() {
        return iban;
    }

    public static String getTitular() {
        return titular;
    }

    public static double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    // métodos para realizar operaciones bancarias
    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
        } else {
            System.out.println("No hay suficiente saldo para realizar la operación.");
        }
    }

    public void transferir(double cantidad, CuentaBancaria cuentaDestino) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            cuentaDestino.depositar(cantidad);
        } else {
            System.out.println("No hay suficiente saldo para realizar la transferencia.");
        }
    }
}
