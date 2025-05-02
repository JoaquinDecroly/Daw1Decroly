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
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    
    
}
