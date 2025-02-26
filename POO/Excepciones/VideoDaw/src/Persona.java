
import java.time.LocalDate;
import java.time.Period;

public class Persona {
String dni;
String nombre;
String dirección;
LocalDate fechaNacimiento;

    public Persona(String dirección, String dni, LocalDate fechaNacimiento, String nombre) {
        this.dirección = dirección;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }




    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    
boolean esMayorDeEdad() {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
}
}
