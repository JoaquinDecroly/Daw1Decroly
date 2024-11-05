import java.util.Scanner;

public class PLT {
    public static void main(String[] args) {
        String opcionMaquina = ""; 
        String opcion = "";
        Scanner sc = new Scanner(System.in);
        String[] opciones = {"Piedra", "Papel", "Tijera"};

        System.out.println("Bienvenido al juego de piedra, papel, tijera.");
        System.out.println();
        System.out.println("Las reglas son las siguientes:");
        System.out.println("---------------------------------");
        System.out.println("Piedra (P) gana a Tijera (T).");
        System.out.println("Tijera (T) gana a Papel (L).");
        System.out.println("Papel (L) gana a Piedra (P).");
        System.out.println("Escribe 'S' para salir del juego.");
        System.out.println("---------------------------------");

        do {
            System.out.println();
            System.out.println("Elige una opcion:");
            System.out.println("P");
            System.out.println("L");
            System.out.println("T");
            System.out.println("S");
            opcion = sc.nextLine();

            if (opcion.equals("S")) {
                System.out.println("Adios...");
                break; 
            }

            int aleatorio = (int) (Math.random() * 3);
            opcionMaquina = opciones[aleatorio];

            switch (opcion) {
                case "P":
                    System.out.println("Has elegido Piedra");
                    break;

                case "L":
                    System.out.println("Has elegido Papel");
                    break;

                case "T":
                    System.out.println("Has elegido Tijera");
                    break;

                default:
                    System.err.println("Opcion invalida, recuerda que la eleccion debe ser en mayusculas"); 
                    continue;
            }

            System.out.println("El ordenador eligió: " + opcionMaquina); 

            if (opcion.equals("P")) {
                if (opcionMaquina.equals("Piedra")) {
                    System.out.println("Empate");
                } else if (opcionMaquina.equals("Tijera")) {
                    System.out.println("Has ganado");
                } else {
                    System.out.println("Has perdido");
                }
            } else if (opcion.equals("L")) {
                if (opcionMaquina.equals("Papel")) {
                    System.out.println("Empate");
                } else if (opcionMaquina.equals("Piedra")) {
                    System.out.println("Has ganado");
                } else {
                    System.out.println("Has perdido");
                }
            } else if (opcion.equals("T")) {
                if (opcionMaquina.equals("Tijera")) {
                    System.out.println("Empate");
                } else if (opcionMaquina.equals("Papel")) {
                    System.out.println("Has ganado");
                } else {
                    System.out.println("Has perdido");
                }
            }
        } while (true); 
        
    }
}
