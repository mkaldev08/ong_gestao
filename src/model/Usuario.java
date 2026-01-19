package model;

import java.time.LocalDate;
import utils.UsuarioPerfilEnum;

/**
 *
 * @author manuelkalueka
 */
public class Usuario {

    private int id_usuario;

    private String nome;

    private String email;

    private String senha;

    private UsuarioPerfilEnum perfil;

    private boolean ativo;
    private LocalDate data_criacao;

    private String username;

    public Usuario(String nome, String email, String senha, UsuarioPerfilEnum perfil, boolean ativo, LocalDate data_criacao, String username) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.ativo = ativo;
        this.data_criacao = data_criacao;
        this.username = username;
    }

    public Usuario(int id_usuario, String nome, String email, String senha, UsuarioPerfilEnum perfil, boolean ativo, LocalDate data_criacao, String username) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.ativo = ativo;
        this.data_criacao = data_criacao;
        this.username = username;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioPerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioPerfilEnum perfil) {
        this.perfil = perfil;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
