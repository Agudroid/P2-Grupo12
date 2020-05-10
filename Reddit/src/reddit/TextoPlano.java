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
 * @author Alba Sevillano
 */
public class TextoPlano extends EntradaGenerica implements Serializable{
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada = false;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase TextoPlano */
    
    public TextoPlano(String titulo, String texto){ //constructor de la clase Texto Plano
        this.Titulo= titulo;
        this.Texto = texto;
    }
    
    @Override
    public String GetTitulo(){ //con este metodo get coseguiremos lo guardado en la variable Titulo
        return Titulo;
    }
    
    @Override
    public void SetTitulo(String titulo){ //asignara a la variable Titulo el valor que se le pase por parametro
        this.Titulo= titulo;
    }
    

    public String GetTexto(){ //con este metodo get coseguiremos lo guardado en la variable Texto
        return Texto;
    }
    

    public void SetTexto(String texto){ //asignara a la variable Texto el valor que se le pase por parametro
        this.Texto= texto;
    }
    
    @Override
    public int GetPuntuacion(){ //con este metodo get coseguiremos lo guardado en la variable Puntuacion
        return Puntuacion;
    }
    
    @Override
    public boolean Votar (int valor){ //permite modificar la variable Puntuacion sumando el valor que se le pase por parametro
        this.Puntuacion= Puntuacion+valor;
        return true;
    }
    
    @Override
    public boolean GetVerificada(){ //con este metodo get coseguiremos el booleano guardado en la variable Verficada
        return Verificada;
    }
    
    @Override
    public void Verificar(boolean resultado){ //modificara el booleano de la variable Verificada
        this.Verificada= resultado;
    }
    
    @Override
    public boolean Comentar(String texto) { //permitira crear el comentario y anadirlo a la lista de comentarios
        Comentario comentario = new Comentario();
        comentario.Comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    }
    
    //Hemos incorporado este metodo mas tarde ya que era necesario para los tests
    public ArrayList<Comentario> GetListaComentarios(){
        return ListaComentarios;
    } 
}