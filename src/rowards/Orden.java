package rowards;

public class Orden {
	
	String nombre;
	String caracteristica1;
	int atributo1;
	String caracteristica2;
	int atributo2;
	String caracteristica3;
	int atributo3;
	Hechizo hechizo;
	
	/**
	 * constructor
	 */
	public Orden(String nombre, Hechizo hechizo) {
		this.nombre=nombre;
		
		switch (nombre) {
		case "Dicendorf":
			this.caracteristica1 = "Predisposicion";
			this.atributo1 = 50;
			this.caracteristica2 = "Inconsiencia";
			this.atributo2 = 10;
			this.caracteristica3 = "Protagonismo";
			this.atributo3 = 30;
			this.hechizo = hechizo;
			break;
		case "Meeplepuf":
			this.caracteristica1 = "Eficiencia";
			this.atributo1 = 50;
			this.caracteristica2 = "Honor";
			this.atributo2 = 20;
			this.caracteristica3 = "Empty";
			this.atributo3 = 0;
			this.hechizo = hechizo;
			break;
		case "Tokenclau":
			this.caracteristica1 = "Arrojo";
			this.atributo1 = 30;
			this.caracteristica2 = "Carisma";
			this.atributo2 = 30;
			this.caracteristica3 = "Empty";
			this.atributo3 = 0;
			this.hechizo = hechizo;
			break;
		case "Sleeverin":
			this.caracteristica1 = "Sigilo";
			this.atributo1 = 50;
			this.caracteristica2 = "Venenoso";
			this.atributo2 = 30;
			this.caracteristica3="Hablar con animales";
			this.atributo3 = 20;
			this.hechizo = hechizo;
			break;
		}
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
	public String getCaracteristica1() {
		return caracteristica1;
	}
	public void setCaracteristica1(String caracteristica1) {
		this.caracteristica1 = caracteristica1;
	}
	public int getAtributo1() {
		return atributo1;
	}
	public void setAtributo1(int atributo1) {
		this.atributo1 = atributo1;
	}
	public String getCaracteristica2() {
		return caracteristica2;
	}
	public void setCaracteristica2(String caracteristica2) {
		this.caracteristica2 = caracteristica2;
	}
	public int getAtributo2() {
		return atributo2;
	}
	public void setAtributo2(int atributo2) {
		this.atributo2 = atributo2;
	}
	public String getCaracteristica3() {
		return caracteristica3;
	}
	public void setCaracteristica3(String caracteristica3) {
		this.caracteristica3 = caracteristica3;
	}
	public int getAtributo3() {
		return atributo3;
	}
	public void setAtributo3(int atributo3) {
		this.atributo3 = atributo3;
	}
	public Hechizo getHechizo() {
		return hechizo;
	}
	public void setHechizo(Hechizo hechizo) {
		this.hechizo = hechizo;
	}
	
	
	
	
}
