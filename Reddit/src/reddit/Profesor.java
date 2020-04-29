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
public class Profesor extends Usuarios implements Serializable{

    public Profesor(String Nombre, String Apellido, String Correo, String Nick, String Contraseña) {
        super(Nombre, Apellido, Correo, Nick, Contraseña);
    }
    
}
