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
import reddit.TextoPlano;
import reddit.Usuarios;
/**
 *
 * 
 * @author miriamdefrancisco
 */
public class Demostrador4 {
    /**(USUARIO ALUMNO). En este demostrador, se intenta iniciar sesion de manera
     * fallida y luego se realiza el proceso de registro de ese usuario, un 
     * alumno. Despues podremos ver una entrada y comentarla. 
     * Haemos logout con el alumno, y acto seguido, se inicia sesion con un profesor
     * intentara crear una entrada, pero esta no sera verificada por el administrador 
     * por lo que se penalizara al autor de la entrada. Intentaremos iniciar sesion 
     * con el usuario penalizado, pero no sera posible, tras el avance de unos 
     * dias comprobaremos que puede volver a hacer login en el foro.*/
    
    public static void main(String[] args) throws IOException {
        try {
            
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            System.out.println("El foro ha sido inicializado");
            System.out.print("\n");
            System.out.println("Iniciamos sesión en el sistema");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es");
            
            if (!encontrado){
                System.out.print("\n");
                System.out.println("Error, la contrasena y/o correo no coinciden");
                System.out.println("Vamos a registrarnos en el sistema");
                boolean esRegistrado = sistema.RegistrarUsuario("Miriam","de Francisco","m.defrancisco.2018@alumnos.urjc.es","miri.fa","12345", "12345");
                if(esRegistrado == true){
                    System.out.print("\n");
                    System.out.println("Se ha registrado con exito");
                }
            } 
            System.out.println("Vamos a visualizar una entrada ya creada y subscribirnos a un foro");
            SubForo sf = sistema.verSubForo("SubForo MP");
            sf.AnadirSuscriptor();
            System.out.print("\n");
            System.out.println("se ha subscrito con exito");
            Entrada ent = sf.VerEntrada("Introduccion");
            System.out.print("\n");
            ent.Comentar("Muchas gracias por la informacion aportada!!!");
            System.out.println("Se ha comentado con exito");
            
            boolean logout = sistema.Logout();
                if(logout==false){
                    System.out.print("\n");
                    System.out.println("Has cerrado sesion. Hasta pronto");                
                }
            System.out.print("\n");
            System.out.print("\n");
            
            
            System.out.println("Vamos a iniciar sesion con otro usuario y crearemos una entrada "+
                    "que va a ser penalizada");
            encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.print("\n");
                System.out.println("Se ha iniciado sesion con exito");
                SubForo SubForoReddit = sistema.verSubForo("SubForo MP");
                Entrada entrada = SubForoReddit.CrearEntrada("Entrada penalizada");
                TextoPlano Entrada_txt = new TextoPlano("Explicacion","Esta entrada"
                +"es para probar la penalizacion");
                entrada.AnadirComponente(Entrada_txt);
                System.out.print("\n");
                System.out.println("se ha creado la entrada con exito, ahora vamos a verificarla");
                Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                System.out.println("El administrador de esta nueva entrada sera: "+admin.GetNick());
                admin.verificarEntrada(entrada,false);
                System.out.print("\n");
                System.out.println("la entrada ha sido finalizada");
                
                logout = sistema.Logout();
                if(logout==false){
                    System.out.print("\n");
                    System.out.println("Has cerrado sesion. Hasta pronto");                
                }
            }
            System.out.print("\n");
            System.out.println("Intentamos acceder al sistema con el usuario penalizado");
            encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.println("Estas penalizado, no puedes acceder al foro");
                System.out.print("\n");
            }
            System.out.println("Avanzamos 4 dias e intentamos acceder de nuevo");
            sistema.AvanzarDias(4);
            encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (!encontrado){
                System.out.print("\n");
                System.out.println("Estas penalizado, no puedes acceder al foro");
            }else{
                System.out.print("\n");
                System.out.println("Se ha iniciado sesion con exito");
                
                logout = sistema.Logout();
                if(logout==false){
                    System.out.print("\n");
                    System.out.println("Has cerrado sesion. Hasta pronto");                
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador4.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            
    }   
}
