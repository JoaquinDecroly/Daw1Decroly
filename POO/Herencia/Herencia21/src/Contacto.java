public class Contacto{

        private String nombre;
        private String telefono;

public Contacto(String nombre, String telefono) {
    this.nombre = nombre;
    this.telefono = telefono;
}

    public String getnombre(){
        return nombre;
    }
    public String gettelefono(){
        return telefono;
    }


    @Override
    public String toString() {
        return "Agenda: \n[Nombre=" + nombre + " \nNumero telefonico=" + telefono + "]";   
     }


}           // MAIN
