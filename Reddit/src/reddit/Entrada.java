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
public class Entrada extends EntradaGenerica implements Serializable{
    private Usuarios Autor;
    private String Titulo = "";
    private int Puntuacion = 0;
    boolean Verificada = false;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    private ArrayList<EntradaGenerica> Componentes = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
   esta clase Entrada */
    
    //Hemos incorporado este método más tarde ya que era necesario para los tests
    public ArrayList<Comentario> GetListaComentarios(){
        return ListaComentarios;
    } 
    
    public Entrada (String titulo, Usuarios autor){ //Constructor de la clase Entrada
        this.Titulo = titulo;
        this.Autor = autor;
    }
    public Usuarios GetAutor(){ //con este metodo get conseguiremos el nombre del usurario que crea la entrada
        return Autor;
    }

    public String GetTitulo(){ //con este metodo get coseguiremos lo guardado en la variable Titulo
        return Titulo;
    }
    
    @Override
    public void SetTitulo(String titulo){ //asignará a la variable Titulo el valor que se le pase por parámetro 
        this.Titulo = titulo;
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

    //permitirá añadir al array de Componentes una nuevo tipo de entrada, comprobando que el usurio pueda o no crearla
    public boolean AnadirComponente (EntradaGenerica componente){ 
        boolean esposible = false;
        if ((Autor.isProfesor()) && ((componente instanceof Ejercicio) || (componente instanceof Encuesta))){
            Componentes.add(componente);
            esposible = true;
        }
        else if (componente instanceof TextoPlano){
            Componentes.add(componente);
            esposible = true;
        }
        return esposible;
    }
    
    public void BorrarComponente (EntradaGenerica comp){ //permitirá eliminar del array de componentes aquello que no queramos que aparezca en la entrada
        Componentes.remove(comp);
    }
    
    public ArrayList<EntradaGenerica> GetComponentes(){ //con este metodo get coseguiremos el array de Componentes de la entrada con la que estamos trabajando
        return Componentes;
    }  
}
