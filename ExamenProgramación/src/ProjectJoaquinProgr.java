import java.util.Scanner;

public class ProjectJoaquinProgr {
public static void main(String[] args) {
    /*do while
    array
    pedir v
    pedir posicion
    modificar v en posición
    borrar v en posición

-------------------------
hacer media math.sqrt
hacer suma
hacer maximo math.max
hacer minimo math.min
----------------------
modificar longitud array
exit
____________________
*/
    Scanner sc = new Scanner(System.in);
        //Variables
        //int N = 0;
        int[] nums = new int[10];
    int P = 0, V = 0;
    char opcion;
    boolean d = false, a = false, a1 = false, a2 = false;
    int suma = 0, max = 0, min = 0;

    do {
        //menú
        //System.out.println("Longitud array: ");
        //nums[N] = sc.nextInt();
        System.out.println("-----Menu-----");
        System.out.println();
        System.out.println("a. Mostrar Valores");
       System.out.println("b. Estadisticas ");
        System.out.println("c. Introducir valor ");
        System.out.println("d. Borrar numero ");
        System.out.println("e. Salir ");
        
        System.out.println();
        System.out.println("Elige una opcion: ");
        System.out.println("-------------------");
        opcion = sc.next().charAt(0); //almacenar respuesta en array
    
        switch(opcion) {
            case 'a':
                System.out.println("Valores en el array:");
                for (int i = 0; i < nums.length; i++) {
                System.out.println("Posición " + i + ": " + nums[i]);
                }
                
                break;

            case 'b':
                for (int i = 0; i < nums.length; i++) {
                suma += nums[i]; //suma valores array
            
                max = Math.max(max, nums[i]); //máximo array
                min = Math.min(min, nums[i]); //minimo array
                }
                System.out.println("Suma: " +suma);
                System.out.println("Media: " +Math.sqrt(suma)); //media array
                System.out.println("Maximo: " +max);
                System.out.println("Minimo: " +min);
                
    
            case 'c': //
                System.out.print("Introduce un valor: ");
                V = sc.nextInt();
                System.out.print("Introduce una posición (0-9): ");
                P = sc.nextInt();
    
                if (P >= 0 && P < nums.length) {
                nums[P] = V; 
                System.out.println("Valor " + V + " introducido en la posición " + P);
                } else {
                System.out.println("Posición no válida. Debe estar entre 0 y 9.");
                }
                
                break;
                
            case 'd': //borrar valor
                System.out.print("Introduce una posición (0-9): ");
                P = sc.nextInt();
                      
                for (int i = 0; i < nums.length; i++) {
                    nums[V] = 0;
                    
                }
                
                break;

            case 'e':
                System.out.println("Adios...");
                d = true; //arreglo salida mediante booleano
    
            default:
                System.out.println("Opción no válida. Por favor, elige 'a', 'b', 'c', 'd', o 'e'.");
                }

    } while (d != true); 
    
        }
    }
    



