package reddit;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Alba Sevillano // miriamdefrancisco
 */
public class Encuesta extends EntradaGenerica implements Serializable{
    
    private String Titulo;
    private String Texto;
    private int Puntuacion;
    boolean Verificada = false;
    private ArrayList<String> Respuestas = new ArrayList<>();
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();

/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
    esta clase Encuesta */
    //Hemos incorporado este metodo mas tarde ya que era necesario para los tests
    public ArrayList<Comentario> GetListaComentarios(){
        return ListaComentarios;
    } 
    
    public Encuesta (String titulo, String texto){ //Constructor de la clase Encuesta 
        this.Titulo = titulo;
        this.Texto = texto;
    }
    
    @Override
    public String GetTitulo(){ //con este metodo get coseguiremos lo guardado en la variable Titulo
        return Titulo;
    }
    
    @Override
    public void SetTitulo(String title){ //asignara a la variable Titulo el valor que se le pase por parametro
        this.Titulo = title;
    }
    

    public String GetTexto(){ //con este metodo get coseguiremos lo guardado en la variable Texto
        return Texto;
    }


    public void SetTexto(String text){ //asignara a la variable Texto el valor que se le pase por parametro
        this.Texto = text;
    }
    
    @Override
    public int GetPuntuacion(){ //con este metodo get coseguiremos lo guardado en la variable Puntuacion
        return Puntuacion;
    }
    
    @Override
    public boolean Votar(int valor){ //modificar la variable Puntuacion sumandole el valor que se le pase por parámetro
        Puntuacion += valor;
        return true;
    }
    
    @Override
    public boolean GetVerificada(){ //con este metodo get coseguiremos el booleano de la variable Verificada
        return Verificada;
    }
    
    @Override
    public void Verificar(boolean resultado){ //modificara el booleano de la variable Verificada
        Verificada = resultado;
    }
    
    public ArrayList<String> GetRespuestas(){ //con este metodo get coseguiremos el array de Respuestas
        return Respuestas;
    }
    
    public void SetRespuesta(String respuesta){ //permitira anadir al array de respuestas una nueva propuesta como respuesta 
        Respuestas.add(respuesta);
    }
    
    @Override
    public boolean Comentar(String texto){ //permitira crear el comentario y anadirlo a la lista de comentarios
        Comentario comment = new Comentario();
        comment.Comentar(texto);
        ListaComentarios.add(comment);
        return true;
    }
}