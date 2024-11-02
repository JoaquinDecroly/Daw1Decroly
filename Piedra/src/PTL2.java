import java.util.Scanner;

public class PTL2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Bienvenido al juego de Piedra, Papel o Tijera");
        
        do {
            // Mostrar menú de opciones
            System.out.println("Haz tu elección: ");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();
            System.out.println();

            // Solo continuar si la opción es válida
            if (opcion >= 1 && opcion <= 3) {
                // Generar elección aleatoria de la máquina
                int eleccionMaquina = (int) (Math.random() * 3) + 1; // Genera 1, 2 o 3

                // Mostrar elección del usuario
                switch(opcion) {
                    case 1:
                        System.out.println("Has elegido Piedra");
                        break;
                    case 2:
                        System.out.println("Has elegido Papel");
                        break;
                    case 3:
                        System.out.println("Has elegido Tijera");
                        break;
                }

                // Mostrar elección de la máquina
                System.out.print("Elección de la máquina: ");
                switch(eleccionMaquina) {
                    case 1:
                        System.out.println("Piedra");
                        break;
                    case 2:
                        System.out.println("Papel");
                        break;
                    case 3:
                        System.out.println("Tijera");
                        break;
                }

                // Determinar el resultado
                if (opcion == eleccionMaquina) {
                    System.out.println("Es un empate!");
                } else if ((opcion == 1 && eleccionMaquina == 3) || 
                           (opcion == 2 && eleccionMaquina == 1) || 
                           (opcion == 3 && eleccionMaquina == 2)) {
                    System.out.println("¡Has ganado!");
                } else {
                    System.out.println("¡Has perdido!");
                }
                System.out.println();
            } else if (opcion != 0) {
                System.out.println("Opción no válida, intenta de nuevo.");
                System.out.println();
            }

        } while (opcion != 0);

        System.out.println("Saliendo del juego...");
        entrada.close();
    }
}