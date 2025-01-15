public class Contacto {

public static int contC;
public String name;
public String telf;
    Contacto[] contactos;
    private Contacto contacto;

    //constructor
public Contacto(String nombre, String telf) {
    this.name = name;
    this.telf = telf;
    }




//getters y setters
    public static int getContC() {
    return contC;
}
public static void setContC(int contC) {
    Contacto.contC = contC;
}

public Contacto[] getContacto() {
    return contactos;
}

public void setContacto(Contacto[] contacto) {
    this.contactos = contacto;
}
public void setContacto(Contacto contacto) {
    this.contacto = contacto;
}
public String getName() {
    return name;
}
    public String getTelf() {
    return telf;
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
            System.out.println(contactos[i]);
            if (contactos[i].equals(nombre)) {
                System.out.println("Contacto encontrado. Datos: " + contactos[i].getName() + contactos[i].getTelf());
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
        return "Contacto [name=" + name + ", telf=" + telf + "]";
    }

}



