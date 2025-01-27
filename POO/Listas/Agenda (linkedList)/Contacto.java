import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
String nombre;
String telefono;
String correo;

public Contacto(String nombre, String telefono, String correo) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.correo = correo;
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
    public static boolean validarMovilER(String telefono) {
        Pattern pattern = Pattern.compile("^(\\+34|0034|34)?[67]\\d{8}$", Pattern.CASE_INSENSITIVE);        
         return pattern.matcher(telefono).matches();
    }

    public static boolean formatearNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return false; 
        }
    
        String[] palabras = nombre.toLowerCase().split("\\s+");
        StringBuilder nombreFormateado = new StringBuilder();
    
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                nombreFormateado.append(Character.toUpperCase(palabra.charAt(0)))
                                .append(palabra.substring(1))
                                .append(" ");
            }
        }
    
        System.out.println(nombreFormateado.toString().trim()); // Ejemplo de uso
        return true; 
    }
    
    @Override
public String toString() {
    return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
}







}
