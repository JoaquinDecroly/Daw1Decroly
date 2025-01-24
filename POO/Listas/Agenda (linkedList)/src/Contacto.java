import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
String nombre;
String telefono;
String correo;

public Contacto(String nombre, String telefono, Boolean correo) {
    this.nombre = nombre;
    this.telefono = telefono;
    validaEmail(correo.toString());
}

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getTelefono() {
    return telefono;
}
public void setTelefono(String telefono) {
    this.telefono = telefono;
}
public String getCorreo() {
    return correo;
}
public void setCorreo(String correo) {
    this.correo = correo;
}

public static Boolean validaEmail (String correo) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(correo);
		return matcher.matches();
	}




}
