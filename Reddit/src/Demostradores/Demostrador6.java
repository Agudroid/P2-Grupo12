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
import reddit.Ejercicio;
import reddit.Entrada;
import reddit.Foro;
import reddit.SubForo;
import reddit.Usuarios;

/**
 *
 * @author Alba Sevillano
 */
public class Demostrador6 {

    /** (USUARIO ALUMNO) En este demostrador iniciamos sesion con un alumno 
     * registrado (el del demostrador 1) y entraremos en el foro, tras esto 
     * intentaremos anadir una entrada al subforo creado, pero con un tipo de 
     * componente que no puede crear el alumno, por lo que se devolvera un mensaje 
     * advirtiendo de este fallo.En este demostrador, tambien se probara a votar 
     * una entrada del subforo.*/
    
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            
            System.out.println("El foro se abrio con exito"); //se ha abierto el Foro con exito
            System.out.println("Iniciamos sesion en el sistema");
            System.out.print("\n");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es"); // si el usuario esta registrado y escribe bien el correo y la contrasena se guarda true
            
            if (encontrado){ // existe el usuario
                System.out.println("Bienvenido al foro");
                
                SubForo sf  = sistema.verSubForo("SubForo MP"); //accedemos al subforo "SubForo MP"
                System.out.println("Hemos accedido al SubForo MP");
                
                sf.AnadirSuscriptor(); // el usuario loggeado se suscribe al subforo
                
                System.out.println("Vamos a anadir una nueva entrada al subforo");
                System.out.print("\n");
                Entrada entrada = sf.CrearEntrada("Ejercicio de Matematicas"); // creamos una entrada con su titulo
                Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987"); //creamos un administrador para verificar la entrada
                System.out.println("El administrador de esta nueva entrada sera: "+admin.GetNick());
                admin.verificarEntrada(entrada, true); // El administrador acepta la entrada
                System.out.println("Se ha creado una entrada con texto plano, que se ha anadido tras ser verificada"
                            + "al SubForo Mp");
                
                System.out.print("\n");
                System.out.println("Ahora el alumno, quiere anadir un ejercicio"
                        + "entrada que no puede crear");
                System.out.print("\n");
                Ejercicio en = new Ejercicio("Ejercicio", "1+1 ", "= 2"); // Introducimos el titulo, el enunciado y la solucion
                
                boolean posible = entrada.AnadirComponente(en); //si tienes autorizacion para anadir el componente, se guarda true, en caso contrario se guarda false
                if (!posible){
                    System.out.println("No puedes anadir un ejercicio siendo un alumno"); //solo los profesores pueden crear ejercicios
                }
                System.out.print("\n");
                System.out.println("Ahora va a votar la segunda entrada");
                Entrada e2 = sf.VerEntrada("SEGUNDA ENTRADA"); //accedemos a "Segunda entrada" 
                e2.Votar(1);
                System.out.println("La entrada tiene una valoracion de: "+e2.GetPuntuacion()); //mostramos la valoracion de "Segunda entrada"               
                System.out.print("\n");
            }
            boolean logout = sistema.Logout();
            if(logout==false){ // si en la var logout se guarda un false, es decir, se hace logout correctamente, entra en el if
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
