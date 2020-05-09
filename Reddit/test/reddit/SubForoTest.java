/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alba Sevillano
 */
public class SubForoTest {


    /**
     * Test of AnadirSuscriptor method, of class SubForo.
     */
    @Test
    public void testAnadirSuscriptor() {
        Usuarios u = new Usuarios("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adri","aaaddd");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.AnadirSuscriptor();
        assertTrue(sf.GetListaUsuarios().size()==1 ); //hemos tenido que crear un GetListaUsuarios
    }

    /**
     * Test of Notificar method, of class SubForo.
     */
    @Test
    public void testNotificar() {
    }

    /**
     * Test of EliminarSuscriptor method, of class SubForo.
     */
    @Test
    public void testEliminarSuscriptor() {
        Usuarios u = new Usuarios("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adri","aaaddd");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.AnadirSuscriptor();
        sf.EliminarSuscriptor();
        assertTrue(sf.GetListaUsuarios().size()==0 ); //hemos tenido que crear un GetListaUsuarios
    }

    /**
     * Test of CrearEntrada method, of class SubForo.
     */
    @Test
    public void testCrearEntrada() {
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.CrearEntrada(Prueba);
        assertEquals(Prueba, sf.GetTitulo());
    }

    /**
     * Test of VerEntrada method, of class SubForo.
     */
    @Test
    public void testVerEntrada() {
       String Prueba = "esto es una prueba";
       SubForo sf = new SubForo(Prueba);
       sf.CrearEntrada(Prueba);
       sf.VerEntrada(Prueba);
       assertEquals(Prueba,sf.GetTitulo());
    }
    
}