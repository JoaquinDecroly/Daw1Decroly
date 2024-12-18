import java.time.LocalDate;

public class Perro extends Mascotas {
public String raza;
public boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fechaNacimiento, LocalDate fechaMuerte,   ) {
        
    }

    @Override
    public void cumpleaños(LocalDate fechaNacimiento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cumpleaños'");
    }

    @Override
    public void morir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'morir'");
    }

    @Override
    public String hablar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hablar'");
    }


}
