/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import javax.swing.JInternalFrame;
import static org.testng.Assert.*;

/**
 *
 * @author thami
 */
public class GUIMenuNGTest {
    
    public GUIMenuNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getJInternalFrameEditarCadastro method, of class GUIMenu.
     */
    @org.testng.annotations.Test
    public void testGetJInternalFrameEditarCadastro() {
        System.out.println("getJInternalFrameEditarCadastro");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getJInternalFrameEditarCadastro();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJInternalFrameCadastroLanche method, of class GUIMenu.
     */
    @org.testng.annotations.Test
    public void testGetJInternalFrameCadastroLanche() {
        System.out.println("getJInternalFrameCadastroLanche");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getJInternalFrameCadastroLanche();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getjInternalFramePesquisar method, of class GUIMenu.
     */
    @org.testng.annotations.Test
    public void testGetjInternalFramePesquisar() {
        System.out.println("getjInternalFramePesquisar");
        GUIMenu instance = new GUIMenu();
        JInternalFrame expResult = null;
        JInternalFrame result = instance.getjInternalFramePesquisar();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
