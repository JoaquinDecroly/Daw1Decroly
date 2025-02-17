import java.time.LocalDate;

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



    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    

}