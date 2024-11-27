import java.time.LocalDate;

public class VideoDaw {
private String cif;
private String direccion;
private LocalDate fechaAlta;

//arrays
Pelicula[] peliculasRegistradas;
Cliente[] clientesRegistrados;

//CONSTRUCTOR

public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
    if(isCifValido(cif)){
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        }else
        System.out.println("CIF no válido");
    }

    //getters y setters
public String getCif() {
    return cif;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public LocalDate getFechaAlta() {
    return fechaAlta;
}

//metodos

private boolean isCifValido (String cif) {
    return cif.matches("[A-H, J, N, P, Q-S, T-V, W][0-9]//d{7}$");
    }

    
private void mostrarInfoVideoClub(){
    String info = String.format("CIF= %s, Direccion= %s, Fecha de alta= %s",
     cif, direccion, fechaAlta);
}

private void mostrarPeliculasRegistradas(){
    for(Pelicula pelicula : peliculasRegistradas){
        System.out.println(pelicula);
    }
}
private void mostrarClientesRegistrados(){
    for(Cliente cliente : clientesRegistrados){
        System.out.println(cliente);
    }


}
}

    


