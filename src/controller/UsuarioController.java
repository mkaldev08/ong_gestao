package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conexao;
import model.Usuario;
import utils.PasswordUtil;
import utils.UsuarioPerfilEnum;

/**
 *
 * @author manuelkalueka
 */
public class UsuarioController {

    public void inserir(Usuario us) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO usuario (nome, email, senha_hash, perfil, ativo, data_criacao, username) VALUES (?, ?, ?, ?, ?, ?,?);";
        PreparedStatement pst = Conexao.conectar().prepareStatement(SQL);

        pst.setString(1, us.getNome());
        pst.setString(2, us.getEmail());
        pst.setString(3, PasswordUtil.hashPassword(us.getSenha()));
        pst.setString(4, us.getPerfil().name());
        pst.setBoolean(5, us.isAtivo());
        pst.setDate(6, Date.valueOf(us.getData_criacao()));
        pst.setString(7, us.getUsername());

        pst.executeUpdate();

    }

    public Usuario buscarUsuarioPorUsername(String username)
            throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM usuario WHERE username = ?";

        try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha_hash"),
                            UsuarioPerfilEnum.valueOf(rs.getString("perfil")),
                            rs.getBoolean("ativo"),
                            rs.getDate("data_criacao").toLocalDate(),
                            rs.getString("username")
                    );
                }
            }
        }

        return null;
    }

}
