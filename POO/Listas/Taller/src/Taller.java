import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taller {
    Scanner scanner = new Scanner(System.in);
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
            taller.put(coche.getMatrícula(), coche);
    }
        }
    }

    void eliminaElemento(String matricula){
        System.out.println("Matrícula: ");
        String matricula1 = scanner.nextLine();
        do {
            for (String m : taller.keySet()) {
            if (taller.containsKey(matricula1)) {
                taller.remove(matricula1);
                if (!taller.containsKey(matricula1)) {
                    System.out.println("El coche ha sido eliminado");     
                }else
                System.out.println("Hubo un error durante la eliminación");
            }
        }
        } while (taller.containsKey(matricula1));
    }

    void  visualizarMatriculas(String matricula){
    for (String matricula2 : taller.keySet()) {
        System.out.println("Matrícula: " + matricula2);
    }
    }
    void visualizarCoches(Coche coche){
    for (Coche c : taller.values()) {
        System.out.println(c);
    }
    }
    void visualizaTaller(Coche coche){
    for (Map.Entry<String, Coche> entry : taller.entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }
}


@Override
public String toString() {
    return "Taller [taller=" + taller + "]";
}
}




