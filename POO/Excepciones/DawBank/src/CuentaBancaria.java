import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String iban;
    
    private double saldo;
    Cliente cliente;
    private List<Movimiento> movimientos;
    private final Double saldo_neg_max = -50.0;

    public CuentaBancaria(String iban, Cliente cliente) {
        if (isIbanValido(iban) && !cliente.getNombre().isEmpty()) {
            this.iban = iban;
            this.cliente = cliente;
            this.saldo = 0;
            this.movimientos = new ArrayList<>();
        } else {
            System.out.println("Datos de cuenta inválidos.");
            System.exit(0);
        }
    }


 //metodos ingreso, retirada, ver  
    public void mostrarDatos() {
        System.out.printf("IBAN: %s, Cliente %s, Saldo: %s", iban, cliente, saldo);
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

        saldo -= cantidad;
        movimientos.add(new Movimiento("Retirada", cantidad));

        if (saldo < 0) {
            System.out.println("AVISO: Saldo negativo. El saldo negativo maximo es de " + saldo_neg_max);
        }

        if (saldo - cantidad < saldo_neg_max) {
            System.out.println("No cuenta con suficientes fondos.");
            return;
        }

        if (saldo == saldo_neg_max) {
            System.out.println("Ha llegado al límite de saldo negativo. No puede retirar más dinero.");
        }
    }

    public void mostrarMovimientos() {
        if (movimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento.toString());
        }
    }





 //validacion
    private boolean isIbanValido(String iban) {
        return iban != null && iban.matches("[A-Z]{2}\\d{22}");
    }


    //getters
    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

   


    public Cliente getCliente() {
        return cliente;
    }


    //excepciones
    public void AvisarHaciendaException(double cantidad) throws AvisarHaciendaException {
    if (cantidad > 3000) {
        throw new AvisarHaciendaException("Movimiento sospechoso. Contacte a Hacienda");
    }
}

public void SaldoNegativoException(Double cantidad) throws SaldoNegativoException {
    
    if (saldo < 0) {
    if(saldo - cantidad >= -50) {
        throw new SaldoNegativoException("Saldo inferior o igual a -50€. Porfavor Ingrese dinero antes de hacer una retirada");
    }
    }
}

public void CuentaException(CuentaBancaria cb) throws CuentaException {
    if (!isIbanValido(cb.getIban()) || !cb.getCliente().equals(cliente) ) {
        throw new CuentaException("La cuenta bancaria proporcionada no es válida o no pertenece al titular.");
    }
}
}
