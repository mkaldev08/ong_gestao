package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import model.Doacao;
import utils.DoacaoTipoEnum;

public class DoacaoController {

  public void salvar(Doacao d)
          throws ClassNotFoundException, SQLException {

    String sql = "INSERT INTO doacao (tipo, valor, descricao_bem, data_doacao, id_projeto, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, d.getTipo().name());
      pst.setObject(2, d.getValor());
      pst.setString(3, d.getDescricao_bem());
      pst.setDate(4, Date.valueOf(d.getData_doacao()));
      pst.setInt(5, d.getId_projeto());
      pst.setInt(6, d.getId_usuario());
      pst.executeUpdate();
    }
  }

  public List<Doacao> listar()
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM doacao";
    List<Doacao> lista = new ArrayList<>();

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

      while (rs.next()) {
        Doacao d = new Doacao();
        d.setId_doacao(rs.getInt("id_doacao"));
        d.setTipo(DoacaoTipoEnum.valueOf(rs.getString("tipo")));
        d.setValor(rs.getDouble("valor"));
        d.setDescricao_bem(rs.getString("descricao_bem"));
        d.setData_doacao(rs.getDate("data_doacao").toLocalDate());
        d.setId_projeto(rs.getInt("id_projeto"));
        d.setId_usuario(rs.getInt("id_usuario"));
        lista.add(d);
      }
    }

    return lista;
  }

  public Doacao buscarPorId(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM doacao WHERE id_doacao = ?";
    Doacao d = null;

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);

      try (ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
          d = new Doacao();
          d.setId_doacao(rs.getInt("id_doacao"));
          d.setTipo(DoacaoTipoEnum.valueOf(rs.getString("tipo")));
          d.setValor(rs.getDouble("valor"));
          d.setDescricao_bem(rs.getString("descricao_bem"));
          d.setData_doacao(rs.getDate("data_doacao").toLocalDate());
          d.setId_projeto(rs.getInt("id_projeto"));
          d.setId_usuario(rs.getInt("id_usuario"));
        }
      }
    }

    return d;
  }

  public void atualizar(Doacao d)
          throws ClassNotFoundException, SQLException {

    String sql = "UPDATE doacao SET tipo = ?, valor = ?, descricao_bem = ?, data_doacao = ?, id_projeto = ? WHERE id_doacao = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, d.getTipo().name());
      pst.setObject(2, d.getValor());
      pst.setString(3, d.getDescricao_bem());
      pst.setDate(4, Date.valueOf(d.getData_doacao()));
      pst.setInt(5, d.getId_projeto());
      pst.setInt(6, d.getId_doacao());
      pst.executeUpdate();
    }
  }

  public void excluir(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM doacao WHERE id_doacao = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);
      pst.executeUpdate();
    }
  }
}
