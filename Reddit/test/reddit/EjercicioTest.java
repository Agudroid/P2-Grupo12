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
 
    @Test
    public void testVotar() {
        System.out.println("test Votar");
        Ejercicio e = new Ejercicio("prueba","prueba","prueba");
        e.Votar(4);
        assertEquals(e.GetPuntuacion(),4);
        e.Votar(2);
        assertEquals(e.GetPuntuacion(),6);
    }
    
    @Test
    public void testComentar() {
        System.out.println("test Comentar");
         Ejercicio e = new Ejercicio("prueba","prueba","prueba");
         e.Comentar("hola");
         assertEquals(e.GetListaComentarios().get(0).GetTexto(),"hola");
    }
    
}
