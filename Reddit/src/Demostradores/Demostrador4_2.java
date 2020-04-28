/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Demostrador4_2 {
    /**Este primer demostrador sirve para añadir contenido a las bases de datos,
     primero intentando iniciar sesión de manera fallida y luego creando un usuario
     alumno registrándolo en la base de datos, después podremos ver una entrada y 
     comentarla (ALUMNO)*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es");
            if (!encontrado){
                System.out.println("Estas penalizado");
            }
            encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es");
            if (!encontrado){
                System.out.println("No puede hacer login");
            }else{
                System.out.println("Se ha iniciado sesion con exito");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador4.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
    }   
}
