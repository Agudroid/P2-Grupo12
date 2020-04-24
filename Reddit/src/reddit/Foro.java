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
    private BBDDForo foro = new BBDDForo(ListaSubForo);
    boolean Verificado = false;
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    la clase principal del programa, Foro (sistema) */
    
    private Foro(String nombre) throws ClassNotFoundException, IOException{
        this.Nombre = nombre;
        foro.CargarBBDD();
    }
    
    public static Foro GetForo(String nombre) throws ClassNotFoundException, IOException{ //este método nos permitirá crear solo un objeto foro, comprobando si la instancia Foro esta apuntando a null o no
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
            }
        }
        /*tras ese proceso, comprobaremos como se encuentra la variable verificado
            y realizaremos lo oportuno en cada caso*/
        return Verificado;
    }

    public boolean RegistrarUsuario (String nombre, String apellido, String correo,String nick, String contraseña1, String contraseña2){
    //la aplicacion debe permitir al usuario que se registre en la aplicación
        String prueba;
        boolean resultado;
        Scanner sc = new Scanner(correo);
        prueba = sc.findInLine("([a-z]).([a-z]+)20([0-9][0-9])@alumnos.urjc.es");
        String prueba2 = sc.findInLine("([a-z]).([a-z]+)@urjc.es");
        boolean alumno = correo.equals(prueba);
        boolean profesor = correo.equals(prueba2);
        resultado = false;
        if (alumno==true || profesor ==true){
           if (contraseña1.equals(contraseña2)){
            Usuarios usuario = new Usuarios(nombre,apellido,correo,nick,contraseña1);
            ListaUsuarios.add(usuario); 
            resultado = true;
           }
           else{
               System.out.println("Las contraseñas no coinciden. Por favor intentelo de nuevo.");  
           }
        }
        else{
           System.out.println("Has escrito mal el correo. Por favor intentelo de nuevo.");         
           
        }
        return resultado;
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
        Verificado = false;
        return Verificado;
        // Despues de esto llamar a los metodos login o registrarse
    }
    
    public boolean CrearSubForo(String nombre) throws IOException{ //permitirá crear un nuevo subforo, que se añadirá al foro
        SubForo f = new SubForo(nombre);
        ListaSubForo.add(f);
        foro.EscribirBBDD();
        return ListaSubForo.contains(f);
    }
    
}  
        
        
        
        

    
    
    
   
