/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.dobackaofront.lanchonete;

import br.com.dobackaofront.lanchonete.controller.Banco;
import br.com.dobackaofront.lanchonete.view.GUIMenu;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thami
 */
public class Lanchonete {

   /* public static void main(String[] args) throws SQLException, IOException {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
        Lanche l = new Lanche("Café Gelado", 9.90);
        br.com.dobackaofront.lanchonete.model.Lanche lanche = null;
        b.salvar(lanche, conexao);
    }
}*/
     public static void main(String args[]) throws SQLException, IOException {
        GUIMenu janelaPrincipal = new GUIMenu();
        Banco b = new Banco();
        b.inicializarBanco();
       
        
       ArrayList<br.com.dobackaofront.lanchonete.model.Lanche> lanches = b.buscarPorTrechoNome("pastel");
       
       for (br.com.dobackaofront.lanchonete.model.Lanche lanche : lanches) {
           lanche.apresentarLanche();
       }
       
       b = null;
        
       
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run () {
                janelaPrincipal.setVisible(true);
                janelaPrincipal.getJInternalFrameCadastroLanche().setVisible(false);
                janelaPrincipal.getjInternalFramePesquisar().setVisible(false);
            }
        } );
    }
}     

