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
   
    public void CargarBBDD(File f) throws IOException{
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Usuarios aux = (Usuarios) ois.readObject();
        System.out.println(aux.getNombre);
        System.out.println(aux.getApellido);
        System.out.println(aux.getCorreo);
        System.out.println(aux.getNick);
        System.out.println(aux.getContraseña);
        System.out.println("");
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
    
    public boolean VerificarUsuario(String Correo,String Contrasena){
        
        
        return UsuarioEncontrado(Correo) && ContrasenaValida(Correo,Contrasena);
    }
    
    private boolean UsuarioEncontrado(String Correo){
        boolean encontrado=false;
        for (int i = 0; i < ListaUsuarios.size(); i++) {
            String correoA=ListaUsuarios.get(i).getCorreo();
            if(correoA.equalsIgnoreCase(Correo)){
                encontrado=true;
            }
        }
        return encontrado;
    }
    
    private boolean BuscarUsuario(String Correo,String Contrasena){
        return false;
        
    }

    private boolean ContrasenaValida(String Correo, String Contrasena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
