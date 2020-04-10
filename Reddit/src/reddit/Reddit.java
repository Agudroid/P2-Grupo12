/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

/**
 *
 * @author Administrador
 */
public class Reddit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuarios pepe = new Usuarios("Antonio","Agudo","alumnos.urjc","Pepe","patata");
        SubForo s = new SubForo();
        s.enlazarObservador(pepe);
        s.notificar();
    }
    
    
}
