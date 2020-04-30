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
public class Demostrador2 { 

    /**(USUARIO PROFESOR). 
     * En este demostrador iniciamos sesión con un usuario no 
     * registrado y veremos que da error, y no nos dejará hacer login, por lo 
     * tanto, nos disponemos a registrarlo, pero durante el proceso de registro
     * se introducen de manera errónea algunos datos por lo que no podrá 
     * registrarse en el foro */
    
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            System.out.println("El foro se abrió con éxito");
            System.out.print("\n");
            System.out.println("Iniciamos sesión en el sistema");
            boolean encontrado = sistema.Login("67890", "j.perez@urjc.es");
            if (!encontrado){
                System.out.print("\n");
                System.out.println("Error, la contraseña y/o correo no coinciden");
                System.out.print("\n");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Juan","Perez","j.perez@urjc.com","j.perez","67890", "67890");
                if(esRegistrado == false){
                    System.out.print("\n");
                    System.out.println("No se ha podido registrar. Hay datos introducidos erróneos");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador4.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
    }
    
}
