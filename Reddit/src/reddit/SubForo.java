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
   
    private String Titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();

    public SubForo(String titulo) {
        this.Titulo = titulo;
    }
    
    public void AñadirSuscriptor (Usuarios suscriptor){
        ListaUsuario.add(suscriptor);
    }
    
    public void Notificar (){   
    }
    
    public void EliminarSuscriptor (Usuarios suscriptor){
        ListaUsuario.remove(suscriptor);
    }
}
