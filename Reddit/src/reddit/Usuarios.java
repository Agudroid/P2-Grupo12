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
class Usuarios implements Serializable{
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Nick;
    private String Contraseña;

    public Usuarios(String Nombre, String Apellido, String Correo, String Nick, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Nick = Nick;
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getNick() {
        return Nick;
    }

    public String getContraseña() {
        return Contraseña;
    }
    

    @Override
    public String toString() {
        return "Usuarios{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo + ", Nick=" + Nick + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
    
}
