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
public class Entrada extends EntradaGenerica {
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    private ArrayList<EntradaGenerica> Componentes = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
   esta clase Entrada */
    
    @Override
    public String GetTitulo(){ //con este metodo get coseguiremos lo guardado en la variable Titulo
        return Titulo;
    }
    
    @Override
    public void SetTitulo(String titulo){ //asignará a la variable Titulo el valor que se le pase por parámetro 
        this.Titulo = titulo;
    }

    @Override
    public String GetTexto(){ //con este metodo get coseguiremos lo guardado en la variable Texto
        return Texto;
    }

    @Override
    public void SetTexto(String texto){ //asignará a la variable Texto el valor que se le pase por parámetro 
        this.Texto = texto;
    }

    @Override
    public int GetPuntuacion(){ //con este metodo get coseguiremos lo guardado en la variable Puntuacion
        return Puntuacion;
    }
    
    @Override
    public boolean Votar(int valor){ //permite modificar la variable Puntuacion sumando el valor que se le pase por parámetro 
        this.Puntuacion= Puntuacion+valor;
        return true;
    }

    @Override
    public boolean GetVerificada(){ //con este metodo get coseguiremos el booleano guardado en la variable Verficada
        return Verificada;
    }

    @Override
    public void Verificar(boolean resultado){ //modificará el booleano de la variable Verificada 
        Verificada = resultado;
    }

    @Override
    public boolean Comentar(String texto){ //permitirá crear el comnentario y añadirlo a la lista de comentarios
        Comentario comentario = new Comentario();
        comentario.Comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    }

    public void AñadirComponente (EntradaGenerica comp){ //permitirá añadir al array de Componentes una nuevo tipo de entrada
        Componentes.add(comp);
    }
    
    public void BorrarComponente (EntradaGenerica comp){ //permitirá elimianr del array de componentes aquello que no queramos que aparezca en la entrada
        Componentes.remove(comp);
    }
    
    public ArrayList<EntradaGenerica> GetComponentes(){ //con este metodo get coseguiremos el array de Componentes de la entrada con la que estamos trabajando
        return Componentes;
    }  
}