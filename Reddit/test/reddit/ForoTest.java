/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adri-
 */
public class ForoTest {
    
    public ForoTest() {
    }

    /**
     * Test of Login method, of class Foro.
     */
    @Test
    public void testLogin() throws ClassNotFoundException, IOException {
        Foro sistema = Foro.GetForo("Reddit URJC");
        sistema.RegistrarUsuario("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adrian","aaaddd", "aaaddd");
        assertTrue(sistema.Login("aaaddd", "a.lopezco.2018@alumnos.urjc.es"));
                
    }

    /**
     * Test of RegistrarUsuario method, of class Foro.
     */
    @Test
    public void testRegistrarUsuario() throws ClassNotFoundException, IOException {
        Foro sistema = Foro.GetForo("Reddit URJC");
        assertTrue(sistema.RegistrarUsuario("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adrian","aaaddd", "aaaddd"));
    }

    /**
     * Test of Logout method, of class Foro.
     */
    @Test
    public void testLogout() throws Exception {
        Foro sistema = Foro.GetForo("Reddit URJC");
        sistema.RegistrarUsuario("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adrian","aaaddd", "aaaddd");
        sistema.Login("aaaddd", "a.lopezco.2018@alumnos.urjc.es");
        assertFalse(sistema.Logout());
    }

    /**
     * Test of CrearSubForo method, of class Foro.
     */
    @Test
    public void testCrearSubForo() throws Exception {
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        assertEquals(sf.GetTitulo(), Prueba);
    }

//    /**
//     * Test of EscribirBBDD method, of class Foro.
//     */
//    @Test
//    public void testEscribirBBDD() throws Exception {
//    }
//
//    /**
//     * Test of LeerBBDD method, of class Foro.
//     */
//    @Test
//    public void testLeerBBDD() throws Exception {
//    }

    /**
     * Test of verSubForo method, of class Foro.
     */
    @Test
    public void testVerSubForo() {
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.verSubForo("esto es una prueba");
        assertEquals(sf.GetTitulo(), Prueba);
    }
    
}