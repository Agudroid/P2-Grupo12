/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

/**
 *
 * @author Administrador
 */
public interface Subject {
    
    public void añadirSubscritor(Usuarios sub);
    public void eleminarSubscritor(Usuarios sub);
    public void notificar();
    
}
