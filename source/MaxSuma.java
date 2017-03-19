/**
 * @author Daniel Daher Perez, Diego Luis Afonso
 * Proyecto DAA
 * Problema de SubArray de suma maxima
 * 
 * Clase principal donde tenemos nuestros 2 algoritmos, 
 * fuerza bruta y divide y venceras.
 */

package MaxSuma;

import java.util.ArrayList;
import java.util.Random;

public class MaxSuma {
	
	public MaxSuma(){}
	
	/**
	 * Metodo en el que calculamos el SSM (SubArray Suma Max)
	 * por el metodo de fuerza bruta
	 * @param array
	 * @return
	 */
	SubArray maxSubarrayFB(ArrayList<Integer> array){
	  
		int max = 0;
		int inic = 0;
		int fin = 0;
		
		for (int i = 0; i < array.size(); i++){
			int suma = 0;
			for (int j = i; j < array.size(); j++){
				suma += array.get(j);
				if (suma > max){
					max = suma;
					inic = i;
					fin = j;
				}
			}
		}
		
		return new SubArray(inic, fin, max);
	}
	
	/**
	 * Metodo en el que calculamos el SSM (SubArray Suma Max)
     * por el metodo de Divide y Venceras
	 * @param array
	 * @param inic
	 * @param fin
	 * @return
	 */
	SubArray maxSubarrayDyC(ArrayList<Integer> array, int inic, int fin){
		int medio = 0;
		
		if (inic == fin)
			
			return new SubArray(inic, fin, array.get(inic));

		else{
			medio = (int) Math.floor((inic + fin) / 2);
			
			SubArray izq = maxSubarrayDyC(array, inic, medio);
			SubArray der = maxSubarrayDyC(array, medio+1, fin);
			SubArray cruce = maxSubarrayCruce(array, inic, medio, fin);
			
			if(izq.getSuma() >= der.getSuma() && izq.getSuma() >= cruce.getSuma())
				return new SubArray(izq.getInic(), izq.getFin(), izq.getSuma());
			if(der.getSuma() >= izq.getSuma() && der.getSuma() >= cruce.getSuma())
				return new SubArray(der.getInic(), der.getFin(), der.getSuma());
			else
				return new SubArray(cruce.getInic(), cruce.getFin(), cruce.getSuma());
			
		}
	}
	
	/**
	 * Devuelve el subarray que se compone con los valores centralles del array parametro
	 * @param array
	 * @param inic
	 * @param medio
	 * @param fin
	 * @return
	 */
	SubArray maxSubarrayCruce(ArrayList<Integer> array, int inic, int medio, int fin){
	  
		int izqSuma = -100000;
		int suma = 0;
		int izqIndice = 0;
		
		for (int i = medio; i >= inic; i--){
			suma += array.get(i);
			if (suma > izqSuma){
				izqSuma = suma;
				izqIndice = i;
			}
		}
		
		int derSuma = -100000;
		suma = 0;
		int derIndice = 0;
		
		for (int i = medio + 1; i <= fin; i++){
			suma += array.get(i);
			if (suma > derSuma){
				derSuma = suma;
				derIndice = i;
			}
		}	
		return new SubArray(izqIndice, derIndice, derSuma + izqSuma);
	}
	
	public static void main (String args[]){
		MaxSuma sumaMax = new MaxSuma();
		ArrayList<Integer> array = new ArrayList<Integer>();
		Random rand = new Random();
		
	    /*for (int i = 0; i < 1500000; ++i){
	    	array.add(rand.nextInt(21) -10);
	    }*/
		
		// Si se desea crear un array aleatorio descomentar las lineas superiores
		// y comentar el siguiente conjunto
		
		array.add(-4);
		array.add(3);
		array.add(1);
		array.add(-1);
		array.add(1);
		array.add(-3);
		array.add(3);
		array.add(-2);
	    
	    System.out.println("FUERZA BRUTA");
		System.out.println("Array original: " + array);
	    SubArray a1 = sumaMax.maxSubarrayFB(array);
	    
	    System.out.println("Índice inicial:" + a1.getInic());
	    System.out.println("Índice final:" + a1.getFin());
	    System.out.println("SubArray de suma máxima: " + array.subList(a1.getInic(), a1.getFin() + 1));
	    
	    System.out.println("");
	    System.out.println("-------- -------- -------- --------");
	    System.out.println("");
	    
	    System.out.println("DIVIDE Y VENCERAS");
	    System.out.println("Array original: " + array);

	    SubArray a2 = sumaMax.maxSubarrayDyC(array, 0, array.size() - 1);

	    System.out.println("Índice inicial:" + a2.getInic());
	    System.out.println("Índice final:" + a2.getFin());
	    System.out.println("SubArray de suma máxima: " + array.subList(a2.getInic(), a2.getFin() + 1));

		
	}
	
}
