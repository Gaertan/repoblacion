package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {
	


	public static void main(String[] args) {
		
			Bosque bosque = null;
		
		int altura;
		int anchura;
		int poblacion;

		System.out.println("Bienvenido a la app de repoblación");
		System.out.println("a continuacion se le pedirán las dimensiones del bosque y arboles a replantar");
		
		anchura = Consola.leerAnchura();
		altura = Consola.leerAltura();
		poblacion = Consola.leePoblacion();
		
		
		try {
			bosque = new Bosque(anchura, altura, poblacion);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		bosque.realizarCalculos();
		
		System.out.println("el arbol mas alejado es " + bosque.getArbolMasAlejado());
		System.out.println("el arbol mas centrado es " + bosque.getArbolMasCentrado());
	}

}
