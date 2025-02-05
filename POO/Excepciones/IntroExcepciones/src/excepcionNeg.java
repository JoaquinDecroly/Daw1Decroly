package src;
public class excepcionNeg extends Exception{
private static final long serialVersionUID = 1L;
private int p;

    public excepcionNeg(int p) {
        super("p no puede ser positivo");
        this.p = p;
    }
    
}
