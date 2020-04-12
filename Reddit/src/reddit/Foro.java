/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador // Alba Sevillano // miriamdefrancisco
 */
public class Foro {
    
    private static Foro Foro;
    private  String Nombre;
    private List <Usuarios> ListaUsuarios = new LinkedList<>();
    private List <SubForo> ListaSubForo = new LinkedList<>();
    
    boolean Verificado = false;
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    la clase principal del programa, Foro (sistema) */
    
    private Foro(String nombre){
        this.Nombre = nombre;
    }
    
    public static Foro GetForo(String nombre){ //este método nos permitirá crear solo un objeto foro, comprobando si la instancia Foro esta apuntando a null o no
        if (Foro == null){
            Foro = new Foro(nombre);
        }
        return Foro;
    }
    
    public boolean Login (String contraseña, String correo){ //método para que el usuario inicie sesión en la aplicación
        Iterator <Usuarios> it = ListaUsuarios.iterator() ;
        while(it.hasNext() && Verificado==false){ 
        /*mientras haya mas usuarios en la lista, seguiré recorriendola hasta encontrar 
            al que coincida con los daos pasados como parámetros*/
            Usuarios usuarioActual = it.next();
            if (usuarioActual.GetCorreo().equals(correo) && usuarioActual.GetContraseña().equals(contraseña) ) {
            /*si coincide lo que hay en el "usuarioActual" con los parámetros 
                devolvermos un true y un comenatrio*/
                Verificado = true;
                System.out.println("Es correcto.");
            }
        }
        /*tras ese proceso, comprobaremos como se encuentra la variable verificado
            y realizaremos lo oportuno en cada caso*/
        if (Verificado==false) {
            System.out.println("Has escrito mal el correo o la contraseña. Por favor, intentelo de nuevo");
        }
        return Verificado;
    }

    public void RegistrarUsuario (String nombre, String apellido, String correo,String nick, String contraseña){ 
    //la aplicacion debe permitir al usuario que se registre en la aplicación
        Usuarios usuario = new Usuarios(nombre,apellido,correo,nick,contraseña);
        ListaUsuarios.add(usuario);
    }

    public void CargarBBDD_Usuario(File f) throws IOException, ClassNotFoundException{
    /*con este método podremos cargar la información que tenemos en la base de datos del usuario*/
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            Usuarios aux = (Usuarios) ois.readObject();
            /*A continuación mostraremos todos los campos guardados en la base de datos*/
            System.out.println(aux.GetNombre());
            System.out.println(aux.GetApellido());
            System.out.println(aux.GetCorreo());
            System.out.println(aux.GetNick());
            System.out.println(aux.GetContraseña());
        }
        catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }

    public void GuardarBBDD_Uusario(File f)throws IOException{
    /*con este método podremos cargar al nuevo usuario que haya iniciado sesión*/
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            Iterator <Usuarios> it = ListaUsuarios.iterator() ;
            while(it.hasNext()){
                Usuarios usuarioActual = it.next();
                oos.writeObject(usuarioActual);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
        
    public boolean Logout (){ //método que permitirá salir de la aplicación, cerrar sesión
        System.out.println("Se ha desconectado con éxito");
        Verificado = false;
        return Verificado;
        // Despues de esto llamar a los metodos login o registrarse
    }
    
    public boolean CrearSubForo(String nombre){ //permitirá crear un nuevo subforo, que se añadirá al foro
        SubForo f = new SubForo(nombre);
        ListaSubForo.add(f);
        return ListaSubForo.contains(f);
    }
    
}            

        
        
        
        

    
    
    
   
