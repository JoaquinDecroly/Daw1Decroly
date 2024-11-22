import java.time.LocalDate;
import java.util.Arrays;

//variables
public class VideoDaw {
private String CIF;
private String direccion;
private LocalDate fecha;

//arrays
private peliculasregistradas[] peliculasregistradas;
private clientesregistrados[] clientesregistrados;

//constructor
public VideoDaw(String CIF, String direccion, LocalDate fecha) {
    this.CIF = CIF;
    this.direccion = direccion;
    this.fecha = fecha;
} 


//getters/setters
public String getCIF() {
    return CIF;
}



public String getDireccion() {
    return direccion;
}
public void setDireccion(){
    this.direccion = direccion;
}



public LocalDate getFecha() {
    return fecha;
}


//metodos
public void mostrarPelisRegistradas(){

}
public void mostrarClientesRegistrados(){

}

public void alquilarPelicula(Peliculas, Clientes){

}



public String InfoVideoDaw() {
    return "VideoDaw [CIF=" + CIF + ", direccion=" + direccion + ", fecha=" + fecha + ", peliculasregistradas="
            + Arrays.toString(peliculasregistradas) + ", clientesregistrados=" + Arrays.toString(clientesregistrados)
            + "]";
}}
