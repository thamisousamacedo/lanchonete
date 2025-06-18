/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.dobackaofront.lanchonete;

import br.com.dobackaofront.lanchonete.controller.Banco;
import br.com.dobackaofront.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author thami
 */
public class Lanchonete {

    public static void main(String[] args) {
        
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
        Lanche l = new Lanche("Café expresso", 5.90);
        
        if(conexao != null) {
            try {
                b.salvar(l, conexao);
                conexao.close();
            } catch(SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados");
            }
        }
        
        
        
        
        
        
        
        
        
        
    }
}
