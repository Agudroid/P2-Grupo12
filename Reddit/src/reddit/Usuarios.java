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
    private String Contraseña;
    private ArrayList<String> Notificaciones = new ArrayList<String>();
    
    public int tamano(){
        return Penalizaciones.size();
    }
    public void añadirPenalizacion (Penalizacion penalizacion){
        Penalizaciones.add(penalizacion);
    }
    
    public ArrayList<Penalizacion> getListaPenalizaciones(){
        return Penalizaciones;
    }
    
    public Usuarios(String nombre, String apellido, String correo, String nick, String contraseña){
        Penalizaciones = new ArrayList<Penalizacion>();
        Notificaciones = new ArrayList<String>();
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Correo = correo;
        this.Nick = nick;
        this.Contraseña = contraseña;
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

    public String GetContrasena() { //con este metodo get coseguiremos lo guardado en la variable Contraseña
        return Contraseña;
    }
    
    public void RecibirNotificacion(String notificacion){ //permite añadir al array de notificaciones la notificaion pasada por parámetro
        Notificaciones.add(notificacion);
    }
    
    public void AvanzarDias(int dias) {   //Función que nos permitirá acaba antes una penalización, para realizar las pruebas pertinentes
	for(Penalizacion p : Penalizaciones) {
            if(p.EstaActiva()) {
		p.AvanzarDias(dias);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Usuarios{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + ", Nick=" + Nick + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
    public boolean isProfesor(){
        return Correo.endsWith("@urjc.es");
    }
    
    
}
