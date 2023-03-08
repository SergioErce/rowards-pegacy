package rowards;

import java.util.ArrayList;

public class LibroHechizo {

	ArrayList <Hechizo> hechizos;
	int paginasTotales;
	int paginasOcupadas;
	
	/**
	 * constructor 
	 */
	public LibroHechizo(int paginasTotales) {
		this.hechizos = new ArrayList <Hechizo>();
		this.paginasTotales = paginasTotales;
		this.paginasOcupadas = hechizos.size();
	}
	
	/**
	 * getters and setters
	 */
	public int getPaginasTotales() {
		return paginasTotales;
	}
	public void setPaginasTotales(int paginasTotales) {
		this.paginasTotales = paginasTotales;
	}
	public int getPaginasOcupadas() {
		return paginasOcupadas;
	}
	public void setPaginasOcupadas(int paginasOcupadas) {
		this.paginasOcupadas = paginasOcupadas;
	}
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
		
}
