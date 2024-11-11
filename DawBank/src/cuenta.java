public class cuenta {
// atributos
private String IBAN;
private String titular;
private double  saldo;

// constructor
public cuenta(String IBAN, String titular, double saldo) {
    this.IBAN = IBAN;
    this.titular = titular;
    this.saldo = saldo;
}

    // métodos getter y setter
    public String getIban() {
        return IBAN;
    }

    public void setIban(String iban) {
        this.IBAN = IBAN;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

public void transferir(double cantidad, cuenta cuentaDestino) {
    if (this.saldo >= cantidad) {
        this.saldo -= cantidad;
        cuentaDestino.depositar(cantidad);
    } else {
        System.out.println("No hay suficiente saldo para realizar la transferencia.");
    }
}
}
