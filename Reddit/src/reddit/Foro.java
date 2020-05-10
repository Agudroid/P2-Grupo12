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
    private static final long SerialVersionUID = 1L;
    private  String Nombre;
    private List <Usuarios> ListaUsuarios = new LinkedList<>();
    private List <SubForo> ListaSubForo = new LinkedList<>();
    boolean Verificado = false;
    Usuarios UsuarioLoggeado = null;
    private static File fichero= new File("basededatos.obj");
    
    //anadimos los getters de las listas para los test
    public List<Usuarios> getListaUsuarios() {
        return ListaUsuarios;
    }

    public List<SubForo> getListaSubForo() {
        return ListaSubForo;
    }

    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    la clase principal del programa, Foro (sistema) */
    
    private Foro(String nombre) throws ClassNotFoundException, IOException{ //Constructor de foro
        this.Nombre = nombre;
    }
    
    public void AvanzarDias(int dias){ //Funcion creada para poder acabar antes las penalizaciones que se le pongan a los usuarios
	for(Usuarios u: ListaUsuarios){
            u.AvanzarDias(dias);
	}
    }
    
    public Usuarios  GetUsuarioActual(){ //nos permitira saber que usuario es el que ha iniciado sesion
        return UsuarioLoggeado;
    }
    
    public static Foro GetForo(String nombre) throws ClassNotFoundException, IOException{ //este metodo nos permitira crear solo un objeto foro, comprobando si la base de datos esta creada o no esta creada
        if (Foro == null){
            if (fichero.exists()){ 
                Foro = Foro.LeerBBDD();
            }
            else{
                Foro = new Foro(nombre);
            }
        }
        return Foro;
    }
    
    public boolean Login (String contrasena, String correo){ //metodo para que el usuario inicie sesion en la aplicacion
        Iterator <Usuarios> it = ListaUsuarios.iterator() ;
        while(it.hasNext() && Verificado==false){ 
        /*mientras haya mas usuarios en la lista, seguire recorriendola hasta encontrar 
            al que coincida con los daos pasados como parametros*/
            Usuarios usuarioActual = it.next();
            if (usuarioActual.GetCorreo().equals(correo) && usuarioActual.GetContrasena().equals(contrasena))  {
            /*si coincide lo que hay en el "usuarioActual" con los parametros 
                devolvermos un true y un comenatrio*/
                UsuarioLoggeado = usuarioActual;
                Verificado = true;
                for (int i=0;i<UsuarioLoggeado.tamano();i++){
                    if (UsuarioLoggeado.getListaPenalizaciones().get(i).EstaActiva()){
                        Verificado = false;
                    }
                }
            }
        }
        /*tras ese proceso, comprobaremos como se encuentra la variable verificado 
        y realizaremos lo oportuno en cada caso*/
        return Verificado;
    }

    public boolean RegistrarUsuario (String nombre, String apellido, String correo,String nick, String contrasena1, String contrasena2){
    //la aplicacion debe permitir al usuario que se registre en la aplicacion
        String prueba;
        boolean resultado;
        Scanner sc = new Scanner(correo);
        
        prueba = sc.findInLine("([a-z]).([a-z]+).20([0-9][0-9])@alumnos.urjc.es"); //comprobamos que es el patron del correo del alumno
        String prueba2 = sc.findInLine("([a-z]).([a-z]+)@urjc.es"); //comprobamos que es el patron del correo del profesor
        
        boolean alumno = correo.equals(prueba); //comprobamos que es el correo del alumno
        boolean profesor = correo.equals(prueba2); //comprobamos que es el correo del alumno
        resultado = false; //inicializamos la var resultado
        if (alumno==true || profesor ==true){ //si el correo coincide tanto para alumno o profesor entramos en el if
           if (contrasena1.equals(contrasena2)){ //si al registrarse las contrasenas coinciden entras al if
            Usuarios usuario = new Usuarios(nombre,apellido,correo,nick,contrasena1); //te has registrado con exito
            ListaUsuarios.add(usuario); //Se anade a la lista de usuarios registrados
            resultado = true; // resultado pasa a valer true porque se ha registrado con exito
           }
           else{
               System.out.println("Las contrasenas no coinciden. Por favor intentelo de nuevo."); //las contrasenas no coinciden  
           }
        }
        else{
           System.out.println("Has escrito mal el correo. Por favor intentelo de nuevo.");  //el correo no coincide con el de profesor o alumno          
        }
        return resultado;
    }
        
    public boolean Logout () throws ClassNotFoundException, IOException{ //metodo que permitira salir de la aplicacion, cerrar sesion
        Verificado = false;
        EscribirBBDD();
        return Verificado;
        // siempre va a devolver false porque haces logout
    }
    
    //permitira crear un nuevo subforo, que se anadira al foro, comprobando que el usuario que lo crea sea un profesor
    public boolean CrearSubForo(String nombre) throws IOException, ClassNotFoundException{  
        if (UsuarioLoggeado.isProfesor()){
            SubForo subforo = new SubForo(nombre); //creamos un subforo y le pasamos su nombre
            ListaSubForo.add(subforo); //se anade a la lista de subforos
            Foro.EscribirBBDD(); //lo guardamos en la base de datos
             //devolvemos true si se ha guardado con exito y false en caso contrario
            return ListaSubForo.contains(subforo);
        }
        else{
            return false;
        }
    }
    
    //metodo que nos permitira guardar los datos en la base de datos
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
    
    //metodo que nos permitira cargar la informacion de la base de datos
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
    
    public SubForo verSubForo(String nombre){ //metodo necesario para permitir acceder al foro, y verlo
        SubForo subforo = null;
        for (int i = 0; i < ListaSubForo.size(); i++) {
            if (ListaSubForo.get(i).GetTitulo().equals(nombre)){ //si lo hemos encontrado entre todos los foros creados
                subforo = ListaSubForo.get(i);
                subforo.SetUsuarioActual(UsuarioLoggeado);
            }
        }
        return subforo;
    }
}
  
        
        
        
        

    
    
    
   
