/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Conexao;
import model.Doacao;

/**
 *
 * @author manuelkalueka
 */
public class DoacaoController {
        public void inserir(Doacao doacao) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO doacao (tipo, valor, descricao_bem, data_doacao, id_projeto) VALUES (?, ?, ?, ?, ?, );";
        PreparedStatement pst = Conexao.conectar().prepareStatement(SQL);

//        pst.setI(1, doacao.getTipo());
//        pst.setString(2, String.valueOf((us.getSenha())));
//        pst.setString(3, String.valueOf(us.getTelefone()));
//        pst.executeUpdate();

    }
    
}
