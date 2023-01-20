package repoblacion.modelo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bosque {
	public final int MAX_ALTURA = 500;
	public final int MINIMO = 10;
	public final int MAX_ANCHURA = 1000;
	public final int MAX_ESPECIES = 4;
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador;
	private int ancho;
	private int alto;
	
	
	private Arbol[] arboles;


	public Arbol getArbolMasAlejado() {return arbolMasAlejado;}
	public int getAncho() {return ancho;}
	public Arbol getArbolMasCentrado() {return arbolMasCentrado;}
	public int getAlto() {return alto;}	

	
	
	public void setArbolMasAlejado(Arbol arbolMasAlejado) {this.arbolMasAlejado = arbolMasAlejado;}
	public void setArbolMasCentrado(Arbol arbolMasCentrado) {this.arbolMasCentrado = arbolMasCentrado;}
	public void setAncho(int ancho) {if(ancho<=this.ancho)this.ancho = ancho;else throw new IllegalArgumentException("ERROR: Anchura no válida.");}
	public void setAlto(int alto) {if(alto<=this.alto)this.alto = alto;else throw new IllegalArgumentException("ERROR: Altura no válida.");}
	public void setArboles(Arbol[] arboles) {if(arboles!=null)	this.arboles = arboles;	}
	public void checkPoblacion(int poblacion) throws IllegalArgumentException {
		if(poblacion<= (2 * (ancho+alto) )  );
		if(poblacion == 0) {throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");}
		else throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");}
	
	public Bosque(int ancho,int alto,int poblacion) throws IllegalArgumentException {
		
		setAncho(ancho);setAlto(alto);checkPoblacion(poblacion);
		repoblar();
		
		
	}
	
	public Arbol[] duplicaBosque(){
		return arboles.clone();
	}
	
	private void repoblar() {
		// escoger especies a plantar aleatoriamente; crea una array contenedor y una con los valores de Especie, que se eescogen aleatoriamente
		//estos valores llenan la array contenedor(tamaño maximo igual a la constante definida,escalable)
	
		
		Especie[] especieArr = Especie.values();
		Especie[] especieRand = new Especie[MAX_ESPECIES];
		for(int i=0;i<especieRand.length;i++) {especieRand[i] =	especieArr [new Random().nextInt (Especie.values().length) ];}
		
		//recorrer array  generando arboles con posiciones aleatorias

		
		
		boolean especieCorrecta = true;
		boolean posicionLlena = false;
		double xTest;
		double yTest;
		Especie especieTest;
		Especie prevEspecie;
		
		for(int i=0;i<arboles.length;i++) {
			
			posicionLlena = false;
			especieCorrecta = true;
			
			//bucle para checkear que las posiciones no sean iguales en otros arboles(vas a plantar uno encima de otro?o.o) que genera hasta que sean validas 
			do {
			xTest = generador.nextDouble(-ancho/2, ancho/2);
			yTest = generador.nextDouble(-alto/2, alto/2);
			if(  ( xTest==(arboles[i].getPosicion().getX()) ) && ( yTest==(arboles[i].getPosicion().getY()) )    ) {posicionLlena = true;}
			}while(posicionLlena == true);
			Posicion posicionAPasar = new Posicion(xTest,yTest);
			
			
			//obtiene la especie del arbol anterior del array como dice el enunciado			
			 prevEspecie = arboles[(i-1)].getEspecie();
			//genera una especie aleatoria dentro de las escogidas para replantar mientras sea incompatible con la ocurrencia anterior
			do {
				especieTest = especieRand[generador.nextInt(especieRand.length)];
				if(especieTest==Especie.ALAMO &&( prevEspecie==Especie.CASTANO||prevEspecie==Especie.CIPRES||prevEspecie==Especie.OLIVO) ) {especieCorrecta = false;}
				if(especieTest==Especie.OLIVO &&( prevEspecie==Especie.ALAMO||prevEspecie==Especie.ENCINA) )
				{especieCorrecta = false;}				
				
				
			}while(especieCorrecta == false);

			
			
			arboles[i] = new Arbol (posicionAPasar, especieTest);
			
		}

		
		
		
	}
	
	
	
	public void realizarCalculos() {
		//para hacer estos calculos creo un arbol lo mas lejos posible y uno lo mas centrado posible
			Posicion centro = new Posicion(0,0);
			Posicion perimetro = new Posicion(1000,500);
			Arbol arbolMasAlejadoHelper = new Arbol(centro,Especie.ALAMO);
			Arbol arbolMasCercanoHelper= new Arbol(perimetro,Especie.ALAMO);
		//a continuacion hago dos bucles calculando la distancia de la posicion de cada arbol del array comparandolo con el caso limite
		//al ser por ejemplo lo mas lejano el arbol situado en el perimetro, cualquier arbol sera mas cercano y se asigna al helper
		//el bucle cicla todos los arboles comparando si alguno es mas cercano de ese primer arbol(o sucesivos que encuentre mas cercanos)
		//el segundo bucle hace lo mismo pero cambiando el punto de referencia para ver el mas lejano
		for(int i=0;i<arboles.length;i++) {
			
				try {
					if(arboles[i].getPosicion().distancia(centro)<arbolMasCercanoHelper.getPosicion().distancia(centro)) {arbolMasCercanoHelper = arboles[i];}
					}
				catch(Exception e) {e.getMessage();}}
		
		for(int i=0;i<arboles.length;i++) {
			
			try {
				if(arboles[i].getPosicion().distancia(perimetro)<arbolMasAlejadoHelper.getPosicion().distancia(perimetro)) {arbolMasAlejadoHelper = arboles[i];}
				}
			catch(Exception e) {e.getMessage();}}
		
		setArbolMasCentrado(arbolMasCercanoHelper);
		setArbolMasAlejado(arbolMasAlejadoHelper);
	}
	
	
	@Override
	public String toString() {
		return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
	}
	
	
	

}
