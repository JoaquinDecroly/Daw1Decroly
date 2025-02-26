
public enum GeneroVideojuego {
    ACCION,
    AVENTURA,
    RPG,
    ESTRATEGIA,
    DEPORTES,
    SIMULACION,
    PELEA,
    PLATAFORMAS,
    SHOOTER,
    CARRERAS,
    PUZZLE,
    MUSICAL,
    ROL,
    SURVIVAL,
    MOBA;

    @Override
    public String toString() {
        return name().toLowerCase(); // Convierte el nombre del enum a minúsculas
    }
}
