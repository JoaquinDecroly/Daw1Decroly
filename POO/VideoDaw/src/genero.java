public enum genero {
CIENCIAFICCION(1), ACCION(2), SUSPENSE(3), ROMANCE(4), THRILLER(5); 

private genero(int valor) {
    this.valor = valor;
}
    public static genero getCIENCIAFICCION() {
        return CIENCIAFICCION;
    }

    public static genero getACCION() {
        return ACCION;
    }

    public static genero getSUSPENSE() {
        return SUSPENSE;
    }

    public static genero getROMANCE() {
        return ROMANCE;
    }

    public static genero getTHRILLER() {
        return THRILLER;
    }

private int valor;




}
