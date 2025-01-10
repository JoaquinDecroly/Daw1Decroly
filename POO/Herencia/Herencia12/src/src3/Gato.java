import java.time.LocalDate;

public class Gato extends Mascotas {
public Color color;
public boolean peloLargo;
public Gato(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, LocalDate fechaMuerte, Color color,
        boolean peloLargo) {
    super(nombre, edad, estado, fechaNacimiento, fechaMuerte);
    this.color = color;
    this.peloLargo = peloLargo;
}

    

    @Override
    public void cumpleaños(LocalDate fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void morir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String hablar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   @Override
public String toString() {
    return String.format("Gato [nombre=%s, color=%s, edad=%d, peloLargo=%b, estado=%s, fechaNacimiento=%s, fechaMuerte=%s]",
            getNombre(), this.color, this.edad, this.peloLargo, this.estado, this.fechaNacimiento, this.fechaMuerte);
}

    



}
