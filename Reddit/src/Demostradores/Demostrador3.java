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
import reddit.TextoPlano;

/**
 *
 * @author Alba Sevillano
 */
public class Demostrador3 {

    /** (USUARIO PROFESOR) En este demostrador iniciamos sesión con un profesor
     * registrado (el del primer demostrador) y accedemos al foro Reddit, tras 
     * esto se añadirá una nueva entrada a un subforo ya creado, esta entrada 
     * tendrá un componente de tipo texto plano.Finalmente se añadirá a esta 
     * entrada un componente del tipo ejercicio.)
     */
    public static void main(String[] args) throws IOException {
        try {
            //iniciamos el foro
            System.out.println("Vamos a inicializar el foro Reddit URJC");
            Foro sistema = Foro.GetForo("Reddit URJC");
            System.out.print("\n");
            System.out.println("El foro ha sido creado con exito");
            
            //iniciamos sesion con un usuario existente
            System.out.println("Iniciamos sesión en el sistema");
            boolean encontrado = sistema.Login("67890", "a.perez@urjc.es");
            if (encontrado){
                System.out.println("Bienvenido al foro");
                
               //añadimos una entrada y nos suscribimos al SubForo MP
                System.out.print("\n");
                SubForo sf = sistema.verSubForo("SubForo MP");
                System.out.println("Hemos accedido al SubForo MP");
                System.out.print("\n");
                System.out.println("Vamos a añadir una nueva entrada al subforo");
                System.out.print("\n");
                Entrada entrada= sf.CrearEntrada("SEGUNDA ENTRADA");
                TextoPlano Entrada_txt = new TextoPlano("Ejercicio","A continuación veremos un"
                        + "simple ejercicio, para asi probar esta función");
                entrada.AñadirComponente(Entrada_txt);
                
               //creamos un administrador y verificamos la entrada
                Administrador admin = new Administrador("Pedro", "Garcia", "p.garcia@urjc.es", "p.garcia", "cc987");
                System.out.println("El administrador de esta nueva entrada será: "+admin.GetNick());
                admin.verificarEntrada(entrada,true);
                System.out.println("Se ha creado una entrada con texto plano, que se ha añadido tras ser verificada"
                            + "al SubForo Mp");
                
                //creamos un ejercicio de matematicas y lo añadimos a la entrada
                Entrada segundaEntrada = sf.VerEntrada("SEGUNDA ENTRADA");
                Ejercicio ejercicio = new Ejercicio ("Matematicas", "2+2", "4");
                segundaEntrada.AñadirComponente(ejercicio);
                System.out.print("\n");
                System.out.println("Ahora se quiere modificar la entrada, por lo que deberá ser verificada por el "
                        + "administrador");
                admin.verificarEntrada(entrada,true);
                System.out.println("Hemos verificado la entrada de nuevo, tras haberle añadido la encuesta");
                
                System.out.print("\n");
                
                System.out.println("Mostramos la entrada que hemos creado:");
                System.out.print("\n");
                System.out.println(entrada.GetTitulo());
                System.out.println(Entrada_txt.GetTitulo());
                System.out.println(Entrada_txt.GetTexto());
                System.out.println(ejercicio.GetTitulo());
                System.out.println(ejercicio.GetTexto());
                System.out.println(ejercicio.GetSolucion());
            }
            boolean logout = sistema.Logout();
            if(logout==false){
                System.out.print("\n");
                System.out.println("Has cerrado sesion. Hasta pronto");                
            } 
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Demostrador6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
