
public class Empresa {
String nombre = "";
String teléfono = "";
String paginaWeb = "";
public Empresa(String nombre, String teléfono, String paginaWeb) {
    this.nombre = nombre;
    this.teléfono = teléfono;
    this.paginaWeb = paginaWeb;
}
public String getNombre() {
    return nombre;
}

public String getTeléfono() {
    return teléfono;
}

public String getPaginaWeb() {
    return paginaWeb;
}
@Override
public String toString() {
    return "Empresa [nombre=" + nombre + ", teléfono=" + teléfono + ", paginaWeb=" + paginaWeb + "]";
}




}
