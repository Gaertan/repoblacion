package repoblacion.modelo;

import java.util.Objects;

public class Posicion {

	
	
	private double x;
	private double y;
		
		public Posicion(Posicion p){
			if(p==null) {throw new NullPointerException("ERROR: No se puede copiar una posición nula.");}
			else {this.x = p.getX();this.y=p.getY();}
		}
	
		public Posicion(double x, double y) {
		super();
			setX(x);
			setY(y);
	}
	
	
		public double getX() {return x;}
		public double getY() {return y;}
		
		private void setX(double x){this.x = x;}
		private void setY(double y){this.y = y;}
		
		
		public double distancia(Posicion posicion)throws NullPointerException{
			
			if(posicion !=null && this!=null) {	
				
				double x2 =posicion.getX();
				double y2=posicion.getY();
				double retX;
				double rety;
				double Distance_Result;
				
				
				if(!posicion.equals(this)) {				
		        // Implement pythagorean theorem
		        retX = x2-x;
		        retX = y2-y;
		        Distance_Result = Math.sqrt(x*x + y*y);		        
		        return Distance_Result;}
				
				else {Distance_Result = 0;return Distance_Result = 0;}
		        
				
				
			}
			//if (this==null) throw new NullPointerException("ERROR: La distancia debería ser 0 ya que no se puede calcular la distancia de una posición nula.");
			else /*if(posicion == null)*/ throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
			
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Posicion other = (Posicion) obj;
			return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
					&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
		}

		@Override
		public String toString() {
			return new String(String.format("x=%5.3f, y=%5.3f", x,y));
		}
		
		
}

