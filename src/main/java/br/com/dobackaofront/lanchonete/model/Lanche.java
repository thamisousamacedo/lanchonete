/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dobackaofront.lanchonete.model;

import br.com.dobackaofront.lanchonete.controller.Banco;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thami
 */
public class Lanche {
    private int id;
    private String nome;
    private double preco;
    
    public Lanche(){
        this.id = 0;
        this.nome = "";
        this.preco = 0;
    }
    
    public Lanche(int id, String nome, double preco) throws SQLException, IOException {
        this(nome, preco);
    }

    public Lanche(String nome, double preco) throws SQLException, IOException {
        this.id = 0;
        this.nome = nome;
        this.preco = preco;
        //salvar(nome, preco);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void apresentarLanche(){
    System.out.println("Nome: " + nome + ", R$ " + preco + ", ID: " + id);
    } 
    
    
    
    public void salvar(String nome, double preco) throws SQLException, IOException {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        b.salvar(nome, preco, conexao);
    }
    
    public ArrayList<Lanche> pesquisar(String nome) throws SQLException, IOException {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        ArrayList<Lanche> lanches = b.buscarPorTrechoNome(nome);
        
        return lanches;
        
    }
    
    public void deletar (int id) throws SQLException, IOException {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        b.deletar(id);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
