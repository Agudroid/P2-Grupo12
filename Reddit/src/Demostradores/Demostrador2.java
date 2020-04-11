/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demostradores;

import reddit.Foro;

/**
 *
 * @author miriamdefrancisco
 */
public class Demostrador2 {
    /**En este demostrador iniciamos sesión con un usuario ya registrado y
     comentamos y votamos una entrada ya existente de manera correcta*/
    public static void main(String[] args){
            System.out.println("Inicializamos el foro:");
            Foro sistema = Foro.getForo("Reddit URJC");
            System.out.println("El foro ha sido creado.");
            System.out.println("Iniciamos sesión en el sistema con un usuario registrado");
            boolean encontrado = sistema.login("12345", "m.d.2018@alumnos.urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
            } else {
                System.out.println("Error, la contraseña y/o correo no coinciden");
            }
            System.out.println("Vamos a acceder a un subforo");         
    }   
}
