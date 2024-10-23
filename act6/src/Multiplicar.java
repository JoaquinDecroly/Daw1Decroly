public class Multiplicar {
public static void main(String[] args) {
    //crear tabla de multiplicar 10x10
    //tabla multiplicar 1-10
    //i++
    
    int num[][] = new int[10][10];
    int nums = 1;
    
    for (int i = 0; i < num.length; i++) {
        for (int j = 0; j < num[i].length; j++) {
                num[i][j] = nums++;
            }
        }
    for (int i = 1; i <= 10; i++) {
        System.out.print("| ");
        
        for (int j = 1; j <= 10; j++) {
            int resultado = i * j; 
                
            if (resultado < 10) {
                System.out.print(" " + resultado + " | ");
            } else {
                System.out.print(resultado + " | ");
                }
                }
            System.out.println(); 
        }
    }
}
   

