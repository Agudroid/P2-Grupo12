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
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    
    public abstract String getTitulo();
    public abstract String getTexto();
    public abstract void setTitulo(String title);
    public abstract void setTexto(String text);
    public abstract int getPuntuacion();
    public abstract boolean getVerificada();
    public abstract void verificar(boolean resultado);
    public abstract boolean comentar (String texto);
    public abstract boolean votar (int valor);
    
}
