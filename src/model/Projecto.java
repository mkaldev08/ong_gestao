package model;

import java.time.LocalDate;
import utils.CustomezedEnum;

/**
 *
 * @author manuelkalueka
 */
public class Projecto {

    private int id_projeto;

    private String nome;
    private String descricao;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private CustomezedEnum status;
    private LocalDate data_criacao;

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public CustomezedEnum getStatus() {
        return status;
    }

    public void setStatus(CustomezedEnum status) {
        this.status = status;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

}
