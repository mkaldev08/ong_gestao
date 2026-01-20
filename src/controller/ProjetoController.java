package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;
import model.Projeto;
import utils.CustomezedEnum;

public class ProjetoController {

  public void salvar(Projeto p)
          throws ClassNotFoundException, SQLException {

    String sql = "INSERT INTO projeto (nome, descricao, data_inicio, data_fim, status, data_criacao) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, p.getNome());
      pst.setString(2, p.getDescricao());
      pst.setDate(3, Date.valueOf(p.getData_inicio()));
      pst.setDate(4, p.getData_fim() != null ? Date.valueOf(p.getData_fim()) : null);
      pst.setString(5, p.getStatus().name());
      pst.setDate(6, Date.valueOf(p.getData_criacao()));
      pst.executeUpdate();
    }
  }

  public List<Projeto> listar()
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM projeto";
    List<Projeto> lista = new ArrayList<>();

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

      while (rs.next()) {
        Projeto p = new Projeto();
        p.setId_projeto(rs.getInt("id_projeto"));
        p.setNome(rs.getString("nome"));
        p.setDescricao(rs.getString("descricao"));
        p.setData_inicio(rs.getDate("data_inicio").toLocalDate());
        Date df = rs.getDate("data_fim");
        p.setData_fim(df != null ? df.toLocalDate() : null);
        p.setStatus(CustomezedEnum.valueOf(rs.getString("status")));
        p.setData_criacao(rs.getDate("data_criacao").toLocalDate());
        
        lista.add(p);
      }
    }

    return lista;
  }

  public Projeto buscarPorId(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "SELECT * FROM projeto WHERE id_projeto = ?";
    Projeto p = null;

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);

      try (ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
          p = new Projeto();
          p.setId_projeto(rs.getInt("id_projeto"));
          p.setNome(rs.getString("nome"));
          p.setDescricao(rs.getString("descricao"));
          p.setData_inicio(rs.getDate("data_inicio").toLocalDate());
          Date df = rs.getDate("data_fim");
          p.setData_fim(df != null ? df.toLocalDate() : null);
          p.setStatus(CustomezedEnum.valueOf(rs.getString("status")));
          p.setData_criacao(rs.getDate("data_criacao").toLocalDate());
        }
      }
    }

    return p;
  }

  public void atualizar(Projeto p)
          throws ClassNotFoundException, SQLException {

    String sql = "UPDATE projeto SET nome = ?, descricao = ?, data_inicio = ?, data_fim = ?, status = ? WHERE id_projeto = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setString(1, p.getNome());
      pst.setString(2, p.getDescricao());
      pst.setDate(3, Date.valueOf(p.getData_inicio()));
      pst.setDate(4, p.getData_fim() != null ? Date.valueOf(p.getData_fim()) : null);
      pst.setString(5, p.getStatus().name());
      pst.setInt(6, p.getId_projeto());
      pst.executeUpdate();
    }
  }

  public void excluir(int id)
          throws ClassNotFoundException, SQLException {

    String sql = "DELETE FROM projeto WHERE id_projeto = ?";

    try (PreparedStatement pst = Conexao.conectar().prepareStatement(sql)) {
      pst.setInt(1, id);
      pst.executeUpdate();
    }
  }
}
