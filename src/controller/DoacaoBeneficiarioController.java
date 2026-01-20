package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import model.DoacaoBeneficiario;

public class DoacaoBeneficiarioController {

  public void salvar(DoacaoBeneficiario d)
          throws ClassNotFoundException, SQLException {

    if (d.getQuantidade() <= 0) {
      throw new IllegalArgumentException("Quantidade inválida");
    }

    if (d.getData_entrega().isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Data de entrega inválida");
    }

    if (existeEntrega(d.getId_doacao(), d.getId_beneficiario())) {
      throw new IllegalStateException("Beneficiário já recebeu esta doação");
    }

    String sql = "INSERT INTO doacao_beneficiario (id_doacao_beneficiario, id_doacao, id_beneficiario, quantidade, data_entrega, observacao) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, d.getId_doacao());
      pst.setInt(2, d.getId_beneficiario());
      pst.setInt(3, d.getQuantidade());
      pst.setDate(4, Date.valueOf(d.getData_entrega()));
      pst.setString(5, d.getObservacao());

      pst.executeUpdate();
    }
  }

  public List<DoacaoBeneficiario> listar()
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM doacao_beneficiario";
    List<DoacaoBeneficiario> lista = new ArrayList<>();

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

      while (rs.next()) {
        DoacaoBeneficiario d = new DoacaoBeneficiario();
        d.setId_doacao_beneficiario(rs.getString("id_doacao_beneficiario"));
        d.setId_doacao(rs.getInt("id_doacao"));
        d.setId_beneficiario(rs.getInt("id_beneficiario"));
        d.setQuantidade(rs.getInt("quantidade"));
        d.setData_entrega(rs.getDate("data_entrega").toLocalDate());
        d.setObservacao(rs.getString("observacao"));

        lista.add(d);
      }
    }

    return lista;
  }

  public void atualizar(DoacaoBeneficiario d)
          throws ClassNotFoundException, SQLException {

    if (d.getQuantidade() <= 0) {
      throw new IllegalArgumentException("Quantidade inválida");
    }

    String sql = "UPDATE doacao_beneficiario SET quantidade = ?, data_entrega = ?, observacao = ? WHERE id_doacao_beneficiario = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, d.getQuantidade());
      pst.setDate(2, Date.valueOf(d.getData_entrega()));
      pst.setString(3, d.getObservacao());
      pst.setString(4, d.getId_doacao_beneficiario());

      pst.executeUpdate();
    }
  }

  public void excluir(String id)
          throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM doacao_beneficiario WHERE id_doacao_beneficiario = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, id);

      pst.executeUpdate();
    }
  }

  private boolean existeEntrega(int idDoacao, int idBeneficiario)
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM doacao_beneficiario WHERE id_doacao = ? AND id_beneficiario = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, idDoacao);
      pst.setInt(2, idBeneficiario);

      try (ResultSet rs = pst.executeQuery()) {
        return rs.next();
      }
    }
  }
}
