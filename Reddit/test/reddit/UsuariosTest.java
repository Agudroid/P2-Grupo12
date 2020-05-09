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
public class UsuariosTest {
    
    public UsuariosTest() {
    }

    /**
     * Test of tamano method, of class Usuarios.
     */
    @Test
    public void testTamano() {
        System.out.println("test Tamano");
        Usuarios usuario = new Usuarios("Miriam","de Francisco","miriam@alumnos.urjc.es","miri.fa","0123456");
        Entrada ent = new Entrada("Titulo",usuario);
        Administrador admin = new Administrador("admin","admin","admin@urjc.es","admin","01234");
        admin.verificarEntrada(ent, false);
        assertTrue(usuario.tamano()==1);
    }

    /**
     * Test of RecibirNotificacion method, of class Usuarios.
     */
    @Test
    public void testRecibirNotificacion() {
        System.out.println("test RecibirNotificacion");
        Usuarios usuario = new Usuarios("Miriam","de Francisco","miriam@urjc.es","miri.fa","0123456");
        SubForo s = new SubForo("titulo");
        s.SetUsuarioActual(usuario);
        s.AnadirSuscriptor();
        s.CrearEntrada("entrada1");
        assertTrue(usuario.GetNotificaciones().size()==1);
    }

    /**
     * Test of AvanzarDias method, of class Usuarios.
     */
    @Test
    public void testAvanzarDias() {
    }

    
}
