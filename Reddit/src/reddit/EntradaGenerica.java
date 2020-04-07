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
public abstract class EntradaGenerica {
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    
    public abstract int getPuntuacion();
    public abstract void verificar(boolean resultado);
    public abstract boolean comentar (String texto);
    public abstract boolean votar (int valor);
    sdfgb
    
}
