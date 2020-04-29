/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Administrador extends Usuarios implements Serializable{

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
esta clase Administrador */
    
    //Constructor de la clase Administrador
    public Administrador(String nombre, String apellido, String correo, String nick, String contraseña) {
        super(nombre, apellido, correo, nick, contraseña);
    }
    
    //Con este metodo conseguiremos verificar o no la entrada que vaya a revisar el Administrador 
    public void verificarEntrada(Entrada entrada,boolean verificada){  
        entrada.Verificar(verificada);
        if (!verificada){
            Usuarios autor = entrada.GetAutor();
            Penalizacion p = new Penalizacion();
            autor.añadirPenalizacion(p);

        } 
    }
    
}
