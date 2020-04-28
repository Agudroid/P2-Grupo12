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
public abstract class EntradaGenerica implements Serializable{
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase EntradaGenerica, que es una clase abstracta de la que hereda Entrada, 
    Encuesta, Ejercicio y TextoPlano.
    Los sihuientes métodos se explicarán en cada clase. */
    
    public abstract String GetTitulo();
    public abstract void SetTitulo(String titulo);
    
    public abstract String GetTexto();
    public abstract void SetTexto(String texto);
    
    public abstract int GetPuntuacion();
    public abstract boolean Votar (int valor);
    
    public abstract boolean GetVerificada();
    public abstract void Verificar(boolean resultado);
    
    public abstract boolean Comentar (String texto);
     
}