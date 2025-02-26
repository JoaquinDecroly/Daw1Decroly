
public enum GeneroPelicula {
    ACCION,
    AVENTURA,
    ANIMACION,
    COMEDIA,
    CRIMEN,
    DOCUMENTAL,
    DRAMA,
    FANTASIA,
    TERROR,
    MISTERIO,
    ROMANCE,
    CIENCIA_FICCION,
    SUSPENSO,
    WESTERN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }


}
