package rowards;

import java.util.ArrayList;
import java.util.Scanner;

public class metodos {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * muestra la informacion de un mago
	 * @param mago
	 */
	public static void mostrarMago(Mago mago) {
		System.out.println("----");
		System.out.println("Mago");
		System.out.println("----");
		System.out.println("Nombre: "+mago.nombre);
		System.out.println("Vida: "+mago.vida);
		System.out.println("Afinidad: "+mago.afinidad);
		System.out.println("Resistencia: "+mago.resistencia);
		System.out.println("Plomo: "+mago.plomo);
		System.out.println("Orden: "+mago.orden.nombre);
	}
	
	/**
	 * muestra todos los magos
	 * @param magos
	 */
	public static void mostrarMagos(ArrayList <Mago> magos) {
		for(int i=0;i<magos.size();i++) {
			mostrarMago(magos.get(i));
			System.out.println();
		}
	}
	
	/**
	 * buscar un mago por el nombre
	 * @param magos
	 * @return magos.index o -1 si no existe
	 */
	public static int buscarMago(ArrayList <Mago> magos) {
		String nombre;
		System.out.println("Introduzca el nombre del mago:");
		nombre = sc.nextLine();
		
		for(int i=0;i<magos.size();i++) {
			if(magos.get(i).nombre.toLowerCase().equals(nombre.toLowerCase()) == true){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * muestra los datos de una Orden
	 * @param orden
	 */
	public static void mostrarOrden(Orden orden) {
		System.out.println("-----");
		System.out.println("Orden");
		System.out.println("-----");
		System.out.println(orden.nombre);
		System.out.println();
		System.out.println("Caracteristicas:");
		System.out.println(orden.caracteristica1);
		System.out.println(orden.caracteristica2);
		if(orden.caracteristica3.equals("Empty")==false)
		System.out.println(orden.caracteristica3);
		else System.out.println();
	}
	
	/**
	 * muestra el libro de hechizos de un mago
	 * @param mago
	 */
	public static void mostrarLibro(Mago mago) {
		System.out.println("-----");
		System.out.println("Libro");
		System.out.println("-----");
		
		for(int i=0;i<mago.libro.hechizos.size();i++) {
			System.out.println("Nombre Hechizo: "+mago.libro.hechizos.get(i).nombre);
		}
	}
	
	/**
	 * muestra un hechizo
	 * @param hechizo
	 */
	public static void mostrarHechizo(Hechizo hechizo) {
		System.out.println("-----");
		System.out.println("Hechizo");
		System.out.println("-----");
		System.out.println("Nombre: "+hechizo.nombre);
		System.out.println();
		System.out.println("Descripcion: "+hechizo.descripcion);
		System.out.println("Defensa: "+hechizo.defensa);
		System.out.println("Ataque: "+hechizo.ataque);
		System.out.println("Espacio: "+hechizo.espacio);
		System.out.println("Coste: "+hechizo.coste);
		System.out.println("Categoria: "+hechizo.categoria);
		
	}
	
	/**
	 * añade un hechizo al libro de un mago
	 * @param mago
	 * @param hechizo
	 */
	public static void añadirHechizoLibro(Mago mago, Hechizo hechizo) {
		if(mago.libro.paginasOcupadas + hechizo.espacio <= mago.libro.paginasTotales) {
			mago.libro.hechizos.add(hechizo);
			mago.libro.paginasOcupadas = mago.libro.paginasOcupadas + hechizo.espacio;
			System.out.println("Hechizo añadido");
		}
		else System.out.println("El Hechizo no se ha podido añadir");
	}
	
	/**
	 * añade los hechizos basicos a un mago
	 * @param mago
	 * @param hechizos
	 * @param orden
	 */
	public static void añadirHechizosBasicos(Mago mago, ArrayList <Hechizo> hechizos, Orden orden) {
		
		mago.libro.hechizos.add(orden.hechizo);
		mago.libro.paginasOcupadas = mago.libro.paginasOcupadas + orden.hechizo.espacio;
		
		for(int i=4;i<9;i++) {
			mago.libro.hechizos.add(hechizos.get(i));
			mago.libro.paginasOcupadas = mago.libro.paginasOcupadas + hechizos.get(i).espacio;
		}
	}
	
	/**
	 * menus
	 * @param opcion
	 */
	public static void menu(int opcion) {
		switch (opcion) {
		case 1:
			break;
		
		}
	}
}