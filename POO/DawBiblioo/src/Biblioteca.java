public class Biblioteca {
    // Atributos

    private String id;
    private String nombre;
    private String direccion;
    private String email;
    private String nTelefono;
    private int nElementosActuales;
    private int nlibros;
    private Libros l1;

    // Colección libros
     private Libros [] libros;
        
    //  constructor
    public Biblioteca(String id, String nombre, String direccion, String email, String nTelefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.nTelefono = nTelefono;
        
                this.libros = new Libros[nlibros];
        this.nElementosActuales = 0;
    }
    public String getnombre(){
        return nombre;
    }
    public String getdireccion(){
        return direccion;
    }
    public String getemail(){
        return email;
    }
    public String getnTelefono(){
        return nTelefono;
    }

    // METODOS MANEJAR ARRAY BIBLIOTECA

    // insertar libro
    public boolean insertarLibro(Libros libro){
        boolean IsAdd = false;

        if(l1 != null){
          this.libros[nElementosActuales] = l1;
               
                this.nElementosActuales++;
                IsAdd = true;
            }
        return IsAdd;
}


// eliminar libro
    public boolean eliminarLibro(Libros libro){
        boolean IsRemoved = false;
        int index = 0;
if (l1 != null) {
    for (int i = 0; i < this.libros.length; i++) {
        if (this.libros[i].getIsbn().equalsIgnoreCase(l1.getIsbn())) {
            index = i;
        }
    }
}
if(index != -1){
    this.libros[index] = null;
    IsRemoved = true;
}
// recolocar array
for (int i = index + 1; i < this.libros.length; i ++) {
    this.libros[i - 1] = this.libros[i];
    this.libros[this.libros.length - 1] = null;
    this.nElementosActuales--;
    }
    return IsRemoved;
}


public String infoLibro(){
    String info = "";
    if(libros != null){
       for(Libros l : this.libros){
        if(l != null){
            info += l.infoLibro() + "\n";
        }
       }
    }
    return info;
}
}

