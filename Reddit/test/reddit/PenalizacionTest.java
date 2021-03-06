/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Alba Sevillano
 */
public class PenalizacionTest {
    
    /**
     * Test of GetPenalizacion method, of class Penalizacion.
     */
    
    @Test
    public void testGetPenalizacion() {
        System.out.println("testGetPenalizacion");
        Penalizacion p = new Penalizacion();
        p.AvanzarDias(2);
        
        assertEquals(2-2, p.GetPenalizacion());
    }

    /**
     * Test of EstaActiva method, of class Penalizacion.
     */
    
    @Test
    public void testEstaActiva() {
        System.out.println("testEstaActiva");
        Penalizacion p = new Penalizacion();
        boolean estaActiva = p.EstaActiva();
        if (estaActiva){
            p.AvanzarDias(2);
            assertEquals(2-2, p.GetPenalizacion());
            estaActiva =p.EstaActiva();
        }
    }

    /**
     * Test of AvanzarDias method, of class Penalizacion.
     */
    
    @Test
    public void testAvanzarDias() {
        System.out.println("testAvanzarDias");
        Penalizacion p = new Penalizacion();
        p.AvanzarDias(2);
        
        assertEquals(2-2, p.GetPenalizacion());
    }
    
}
