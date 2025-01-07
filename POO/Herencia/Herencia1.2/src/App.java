import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
    }

    private Tipo tipo = Tipo.UNKNOWN;
    private Estado estado = Estado.ACTIVO;
    private Color color = Color.DESCONOCIDO;
    private int edad = 0;
    private String nombre = "";
    private final LocalDate fechaNacimiento;
    private final LocalDate fechaMuerte;

    private Mascotas[] mascotas;

    public App(LocalDate fechaNacimiento, LocalDate fechaMuerte, Mascotas[] mascotas) {
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.mascotas = mascotas;
        this.edad = calcularEdad(fechaNacimiento);
    }

    private int calcularEdad(LocalDate fechaNacimiento) {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }
}
