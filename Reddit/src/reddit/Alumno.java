/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;


import java.io.Serializable;
import java.util.Calendar;



/**
 *
 * @author Administrador
 */
public class Alumno extends Usuarios implements Serializable{
    
    private Penalizacion penalizacion=new Penalizacion(null,null);
    public Alumno(String Nombre, String Apellido, String Correo, String Nick, String Contraseña){
        super(Nombre, Apellido, Correo, Nick, Contraseña);
        
    }
    
    public void Penalizar(Calendar FechaFin){
        Calendar FechaIni = Calendar.getInstance();
        penalizacion.setFechaFin(Calendar.getInstance());
        penalizacion.setFechaFin(FechaFin);
    }
    
    public boolean EstaPenalizado(){
        Calendar FechaFin = penalizacion.getFechaFin();
        return FechaFin.after(Calendar.getInstance());
    }  
}
