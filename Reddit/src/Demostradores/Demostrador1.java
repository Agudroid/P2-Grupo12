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

    /**(USUARIO PROFESOR).
     * Este primer demostrador sirve para añadir contenido a
     * las bases de datos, que en un primer momento están vacias.Primero se
     * intenta iniciar sesión de manera fallida, ya que el usuario no está 
     * registrado, posteriormente registramos un usuario profesor. Tras esto 
     * accedemos al sistema y creamos un subforo y añadimos una entrada con 
     * texto plano, pero posteriormente la modificaremos añadiéndole 
     * una encuesta. */
    
    public static void main(String[] args) throws IOException{
        try {
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            
            System.out.println("El foro se abrio con exito");
            System.out.print("\n");
            System.out.println("Iniciamos sesion en el sistema");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            
            if (!encontrado){
                System.out.print("\n");
                System.out.println("Error, la contrasena y/o correo no coinciden");
                System.out.print("\n");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Antonio","Perez","a.perez@urjc.es","a.perez","67890", "67890");
                if(esRegistrado == true){
                    System.out.println("El usuario a.perez se ha registrado con exito");
                    System.out.print("\n");
                }
            }
      
            System.out.println("Ahora intentamos iniciar sesion con el usuario que"
                    + "acabamos de registrar");
            encontrado =sistema.Login("67890", "a.perez@urjc.es");
            if(encontrado){
                System.out.print("\n");
                System.out.println("El usuario se encuentra en la base de datos");
                System.out.print("\n");
                
                System.out.println("A continuación, el usuario creara un subforo");
                boolean SubForoCreado=sistema.CrearSubForo("SubForo MP");
                if(SubForoCreado){
                    System.out.println("El SubForo 'SubForo MP' ha sido creado con éxito");
                    SubForo SubForoReddit = sistema.verSubForo("SubForo MP");
                    
                    System.out.print("\n");
                    System.out.println("Accedemos a el para añadirle una nueva entrada");
                   
                    Entrada entrada = SubForoReddit.CrearEntrada("Introduccion");
                    TextoPlano Entrada_txt = new TextoPlano("Explicacion","El siguiente subforo"
                            +"se corresponde con la asignatura de MP");
                    entrada.AnadirComponente(Entrada_txt);
                    Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                    System.out.println("El administrador de esta nueva entrada será: "+admin.GetNick());
                    admin.verificarEntrada(entrada,true);
                    
                    System.out.println("Se ha creado una entrada con texto plano, que se ha añadido tras ser verificada"
                            + "al SubForo Mp");
                    
                    Encuesta Entrada_encuesta = new Encuesta("ENCUESTA ENTREGA PRÁCTICA","¿Te parece bien la entrega de la practica?");
                    Entrada_encuesta.SetRespuesta("SI");
                    Entrada_encuesta.SetRespuesta("NO");
                    
                    System.out.print("\n");
                    System.out.println("En este momento el administrador, quiere modificar la entrada añadiendole una encuesta");
                    
                    entrada.AnadirComponente(Entrada_encuesta);
                    admin.verificarEntrada(entrada,true);   
                    System.out.println("Hemos verificado la entrada de nuevo, tras haberle añadido la encuesta");
                    
                    System.out.print("\n");
                    System.out.println("La entrada añadida es:");
                    System.out.print("\n");
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
                System.out.print("\n");
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
