/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Foro {
    private Foro instancia;
    public String nombre;
    
    private Foro(String nombre){
        this.nombre = nombre;
    }
    
    public Foro getForo(String nombre){
        if (instancia == null){
            instancia = new Foro(nombre);
        }
        return instancia;
    }
}            

        
        
        
        

    
    
    
   
