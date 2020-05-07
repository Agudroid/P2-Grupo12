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
public class TextoPlanoTest {
    
    public TextoPlanoTest() {
    }
    
    @Test
    public void testVotar() {
        TextoPlano t = new TextoPlano("prueba","prueba");
        t.Votar(4);
        assertEquals(t.GetPuntuacion(),4);
        t.Votar(2);
        assertEquals(t.GetPuntuacion(),6);
    }

    /**
     * Test of GetVerificada method, of class TextoPlano.
     */
   
    @Test
    public void testComentar() {
        TextoPlano t = new TextoPlano("prueba","prueba");
        t.Comentar("hola");
        assertEquals(t.GetListaComentarios().get(0).GetTexto(),"hola");
    }
    
}