import java.util.Arrays;

public class Contacto extends Agenda {

public static int contC;
    Contacto[] contactos;
    private Contacto contacto;

    //constructor
public Contacto(String nombre, int numTelf, Contacto[] contactos) {
        super(nombre, numTelf);
        this.contactos = contactos;
    }




//getters y setters
    public static int getContC() {
    return contC;
}
public static void setContC(int contC) {
    Contacto.contC = contC;
}
public Contacto getContacto() {
    return contacto;
}
public void setContacto(Contacto contacto) {
    this.contacto = contacto;
}




//metodos
    public boolean agregarContacto(String nombre) {
        if (contC < contactos.length) {
            contactos[contC] = contacto;
            contC++;
         return true;
        }
        else {
            System.out.println("No hay espacio para agregar mas contactos");
        return false;
        }
    }

    public boolean eliminarContacto(String nombre){
        int index = -1;
    
        for (int i = 0; i < contC; i++) {
            if (contactos[i].equals(nombre)) {
                index = i;
                break;
                
            }  
            
        }
        if (index == -1) {
            System.out.println("No se encontró al contacto" + nombre + "a eliminar");
            return false;
        } 
    return true;
    } 

    public void buscarContacto(String nombre){
        int index = -1;
        for (int i = 0; i < contC; i++) {
            if (contactos[i].equals(nombre)) {
                break;
            }
        }
        if (index == -1) {
            System.out.println("No se encontró al contacto " + nombre + "a buscar");
            return;
        }
    }
    
    public void recolocarArrayContactos(Contacto contacto){
        int index = -1;
        //desplazar elementos a la izq.
        for (int i = index; i < contC; i++) {
            contactos[i] = contactos[i + 1];
        }
        //último elemento es null
        contactos[contC -1] = null;
        contC--;
    }

    public boolean buscarContacto1(String nombre){
        int index = -1;
        for (int i = 0; i < contC; i++) {
            if (contactos[i].equals(nombre)) {
                System.out.println("Contactoo encontrado. Datos: " + contactos[i].getNombre() + contactos[i].getNumTelf());
                break;
            }
        }
        if (index == -1) {
            System.out.println("No se encontró el contacto");
            return false;
        }


        return true;
}



    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", numTelf=" + numTelf + ", contactos=" + Arrays.toString(contactos)
                + ", contacto=" + contacto + "]";
    }
}

