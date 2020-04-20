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

/**
 *
 * @author Administrador
 */


public class BBDDForo {
    
    private List<SubForo> ListaSubForos= new LinkedList<>();
    private File f = new File("BBDDUsuarios");
    
    public BBDDForo(List listaSubForos){
        this.ListaSubForos = listaSubForos;
    }
    
    public void CargarBBDD() throws ClassNotFoundException, IOException{
        if(f.exists()){
            
        
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                SubForo s = (SubForo) ois.readObject();
            }
            catch(IOException e){
                System.out.println(e.getMessage()); 
            }
        }
        else{
            f.createNewFile();
            
        }
        
    }
    
    public void EscribirBBDD()throws IOException{
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            Iterator <SubForo> it = ListaSubForos.iterator() ;
            while(it.hasNext()){
                SubForo subForoActual = it.next();
                oos.writeObject(subForoActual);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
}





