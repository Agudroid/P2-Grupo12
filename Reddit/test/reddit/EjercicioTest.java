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
public class EjercicioTest {
    
    public EjercicioTest() {
    }
 
    public void testVotar() {
        Ejercicio e = new Ejercicio("prueba","prueba","prueba");
        e.Votar(4);
        assertEquals(e.GetPuntuacion(),4);
        e.Votar(2);
        assertEquals(e.GetPuntuacion(),6);
    }
    
    /**
     * Test of Comentar method, of class Ejercicio.
     */
    @Test
    public void testComentar() {
         Ejercicio e = new Ejercicio("prueba","prueba","prueba");
         e.Comentar("hola");
         assertEquals(e.GetListaComentarios().get(0).GetTexto(),"hola");
    }
    
}
