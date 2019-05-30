package it.prova;

public class Punto implements Comparable<Punto> {

	private int x;
	private int y;
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Punto p) {
		return (x == p.x && y == p.y) ? true:false;
	}
	
	public int hashCode() {
		return x*x + y*y;
	}
	
	public int compareTo(Punto p) {
		return (x*x + y*y) > (p.x*p.x + p.y*p.y) ? 1:-1; 
//		return (x > p.x && y > p.y) ? 1:-1;
	}
	
	public String toString() {
		return "x,y = " + x + "," + y;
	}
	
}
