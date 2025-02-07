import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;
    private List<Movimiento> movimientos;

    private static final double SALDO_NEGATIVO_MAX = -50;

    public CuentaBancaria(String iban, String titular) {
        if (isIbanValido(iban) && !titular.isEmpty()) {
            this.iban = iban;
            this.titular = titular;
            this.saldo = 0;
            this.movimientos = new ArrayList<>();
        } else {
            System.out.println("Datos de cuenta inválidos.");
        }
    }

    private boolean isIbanValido(String iban) {
        return iban != null && iban.matches("[A-Z]{2}\\d{22}");
    }

    public void mostrarDatos() {
        System.out.printf("IBAN: %s, Titular: %s, Saldo: %s", iban, titular, saldo);
    }

    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        saldo += cantidad;
        movimientos.add(new Movimiento("Ingreso", cantidad));

    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        if (saldo - cantidad < SALDO_NEGATIVO_MAX) {
            System.out.println("Retirada no permitida. Verifica la cantidad o el saldo.");
            return;
        }

        saldo -= cantidad;
        movimientos.add(new Movimiento("Retirada", cantidad));

        if (saldo < 0) {
            System.out.println("AVISO: Saldo negativo");
        }
    }

    public void mostrarMovimientos() {
        if (movimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (Movimiento movimiento : movimientos) {
            movimiento.mostrarInfoMovimiento();
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }





    public static void avisarHacienda(double cantidad) throws AvisarHaciendaException {
        if (cantidad > 3000) {
            throw new AvisarHaciendaException("Movimiento sospechoso. Avisar a Hacienda");
        } 
    }

    
    public static void CuentaException(CuentaBancaria cb) throws CuentaException {
        if (isIbanValido(iban) && !titular.isEmpty())  {
            throw new CuentaException("Movimiento sospechoso. Avisar a Hacienda");
        } 
    }


}