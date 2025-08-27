
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //armazena uma conexão ativa com o banco de dados.
    public Connection conexao = null;
    
    //metoodo explicito para efetuar uma conxão com o banco de dados
    public void conrcte() throws ClassNotFoundException, SQLException {
        //string de conexão com o banco de dados
        String url = "jdbc://localhost:3306/gestao_financeira?autoReconnect=true&useSSL=false";
        
        //define usuario e senha de comunicação com o banco de dados
        String usuario = "root";
        String senha = "";
        
        //registra o drive de conexão na aplicação 
        Class.forName("com.mysql.jdbc.Driver");
        
        //efetua uma conexão com o banco de daos e a atribui á variavel global conexão
        this.conexao = DriverManager.getConnection(url, usuario, senha);
        
    }
    
}
