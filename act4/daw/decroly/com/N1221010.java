public class N1221010 {
public static void main(String[] args) {
    //Cadena stringbuilder
    //for 10 numeros
        //for en for, para iterar cada numero
    //.append incorporar resultado a cadena
    StringBuilder resultado = new StringBuilder(); 

    for (int i = 1; i <= 10; i++) { 
        for (int j = 0; j < i; j++) { 
            resultado.append(i); 
        }
    }
    System.out.println(resultado.toString()); 
}
}
