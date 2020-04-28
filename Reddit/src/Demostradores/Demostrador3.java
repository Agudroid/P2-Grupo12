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

    /** En este demostrador iniciamos sesión con un profesor registrado y entraremos
     en el foro, y tras esto se añadirá una entrada a un subforo ya creado, y se 
     penalizará a un alumno
     (PROFESOR)
     */
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            }   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
