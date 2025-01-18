import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContactoPersona extends Contacto implements Persona {
    private LocalDate cumpleaños;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ContactoPersona(String nombre, String telefono, LocalDate cumpleaños) {
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    @Override
    public LocalDate getCumpleaños() {
        return cumpleaños;
    }

    @Override
    public void setCumpleaños(LocalDate cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cumpleaños: " + cumpleaños.format(formatter);
    }
}

