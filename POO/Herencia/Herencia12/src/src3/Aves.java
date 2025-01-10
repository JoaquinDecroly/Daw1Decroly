import java.time.LocalDate;

public abstract class Aves extends Mascotas {
private boolean vuela;
private boolean pico;



public Aves(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, LocalDate fechaMuerte, boolean vuela,
        boolean pico) {
    super(nombre, edad, estado, fechaNacimiento, fechaMuerte);
    this.vuela = vuela;
    this.pico = pico;
}

public boolean isVuela() {
    return vuela;
}

public boolean isPico() {
    return pico;
}

@Override
public void cumpleaños(LocalDate fechaNacimiento) {
    if (LocalDate.now() == fechaNacimiento) {
        System.out.println("Feliz cumpleaños " + this.getNombre());
        
    }    
}

@Override
public String hablar() {
    return "Hola";
}

@Override
public void morir() {
   fechaMuerte = LocalDate.now().minusYears(edad);
}

public boolean volar(Boolean vuela) {
return true;
}

@Override
 public LocalDate getFechaMuerte() {
    return super.getFechaMuerte();
    }
@Override
public String toString() {
    return "Aves [nombre=" + nombre + ", vuela=" + vuela + ", edad=" + edad + ", pico=" + pico + ", estado=" + estado
            + ", fechaNacimiento=" + fechaNacimiento + ", fechaMuerte=" + fechaMuerte + "]";
}

    @Override
    public LocalDate getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    @Override
    public void setEstado(Estado estado) {
        super.setEstado(estado);
    }

    @Override
    public Estado getEstado() {
        return super.getEstado();
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }

    @Override
    public int getEdad() {
        return super.getEdad();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    

   






}
