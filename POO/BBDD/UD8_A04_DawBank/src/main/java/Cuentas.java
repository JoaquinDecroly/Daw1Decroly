import java.util.LinkedList;
import java.util.List;

public class Cuentas {
    private List<CuentaBancaria> cuentas;

    public Cuentas() {
        this.cuentas = new LinkedList<>();
    }
    
    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }
}
