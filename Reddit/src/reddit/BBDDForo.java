/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class BBDDForo {
    
    private List<SubForo> ListaSubForos= new LinkedList<>();
    
    public BBDDForo(List ListaSubForos){
        this.ListaSubForos=ListaSubForos;
    }
    
    public void AñadirSubForo(SubForo f){
        ListaSubForos.add(f);
    }
    
    public void CargarBBDD(File f) throws ClassNotFoundException{
    try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        SubForo s = (SubForo) ois.readObject();
        
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
}