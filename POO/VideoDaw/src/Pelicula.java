
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Pelicula {
private String titulo;
private static int id;

private LocalDate fechaBaja;
private LocalDateTime fechaAlquiler;
private boolean IsAlquilado;

private List<> mostrarPelisRegistradas;

public Pelicula(String titulo, int id, Enum genero, LocalDate fechaBaja, LocalDateTime fechaAlquiler) {
    this.titulo = titulo;
    this.id = 000;
    id++;
    this.genero = genero;
    this.fechaBaja = fechaBaja;
    this.fechaAlquiler = fechaAlquiler;
}


public Pelicula(Enum genero) {
    this.genero = genero;
}


public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public static int getId() {
    return id;
}

public Enum getGenero() {
    return genero;
}

public LocalDate getFechaBaja() {
    return fechaBaja;
}

public LocalDateTime getFechaAlquiler() {
    return fechaAlquiler;
}

public boolean isIsAlquilado() {
    return IsAlquilado;
}

public void devolverPeli(){
    IsAlquilado = false;
}
public void mostrarPelisRegistradas(){
    for (int i = 0; i < mostrarPelisRegistradas; i++) {
        
    }
}



}
