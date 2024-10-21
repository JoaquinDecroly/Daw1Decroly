import java.util.Scanner;

public class CadenaTexto { 
    //Scanner
    //String
    //almacenar array en string
    //.split en " ";
public static void main(String[] args) {  
    Scanner entrada = new Scanner(System.in);
    System.out.println("Introduce un texto: ");
   String texto = entrada.nextLine();

    String[] palabras = texto.split(" ");
    for(String palabra:palabras){
            System.out.println(palabra);

    }
}

}