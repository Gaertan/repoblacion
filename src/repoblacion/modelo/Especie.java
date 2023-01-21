package repoblacion.modelo;

public enum Especie {ALAMO("álamo"),ENCINA("encina"),CASTANO("castaño"),CIPRES("ciprés"),PINO("pino"),ROBLE("roble piñonero"),OLIVO("olivo");

	
	
	
	
	private String cadenaAmostrar;
	
	
	private Especie(String cadenaAmostrar) {this.cadenaAmostrar=cadenaAmostrar;}


public String toString() {return this.cadenaAmostrar;}



}