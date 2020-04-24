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
 * @author Alba Sevillano
 */
public class Demostrador5 {

    /**En este demostrador iniciamos sesión con un profesor no registrado y veremos 
     que da error, intentaremos registrarlo pero no se podrá porque los datos son 
     erroneos (PROFESOR)*/
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario no registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println("Error, la contraseña y/o correo no coinciden");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Antonio","Perez","a.perez@urjc.es","a.perez","67890", "67890");
                if(esRegistrado == false){
                    System.out.println("No se ha podido registrar.");
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador1.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
    }
    
}
