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
            System.out.println("Inicializamos el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("");
            
            System.out.println("El foro ha sido creado con exito");
            System.out.println("Iniciamos sesión en el sistema");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println(" ");
                System.out.println("Error, la contraseña y/o correo no coinciden");
                System.out.println(" ");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Antonio","Perez","a.perez@urjc.es","a.perez","67890", "67890");
                if(esRegistrado == true){
                    System.out.println("a.perez se ha registrado con exito");
                    System.out.println(" ");
                }
            }
      
            System.out.println("Ahora intentamos iniciar sesion con el usuario que"
                    + "acabamos de registrar");
            encontrado =sistema.Login("67890", "a.perez@urjc.es");
            if(encontrado){
                System.out.println(" ");
                System.out.println("El usuario se encuentra en la base de datos");
                System.out.println(" ");
                System.out.println("Voy a crear un subforo");
                boolean SubForoCreado=sistema.CrearSubForo("SubForo MP");
                if(SubForoCreado){
                    System.out.println("El SubForo ha sido creado con éxito");
                    SubForo SubForoReddit = sistema.verSubForo("SubForo MP");
                    
                    System.out.println(" ");
                    
                    Entrada entrada = SubForoReddit.CrearEntrada("Introducción");
                    TextoPlano Entrada_txt = new TextoPlano("Explicación","El siguiente subforo"
                            +"se corresponde con la asignatura de MP");
                    entrada.AñadirComponente(Entrada_txt);
                    Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                    admin.verificarEntrada(entrada,true);
                    
                    System.out.println("Se ha creado una entrada con texto plano, que se ha añadido"
                            + "al SubForo Mp");
                    Encuesta Entrada_encuesta = new Encuesta("ENCUESTA ENTREGA PRÁCTICA","¿Te parece bien la entrega de la práctica?");
                    Entrada_encuesta.SetRespuesta("SÍ");
                    Entrada_encuesta.SetRespuesta("NO");
                    
                    System.out.println(" ");
                    
                    entrada.AñadirComponente(Entrada_encuesta);
                    admin.verificarEntrada(entrada,true);   
                    System.out.println("Hemos verificado la entrada, tras haberle añadido la encuesta");
                    
                    System.out.println(" ");
                    System.out.println("La entrada añadida es:");
                    System.out.println(entrada.GetTitulo());
                    System.out.println(Entrada_txt.GetTitulo());
                    System.out.println(Entrada_txt.GetTexto());
                    System.out.println(Entrada_encuesta.GetTitulo());
                    System.out.println(Entrada_encuesta.GetTexto());
                    System.out.println(Entrada_encuesta.GetRespuestas());
                }
            }
            boolean logout = sistema.Logout();
            if(logout==false){
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
