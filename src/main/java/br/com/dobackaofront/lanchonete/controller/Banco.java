/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dobackaofront.lanchonete.controller;

import br.com.dobackaofront.lanchonete.model.Lanche;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
    private String url;
    private String usuario;
    private String senha;
    
    public Banco() throws SQLException, IOException {
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "400456Tha!";
    }
    
    public Connection conectar() {
        try {
            url = "jdbc:mysql://localhost:3306/lanchonete";
            usuario = "root";
            senha = "400456Tha!";
        
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
           System.out.println("Conexão com o banco de dados estabelecida com sucesso");
           return conexao;    
        } catch(SQLException e) {
            System.out.println("Não foi possível conectar no banco de dados");
            return null;
        }
    }
    
    public void salvar(String nome, double preco, Connection conexao) {
        
        String sql = "INSERT INTO lanche(nome, preco) VALUES(? , ?)";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("O pedido foi salvo com sucesso");
            }                              
        } catch(SQLException e) {
            System.out.println("O pedido não foi salvo no banco de dados!");
        }       
    }
    
    public void inicializarBanco() throws SQLException, FileNotFoundException, IOException {
        
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "400456Tha!";
        
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();
            
            try {
                InputStream is = new FileInputStream("banco.sql");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                
                String linha;
                StringBuilder sql = new StringBuilder();
                
                linha = br.readLine();
                
                while(linha != null) {
                    System.out.println(linha);
                    sql.append(linha).append("\n");
                    
                    if (linha.trim().endsWith(";")) {
                        stmt.execute(sql.toString());
                        sql.setLength(0);
                    }
                    
                    linha = br.readLine();
                }
                
                stmt.close();
                conexao.close();
                
            } catch (Exception e) {
                System.out.println("Não foi possível ler o arquivo banco.sql");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados no método inicializarBanco");
        }
    }

}
