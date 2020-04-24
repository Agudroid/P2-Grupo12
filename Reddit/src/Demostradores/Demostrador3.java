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
public class Demostrador3 {

    /** En este demostrador iniciamos sesión con un alumno registrado y entraremos
     en el foro, y tras esto podremos ver una entrada y comentarla de nuevo
     (ALUMNO)*/
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario no registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            } else {
                System.out.println("Error, la contraseña y/o correo no coinciden");
            }
            System.out.println("Vamos a registrarnos en el sistema");
            sistema.RegistrarUsuario("Antonio","Perez","a.perez@urjc.es","anto.pe","67890","67890");  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
