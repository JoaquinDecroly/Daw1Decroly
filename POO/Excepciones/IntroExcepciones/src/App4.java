package src;
import java.util.Scanner;

public class App4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App4 app = new App4();
        
        
        app.imprimirPos(5);   
        app.imprimirPos(-3);  
        
        app.imprimirNeg(-2);  
        app.imprimirNeg(4);  
    }

    public void imprimirPos(int p) {
        if (p < 0) {
            try {
                throw new excepcionPos(p);
            } catch (excepcionPos pos) {
                System.err.println(pos.getClass().getName());
                pos.printStackTrace();
            }
        } else {
            System.out.println("Valor positivo correcto: " + p);
        }
    }

    public void imprimirNeg(int p) {
        if (p > 0) {
            try {
                throw new excepcionNeg(p);
            } catch (excepcionNeg neg) {
                System.err.println(neg.getClass().getName());
                neg.printStackTrace();
            }
        } else {
            System.out.println("Valor negativo correcto: " + p);
        }
    }
}
