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
public class Ejercicio extends EntradaGenerica {
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada;
    private String Solucion;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase Ejercicio */
    
    @Override
    public String GetTitulo(){ //con este metodo get coseguiremos lo guardado en la variable Titulo
        return Titulo;
    }
    
    @Override
    public void SetTitulo(String titulo){ //asignará a la variable Titulo el valor que se le pase por parámetro
        this.Titulo= titulo;
    }
    
    @Override
    public String GetTexto(){ //con este metodo get coseguiremos lo guardado en la variable Texto
        return Texto;
    }
    
    @Override
    public void SetTexto(String texto){ //asignará a la variable Texto el valor que se le pase por parámetro
        this.Texto= texto;
    }
    
    @Override
    public int GetPuntuacion(){ //con este metodo get coseguiremos lo guardado en la variable Puntuacion
        return Puntuacion;
    }
    
    @Override
    public boolean Votar (int valor){ //permite modificar la variable Puntuación sumandole el valor que se le pase
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
    
    public void SetSolucion(String solucion){ //asignará a la variable Solucion el valor que se le pase
        this.Solucion= solucion;
    }
    
    @Override
    public boolean Comentar(String texto) { //nos permitirá comentar el ejercicio, permitiendo llamar a los métodos de la clase Comentario         
        Comentario comentario = new Comentario();
        comentario.Comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    } 
}