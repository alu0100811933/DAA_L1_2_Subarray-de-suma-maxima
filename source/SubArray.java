/**
 * @author Daniel Daher Perez, Diego Luis Afonso
 * Proyecto DAA
 * Problema de SubArray de suma maxima
 * 
 * Clase que usaremos para almacenar indices y sumas 
 * de subarrays
 */


package MaxSuma;

public class SubArray {
	private int inic;
	private int fin;
	private int suma;
	
	SubArray(int inic, int fin, int suma){
		this.inic = inic;
		this.fin = fin;
		this.suma = suma;
	}
	
	public int getInic() {
		return inic;
	}

	public void setInic(int inic) {
		this.inic = inic;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}
	
}
