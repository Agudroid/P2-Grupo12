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
    
    /**
     * Test of Comentar method, of class Comentario.
     */
    @Test
    public void testComentar() {
        System.out.println("test Comentar");
        Comentario c = new Comentario();
        c.Comentar("hola");
        assertEquals(c.GetTexto(),"hola");
    }

    /**
     * Test of Votar method, of class Comentario.
     */
    @Test
    public void testVotar() {
        System.out.println("test Votar");
        Comentario c = new Comentario();
        c.Votar(5);
        assertEquals(c.GetPuntuacion(),5);
    }
    
}
