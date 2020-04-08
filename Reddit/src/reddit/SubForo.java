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
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();
    
    public void añadirSubscriptor (Usuarios subscriptor){
        ListaUsuario.add(subscriptor);
    }
    
    public void notificar (){   
    }
    
    public void eliminarSubscriptor (Usuarios subscriptor){
        ListaUsuario.remove(subscriptor);
    }
}
