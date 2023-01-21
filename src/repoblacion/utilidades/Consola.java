package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	
	private  Consola() {}
	
	
	//si nos hubieran pedido getters para la clase Bosque en las constantes de los maximos,
	//podriamos haber hecho facilmente escalable automatico este codigo haciendo uso de los maximos gracias a los setters
	//(por ejemplo en vez de anchura<1001,haber hecho : anchura<(Bosque.getMAX_ANCHURA()+1)
	
	
	public int leerAnchura() {
		boolean anchuraCorrecta = false;
		int anchura = -1;
		do {
			System.out.println("Por favor teclee el valor de la anchura(entre 0 y 1000)" );
			anchura = Entrada.entero();
			if(anchura>0&&anchura<1001) {anchuraCorrecta = true;}
			
		}
		while(!anchuraCorrecta);
		return anchura;
		
		
	}
	
	
	public int leerAltura() {
		boolean alturaCorrecta = false;
		int altura = -1;
		do {
			System.out.println("Por favor teclee el valor de la altura(entre 0 y 500)" );
			altura = Entrada.entero();
			if(altura>0&&altura<1001) {alturaCorrecta = true;}
			
		}
		while(!alturaCorrecta);
		return altura;
		
	}
	
	
	public int leePoblacion() {
		boolean poblacionCorrecta = false;
		int poblacion = -1;
		do {System.out.println("Por favor teclee el valor de la poblacion a replantar(entre 0 y el valor del perimetro)" );
			poblacion = Entrada.entero();
			if(poblacion>0&&poblacion<(2*(1000+500))) {poblacionCorrecta = true;}
		}
		while(!poblacionCorrecta);
		return poblacion;
	}
	

}
