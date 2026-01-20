package utils;

/**
 *
 * @author manuelkalueka
 */
public enum BeneficiarioEnum {

  INDIVIDUAL("INDIVIDUAL"),
  FAMILIA("FAMILIA"),
  COMUNIDADE("COMUNIDADE");

  private final String tipo;

  BeneficiarioEnum(String tipo
  ) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }
}
