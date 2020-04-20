/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador 
 */
public class Reddit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        try {
            Foro foro =  Foro.GetForo("Reddit");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reddit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
