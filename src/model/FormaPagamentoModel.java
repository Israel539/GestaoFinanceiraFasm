package model;

import controller.FormaPagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormaPagamentoModel {

    // registra forma de pagamento no banco de dados
    public String grave(FormaPagamento formaPagamento) {
        // declara a variável de retorno
        String msg = "";

        try {
            // abre a conexão com o banco de dados
            Conexao c = new Conexao();
            c.conecte();

            String sql = "call p_salve_forma_pagamento(?, ?)";

            PreparedStatement st = c.conexao.prepareStatement(sql);

            st.setInt(1, formaPagamento.getFormaPagamentoId());
            st.setString(2, formaPagamento.getDescricao());

            st.executeUpdate();

            ResultSet rs = st.getResultSet();
            rs.next();
            msg = rs.getString(2);

            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        // retorna a mensagem
        return msg;
    }
}
