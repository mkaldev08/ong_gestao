package model;

import utils.BeneficiarioEnum;

/**
 *
 * @author manuelkalueka
 */
public class Beneficiario {

  private int id_beneficiario;
  private String nome;
  private BeneficiarioEnum tipo;
  private String documento;
  private String telefone;
  private boolean ativo;

  public Beneficiario() {
  }

  public Beneficiario(String nome, BeneficiarioEnum tipo, String documento, String telefone, boolean ativo) {
    this.nome = nome;
    this.tipo = tipo;
    this.documento = documento;
    this.telefone = telefone;
    this.ativo = ativo;
  }

  public Beneficiario(int id_beneficiario, String nome, BeneficiarioEnum tipo, String documento, String telefone, boolean ativo) {
    this.id_beneficiario = id_beneficiario;
    this.nome = nome;
    this.tipo = tipo;
    this.documento = documento;
    this.telefone = telefone;
    this.ativo = ativo;
  }

  public int getId_beneficiario() {
    return id_beneficiario;
  }

  public void setId_beneficiario(int id_beneficiario) {
    this.id_beneficiario = id_beneficiario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BeneficiarioEnum getTipo() {
    return tipo;
  }

  public void setTipo(BeneficiarioEnum tipo) {
    this.tipo = tipo;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

}
