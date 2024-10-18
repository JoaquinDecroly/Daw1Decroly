public class N1221010 {
public static void main(String[] args) {
   int maxNumero = 10; 
        int totalElementos = 0;

       
        for (int i = 1; i <= maxNumero; i++) {
            totalElementos += i; 
        }

        int[] numeros = new int[totalElementos]; 
        int index = 0; 

       
        for (int i = 1; i <= maxNumero; i++) {
            for (int j = 0; j < i; j++) {
                numeros[index] = i; 
                index++; 
            }
        }

        
        for (int numero : numeros) {
            System.out.print(numero); 
        }
        System.out.println(); 
    }
}
