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
public class TextoPlano extends EntradaGenerica{
    
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    
    @Override
    public String getTitulo(){
        return titulo;
    }
    
    @Override
    public String getTexto(){
        return texto;
    }
    
    @Override
    public void setTitulo(String titulo){
        this.titulo= titulo;
    }
    
    @Override
    public void setTexto(String texto){
        this.texto= texto;
    }
    
    @Override
    public int getPuntuacion(){
        return puntuacion;
    }
    
    @Override
    public boolean getVerificada(){
        return verificada;
    }
    
    @Override
    public void verificar(boolean resultado){
        this.verificada= resultado;
    }
    
    @Override
    public boolean comentar(String texto) {
        Comentario comentario = new Comentario();
        comentario.comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    }
    
    @Override
    public boolean votar (int valor){
        this.puntuacion= puntuacion+valor;
        return true;
    }
    
}
