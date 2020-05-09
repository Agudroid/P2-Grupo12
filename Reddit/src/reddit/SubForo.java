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
    
    private Usuarios UsuarioActual;
    private String Titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();
    private ArrayList<Entrada> ListaEntradas = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    la clase SubForo */
    
    public SubForo(String titulo) { //constructor de la clase SubForo
        this.Titulo = titulo;
    }
    
    public String GetTitulo(){ //con este metodo get coseguiremos el string guardado en la variable Titulo
        return Titulo;
    }
    
    public void SetUsuarioActual (Usuarios usuario){ //con este metodo coseguiremos asiganr a la variable UsuarioActual el nombre por parametro
        UsuarioActual = usuario;
    }
    
    public void AnadirSuscriptor (){ //metodo que anade al array de usuarios del subforo un subscriptor
        ListaUsuario.add(UsuarioActual);
    }
    
    public void Notificar (){
        for (int i = 0; i < ListaUsuario.size(); i++) {
            String notificacion = "Se ha creado una entrada nueva";
            ListaUsuario.get(i).RecibirNotificacion(notificacion);
        }
    }
    
    public void EliminarSuscriptor (){ //metodo que nos permitira eliminar a un subscriptor de la lista de usuarios del subforo
        ListaUsuario.remove(UsuarioActual);
    }
    
    //metodo para crear la entrada, conociendo el usuario que ha hecho login, se anadira al array de entradas y se notificara al usuario
    public Entrada CrearEntrada (String titulo){  
        Entrada entrada = new Entrada(titulo, UsuarioActual);
        ListaEntradas.add(entrada);
        Notificar(); 
        return entrada;
    }
    
    public Entrada VerEntrada(String titulo){ //comprobara si la entrada esta verificada, en este caso permitira verla
        Entrada entrada = null;
        Entrada aux = null;
        for (int i = 0; i < ListaEntradas.size(); i++) {
            if (ListaEntradas.get(i).GetTitulo().equals(titulo)){
                aux = ListaEntradas.get(i);
            }
        }
        if (aux.GetVerificada()){
           entrada = aux; 
        }
        return entrada;
    }
}
