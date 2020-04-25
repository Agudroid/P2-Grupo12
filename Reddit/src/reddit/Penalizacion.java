/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit;

import java.util.Calendar;

/**
 *
 * @author Administrador
 */
public class Penalizacion {
    private Calendar FechaIni;
    private Calendar FechaFin;

    public Penalizacion(Calendar FechaIni, Calendar FechaFin) {
        this.FechaIni = FechaIni;
        this.FechaFin = FechaFin;
    }

    public Calendar getFechaIni() {
        return FechaIni;
    }

    public Calendar getFechaFin() {
        return FechaFin;
    }

    public void setFechaIni(Calendar FechaIni) {
        this.FechaIni = FechaIni;
    }

    public void setFechaFin(Calendar FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    
}
