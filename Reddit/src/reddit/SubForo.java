/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alba Sevillano
 */
public class SubForo implements Subject,Serializable{
    private Administrador admin = null;
    private String Titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();
    private ArrayList<Entrada> ListaEntradas = new ArrayList<>();

    public SubForo(String titulo, Administrador admin) {
        this.Titulo = titulo;
        this.admin = admin;
    }
    
    public void AñadirSuscriptor (Usuarios suscriptor){
        ListaUsuario.add(suscriptor);
    }
    
    public void Notificar (){
        for (int i = 0; i < ListaUsuario.size(); i++) {
            String notificacion = "Se ha creado una entrada nueva";
            ListaUsuario.get(i).RecibirNotificacion(notificacion);
        }
    }
    
    public void EliminarSuscriptor (Usuarios suscriptor){
        ListaUsuario.remove(suscriptor);
    }
    
    public void CrearEntrada (Entrada entrada){
        ListaEntradas.add(entrada);
        Notificar();
    }
    
}
