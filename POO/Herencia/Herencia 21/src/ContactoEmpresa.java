public class ContactoEmpresa extends Contacto implements Empresa {
    private String paginaWeb;

    public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
        super(nombre, telefono);
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String getPaginaWeb() {
        return paginaWeb;
    }

    @Override
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String toString() {
        return super.toString() + ", Página Web: " + paginaWeb;
    }
}
