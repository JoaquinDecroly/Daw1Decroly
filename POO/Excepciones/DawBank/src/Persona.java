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



    public String getFechaNacimiento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        return fechaNacimiento.format(formatter);
    }
}