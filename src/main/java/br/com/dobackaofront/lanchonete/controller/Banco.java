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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;

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
    
    public ArrayList<Lanche> buscarPorTrechoNome(String trechoNome) throws IOException {
        ArrayList<Lanche> listaDeLanches = new ArrayList<>();
        
        String trechoNormalizado = "%" + normalizarTexto(trechoNome) + "%";
        String sql = "SELECT * FROM lanche WHERE nome LIKE ?";
        
        try {
            Connection conexao = conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, trechoNormalizado);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                Lanche lanche = new Lanche(id, nome, preco);
                lanche.setId(id);
                
                listaDeLanches.add(lanche);
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch(SQLException e) {
            System.out.println("Não conseguiu conectar no banco de dados no método buscarPorTrechoNome()");
        }
        
        return listaDeLanches;
    }
    
    private String normalizarTexto(String trecho) {
        return Normalizer.normalize(trecho, Normalizer.Form.NFD).replace("[^\\p{ASCII}]", "");
    }
    
    public void deletar(int id) {
        String sql = "DELETE FROM lanche WHERE id = ?";
        
        try {
            Connection conexao = conectar();
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0){
                System.out.println("O lanche de iD: " + id + " foi excluído com sucesso!");
                
            } else {
                 System.out.println("O lanche de iD: " + id + " não foi encontrado!");
            }
            
            stmt.close();
            conexao.close();
            
        } catch(SQLException e) {
             System.out.println("Houve um erro ao tentar conectar no Banco de Dados no método Deletar!");
        }
    }
  
    public void editar (String nome, double preco, int id) {
        String sql = "UPDATE lanche SET nome = ?, preco = ? WHERE id = ?";
        
        try {
            Connection conexao = conectar();
            PreparedStatement stmt = conexao.prepareCall(sql);
            
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, id);
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("O Cadastro foi editado com Sucesso!");
            } else {
                System.out.println("Não houve alteração na edição de Cadastro!");
            }
            
            stmt.close();
            conexao.close();
            
        } catch(SQLException e) {
            System.out.println("Não foi possível conectar no banco de dados para o método editar Cadastro!");
        }     
    }
    
    public Lanche buscarPorId(int id) throws IOException {
        String sql = "SELECT * FROM lanche WHERE id = ?";
        Lanche lancheEncontrado = null;
        
        try {
           Connection conexao = conectar();
           PreparedStatement stmt = conexao.prepareStatement(sql);
           
           stmt.setInt(1, id);
           
           ResultSet rs = stmt.executeQuery();
           
           if (rs.next()) {
               String nome = rs.getString("nome");
               double preco = rs.getDouble("preco");
               lancheEncontrado = new Lanche(nome, preco);
               lancheEncontrado.setId(id);
           }
           
           stmt.close();
           conexao.close();
     
        }catch (SQLException e) {
            System.out.println("Não foi possível conectar no bamco de dados no método buscarPorId");
        }
        
        return lancheEncontrado;
    }

}