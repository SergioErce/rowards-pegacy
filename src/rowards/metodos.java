package rowards;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class metodos {
	static Scanner sc = new Scanner(System.in);
	
	//gestion de RowardsPegacy.bkp 
	/**
	 * crea los magos leidos por el archivo RowardsPegacy.bkp
	 * @param magos
	 * @param ordenes
	 */
	public static void leerPersonajes(ArrayList<Mago> magos, ArrayList <Orden> ordenes) {
		File backup = new File("RowardsPegacy.bkp");
		Scanner s = null;
		int cont = 0;
		
		try {
			// Leemos el contenido del fichero
			System.out.println("**Cargando Magos**");
			s = new Scanner(backup);
			String nombre="";
			String orden="";
			int vida=0, afinidad=0, resistencia=0;

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				cont++;
				if(cont%5 == 1) {
					nombre = s.next();
				}else if (cont%5 == 2) {
					vida = s.nextInt();
				}
				else if (cont%5 == 3) {
					afinidad = s.nextInt();
				}
				else if (cont%5 == 4) {
					resistencia = s.nextInt();
				}
				else if (cont%5 == 0) {
					orden = s.next();
					magos.add(new Mago(nombre, vida, afinidad, resistencia, buscarOrden(orden, ordenes) ));
				}
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
			}
		}
	}
	
	/**
	 * guardar los magos en RowardsPegacy.bkp
	 * @param magos
	 */
	public static void guardarPersonajes(ArrayList<Mago> magos) {
		FileWriter backup = null;
		try {

			backup = new FileWriter("RowardsPegacy.bkp");

			// Escribimos linea a linea en el fichero
			for (int i=0;i<magos.size();i++) {
				backup.write(magos.get(i).nombre + "\n");
				backup.write(magos.get(i).vida + "\n");
				backup.write(magos.get(i).afinidad + "\n");
				backup.write(magos.get(i).resistencia + "\n");
				backup.write(magos.get(i).orden.nombre + "\n");
			}
			System.out.println("**Guardando Magos**");
			backup.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	//gestion de mago
	/**
	 * muestra la informacion de un mago
	 * @param mago
	 */
	public static void mostrarMago(Mago mago) {
		System.out.println("----");
		System.out.println("Mago");
		System.out.println("----");
		System.out.println("1.Nombre: "+mago.nombre);
		System.out.println("2.Vida: "+mago.vida);
		System.out.println("3.Afinidad: "+mago.afinidad);
		System.out.println("4.Resistencia: "+mago.resistencia);
		System.out.println("5.Plomo: "+mago.plomo);
		System.out.println("6.Orden: "+mago.orden.nombre);
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
		System.out.println("Lista de magos");
		for(int i=0;i<magos.size();i++) {
			System.out.println(magos.get(i).nombre);
		}
		do {
			System.out.println("Introduzca el nombre del mago:");
			nombre = sc.next();
			
			if(validarMago(magos, nombre) == true){
				for(int i=0;i<magos.size();i++) {
					if(magos.get(i).nombre.toLowerCase().equals(nombre.toLowerCase()) == true){
						return i;
					}
				}
			}else System.out.println("Mago no encontrado.");
		}while (validarMago(magos, nombre) == false);
		return -1;
	}
	
	/**
	 * valida la existencia de un mago por su nombre, si existe el mago, devuelve true
	 * @param magos
	 * @param nombre
	 * @return false (el mago no existe), true (el mago existe) 
	 */
	public static boolean validarMago(ArrayList <Mago> magos, String nombre) {
		for(int i=0;i<magos.size();i++) {
			if(magos.get(i).nombre.toLowerCase().equals(nombre.toLowerCase()) == true){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * modificar un campo de un mago
	 * @param magos
	 * @param ordenes
	 */
	public static void modificarMago(ArrayList <Mago> magos, ArrayList <Orden> ordenes) {
		System.out.println("Para modificar los datos de un mago:");
		int num = buscarMago(magos);
		int campo;
		if (num<0) {
			System.out.println("Mago no encontrado");
		}else {
			do {
				System.out.println("Seleccione el campo a modificar (0 Para salir)");
				mostrarMago(magos.get(num));
				campo = sc.nextInt();
				switch (campo) {
				case 0:
					System.out.println("Salida");
					break;
				case 1:
					System.out.println("Nombre:");
					String nombre = sc.next();
					magos.get(num).nombre= nombre;
					System.out.println("Campo modificado");
					break;
				case 2:
					System.out.println("Vida:");
					int vida = sc.nextInt();
					magos.get(num).vida= vida;
					System.out.println("Campo modificado");
					break;
				case 3:
					System.out.println("Afinidad:");
					int afinidad = sc.nextInt();
					magos.get(num).afinidad= afinidad;
					System.out.println("Campo modificado");
					break;
				case 4:
					System.out.println("Resistencia:");
					int resistencia = sc.nextInt();
					magos.get(num).resistencia= resistencia;
					System.out.println("Campo modificado");
					break;
				case 5:
					System.out.println("Plomo:");
					int plomo = sc.nextInt();
					magos.get(num).plomo= plomo;
					System.out.println("Campo modificado");
					break;
				case 6:
					System.out.println("Orden:");
					String orden = sc.next();
					Orden nuevaorden =buscarOrden(orden, ordenes);
					if (nuevaorden == null) {
						System.out.println("Error al modificar la Orden ");
					}else {
						magos.get(num).orden= nuevaorden;
						cambiarHechizoOrden(magos.get(num));
						System.out.println("Campo modificado");
					}
					
					break;	
				default:
					System.out.println("Seleccion erronea");
					break;
				}
			}	while(campo != 0);
		}	
	}
	
	/**
	 * añade un mago a la lista de magos
	 * @param magos
	 * @param ordenes
	 */
	public static void añadirMago(ArrayList <Hechizo> hechizos, ArrayList <Mago> magos, ArrayList <Orden> ordenes) {
		String nombre, nombreorden;
		Orden orden;
		int vida, afinidad, resistencia;
		System.out.println("Para introducir a un mago debemos introducir los siguentes datos:");
		do {
			System.out.println("Nombre:");
			nombre = sc.next();
			if (validarMago(magos, nombre) == true)System.out.println("Este mago ya existe");
		}while(validarMago(magos, nombre) == true);
		
		System.out.println("Vida:");
		vida = sc.nextInt();
		System.out.println("Afinidad:");
		afinidad = sc.nextInt();
		System.out.println("Resistencia:");
		resistencia = sc.nextInt();
		
		do {
			System.out.println("Orden:");
			nombreorden = sc.next();
			orden = buscarOrden(nombreorden, ordenes);
			if (orden == null) {
				System.out.println("Error al introducir la Orden ");
			}
		}while(orden == null);
		magos.add(new Mago(nombre, vida, afinidad, resistencia, orden));
		añadirHechizosBasicos(magos.get(magos.size()-1), hechizos, orden);
		guardarPersonajes(magos);
	}
	
	/**
	 * elimina un mago pidiendo el nombre
	 * @param magos
	 */
	public static void eliminarMago(ArrayList <Mago> magos) {
		int n;
		do {
			System.out.println("Para eliminar un mago:");
			n = buscarMago(magos);
			if (n<0)System.out.println("Mago no encontrado");
		}while(n<0);
		magos.remove(n);
		System.out.println("Mago eliminado");
	}
	
	//gestion orden
	/**
	 * buscar una orden por el nombre
	 * @param nombre
	 * @param ordenes
	 * @return orden
	 */
 	public static Orden buscarOrden(String nombre, ArrayList <Orden> ordenes) {
		Orden orden = null;
		boolean boo=false;
		for(int i=0;i<ordenes.size();i++) {
			if(ordenes.get(i).nombre.toLowerCase().equals(nombre.toLowerCase())== true) {
				orden = ordenes.get(i);
				boo=true;
			}
		}
		if(boo == false)System.out.println("Error al buscar la Orden");
		return orden;
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
	
	//gestion libros
	/**
	 * muestra el libro de hechizos de un mago
	 * @param mago
	 */
	public static void mostrarLibro(Mago mago) {
		System.out.println("-----");
		System.out.println("Libro");
		System.out.println("-----");
		System.out.println("Paginas Ocupadas: "+mago.libro.paginasOcupadas+"/"+mago.libro.paginasTotales);
		for(int i=0;i<mago.libro.hechizos.size();i++) {
			System.out.println("Nombre Hechizo: "+mago.libro.hechizos.get(i).nombre);
		}
	}
	
	/**
	 * muestra el libro de hechizos todos los magos
	 * @param mago
	 */
	public static void mostrarLibros(ArrayList <Mago> magos) {
		for(int i=0;i<magos.size();i++) {
			System.out.println("-----------");
			System.out.println("Mago: "+magos.get(i).nombre);
			mostrarLibro(magos.get(i));
			System.out.println();
		}
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
	 * cambiar el hechizo de orden de un mago
	 * @param mago
	 */
	public static void cambiarHechizoOrden (Mago mago) {
		mago.libro.hechizos.remove(0);
		mago.libro.hechizos.add(0, mago.orden.hechizo);
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
	 * busca un hechizo en la lista
	 * @param hechizos
	 * @return hechizos.index
	 */
	public static int buscarHechizo(ArrayList <Hechizo> hechizos) {
		System.out.println("Lista de Hechizos");
		String nombre;
		boolean check;
		for(int i=0;i<hechizos.size();i++) {
			System.out.println("Hechizo: "+hechizos.get(i).nombre);
		}
		do {
			check = false;
			System.out.println("Indica el nombre completo, o parte de el, del hechizo a seleccionar");
			nombre = sc.next();
			for(int i=0;i<hechizos.size();i++) {
				if(hechizos.get(i).nombre.toLowerCase().contains(nombre.toLowerCase()) == true) {
					check=true;
					return i;
				}
			}
			if(check==false)System.out.println("Hechizo no encontrado");
		}while(check == false);
		return -1;
	}
	
	/**
	 * modificar los datos de un hechizo
	 * @param mago
	 */
	public static void modificarHechizo(Mago mago) {
		mostrarLibro(mago);
		System.out.println("Para modificar un hechizo:");
		int num = buscarHechizo(mago.libro.hechizos);
		int campo;
		
		do {
			System.out.println("Seleccione el campo a modificar (0 Para salir)");
			mostrarHechizo(mago.libro.hechizos.get(num));
			campo = sc.nextInt();
			switch (campo) {
			case 0:
				System.out.println("Salida");
				break;
			case 1:
				System.out.println("Descripcion:");
				String descripcion = sc.next();
				mago.libro.hechizos.get(num).descripcion = descripcion;
				System.out.println("Campo modificado");
				break;
			case 2:
				System.out.println("Defensa:");
				int defensa = sc.nextInt();
				mago.libro.hechizos.get(num).defensa = defensa;
				System.out.println("Campo modificado");
				break;
			case 3:
				System.out.println("Ataque:");
				int ataque = sc.nextInt();
				mago.libro.hechizos.get(num).ataque = ataque;
				System.out.println("Campo modificado");
				break;
			case 4:
				System.out.println("Espacio:");
				int espacio = sc.nextInt();
				mago.libro.hechizos.get(num).espacio = espacio;
				System.out.println("Campo modificado");
				break;
			case 5:
				System.out.println("Coste:");
				int coste = sc.nextInt();
				mago.libro.hechizos.get(num).coste = coste;
				System.out.println("Campo modificado");
				break;
			case 6:
				System.out.println("Categoria:");
				String categoria = sc.next();
				mago.libro.hechizos.get(num).categoria = categoria;
				break;	
			default:
				System.out.println("Seleccion erronea");
				break;
			}
		}	while(campo != 0);
	}
	
	/**
	 * eliminar un hechizo de un mago
	 * @param mago
	 */
	public static void eliminarHechizo(Mago mago) {
		mostrarLibro(mago);
		System.out.println("Para modificar un hechizo:");
		int num = buscarHechizo(mago.libro.hechizos);
		if(num == 0)System.out.println("No se puede eliminar un hechizo de Orden");
		else {
			mago.libro.paginasOcupadas = mago.libro.paginasOcupadas - mago.libro.hechizos.get(num).espacio;
			mago.libro.hechizos.remove(num);
			System.out.println("Hechizo eliminado");
			}
	}
	
	//gestion hechizos
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
		System.out.println("1.Descripcion: "+hechizo.descripcion);
		System.out.println("2.Defensa: "+hechizo.defensa);
		System.out.println("3.Ataque: "+hechizo.ataque);
		System.out.println("4.Espacio: "+hechizo.espacio);
		System.out.println("5.Coste: "+hechizo.coste);
		System.out.println("6.Categoria: "+hechizo.categoria);
		
	}
	
	//menus
	/**
	 * menu inicial
	 * @param hechizos
	 * @param magos
	 * @param ordenes
	 */
	public static void menu(ArrayList <Hechizo> hechizos, ArrayList <Mago> magos, ArrayList <Orden> ordenes) {
		int opcion; 
		do {
			System.out.println("Indica la opcion por su numero (0 Para salir)");
			System.out.println("----");
			System.out.println("Menu");
			System.out.println("----");
			System.out.println("1. Gestion de Magos");
			System.out.println("2. Gestion de Libros de Hechizos");
			System.out.println("3. Duelo de Magos");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo...");
				break;
			case 1:
				menuMagos(hechizos, magos, ordenes);
				break;
			case 2:
				menuLibros(hechizos, magos, ordenes);
				break;
			case 3:
				Duelo.iniciarDuelo(magos);
				break;
			default:
				System.out.println("Error en la seleccion");
				break;
			}
		}while(opcion != 0);
	}
	
	/**
	 * menu de gestion de magos
	 * @param magos
	 * @param ordenes
	 */
	public static void menuMagos(ArrayList <Hechizo> hechizos, ArrayList <Mago> magos, ArrayList <Orden> ordenes) {
		int opcion; 
		do {
			System.out.println("Indica la opcion por su numero (0 Para salir)");
			System.out.println("----");
			System.out.println("Gestion de Magos");
			System.out.println("----");
			System.out.println("1. Mostrar una lista de los magos existentes, con sus características.");
			System.out.println("2. Obtener información de un mago, solicitando su nombre.");
			System.out.println("3. Modificar los datos referentes a un mago.");
			System.out.println("4. Añadir un mago.");
			System.out.println("5. Eliminar un mago solicitando su nombre.");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo...");
				break;
			case 1:
				mostrarMagos(magos);
				break;
			case 2:
				mostrarMago(magos.get(buscarMago(magos)));
				break;
			case 3:
				modificarMago(magos, ordenes);
				break;
			case 4:
				 añadirMago(hechizos, magos, ordenes);
				break;
			case 5:
				eliminarMago(magos);
				break;
			default:
				System.out.println("Error en la seleccion");
				break;
			}
		}while(opcion != 0);
	}
	
	/**
	 * menu de gestion de los libros
	 * @param hechizos
	 * @param magos
	 * @param ordenes
	 */
	public static void menuLibros(ArrayList <Hechizo> hechizos, ArrayList <Mago> magos, ArrayList <Orden> ordenes) {
		int opcion; 
		do {
			System.out.println("Indica la opcion por su numero (0 Para salir)");
			System.out.println("----");
			System.out.println("Gestion de Libros de Hechizos");
			System.out.println("----");
			System.out.println("1. Mostrar la información de todos los magos con sus respectivos libros de hechizos.");
			System.out.println("2. Mostrar un libro de hechizos específico dado un nombre de mago.");
			System.out.println("3. Añadir hechizos al libro de hechizos de un mago dado.");
			System.out.println("4. Modificar cualquiera de los valores de un hechizo de un mago dado");
			System.out.println("5. Eliminar un hechizo del libro de hechizos de un mago.");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo...");
				break;
			case 1:
				mostrarLibros(magos);
				break;
			case 2:
				mostrarLibro(magos.get(buscarMago(magos)));
				break;
			case 3:
				añadirHechizoLibro(magos.get(buscarMago(magos)), hechizos.get(buscarHechizo(hechizos)));
				break;
			case 4:
				 modificarHechizo(magos.get(buscarMago(magos)));
				break;
			case 5:
				eliminarHechizo(magos.get(buscarMago(magos)));
				break;
			default:
				System.out.println("Error en la seleccion");
				break;
			}
		}while(opcion != 0);
	}
}
