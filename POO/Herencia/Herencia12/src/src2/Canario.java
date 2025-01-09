
import java.time.LocalDate;

public class Canario extends Aves {
public String color;
public boolean canta;

    public Canario(String nombre, int edad, String estado, LocalDate fechaNacimiento, LocalDate fechaMuerte, boolean vuela, boolean pico, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, fechaMuerte, vuela, pico);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public boolean volar(Boolean vuela) {
        return super.volar(vuela);
    }

    @Override
    public void morir() {
        super.morir();
    }

    @Override
    public String hablar() {
        return super.hablar();
    }

    @Override
    public void cumpleaños(LocalDate fechaNacimiento) {
        super.cumpleaños(fechaNacimiento);
    }

@Override
public String toString() {
    return "Canario [nombre=" + nombre + ", color=" + color + ", edad=" + edad + ", estado=" + estado
            + ", fechaNacimiento=" + fechaNacimiento + ", fechaMuerte=" + fechaMuerte + ", hablar=" + hablar() + "]";
}

@Override
protected char[] getTipo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
}

    





}
