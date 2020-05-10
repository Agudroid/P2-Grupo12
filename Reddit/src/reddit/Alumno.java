/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;



/**
 *
 * @author Administrador
 */

public class Alumno extends Usuarios implements Serializable{
    
    public Alumno(String nombre, String apellido, String correo, String nick, String contrasena){
        super(nombre, apellido, correo, nick, contrasena); 
    }
}
