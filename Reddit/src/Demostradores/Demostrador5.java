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
 * 
 * @author miriamdefrancisco
 */
public class Demostrador5 { 
    /**(USUARIO ALUMNO) En este demostrador iniciamos sesión con un alumno no 
     * registrado y veremos que dara error, intentaremos registrarlo, pero no se
     * podra porque los datos introducidos son erroneos, por lo tanto, se quiere 
     * mostrar lo mismo que ocurre en el demostrador 2.*/
    
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            System.out.println("El foro se abrio con exito");
            System.out.print("\n");
            System.out.println("Iniciamos sesion en el sistema");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.com");
            if (!encontrado){
                System.out.print("\n");
                System.out.println("Error, la contrasena y/o correo no coinciden");
                System.out.print("\n");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Miriam","Aguirre","m.aguirre.2018@alumnos.urjc.com","miri.ag","12345", "12345");
                if(esRegistrado == false){
                    System.out.print("\n");
                    System.out.println("No se ha podido registrar. Hay datos introducidos erroneos");
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador4.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }   
}

