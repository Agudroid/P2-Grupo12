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
import reddit.EntradaGenerica;
import reddit.Foro;
import reddit.SubForo;

/**
 *
 * @author Alba Sevillano
 */
public class Demostrador3 {

    /** En este demostrador iniciamos sesión con un profesor registrado y entraremos
     en el foro, y tras esto se añadirá una entrada a un subforo ya creado, y se 
     penalizará a un alumno
     (PROFESOR)
     */
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            }
            System.out.println("Vamos a visualizar una entrada ya creada y subscribirnos a un foro");
            SubForo sf = sistema.verSubForo("SubForo de prueba");
            System.out.println("SubForo encontrado");
            System.out.println("Vamos a añadir una nueva entrada al subforo");
            Entrada entrada= sf.CrearEntrada("Segunda entrada", "creación de la segunda mejor entrada");
            Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
            System.out.println("Administrador creado");
            System.out.println("Vamos a verificar la entrada, para poder mostrarla");
            admin.verificarEntrada(entrada);
            System.out.println("Entrada verificada");
            Entrada segundaEntrada = sf.verEntrada("Segunda entrada");
            Ejercicio ejercicio = new Ejercicio ("Matematicas", "2+2", "4");
            sf.añadirComponente(ejercicio, segundaEntrada);
            System.out.println("Vamos a verificar la entrada, para poder mostrarla");
            admin.verificarEntrada(entrada);
            System.out.println("Entrada verificada");
            sistema.Logout();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
