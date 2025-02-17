import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String iban;
    
    private double saldo;
    Cliente cliente;
    private List<Movimiento> movimientos;

    public CuentaBancaria(String iban, Cliente cliente) {
        if (isIbanValido(iban) && !cliente.equals(null) && !cliente.getNombre().isEmpty()){
            this.iban = iban;
            this.cliente = cliente;
            this.saldo = 0;
            this.movimientos = new ArrayList<>();
        } else {
            System.out.println("Datos de cuenta inválidos.");
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
            System.out.println("AVISO: Saldo negativo");
        }
    }

    public void mostrarMovimientos() {
        if (movimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (Movimiento movimiento : movimientos) {
            movimientos.toString();
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
    if(saldo - cantidad < -50) {
        throw new SaldoNegativoException("Saldo inferior o igual a -50€. Porfavor Ingrese dinero antes de hacer una retirada");
    }
    }
}

public void CuentaException(CuentaBancaria cb) throws CuentaException {
    if (!isIbanValido(cb.getIban()) || !cb.getCliente().equals(cliente)) {
        throw new CuentaException("La cuenta bancaria proporcionada no es válida o no pertenece al titular.");
    }
}
}
