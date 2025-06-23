/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.dobackaofront.lanchonete.view;

import javax.swing.JInternalFrame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thami
 */
public class GUIMenuTest {
    
    public GUIMenuTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getJInternalFrameEditarCadastro method, of class GUIMenu.
     */
    @org.junit.jupiter.api.Test
    public void testGetJInternalFrameEditarCadastro() {
        System.out.println("getJInternalFrameEditarCadastro");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getJInternalFrameEditarCadastro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJInternalFrameCadastroLanche method, of class GUIMenu.
     */
    @org.junit.jupiter.api.Test
    public void testGetJInternalFrameCadastroLanche() {
        System.out.println("getJInternalFrameCadastroLanche");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getJInternalFrameCadastroLanche();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getjInternalFramePesquisar method, of class GUIMenu.
     */
    @org.junit.jupiter.api.Test
    public void testGetjInternalFramePesquisar() {
        System.out.println("getjInternalFramePesquisar");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getjInternalFramePesquisar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
