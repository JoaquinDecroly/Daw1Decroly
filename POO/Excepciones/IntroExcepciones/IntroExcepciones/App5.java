package IntroExcepciones;
import java.util.Scanner;

public class App5 {
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        String nombre;
        int edad;

            System.out.println("Ingrese el nombre de su gato (MIN. 3 CARACTERES): ");
                nombre = sc.nextLine();
        try {
            nombreCorrecto(nombre);
        } catch (ExcepcionNombre5 e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Ingrese el nombre de su gato (MIN. 3 CARACTERES): ");
            nombre = sc.nextLine();
           
        }


            System.out.println("Ingrese la edad de su minino: ");
            edad = sc.nextInt();
        try {
            validarEdad(edad);
        }
          catch (ExcepcionEdad5 e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Ingrese la edad de su minino: ");
            edad = sc.nextInt();
}
    }
       
    }
























   public static void nombreCorrecto(String nombre) throws ExcepcionNombre5 {
    if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
        throw new ExcepcionNombre5("El nombre debe tener al menos 3 caracteres.");
    } else {
        String nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        System.out.println(nombreFormateado);
    }
}
    public static void validarEdad(int edad) throws ExcepcionEdad5 {
        if (edad < 0) {
            throw new ExcepcionEdad5("La edad no puede ser negativa");
        }
        System.out.println("Edad válida: " + edad);
    }

}

