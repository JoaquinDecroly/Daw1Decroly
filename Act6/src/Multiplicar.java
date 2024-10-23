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

    for ( int i = 1; i < num.length; i++) {
        System.out.print("| ");
        
        for (int  j = 0; j < num[i].length; j++) {
            if(num[i][j] < 10){
                System.out.print(" "+num[i][j]+ "*" + (i++));
            }
            else{
                System.out.print(num[i][j]+ " ");
            }
            
            
        }
        System.out.print("| ");
        System.out.println();     
    }   
    }
    
}


