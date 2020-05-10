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
public class AdministradorTest {

    /**
     * Test of verificarEntrada method, of class Administrador.
     */
    @Test
    public void testVerificarEntrada() {
        Usuarios autor = new Usuarios("Miriam","de Francisco","miriam@alumnos.urjc.es","miri.fa","0123456");
        Entrada ent = new Entrada("Titulo",autor);
        Administrador admin = new Administrador("admin","admin","admin@urjc.es","admin","01234");
        admin.verificarEntrada(ent, true);
        assertEquals(ent.GetVerificada(),true);
        admin.verificarEntrada(ent, false);
        assertEquals(ent.GetVerificada(),false);
        assertEquals(autor.GetListaPenalizaciones().size(),1);
    }
    
}
