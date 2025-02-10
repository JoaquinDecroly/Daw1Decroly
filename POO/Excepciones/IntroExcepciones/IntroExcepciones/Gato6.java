package IntroExcepciones;
import java.util.ArrayList;
import java.util.List;

public class Gato6 {

   
        String nombre;
        int edad;
        
    private static List<Gato6> gatos = new ArrayList<>(5);
    
            public String getNombre() {
                return nombre;
            }
            public int getEdad() {
                return edad;
            }
            
            public void setEdad(int edad) {
                this.edad = edad;
            }
            
            public Gato6(String nombre, int edad) {
                this.nombre = nombre;
                this.edad = edad;
            }
            
                @Override
                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Gato6{");
                    sb.append("nombre=").append(nombre);
                    sb.append(", edad=").append(edad);
                    sb.append('}');
                    return sb.toString();
                }
    
    
    
        public static void agregarGato(Gato6 gato){
            gatos.add(gato);
        System.out.println("Su minino " + gato.getNombre() + "con edad " + gato.getEdad() + " se añadió correctamente");
    }
        
    public static boolean size(int i){
        for (Gato6 gato : gatos) {
           if (Gato6.size(5)) {
            return true;
           }
        }
    return false;
    }
        
        }
        

