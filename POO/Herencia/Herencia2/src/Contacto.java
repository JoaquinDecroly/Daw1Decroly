
public class Contacto {

// public static int contC;
public String name;
public String telf;
    // Contacto[] contactos;
    // private Contacto contacto;

    //constructor
public Contacto(String nombre, String telf) {
    this.name = name;
    this.telf = telf;
    }




//getters y setters
  
//     //metodos
//     public boolean agregarContacto(String nombre) {
//         if (contC < contactos.length) {
//             contactos[contC] = contacto;
//             contC++;
//          return true;
//         }
//         else {
//             System.out.println("No hay espacio para agregar mas contactos");
//         return false;
//         }
//     }

//     public String getName() {
//         return name;
//     }

//     public String getTelf() {
//         return telf;
//     }

//     public void setTelf(String telf) {
//         this.telf = telf;
//     }




//     public boolean eliminarContacto(String nombre){
//         int index = -1;
    
//         for (int i = 0; i < contC; i++) {
//             if (contactos[i].equals(nombre)) {
//                 index = i;
//                 break;
                
//             }  
            
//         }
//         if (index == -1) {
//             System.out.println("No se encontró al contacto" + nombre + "a eliminar");
//             return false;
//         } 
//     return true;
//     } 

//     public void buscarContacto(String nombre){
//         int index = -1;
//         for (int i = 0; i < contC; i++) {
//             if (contactos[i].equals(nombre)) {
//                 break;
//             }
//         }
//         if (index == -1) {
//             System.out.println("No se encontró al contacto " + nombre + "a buscar");
//             return;
//         }
//     }
    
//     public void recolocarArrayContactos(Contacto contacto){
//         int index = -1;
//         //desplazar elementos a la izq.
//         for (int i = index; i < contC; i++) {
//             contactos[i] = contactos[i + 1];
//         }
//         //último elemento es null
//         contactos[contC -1] = null;
//         contC--;
//     }

//     public boolean buscarContacto1(String nombre){
//         int index = -1;
//         for (int i = 0; i < contC; i++) {
//             System.out.println(contactos[i]);
//             if (contactos[i].equals(nombre)) {
//                 System.out.println("Contacto encontrado. Datos: " + contactos[i].getName() + contactos[i].getTelf());
//                 break;
//             }
//         }
//         if (index == -1) {
//             System.out.println("No se encontró el contacto");
//             return false;
//         }


//         return true;
// }


    @Override
    public String toString() {
        return "Contacto [name=" + name + ", telf=" + telf + "]";
    }

}

