/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.Calendar;

/**
 *
 * @author adri-
 */
public class Penalizacion {
    
    private Calendar FechaIni;

    public Calendar getFechaIni() {
        return FechaIni;
    }

    public Calendar getFechaFin() {
        return FechaFin;
    }
    private Calendar FechaFin;
    
    public Penalizacion(){
        this.FechaIni=Calendar.getInstance();
        FechaFin=FechaIni;
        FechaFin.add(Calendar.DAY_OF_MONTH, 2);
    }
    
    public void FechaDePenalizacion(){
        Calendar FechaIni = Calendar.getInstance();
        FechaIni.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println("La fecha del fin de la penalizacion es: "+FechaIni.getTime());
    }
    
    public Calendar setFechaDePenalizacion (){
        return FechaIni;
    }
}
