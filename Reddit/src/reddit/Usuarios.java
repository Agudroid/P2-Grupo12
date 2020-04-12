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
 * @author Administrador
 */
class Usuarios implements Serializable{
    
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Nick;
    private String Contraseña;
    private ArrayList<String> Notificaciones;

    public Usuarios(String nombre, String apellido, String correo, String nick, String contraseña){
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Correo = correo;
        this.Nick = nick;
        this.Contraseña = contraseña;
    }
    
    public String GetNombre() {
        return Nombre;
    }

    public String GetApellido() {
        return Apellido;
    }

    public String GetCorreo() {
        return Correo;
    }

    public String GetNick() {
        return Nick;
    }

    public String GetContraseña() {
        return Contraseña;
    }
    
    public void RecibirNotificacion(String notificacion){
        
        Notificaciones.add(notificacion);
        
    }

    @Override
    public String toString() {
        return "Usuarios{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + ", Nick=" + Nick + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
    
}
