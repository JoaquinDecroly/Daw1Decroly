import java.time.LocalDate;

public class Personas {
String nombre = "";
String teléfono = "";
LocalDate Cumpleaños = LocalDate.parse("dd/mm/yyyy");
public Personas(String nombre, String teléfono, LocalDate cumpleaños) {
    this.nombre = nombre;
    this.teléfono = teléfono;
    Cumpleaños = cumpleaños;
}
public String getNombre() {
    return nombre;
}
public String getTeléfono() {
    return teléfono;
}
public LocalDate getCumpleaños() {
    return Cumpleaños;
}
@Override
public String toString() {
    return "Personas [nombre=" + nombre + ", teléfono=" + teléfono + ", Cumpleaños=" + Cumpleaños + "]";
}




}
