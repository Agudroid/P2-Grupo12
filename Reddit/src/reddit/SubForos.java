/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.LinkedList;

/**
 *
 * @author Administrador
 */
public class Subforo {
    
    private String titulo;
    private LinkedList <Usuarios> listaSuscriptores;
    
    public void subirEntrada(Entrada e){
      //Llamar al metodo de crear entrada   
    }
    
    public void suscribirse (Usuarios u){
        listaSuscriptores.add(u);
    }
    
    public void desuscribirse (Usuarios u){
        listaSuscriptores.remove(u);
    }
    
    public void notificar (){
        // utilizar el metodo de usuario recibir notificacion
        
    }
    
    
}
