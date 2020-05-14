/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adri-
 */
public class ForoTest {

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
        String Prueba = "testCrearSubForo";
        SubForo sf = new SubForo(Prueba);
        assertEquals(sf.GetTitulo(), Prueba);
    }
    
    //Escribir y leer en la base de datos funciona casi del mismo modo asi que
    //hacemos la misma prueba
    
    /**
    * Test of EscribirBBDD method, of class Foro.
     */
    
    @Test
    public void testEscribirBBDD() throws Exception {
        System.out.println("testEscribirBBDD");
        Foro f = Foro.GetForo("prueba");
        f.RegistrarUsuario("Juan","Perez","j.perez@urjc.es","j.perez","67890", "67890");
        f.Login("67890","j.perez@urjc.es");
        f.CrearSubForo("SubPrueba");
        f.Logout();
        Foro f2 = Foro.GetForo("prueba");
        boolean encontradoSubForo = false;
        boolean encontradoUsuario = false;
        int i =0;
        List <Usuarios> ListaUsuarios = f2.GetListaUsuarios();
        List <SubForo> ListaSubForo = f2.GetListaSubForo();
       
        while(!encontradoSubForo && i<= ListaSubForo.size() ){
            encontradoSubForo=ListaSubForo.get(i).GetTitulo().equals("SubPrueba");
            i+=1;
        }
        
        i=0;
        while(!encontradoUsuario && i<= ListaUsuarios.size() ){
            encontradoUsuario=ListaUsuarios.get(i).GetCorreo().equals("j.perez@urjc.es");
            i+=1;
        }
        assertTrue(encontradoSubForo);
        assertTrue(encontradoUsuario);
    }

    /**
    * Test of LeerBBDD method, of class Foro.
     */
   //se ha tenido que anadir los getters de las listas a la clase SubForo
   @Test
    public void testLeerBBDD() throws Exception {
        System.out.println("testLeerBBDD");
        Foro f = Foro.GetForo("prueba");
        f.RegistrarUsuario("Juan","Perez","j.perez@urjc.es","j.perez","67890", "67890");
        f.Login("67890","j.perez@urjc.es");
        f.CrearSubForo("SubPrueba");
        f.Logout();
        Foro f2 = Foro.GetForo("prueba");
        boolean encontradoSubForo = false;
        boolean encontradoUsuario = false;
        int i =0;
        List <Usuarios> ListaUsuarios = f2.GetListaUsuarios();
        List <SubForo> ListaSubForo = f2.GetListaSubForo();
       
        while(!encontradoSubForo && i<= ListaSubForo.size() ){
            encontradoSubForo=ListaSubForo.get(i).GetTitulo().equals("SubPrueba");
            i+=1;
        }
        
        i=0;
        while(!encontradoUsuario && i<= ListaUsuarios.size() ){
            encontradoUsuario=ListaUsuarios.get(i).GetCorreo().equals("j.perez@urjc.es");
            i+=1;
        }
        assertTrue(encontradoSubForo);
        assertTrue(encontradoUsuario);
    }

    /**
     * Test of verSubForo method, of class Foro.
     */
    @Test
    public void testVerSubForo() throws ClassNotFoundException, IOException {
        System.out.println("testVerSubForo");
        Foro sistema = Foro.GetForo("Reddit URJC");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sistema.verSubForo(Prueba);
        assertEquals(sf.GetTitulo(), Prueba);
    }
    
}