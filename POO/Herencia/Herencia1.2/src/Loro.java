import java.time.LocalDate;

public class Loro extends Aves {
public String origen;
public boolean habla;

public Loro(String nombre, int edad, String estado, LocalDate fechaNacimiento, LocalDate fechaMuerte, boolean vuela,
        boolean pico, String origen, boolean habla) {
    super(nombre, edad, estado, fechaNacimiento, fechaMuerte, vuela, pico);
    this.origen = origen;
    this.habla = habla;
}

    public String getOrigen() {
        return origen;
    }

    public boolean isHabla() {
        return habla;
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

    
    





}
