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
public class Comentario {
    private String texto;
    private int puntuacion;
    private ArrayList<Comentario> comentarios = new ArrayList<>();
    
    public void comentar(String txt){
        texto = txt;
    }
    
    public void votar(int punt){
        puntuacion = punt;
    }
    
    public ArrayList<Comentario> getComentarios(){
        return comentarios;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
}
