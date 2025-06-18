/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dobackaofront.lanchonete.controller;

import br.com.dobackaofront.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Banco {
    private String url;
    private String usuario;
    private String senha;
    
    public Banco() {
        url = "jdbc:mysql://localhost:3306/lanchonete";
        usuario = "root";
        senha = "400456Tha!";
    }
    
    public Connection conectar() {
        try {
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
           System.out.println("Conexão com o banco de dados estabelecida com sucesso");
           return conexao;    
        } catch(SQLException e) {
            System.out.println("Não foi possível conectar no banco de dados");
            return null;
        }
    }
    
    public void salvar(Lanche lanche, Connection conexao) {
        
        String sql = "INSERT INTO lanche(nome, preco) VALUES(? , ?)";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, lanche.getNome());
            stmt.setDouble(2, (lanche.getPreco()));
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("O pedido foi salvo com sucesso");
            }                              
        } catch(SQLException e) {
            System.out.println("O pedido não foi salvo no banco de dados!");
        }       
    }
}