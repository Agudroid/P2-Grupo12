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
    private Usuarios usuarioActual;
    private String Titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();
    private ArrayList<Entrada> ListaEntradas = new ArrayList<>();

    public SubForo(String titulo) {
        this.Titulo = titulo;
    }
    public String getTitulo(){
        return Titulo;
    }
    public void setUsuarioActual (Usuarios usuario){
        usuarioActual = usuario;
    }
    
    public void AñadirSuscriptor (){
        ListaUsuario.add(usuarioActual);
    }
    
    public void Notificar (){
        for (int i = 0; i < ListaUsuario.size(); i++) {
            String notificacion = "Se ha creado una entrada nueva";
            ListaUsuario.get(i).RecibirNotificacion(notificacion);
        }
    }
    
    public void EliminarSuscriptor (){
        ListaUsuario.remove(usuarioActual);
    }
    
    public Entrada CrearEntrada (String titulo, String texto){
        Entrada entrada = new Entrada(titulo, texto);
        ListaEntradas.add(entrada);
        Notificar(); 
        return entrada;
    }
    
    public Entrada verEntrada(String titulo){
        Entrada ent = null;
        Entrada aux = null;
        for (int i = 0; i < ListaEntradas.size(); i++) {
            if (ListaEntradas.get(i).GetTitulo().equals(titulo)){
                aux = ListaEntradas.get(i);
            }
        }
        if (aux.GetVerificada()){
           ent = aux; 
        }
        return ent;
    }
    
    public void añadirComponente(EntradaGenerica componente, Entrada ent){
        if ((usuarioActual.isProfesor()) && ((componente instanceof Ejercicio) || (componente instanceof Encuesta))){
            ent.AñadirComponente(componente);
        }else if (componente instanceof Entrada){
            ent.AñadirComponente(componente);
        }
    }
}
