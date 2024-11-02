import java.util.Scanner;

public class PTL {
    public static void main(String[] args) {
        //menu
            //system.out
            //do{
            //if + else if{
            //}
            //while
        //math.random 1 - 3
            //piedra, papel, tijera == 1,2,3
        //resultados
        Scanner entrada = new Scanner (System.in);
        int opcion = 0;
        double[]random = new double[2];
       
        for (int i = 0; i < random.length; i++) {
            random[i] = (int)(Math.random() * 3);
            
            if (Math.random() == 0) {
                random[i] = entrada.nextInt();
            }
            else if (Math.random() == 1) {
                random[i] = entrada.nextInt();  
            }
            else if (Math.random() == 2){
                random[i] = entrada.nextInt();
            }
        }
                
            

        
        System.out.println("Bienvenido al juego de piedra, pael o tijera");
            System.out.println("Haz tu eleccion sabiamente: ");
        do { 
            System.out.println("1 . Piedra");
            System.out.println("2 . Papel");
            System.out.println("3 . Tijera");
            opcion = entrada.nextInt();
            System.out.println();

            switch(opcion){
                case '1':
                    System.out.println("Has elegido piedra");
                    break;
                case '2':
                    System.out.println("Has elegido papel");
                    break;
                case'3':
                    System.out.println("Has elegido tijera");
                    break;
            }
            System.out.println("Tu eleccion: "+opcion);
            System.out.println("Elección maquina:  "+random[i]);}

        }
          
        } while (opcion != 0);

