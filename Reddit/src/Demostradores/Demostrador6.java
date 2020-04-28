/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            }
            
            SubForo sf  = sistema.verSubForo("SubForo de prueba");
            Usuarios u = sistema.getUsuarioActual();
            sf.setUsuarioActual(u);
            sf.CrearEntrada("Prueba1", "esto es una pruebaaaaa");
            Entrada e = sf.verEntrada("esto es una pruebaaaaa");
            sf.AñadirSuscriptor();
            Ejercicio en = new Ejercicio("Ejercicio", "es una prueba", 10, true, "=2");
            sf.añadirComponente(en, e);
            
            boolean logout = sistema.Logout();
            if(logout==false){
                System.out.println("Has cerrado sesion. Hasta pronto");                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
