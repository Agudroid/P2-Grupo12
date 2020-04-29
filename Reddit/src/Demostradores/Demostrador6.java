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

    /** En este demostrador iniciamos sesión con un alumno registrado y entraremos
     en el foro, y tras esto podremos añadir una entrada al subforo creado
     (ALUMNO)*/
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado."); //se ha cargado el Foro con exito
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es"); // si el usuario esta registrado y escribe bien el correo y la contraseña se guarda true
            if (encontrado){ // existe el usuario
                System.out.println("Bienvenido al foro");
                SubForo sf  = sistema.verSubForo("SubForo MP"); //accedemos al subforo "SubForo MP"
                sf.AñadirSuscriptor(); // el usuario loggeado se suscribe al subforo
                Entrada e = sf.CrearEntrada("Ejercicio de Matemáticas"); // creamos una entrada con su titulo
                Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987"); //creamos un administrador para verificar la entrada
                admin.verificarEntrada(e, true); // El administrador acepta la entrada
                Ejercicio en = new Ejercicio("Ejercicio", "1+1 ", "= 2"); // Introducimos el titulo, el enunciado y la solucion  
                boolean posible = e.AñadirComponente(en); //si tienes autorizacion para añadir el componente, se guarda true, en caso contrario se guarda false
                if (!posible){
                    System.out.println("No puedes añadir un ejercicio siendo un alumno."); //solo los profesores pueden crear ejercicios
                }
                Entrada e2 = sf.verEntrada("Segunda entrada"); //accedemos a "Segunda entrada" 
                e2.Votar(1);
                System.out.println("La entrada tiene de valoración: "+e2.GetPuntuacion()); //mostramos la valoracion de "Segunda entrada"               
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
