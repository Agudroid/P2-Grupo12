/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reddit.Foro;

/**
 *
 * @author adri-
 */
public class Demostrador4 {

    /**Este primer demostrador sirve para añadir contenido a las bases de datos,
     primero intentando iniciar sesión de manera fallida y luego creando un usuario
     profesor registrándolo en la base de datos, después podremos añadir una entrada 
     a un subforo (PROFESOR)*/
    public static void main(String[] args) throws IOException{
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("12345", "m.d.2018@alumnos.urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            } else {
                System.out.println("Error, la contraseña y/o correo no coinciden");
            }
            System.out.println("Vamos a acceder a un subforo");         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
