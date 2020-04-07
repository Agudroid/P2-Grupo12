/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

/**
 *
 * @author Alba Sevillano
 */
public abstract class Ejercicio extends EntradaGenerica {
    
    private String solucion;
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public void verificar(boolean resultado){
        this.verificada= resultado;
    }
    
    public boolean comentar (String texto);
    public abstract boolean votar (int valor);
}
