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

    public BBDDUsuarios(List<Usuarios> Usuarios) {
        this.ListaUsuarios=Usuarios;
    }
    
    public void añadirLista(Usuarios u){
        ListaUsuarios.add(u);
    }
   
    public void CargarBBDD(File f) throws IOException, ClassNotFoundException{
        try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
        Usuarios aux = (Usuarios) ois.readObject();
        System.out.println(aux.getNombre());
        System.out.println(aux.getApellido());
        System.out.println(aux.getCorreo());
        System.out.println(aux.getNick());
        System.out.println(aux.getContraseña());
        System.out.println("");
        }catch(IOException e){
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
               if (usuarioActual.getCorreo().equals(correo) && usuarioActual.getContraseña().equals(contraseña) ) {
                 verificado = true;
                   System.out.println("Es correcto.");
               }
               if (verificado==false) {
                   System.out.println("Has escrito mas el correo o la contraseña. Por favor, intentelo de nuevo");

               }
           }
        return verificado;
    }
}
