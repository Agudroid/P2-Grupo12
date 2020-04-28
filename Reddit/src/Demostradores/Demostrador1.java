/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reddit.*;

/**
 *
 * @author adri-
 */
public class Demostrador1 {

    /**Este primer demostrador sirve para añadir contenido a las bases de datos,
     primero intentando iniciar sesión de manera fallida y luego creando un usuario
     profesor registrándolo en la base de datos, después podremos crear un subforo
       y añadir una entrada (PROFESOR)*/
    public static void main(String[] args) throws IOException{
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println("Error, la contraseña y/o correo no coinciden");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Antonio","Perez","a.perez@urjc.es","a.perez","67890", "67890");
                if(esRegistrado == true){
                    System.out.println("Se ha registrado con existo");
                    
                }
            }
      
            System.out.println("Ahora intentamos iniciar sesion con el usuario que"
                    + "acabamos de crear");
            encontrado =sistema.Login("67890", "a.perez@urjc.es");
            if(encontrado){
                System.out.println("Hemos encontrado el usuario");
                boolean SubForoCreado=sistema.CrearSubForo("SubForo de prueba");
                if(SubForoCreado){
                    System.out.println("SubForo creado");
                    SubForo SubForoActual = sistema.verSubForo("SubForo de prueba");
                    SubForoActual.CrearEntrada("Entrada de prueba", "La mejor entrada del mundo");
                    Entrada entrada=SubForoActual.verEntrada("Entrada de prueba");
                    Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                    admin.verificarEntrada(entrada);
                    System.out.println("Creamos una entrada al subForo");
                    System.out.println(entrada.GetTexto());
                    Encuesta encuesta = new Encuesta("Los ovnis existen?","Crees que existen los ovnis 1.Si 2.No");
                    System.out.println("Añadimos a la Entrada una encuesta");
                    entrada.AñadirComponente(encuesta);
                    System.out.println(encuesta.GetTexto());
                    
                }
            }
            sistema.Logout();
            
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
