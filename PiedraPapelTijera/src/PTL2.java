import java.util.Scanner;

public class PTL2 {
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

            int aleatorio = (int) (Math.random() * 3);
            

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
                case "S":
                    System.out.println("Adios...");
                    break;

                default:
                    System.err.println("Opcion invalida, recuerda que la eleccion debe ser en mayusculas"); 
            }

            
            System.out.println("El ordenador eligió: " + opciones[aleatorio]); 

       
           if ("P ".equals(opcion) && "0".equals(opciones[aleatorio])) {
                System.out.println("Has ganado");
            } else if ("P ".equals(opcion) && "1".equals(opciones[aleatorio])) {
                System.out.println("Has perdido");
            } else if ("P".equals(opcion) && "2".equals(opciones[aleatorio])) {
                System.out.println("Empate");
            }
            if ("L ".equals(opcion) && "0".equals(opciones[aleatorio])) {
            System.out.println("Has perdido");  
            } else if ("L ".equals(opcion) && "1".equals(opciones[aleatorio])) {
                System.out.println("Has ganado");
            } else if ("L".equals(opcion) && "2".equals(opciones[aleatorio])) {
                System.out.println("Empate");
            }
            if ("T ".equals(opcion) && "0".equals(opciones[aleatorio])) {
                System.out.println("Has ganado");
            } else if ("T ".equals(opcion) && "1".equals(opciones[aleatorio])) {
                System.out.println("Has perdido");
            } else if ("T".equals(opcion) && "2".equals(opciones[aleatorio])) {
                System.out.println("Empate");
            } 
        
            
       
           
        } while (!opcion.equals("S"));
}
}


