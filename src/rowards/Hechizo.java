package rowards;

public class Hechizo {
	
	String nombre;
	String descripcion;
	int defensa;
	int ataque;
	int espacio;
	int coste;
	String categoria;
	
	/**
	 * constructores
	 */
	public Hechizo(String nombre, String descripcion, int defensa, int ataque, int espacio, int coste, String categoria) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.defensa= defensa;
		this.ataque= ataque;
		this.espacio= espacio;
		this.coste= coste;
		this.categoria= categoria;
	}
	
	public Hechizo(String nombre, String descripcion, int defensa, int ataque, String categoria) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.defensa= defensa;
		this.ataque= ataque;
		this.espacio= 1;
		this.coste= 1;
		this.categoria= categoria;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getEspacio() {
		return espacio;
	}
	public void setEspacio(int espacio) {
		this.espacio = espacio;
	}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	//otros metodos
	
	public void MostrarHechizo() {
		
	}
}
