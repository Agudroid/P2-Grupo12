
package reddit;

import java.util.ArrayList;

public class Encuesta extends EntradaGenerica{
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    private ArrayList<String> respuestas = new ArrayList<>();

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }
    
    @Override
    public void verificar(boolean resultado) {
        verificada = resultado;
    }

    @Override
    public boolean comentar(String texto) {
        return true;
    }

    @Override
    public boolean votar(int valor) {
        puntuacion = valor;
        return true;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public void setTitulo(String title) {
        titulo = title;
    }

    @Override
    public void setTexto(String text) {
        texto = text;
    }

    @Override
    public boolean getVerificada() {
        return verificada;
    }
   
    
}
