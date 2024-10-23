public class Matriz5x5 {
public static void main(String[] args) {
  //crear matriz 5x5 +  inicializarla con valores
  //int[][] matriz = new int[5][5];
  //if else (opcional estetico)

  //recorrer y pintar matriz

    int[][] nums = new int[5][5];
    int num = 1;
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums[i].length; j++) {
            nums[i][j] = num++;
        }
    }

    for ( int i = 0; i < nums.length; i++) {
        System.out.print("| ");
        
        for (int  j = 0; j < nums[i].length; j++) {
            if(nums[i][j] < 10){
                System.out.print(" "+nums[i][j]+ " ");
            }
            else{
                System.out.print(nums[i][j]+ " ");
            }
            
            
        }
        System.out.print("| ");
        System.out.println();     
    }   
    }
    
}
