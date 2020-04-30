/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reddit.Administrador;
import reddit.Comentario;
import reddit.Entrada;
import reddit.Foro;
import reddit.Penalizacion;
import reddit.SubForo;
import reddit.Usuarios;
/**
 *
 * 
 * @author miriamdefrancisco
 */
public class Demostrador4 {
    /**(USUARIO ALUMNO). En este demostrador, se intenta iniciar sesión de manera
     * fallida y luego se realiza el proceso de registro de ese usuario, un 
     * alumno. Después podremos ver una entrada y comentarla. Acto seguido, 
     * intentará crear una entrada, pero esta no será verificada por el administrador 
     * por lo que se penalizará al autor de la entrada. Intentaremos iniciar sesión 
     * con el usuario penalizado, pero no será posible, tras el avance de unos 
     * días comprobaremos que puede volver a hacer login en el foro.*/
    
    public static void main(String[] args) throws IOException {
        try {
            
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido inicializado");
            System.out.println("Iniciamos sesión en el sistema con un usuario alumno no registrado");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es");
            if (!encontrado){
                System.out.println("Error, la contraseña y/o correo no coinciden");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Miriam","de Francisco","m.defrancisco.2018@alumnos.urjc.es","miri.fa","12345", "12345");
                if(esRegistrado == true){
                    System.out.println("Se ha registrado con existo");
                }
            } 
            System.out.println("Vamos a visualizar una entrada ya creada y subscribirnos a un foro");
            SubForo sf = sistema.verSubForo("SubForo MP");
            sf.AñadirSuscriptor();
            Entrada ent = sf.VerEntrada("Introducción");
            ent.Comentar("Muchas gracias por la información aportada!!!");
            Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
            System.out.println("Se penaliza al autor de la entrada");
            admin.verificarEntrada(ent, false);
             boolean logout = sistema.Logout();
            if(logout==false){
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
            System.out.println("Intentamos acceder al sistema con el usuario penalizado");
            encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println("Estas penalizado, no puedes acceder al foro");
            }
            System.out.println("Avanzamos varios días e intentamos acceder de nuevo");
            sistema.AvanzarDias(4);
            encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println("Estas penalizado, no puedes acceder al foro");
            }else{
                System.out.println("Se ha iniciado sesion con exito");
                logout = sistema.Logout();
                if(logout==false){
                    System.out.println("Has cerrado sesion. Hasta pronto");                
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador4.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
    }   
}
