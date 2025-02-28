import java.time.LocalDate;

public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) throws DNINoValidoException {
        if (!esDNIValido(dni)) {
            throw new DNINoValidoException("El DNI proporcionado no es válido.");
        }
        if (edad(fechaNacimiento) < 18) {
            throw new IllegalArgumentException("La persona debe ser mayor de edad.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    private boolean esDNIValido(String dni) {
        return dni.length() == 9 && Character.isLetter(dni.charAt(8));
    }

    private int edad(LocalDate fechaNacimiento) {
        LocalDate ahora = LocalDate.now();
        return ahora.getYear() - fechaNacimiento.getYear();
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Dirección: " + direccion +
                ", Fecha Nacimiento: " + fechaNacimiento;
    }
}
