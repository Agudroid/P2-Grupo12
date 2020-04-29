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
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("12345", "m.defrancisco.2018@alumnos.urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
                SubForo sf  = sistema.verSubForo("SubForo de prueba");
                sf.AñadirSuscriptor();
                Entrada e = sf.CrearEntrada("Prueba1");
                Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                admin.verificarEntrada(e, true);
                Ejercicio en = new Ejercicio("Ejercicio", "1+1 ", "= 2");
                boolean posible = e.AñadirComponente(en);
                if (!posible){
                    System.out.println("No puedes añadir un ejercicio siendo un alumno");
                }
                Entrada e2 = sf.verEntrada("Segunda entrada");
                e2.Votar(1);
                System.out.println("La entrada tiene de valoración: "+e2.GetPuntuacion());                
            }
            boolean logout = sistema.Logout();
            if(logout==false){
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
