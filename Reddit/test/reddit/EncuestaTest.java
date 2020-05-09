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
public class EncuestaTest {
    
    public EncuestaTest() {
        
    }
    /**
     * Test of Votar method, of class Encuesta.
     */
    
    @Test
    public void testVotar() {
        System.out.println("testVotar");
        Encuesta e = new Encuesta("prueba","prueba");
        e.Votar(4);
        assertEquals(e.GetPuntuacion(),4);
        e.Votar(2);
        assertEquals(e.GetPuntuacion(),6);
    }
    
    @Test
    public void testComentar() {
        System.out.println("testComentar");
        Encuesta e = new Encuesta("prueba","prueba");
         e.Comentar("hola");
         assertEquals(e.GetListaComentarios().get(0).GetTexto(),"hola");
    }
    
}
