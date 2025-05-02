import java.util.List;

public class Cuentas {
    private List<CuentaBancaria> cuentas;

    public Cuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
    
    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }
}
