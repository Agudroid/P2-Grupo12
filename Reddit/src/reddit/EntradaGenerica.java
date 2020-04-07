/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.ArrayList;

/**
 *
 * @author miriamdefrancisco
 */
public abstract class EntradaGenerica {
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    private ArrayList<String> ListaComentarios = new ArrayList<>();
    
    public abstract void getTitulo();
    public abstract void getTexto();
    public abstract int getPuntuacion();
    public abstract void getVerificada();
    public abstract void verificar(boolean resultado);
    public abstract boolean comentar (String texto);
    public abstract boolean votar (int valor);
    
}
