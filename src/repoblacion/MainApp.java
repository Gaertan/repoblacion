package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {
	
	private Bosque bosque;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvenido a la app de repoblación");
		System.out.println("a continuacion se le pedirán las dimensiones del bosque y arboles a replantar");
		
		Consola.leerAnchura();
		Consola.leerAltura();
	}

}
