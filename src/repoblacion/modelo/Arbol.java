package repoblacion.modelo;

import java.util.Objects;

public class Arbol {
	
	
	private Posicion posicion;
	private Especie especie;
	
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	
	public void setPosicion(Posicion posicion) throws NullPointerException {
		if(posicion!=null)this.posicion = posicion;
		else {throw new NullPointerException("ERROR: La posición no puede ser nula.");}
	}
	
	
	public Especie getEspecie() {
		return especie;
	}
	
	
	public void setEspecie(Especie especie) throws NullPointerException {
		if(especie!=null)this.especie = especie;
		else {throw new NullPointerException("ERROR: La especie no puede ser nula.");}
	}


	public Arbol(Posicion posicion, Especie especie) throws NullPointerException {
		super();
		
		if(posicion !=null && especie!=null) {
			setPosicion(posicion);
			setEspecie(especie);
			}
		
		
		
	}
	
	public Arbol(Arbol arbol) throws NullPointerException {
		if(arbol!=null) {setPosicion(arbol.getPosicion());setEspecie(arbol.getEspecie());}
		else {throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");}
		
		
	}

	
	

	@Override
	public String toString() {
		return String.format("especie=%s, posicion=(%s)", especie,posicion);
	}


	@Override
	public int hashCode() {
		return Objects.hash(especie, posicion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbol other = (Arbol) obj;
		return especie == other.especie && Objects.equals(posicion, other.posicion);
	}
	
	
	
	
	
	

}
