import java.time.LocalDate;

public abstract class Mascotas {
protected String nombre;
protected String edad;
protected String estado;
protected LocalDate fechaNacimiento;



    public  Mascotas(String nombre, String edad, String estado, LocalDate fechaNacimiento) {
    this.nombre = nombre;
    this.edad = edad;
    this.estado = estado;
    this.fechaNacimiento = fechaNacimiento;
}



    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }



    public void setEdad(String edad) {
        this.edad = edad;
    }



    public String getEstado() {
        return estado;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }



    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mascotas{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", estado=").append(estado);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }

    



}
