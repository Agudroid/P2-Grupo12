/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;

import reddit.Foro;

/**
 *
 * @author Alba Sevillano
 */
public class Demostrador3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            } else {
                System.out.println("Error, la contraseña y/o correo no coinciden");
            }
            System.out.println("Vamos a acceder a un subforo");  
    }
    
}
