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

/**
 *
 * @author Administrador
 */
public class BBDDUsuarios implements Serializable{
    
    private List <Usuarios> ListaUsuarios = new LinkedList<>();

    public BBDDUsuarios(List<Usuarios> usuarios) {
        this.ListaUsuarios = usuarios;
    }
    
    public void AñadirUsuario(Usuarios u){
        ListaUsuarios.add(u);
    }
   
    public void CargarBBDD(File f) throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
            Usuarios aux = (Usuarios) ois.readObject();
            System.out.println(aux.GetNombre());
            System.out.println(aux.GetApellido());
            System.out.println(aux.GetCorreo());
            System.out.println(aux.GetNick());
            System.out.println(aux.GetContraseña());
            System.out.println("");
        }
        catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
    
    public void EscribirBBDD(File f)throws IOException{
        try{
           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
           Iterator <Usuarios> it = ListaUsuarios.iterator() ;
           while(it.hasNext()){
           Usuarios usuarioActual = it.next();
           oos.writeObject(usuarioActual);
           }
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
    
    public boolean Verificar (String contraseña, String correo){
        boolean verificado = false;
        Iterator <Usuarios> it = ListaUsuarios.iterator() ;
           while(it.hasNext() && verificado==false){
           Usuarios usuarioActual = it.next();
               if (usuarioActual.GetCorreo().equals(correo) && usuarioActual.GetContraseña().equals(contraseña)){
                 verificado = true;
                   System.out.println("Es correcto.");
               }
           }
           if (verificado==false) {
                   System.out.println("Has escrito maL el correo o la contraseña. Por favor, intentelo de nuevo");
           }
        return verificado;
    }
}