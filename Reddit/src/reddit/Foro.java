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
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador // Alba Sevillano // miriamdefrancisco
 */
public class Foro implements Serializable{
    
    private static Foro Foro;
    private static final long SerialVersionUID=1L;
    private  String Nombre;
    private List <Usuarios> ListaUsuarios = new LinkedList<>();
    private List <SubForo> ListaSubForo = new LinkedList<>();
    boolean Verificado = false;
    Usuarios usuarioLoggeado = null;
    private static File f= new File("basededatos.obj");
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    la clase principal del programa, Foro (sistema) */
    
    private Foro(String nombre) throws ClassNotFoundException, IOException{
        this.Nombre = nombre;
    }
    
    public Usuarios  getUsuarioActual(){
        return usuarioLoggeado;
    }
    
    public static Foro GetForo(String nombre) throws ClassNotFoundException, IOException{ //este método nos permitirá crear solo un objeto foro, comprobando si la instancia Foro esta apuntando a null o no
        if (Foro == null){
            if (f.exists()){ 
                Foro = Foro.LeerBBDD();
            }
            else{
                Foro = new Foro(nombre);
            }
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
                usuarioLoggeado = usuarioActual;
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
        prueba = sc.findInLine("([a-z]).([a-z]+).20([0-9][0-9])@alumnos.urjc.es"); //comprobamos que es el patron del correo del alumno
        String prueba2 = sc.findInLine("([a-z]).([a-z]+)@urjc.es"); //comprobamos que es el patron del correo del profesor
        boolean alumno = correo.equals(prueba); //comprobamos que es el correo del alumno
        boolean profesor = correo.equals(prueba2); //comprobamos que es el correo del alumno
        resultado = false; //inicializamos la var resultado
        if (alumno==true || profesor ==true){ //si el correo coincide tanto para alumno o profesor entramos en el if
           if (contraseña1.equals(contraseña2)){ //si al registrarse las contraseñas coinciden entras al if
            Usuarios usuario = new Usuarios(nombre,apellido,correo,nick,contraseña1); //te has registrado con exito
            ListaUsuarios.add(usuario); //Se añade a la lista de usuarios registrados
            resultado = true; // resultado pasa a valer true porque se ha registrado con exito
           }
           else{
               System.out.println("Las contraseñas no coinciden. Por favor intentelo de nuevo."); //las contraseñas no coinciden  
           }
        }
        else{
           System.out.println("Has escrito mal el correo. Por favor intentelo de nuevo.");  //el correo no coincide con el de profesor o alumno        
           
        }
        return resultado;
    }
        
    public boolean Logout () throws ClassNotFoundException, IOException{ //método que permitirá salir de la aplicación, cerrar sesión
        Verificado = false;
        EscribirBBDD();
        return Verificado;
// siempre va a devolver false porque haces logout
        // Despues de esto llamar a los metodos login o registrarse
    }
    
    public boolean CrearSubForo(String nombre) throws IOException, ClassNotFoundException{ //permitirá crear un nuevo subforo, que se añadirá al foro
        if (usuarioLoggeado.isProfesor()){
            SubForo f = new SubForo(nombre); //creamos un subforo y le pasamos su nombre
            ListaSubForo.add(f); //se añade a la lista de subforors
            Foro.EscribirBBDD(); //lo guardamos en la base de datos
             //devolvemos true si se ha guardado con exito y false en caso contrario
            return ListaSubForo.contains(f);
        }
        else{
            return false;
        }
    }
    
    public boolean EscribirBBDD() throws ClassNotFoundException, IOException{      
        
            try{
                FileOutputStream file = new FileOutputStream("basededatos.obj");
                ObjectOutputStream finalFile = new ObjectOutputStream(file);
                finalFile.writeObject(this);
                finalFile.close();
                file.close();
                return true;
            }
            catch(IOException e){
                return false; 
            }       
    }
    
    public static Foro LeerBBDD() throws ClassNotFoundException{
        Foro foroCargado=null;
        try{
            
            FileInputStream file = new FileInputStream("basededatos.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            foroCargado = (Foro) inputFile.readObject();
            inputFile.close();
            file.close();
            
            
        }
        catch(IOException e){
            System.out.println(e.getMessage()); 
        }
        
        return foroCargado;
        
    }
    
    public SubForo verSubForo(String nombre){
        SubForo sf = null;
        for (int i = 0; i < ListaSubForo.size(); i++) {
            if (ListaSubForo.get(i).getTitulo().equals(nombre)){
                sf = ListaSubForo.get(i);
                sf.setUsuarioActual(usuarioLoggeado);
            }
        }
        return sf;
    }
}
  
        
        
        
        

    
    
    
   
