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
public class Usuarios implements Serializable{
    
    private ArrayList<Penalizacion> Penalizaciones;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Nick;
    private String Contrasena;
    private ArrayList<String> Notificaciones = new ArrayList<String>();
    
    public Usuarios(String nombre, String apellido, String correo, String nick, String contrasena){
        Penalizaciones = new ArrayList<Penalizacion>();
        Notificaciones = new ArrayList<String>();
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Correo = correo;
        this.Nick = nick;
        this.Contrasena = contrasena;
    }
    
    public ArrayList GetNotificaciones(){
        return Notificaciones;
    }
    public String GetNombre() { //con este metodo get coseguiremos lo guardado en la variable Nombre
        return Nombre;
    }

    public String GetApellido() { //con este metodo get coseguiremos lo guardado en la variable Apellido
        return Apellido;
    }

    public String GetCorreo() { //con este metodo get coseguiremos lo guardado en la variable Correo
        return Correo;
    }
    

    public String GetNick() { //con este metodo get coseguiremos lo guardado en la variable Nick
        return Nick;
    }

    public String GetContrasena() { //con este metodo get coseguiremos lo guardado en la variable Contrasena
        return Contrasena;
    }
    
    public void RecibirNotificacion(String notificacion){ //permite anadir al array de notificaciones la notificacion pasada por parametro
        Notificaciones.add(notificacion);
    }
    
    public void AvanzarDias(int dias) {   //Funcion que nos permitira acaba antes una penalizacion, para realizar las pruebas pertinentes
	for(Penalizacion p : Penalizaciones) {
            if(p.EstaActiva()) {
		p.AvanzarDias(dias);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Usuarios{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + ", Nick=" + Nick + ", Contrase\u00f1a=" + Contrasena + '}';
    }
    
    public boolean isProfesor(){
        return Correo.endsWith("@urjc.es");
    }
    
    public int Tamano(){
        return Penalizaciones.size();
    }
    public void AnadirPenalizacion (Penalizacion penalizacion){
        Penalizaciones.add(penalizacion);
    }
    
    public ArrayList<Penalizacion> GetListaPenalizaciones(){
        return Penalizaciones;
    }
    
}
