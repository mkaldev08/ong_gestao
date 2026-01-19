package utils;

/**
 *
 * @author manuelkalueka
 */
public enum UsuarioPerfilEnum {
    ADMIN("ADMIN"),
    OPERADOR("OPERADOR");

    private final String perfil;

    UsuarioPerfilEnum(String perfil
    ) {
        this.perfil = perfil;
    }

    public String getUsuarioPerfilEnum() {
        return perfil;
    }
}
