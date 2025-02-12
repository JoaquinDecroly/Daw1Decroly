import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    String DNI;
    String nombre;
    LocalDate fechaNacimiento;

    public Persona(String DNI, String nombre, LocalDate fechaNacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

public static void validarFechaNacimiento(LocalDate fechaNacimiento) throws FechaException {
    if (fechaNacimiento.isAfter(LocalDate.now())) {
        throw new FechaException("Fecha de nacimiento no válida");
    }
}

    public String getFechaNacimiento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/|-MM/|:yyyy");
        return fechaNacimiento.format(formatter);
    }
}