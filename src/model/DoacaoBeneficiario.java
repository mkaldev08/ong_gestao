package model;

import java.time.LocalDate;

/**
 *
 * @author manuelkalueka
 */

public class DoacaoBeneficiario {

    private String id_doacao_beneficiario;
    private int id_doacao;
    private int id_beneficiario;
    private int quantidade;
    private LocalDate data_entrega;
    private String observacao;

    public String getId_doacao_beneficiario() {
        return id_doacao_beneficiario;
    }

    public void setId_doacao_beneficiario(String id_doacao_beneficiario) {
        this.id_doacao_beneficiario = id_doacao_beneficiario;
    }

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public int getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
