package reddit;


import java.io.Serializable;


public class Penalizacion implements Serializable{

    private boolean Activa;
    private int DiasPenalizacion;
    
/* A continuacion se pueden observar los diferentes metodos necesarios para manejar 
esta clase Administrador */
   
	public int GetPenalizacion(){ //con este metodo get coseguiremos lo guardado en la variable DiasPenalización
            return DiasPenalizacion;
        }
        
	public Penalizacion() { //con este metodo activaremso cuando sea necesario una penalización
            DiasPenalizacion = 2;
            Activa = true;
	}
	
	public boolean EstaActiva() { //con este metodo coseguiremos lo guardado en la variable Activa
		return Activa;
	}
	
	public void AvanzarDias(int dias) { //método que nos permitirá avanzar días para favorecer la comprobación de los demostradores
            DiasPenalizacion -= dias;
            if(DiasPenalizacion <= 0) {
                DiasPenalizacion = 0;
		Activa = false;
            }
	}
}
