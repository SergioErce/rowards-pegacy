package rowards;

public class Mago {

	String nombre;
	int vida;
	int afinidad;
	int resistencia;
	int plomo;
	LibroHechizo libro;
	Orden orden;
	
	/**
	 * constructor
	 */
	public Mago(String nombre, int vida, int afinidad, int resistencia, Orden orden) {
		this.nombre = nombre;
		this.vida = vida;
		this.afinidad = afinidad;
		this.resistencia = resistencia;
		this.plomo = 2000;
		this.libro=new LibroHechizo(afinidad/10);
		this.orden = orden;
	}
	
	/**
	 * getters and setters
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAfinidad() {
		return afinidad;
	}
	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	public int getPlomo() {
		return plomo;
	}
	public void setPlomo(int plomo) {
		this.plomo = plomo;
	}
	public LibroHechizo getLibro() {
		return libro;
	}
	public void setLibro(LibroHechizo libro) {
		this.libro = libro;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
}
