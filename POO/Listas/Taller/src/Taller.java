import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taller {
    private Map<String, Coche> coches;

    public Taller() {
        coches = new HashMap<>();
    }

    public void anadeElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el color del coche: ");
        String color = scanner.nextLine();
        System.out.print("Introduce la marca del coche: ");
        String marca = scanner.nextLine();
        System.out.print("Introduce la matrícula del coche: ");
        String matricula = scanner.nextLine();

        // Validar matrícula (puedes agregar más validaciones según sea necesario)
        if (matricula.isEmpty()) {
            System.out.println("La matrícula no puede estar vacía.");
            return;
        }

        // Comprobar si ya existe un coche con la misma matrícula
        if (coches.containsKey(matricula)) {
            System.out.println("Ya existe un coche con la matrícula: " + matricula);
            return;
        }

        // Crear el coche y añadirlo al mapa
        Coche coche = new Coche(color, marca, matricula);
        coches.put(matricula, coche);
        System.out.println("Coche añadido: " + coche);
    }

    public void eliminaElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la matrícula del coche a borrar: ");
        String matricula = scanner.nextLine();

        if (coches.remove(matricula) != null) {
            System.out.println("Coche con matrícula " + matricula + " eliminado.");
        } else {
            System.out.println("No existe un coche con la matrícula: " + matricula);
        }
    }

    public void visualizaMatriculas() {
        System.out.println("Matrículas almacenadas:");
        for (String matricula : coches.keySet()) {
            System.out.println(matricula);
        }
    }

    public void visualizaCoches() {
        System.out.println("Coches almacenados:");
        for (Coche coche : coches.values()) {
            System.out.println("Color: " + coche.getColor() + ", Marca: " + coche.getMarca());
        }
    }

    public void visualizaTaller() {
        System.out.println("Taller:");
        for (Map.Entry<String, Coche> entry : coches.entrySet()) {
            String matricula = entry.getKey();
            Coche coche = entry.getValue();
            System.out.println("Matrícula: " + matricula + ", Color: " + coche.getColor() + ", Marca: " + coche.getMarca());
        }
    }
}



