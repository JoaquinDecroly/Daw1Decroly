import java.util.Scanner;

public class PTL3 {
    public static void main(String[] args) {
        String opcion;
        Scanner sc = new Scanner(System.in);
        String[] opciones = {"Piedra", "Papel", "Tijera"};
        
        // Explicación del juego
        System.out.println("Bienvenido al juego de piedra, papel, tijera.");
        System.out.println("Las reglas son las siguientes:");
        System.out.println("---------------------------------");
        System.out.println("Piedra (P) gana a Tijera (T).");
        System.out.println("Tijera (T) gana a Papel (L).");
        System.out.println("Papel (L) gana a Piedra (P).");
        System.out.println("Escribe 'S' para salir del juego.");
        
        do {
            System.out.println();
            System.out.println("Elige una opcion:");
            System.out.println("Salir (S)");
            System.out.println("Piedra (P)");
            System.out.println("Papel (L)");
            System.out.println("Tijera (T)");
            opcion = sc.nextLine();

            int jugador = -1;
            switch (opcion.toUpperCase()) {
                case "P":
                    jugador = 0; 
                    break;
                case "L":
                    jugador = 1; 
                    break;
                case "T":
                    jugador = 2; 
                    break;
                default:
                    if (!opcion.equalsIgnoreCase("S")) {
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    }
                    continue; 
            }

            // Generar la jugada aleatoria del ordenador
            int aleatorio = (int) (Math.random() * 3);
            System.out.println("El ordenador eligió: " + opciones[aleatorio]);

            // Decidir quién ha ganado
            if (jugador == aleatorio) {
                System.out.println("Empate");
            } else if ((jugador == 0 && aleatorio == 2) || (jugador == 1 && aleatorio == 0) || (jugador == 2 && aleatorio == 1)) {
                System.out.println("Ganaste");
            } else {
                System.out.println("Perdiste");
            }

        } while (!opcion.equalsIgnoreCase("S"));
        System.out.println("Adiós");
    }
}