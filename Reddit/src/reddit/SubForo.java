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
public class SubForo implements Subject{
   
    private String titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();

    public SubForo(String titulo) {
        this.titulo = titulo;
    }
    
    public void añadirSuscriptor (Usuarios suscriptor){
        ListaUsuario.add(suscriptor);
    }
    
    public void notificar (){   
    }
    
    public void eliminarSuscriptor (Usuarios suscriptor){
        ListaUsuario.remove(suscriptor);
    }
}
