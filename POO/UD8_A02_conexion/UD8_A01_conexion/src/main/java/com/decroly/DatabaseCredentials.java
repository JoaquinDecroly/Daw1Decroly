public class DatabaseCredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    private static String DRIVER;
    private static String URL;
    private static String SCHEMA;
    private static String USUARIO;
    private static String CLAVE;

    public DataBaseCredentials(String DRIVER, String URL, String SCHEMA, String USUARIO, String CLAVE) {
        this.DRIVER =  "com.mysql.cj.jdbc.Driver";
        this.URL = "jdbc:mysql://localhost:3306/";
        this.SCHEMA = "tienda";
        this.USUARIO = "root";
        this.CLAVE = "daw12";
    }

    public static String getDriver() {
        return DRIVER;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getSchema() {
        return SCHEMA;
    }

    public static String getUsuario() {
        return USUARIO;
    }

    public static String getClave() {
        return CLAVE;
    }
}