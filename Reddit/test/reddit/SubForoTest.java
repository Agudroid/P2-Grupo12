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
        System.out.println("testAnadirSuscriptor");
        Usuarios u = new Usuarios("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adri","aaaddd");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.SetUsuarioActual(u);
        sf.AnadirSuscriptor();
        assertTrue(sf.GetListaUsuarios().size()==1 ); //hemos tenido que crear un GetListaUsuarios
    }

    /**
     * Test of Notificar method, of class SubForo.
     */
    @Test
    public void testNotificar() {
        System.out.println("testNotificar");
        Usuarios u = new Usuarios("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adri","aaaddd");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.SetUsuarioActual(u);
        sf.AnadirSuscriptor();
        sf.CrearEntrada("Ejercicio");
        assertTrue(u.GetNotificaciones().size()==1);
    }

    /**
     * Test of EliminarSuscriptor method, of class SubForo.
     */
    @Test
    public void testEliminarSuscriptor() {
        System.out.println("testEliminarSuscriptor");
        Usuarios u = new Usuarios("adri","lopez","a.lopezco.2018@alumnos.urjc.es","adri","aaaddd");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        sf.SetUsuarioActual(u);
        sf.AnadirSuscriptor();
        sf.EliminarSuscriptor();
        assertTrue(sf.GetListaUsuarios().size()==0 ); //hemos tenido que crear un GetListaUsuarios
    }

    /**
     * Test of CrearEntrada method, of class SubForo.
     */
    @Test
    public void testCrearEntrada() {
        System.out.println("testCrearEntrada");
        String Prueba = "esto es una prueba";
        SubForo sf = new SubForo(Prueba);
        Entrada e = sf.CrearEntrada("Ejercicio");
        assertEquals("Ejercicio",e.GetTitulo());
    }

    /**
     * Test of VerEntrada method, of class SubForo.
     */
    @Test
    public void testVerEntrada() {
       System.out.println("testVerEntrada");
       String Prueba = "esto es una prueba";
       SubForo sf = new SubForo(Prueba);
       sf.CrearEntrada("Ejercicio");
       sf.VerEntrada("Ejercicio");
       assertTrue(sf.GetListaEntradas().size()==1); //hemos tenido que crear un GetListaEntradas
    }
    
}