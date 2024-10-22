import java.util.Scanner;

public class Palindromo {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Introduce una frase: ");
    String frase = entrada.nextLine();

    frase = frase.replaceAll(" ", "").toLowerCase();

    boolean palindromo = true;

    int texto = frase.length();

    for (int i = 0; i < texto/2; i++) {
        if(frase.charAt(i) != frase.charAt(texto - i - 1)){
           palindromo = false;
           break; 
        }        
    }

    if(palindromo){
        System.out.println("La frase es un palindromo");
    }else{
        System.out.println("La frase no es un palindromo");
    }
    
}
}
