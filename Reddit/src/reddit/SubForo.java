/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.ArrayList;

/**
 *
 * @author Alba Sevillano
 */
public class SubForo implements Subject{
   
    private String titulo;
    private ArrayList<Usuarios> ListaUsuario = new ArrayList<>();
    private ArrayList<Subscritor> Observadores = new ArrayList<>();
    
    
    public void enlazarObservador(Subscritor o){
        Observadores.add(o);
    }

    @Override
    public void añadirSubscritor(Usuarios sub) {
    }

    @Override
    public void eleminarSubscritor(Usuarios sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificar() {
        for(Subscritor o:Observadores){
            o.recibirNotificacion("notificacion nueva");          
        }
    }
}
