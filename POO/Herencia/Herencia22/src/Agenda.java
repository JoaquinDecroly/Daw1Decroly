public class Agenda extends Contacto {
static Contacto[] contactos;
static Contacto contacto;


static int contC;

// public static int contC;
public Agenda(String name, String telf) {
   super(name, telf);
}


//metodos
public static boolean agregarContacto(String name) {
    for (int i = 0; i < contactos.length; i++) {
        if (!contacto.equals(name)) {
            if (contC < contactos.length) {
        contactos[contC] = contacto;
        contC++;
     return true;
    } 
        } else {        
        System.out.println("No hay espacio para agregar mas contactos");
    return false;

        }
    }
    return true;
}

public static boolean eliminarContacto(String nombre){
    int index = -1;

    for (int i = 0; i < contC; i++) {
        if (contactos[i].equals(nombre)) {
            index = i; 
            
        contactos[i] = contactos[i + 1];
        //último elemento es null
        contactos[contC -1] = null;
        contC--;
            break;
            
        }  
        
    }
    if (index == -1) {
        System.out.println("No se encontró al contacto" + nombre + "a eliminar");
        return false;
    } 
return true;
} 

public static boolean buscarContacto(String nombre){
    int index = -1;
    for (int i = 0; i < contC; i++) {
        System.out.println(contactos[i]);
        if (contactos[i].equals(nombre)) {
            System.out.println("Contacto encontrado. Datos: " + contactos[i].name + "" + contactos[i].telf);
            break;
        }
    }
    if (index == -1) {
        System.out.println("No se encontró el contacto");
        return false;
    }


    return true;
}
public static void listarAgenda(){
    for (int i = 0; i < contC; i++) {
        System.out.println(contactos);
}
}

@Override
public String toString() {
    return "Agenda [" + super.toString() + "]";
}

}
