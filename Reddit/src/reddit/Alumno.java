/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.sql.Date;
import java.util.Calendar;



/**
 *
 * @author Administrador
 */
public class Alumno extends Usuarios{
    
    private boolean EstaPenalizado;
    public Alumno(String Nombre, String Apellido, String Correo, String Nick, String Contraseña ,boolean estaPenalizado) {
        super(Nombre, Apellido, Correo, Nick, Contraseña);
        this.EstaPenalizado=estaPenalizado;
    }
    
    public void penalizar(Calendar FechaFin){
        Calendar fecha = Calendar.getInstance();
        
        EstaPenalizado=fecha.compareTo(FechaFin)<0 || fecha.compareTo(FechaFin)==0 ;
  
        
    }
    
    public boolean estaPenalizado(){
        
        return EstaPenalizado;
    }
    
    
    
}
