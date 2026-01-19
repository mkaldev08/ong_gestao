package model;

import java.time.LocalDate;
import utils.DoacaoTipoEnum;

/**
 *
 * @author manuelkalueka
 */
public class Doacao {

    private int id_doacao;
    private DoacaoTipoEnum tipo;
    private Double valor;
    private String descricao_bem;
    private LocalDate data_doacao;
    private int id_projeto;
    private int id_usuario;

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public DoacaoTipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(DoacaoTipoEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao_bem() {
        return descricao_bem;
    }

    public void setDescricao_bem(String descricao_bem) {
        this.descricao_bem = descricao_bem;
    }

    public LocalDate getData_doacao() {
        return data_doacao;
    }

    public void setData_doacao(LocalDate data_doacao) {
        this.data_doacao = data_doacao;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
