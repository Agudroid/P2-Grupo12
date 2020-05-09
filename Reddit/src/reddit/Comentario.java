/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author miriamdefrancisco
 */
public class Comentario implements Serializable{
    
    private String Texto;
    private int Puntuacion;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
 
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase Comentario */
    
    public String GetTexto(){ //con este metodo get coseguiremos lo guardado en la variable texto
        return Texto;
    }
    
    public void Comentar(String texto){ //asignara a la variable Texto el valor que se le pase por parametro
        this.Texto=texto;
    }
    public ArrayList<Comentario> GetComentarios(){ //con este metodo get coseguiremos la lista de comentarios
        return ListaComentarios;
    }
    
    public int GetPuntuacion(){ //con este metodo get coseguiremos lo guardado en la variable puntuacion
        return Puntuacion;
    }
    
    public void Votar(int puntuacion){ //anadira a la variable puntuacion el valor que se le pase
        this.Puntuacion += puntuacion;
    }  
}