package src;
public class excepcionPos extends Exception {
private static final long serialVersionUID = 1L;
private int p;
public excepcionPos(int p) {
    super("p no puede ser negativo");
    this.p = p;
}


}
