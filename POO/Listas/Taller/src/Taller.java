import java.util.HashMap;
import java.util.Map;

public class Taller {
Map<String, Coche> taller = new HashMap<>();

void anadeElemento(Coche coche){
    System.out.println("Matrícula: ");
    String matricula = scanner.nextLine();

    for (String m : taller.keySet()) {
       if (!taller.containsKey(matricula)) {
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Color: ");
        String color = scanner.nextLine();
            taller.put(matricula, coche);
}
    }
}

void eliminaElemento(Coche coche){
    System.out.println("Matrícula: ");
    String matricula = scanner.nextLine();
    do {
         for (String m : taller.keySet()) {
        if (taller.containsKey(matricula)) {
            taller.remove(matricula);
            if (!taller.containsKey(matricula)) {
                System.out.println("El coche ha sido eliminado");     
            }else
            System.out.println("Hubo un error durante la eliminación");
        }
    }
    } while (taller.containsKey(matricula));
}

void visualizarMatriculas(Coche coche){

}
void visualizarCoches(Coche coche){

}
void visualizaTaller(Coche coche){
    
}

}

