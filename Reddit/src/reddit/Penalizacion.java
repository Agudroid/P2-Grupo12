package reddit;


import java.io.Serializable;


public class Penalizacion implements Serializable{

	private boolean activa;
	private int diasPenalizacion;
        
	public int getPenalizacion(){
            return diasPenalizacion;
        }
        
        public boolean getActiva(){
            return activa;
        }
        
	public Penalizacion(int dias) {
		diasPenalizacion = dias;
		activa = true;
	}
	
	public boolean estaActiva() {
		return activa;
	}
	
	public void avanzarDias(int dias) {
		diasPenalizacion -= dias;
		if(diasPenalizacion < 0) {
			diasPenalizacion = 0;
			activa = false;
		}
	}
}
