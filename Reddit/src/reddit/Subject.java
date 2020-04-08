/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

/**
 *
 * @author miriamdefrancisco
 */
public interface Subject {
    public void añadirSubscriptor(Usuarios subscriptor);
    public void notificar();
     public void eliminarSubscriptor (Usuarios subscriptor);
}
