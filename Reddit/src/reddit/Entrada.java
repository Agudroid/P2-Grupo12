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
    private int puntuacion;
    private String titulo;
    private String texto;
    boolean verificada;
    private ArrayList<Comentario> ListaComentarios = new ArrayList<>();
    private ArrayList<EntradaGenerica> componentes = new ArrayList<>();

    @Override
    public String getTitulo() {
        return titulo;
        System.out.println("hOLAAAAAAAAAAAAAAA");
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
    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public boolean getVerificada() {
        return verificada;
    }

    @Override
    public void verificar(boolean resultado) {
        verificada = resultado;
    }

    @Override
    public boolean comentar(String texto) {
        Comentario comentario = new Comentario();
        comentario.comentar(texto);
        ListaComentarios.add(comentario);
        return true;
    }

    @Override
    public boolean votar(int valor) {
        this.puntuacion= puntuacion+valor;
        return true;
    }
    
    public void añadirComponente (EntradaGenerica comp){
        componentes.add(comp);
    }
    
    public void borrarComponente (EntradaGenerica comp){
        componentes.remove(comp);
    }
    
    public ArrayList<EntradaGenerica> getComponentes(){
        return componentes;
    }
    
}
