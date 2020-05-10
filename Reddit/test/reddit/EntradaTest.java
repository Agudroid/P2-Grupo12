/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miriamdefrancisco
 */
public class EntradaTest {
    
    public EntradaTest() {
    }

    /**
     * Test of Votar method, of class Entrada.
     */
    @Test
    public void testVotar() {
        Usuarios autor = new Usuarios("Miriam","de Francisco","miriam@alumnos.urjc.es","miri.fa","0123456");
        Entrada e = new Entrada("prueba",autor);
        e.Votar(4);
        assertEquals(e.GetPuntuacion(),4);
        e.Votar(2);
        assertEquals(e.GetPuntuacion(),6);
    }


    /**
     * Test of Comentar method, of class Entrada.
     */
    
    @Test
    public void testComentar() {
        System.out.println("testComentar");
        Usuarios autor = new Usuarios("Miriam","de Francisco","miriam@alumnos.urjc.es","miri.fa","0123456");
        Entrada e = new Entrada("prueba",autor);
         e.Comentar("hola");
         assertEquals(e.GetListaComentarios().get(0).GetTexto(),"hola");
    }

    /**
     * Test of AnadirComponente method, of class Entrada.
     */
    
    @Test
    public void testAnadirComponente() {
        System.out.println("testAnadirComponente");
        Usuarios autor = new Usuarios("Miriam","de Francisco","miriam@urjc.es","miri.fa","0123456");
        Entrada e = new Entrada("prueba",autor);
        Encuesta encuesta = new Encuesta("prueba","prueba");
        e.AnadirComponente(encuesta);
        assertEquals(e.GetComponentes().get(0).GetTitulo(),"prueba");
    }

    /**
     * Test of BorrarComponente method, of class Entrada.
     */
    
    @Test
    public void testBorrarComponente() {
        System.out.println("testBorrarComponente");
        Usuarios autor = new Usuarios("Miriam","de Francisco","miriam@urjc.es","miri.fa","0123456");
        Entrada e = new Entrada("prueba",autor);
        Encuesta encuesta = new Encuesta("prueba","prueba");
        e.AnadirComponente(encuesta);
        assertEquals(e.GetComponentes().size(),1);
        e.BorrarComponente(encuesta);
        assertEquals(e.GetComponentes().size(),0);
    }
    
}
