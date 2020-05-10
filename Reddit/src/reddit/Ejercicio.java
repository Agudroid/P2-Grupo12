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
public class Ejercicio extends EntradaGenerica implements Serializable{
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada = false;
    private String Solucion;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase Ejercicio */
    //Hemos incorporado este metodo mas tarde ya que era necesario para los tests
    public ArrayList<Comentario> GetListaComentarios(){
        return ListaComentarios;
    } 
    
    public Ejercicio (String titulo, String texto, String solucion){  //Constructor de la clase Ejercicio
        this.Titulo = titulo;
        this.Texto = texto;
        this.Solucion = solucion;  
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
    public boolean Votar (int valor){ //permite modificar la variable Puntuacion sumandole el valor que se le pase
        this.Puntuacion= Puntuacion+valor;
        return true;
    }
    
    @Override
    public boolean GetVerificada(){ //con este metodo get coseguiremos lo guardado en la variable Verificada
        return Verificada;
    }
    
    @Override
    public void Verificar(boolean resultado){ //nos permitira modificar el booleano que tenemos en Verificada 
        this.Verificada= resultado;
    }
    
    public String GetSolucion(){ //con este metodo get coseguiremos lo guardado en la variable Solucion
        return Solucion;
    }
    
    public void SetSolucion(String solucion){ //asignara a la variable Solucion el valor que se le pase
        this.Solucion= solucion;
    }
    
    @Override
    public boolean Comentar(String texto) { //nos permitira comentar el ejercicio, permitiendo llamar a los metodos de la clase Comentario         
        Comentario comentario = new Comentario();
        comentario.Comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    } 
}
