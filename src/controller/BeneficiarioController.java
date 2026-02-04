package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Beneficiario;
import model.Conexao;
import utils.BeneficiarioEnum;

public class BeneficiarioController {

  public void salvar(Beneficiario b)
          throws ClassNotFoundException, SQLException {

    String sql = "INSERT INTO beneficiario (nome, tipo, documento, telefone, ativo) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, b.getNome());
      pst.setString(2, b.getTipo().name());
      pst.setString(3, b.getDocumento());
      pst.setString(4, b.getTelefone());
      pst.setBoolean(5, b.isAtivo());

      pst.executeUpdate();
    }
  }

  public List<Beneficiario> listar()
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM beneficiario WHERE ativo = TRUE";
    List<Beneficiario> lista = new ArrayList<>();

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

      while (rs.next()) {
        Beneficiario b = new Beneficiario();
        b.setId_beneficiario(rs.getInt("id_beneficiario"));
        b.setNome(rs.getString("nome"));
        b.setTipo(BeneficiarioEnum.valueOf(rs.getString("tipo")));
        b.setDocumento(rs.getString("documento"));
        b.setTelefone(rs.getString("telefone"));
        b.setAtivo(rs.getBoolean("ativo"));

        lista.add(b);
      }
    }

    return lista;
  }

  public Beneficiario buscarPorId(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM beneficiario WHERE id_beneficiario = ?";

    Beneficiario b = null;

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);

      try (ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
          b = new Beneficiario();
          b.setId_beneficiario(rs.getInt("id_beneficiario"));
          b.setNome(rs.getString("nome"));
          b.setTipo(BeneficiarioEnum.valueOf(rs.getString("tipo")));
          b.setDocumento(rs.getString("documento"));
          b.setTelefone(rs.getString("telefone"));
          b.setAtivo(rs.getBoolean("ativo"));
        }
      }
    }

    return b;
  }

  public void atualizar(Beneficiario b, int id)
          throws ClassNotFoundException, SQLException {

    String sql = """
            UPDATE beneficiario
            SET nome = ?, tipo = ?, documento = ?, telefone = ?
            WHERE id_beneficiario = ?
            """;

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, b.getNome());
      pst.setString(2, b.getTipo().name());
      pst.setString(3, b.getDocumento());
      pst.setString(4, b.getTelefone());
      pst.setInt(5, id);

      pst.executeUpdate();
    }
  }

  public void excluir(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "UPDATE beneficiario SET ativo = FALSE WHERE id_beneficiario = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);

      pst.executeUpdate();
    }
  }
}
