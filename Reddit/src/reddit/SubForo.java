/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.ArrayList;

/**
 *
 * @author Alba Sevillano
 */
public class SubForo {
   
    private String titulo;
    private ArrayList<Usuario> ListaUsuario = new ArrayList<>();
    
    public void añadirSubscriptor (Usuario subscriptor){
        ListaUsuario.add(subscriptor);
    }
    
    public void notificar (){   
    }
    
    public void eliminarSubscriptor (Usuario subscriptor){
        ListaUsuario.remove(subscriptor);
    }
}
