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
    private ArrayList<Penalizacion> penalizaciones;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Nick;
    private String Contraseña;
    private ArrayList<String> Notificaciones = new ArrayList<String>();
    
    public int tamano(){
        return penalizaciones.size();
    }
    public void añadirPenalizacion (Penalizacion penalizacion){
        penalizaciones.add(penalizacion);
    }
    
    public ArrayList<Penalizacion> getListaPenalizaciones(){
        return penalizaciones;
    }
    
    public Usuarios(String nombre, String apellido, String correo, String nick, String contraseña){
        penalizaciones = new ArrayList<Penalizacion>();
        Notificaciones = new ArrayList<String>();
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
    
    public void avanzarDias(int dias) {
		for(Penalizacion p : penalizaciones) {
			if(p.estaActiva()) {
				p.avanzarDias(dias);
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
