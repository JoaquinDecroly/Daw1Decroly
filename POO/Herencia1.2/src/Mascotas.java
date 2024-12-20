import java.time.LocalDate;

public abstract class Mascotas {
protected String nombre;
protected int edad;
protected String estado;
protected LocalDate fechaNacimiento;
protected LocalDate fechaMuerte;




   



    public Mascotas(String nombre2, int edad2, String estado2, LocalDate fechaNacimiento2, LocalDate fechaMuerte2) {
    this.nombre = nombre;
    this.estado = estado;
    this.edad = edad;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaMuerte = fechaMuerte;
}

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }



    public void setEdad(int edad) {
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

    public abstract void cumpleaños(LocalDate fechaNacimiento);

    public abstract void morir();

    public abstract String hablar();
    
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
