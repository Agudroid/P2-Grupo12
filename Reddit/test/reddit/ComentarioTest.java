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
 * @author Administrador
 */
public class ComentarioTest {
    
    public ComentarioTest() {
    }
    /**
     * Test of GetTexto method, of class Comentario.
     */
    @Test
    public void testComentar() {
        Comentario c = new Comentario();
        c.Comentar("hola");
        assertEquals(c.GetTexto(),"hola");
    }

    /**
     * Test of Votar method, of class Comentario.
     */
    @Test
    public void testVotar() {
        Comentario c = new Comentario();
        c.Votar(5);
        assertEquals(c.GetPuntuacion(),5);
    }
    
}
