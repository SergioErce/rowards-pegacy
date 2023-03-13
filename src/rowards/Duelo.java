package rowards;

import java.util.ArrayList;
import java.util.Scanner;

public class Duelo {
	static Scanner sc = new Scanner(System.in);
	public static void iniciarDuelo(ArrayList <Mago> magos) {
		
		Mago retador,retado;
		int turno = 0;
		boolean hretador = true, hretado = true; 
		
		System.out.println("**DUELO DE MAGOS**");
		System.out.println("Mago retador, seleccione a su mago:");
		retador = magos.get(metodos.buscarMago(magos));
		System.out.println("Mago retado, seleccione a su mago:");
		retado = magos.get(metodos.buscarMago(magos));
		quitarHechizo(retador);
		quitarHechizo(retado);
		System.out.println("Empieza el duelo");
		System.out.println("----------------");
		System.out.println("Retador----Retado");
		System.out.println("");
		System.out.println(retador.nombre+"--VS--"+retado.nombre);
		System.out.println("");
		
		do {
			turno++;
			System.out.println("--------");
			System.out.println("Turno "+turno);
			System.out.println("--------");
			System.out.println("");
			if(retador.vida > 0 && retado.vida > 0) {
				System.out.println("Turno del retador");
				System.out.println(hretador);
				hretador = turno(retador, retado, hretador);
			}
			if(retado.vida > 0 && retador.vida > 0 ) {
				System.out.println("Turno del retado");
				System.out.println(hretado);
				hretado = turno(retado, retador, hretado);
			}
		}while(retador.vida > 0 && retado.vida > 0);
		if (retador.vida <=0 ) {
			System.out.println("");
			System.out.println("El mago retador: "+retador.nombre+" se ha quedado sin vida.");
			System.out.println("---------------------------");
			System.out.println("GANADOR MAGO RETADO: "+retado.nombre);
			System.out.println("---------------------------");
		}
		
	}
	
	public static int turno(Mago atacante, Mago defensor, boolean habilidad) {
		int opcion, valor;
		Hechizo hechizo;
		
		metodos.mostrarMago(atacante);
		
		do {
			System.out.println("-----------------");
			System.out.println("1. Lanzar Hechizo");
			System.out.println("2. Rendirse");
			System.out.println("-----------------");
			opcion = sc.nextInt();
		}while(opcion<1 || opcion>2);
		
		switch (opcion) {
		case 1:
			hechizo = seleccionarHechizo(atacante, defensor, habilidad);
			if (hechizo.nombre.equals(atacante.orden.hechizo.nombre) == true ) habilidad = false;
			
			lanzarHechizo(atacante, defensor, hechizo);
			
			break;
		case 2:
			atacante.vida = 0;
			System.out.println("El Mago "+atacante.nombre+" se ha rendido");
			break;
		}
		return valor;
	}
	
	public static Hechizo seleccionarHechizo(Mago atacante, Mago defensor, boolean habilidad) {
		int opcion;
		
		
		do {
			do {
				System.out.println("Selecciona un hechizo por su numero:");
				if (habilidad == true) {
					for(int i=0;i<atacante.libro.hechizos.size();i++) {
						System.out.println((i+1)+". "+atacante.libro.hechizos.get(i).nombre);
					}
				}
				if (habilidad == false) {
					for(int i=1;i<atacante.libro.hechizos.size();i++) {
						System.out.println(i+". "+atacante.libro.hechizos.get(i).nombre);
					}
				}
				opcion = sc.nextInt();
			}while(opcion<1 || opcion>atacante.libro.hechizos.size());
			if (habilidad == true) opcion--;
		}while(comprobarHechizo(atacante, atacante.libro.hechizos.get(opcion)) == false);

		return atacante.libro.hechizos.get(opcion);
	}
	
	/**
	 * quitar hechizos de sanacion de los magos Sleeverin
	 * @param mago
	 */
	public static void quitarHechizo(Mago mago) {
		boolean existencia = false;
		do {
			if (mago.orden.nombre.equals("Sleeverin")) {
				existencia = false;
				for(int i=0;i<mago.libro.hechizos.size();i++) {
					if(mago.libro.hechizos.get(i).categoria.equals("Sanacion") == true) {
						existencia = true;
						mago.libro.hechizos.remove(i);
					}
				}
			}
		}while (existencia == true);
		
	}
	
	/**
	 * comprobar si un mago puede lanzar un hechizo
	 * @param mago
	 * @param hechizo
	 * @return
	 */
	public static boolean comprobarHechizo(Mago mago, Hechizo hechizo) {
		boolean lanzar = false;
		if(mago.afinidad - hechizo.coste < 0) System.out.println("No tienes Afinidad para lanzar este hechizo");
		else {
			lanzar = true;
		}
		return lanzar;
	}
	
	public static int lanzarHechizo(Mago atacante, Mago defensor, Hechizo hechizo) {
		int valor;
		
		String orden = atacante.orden.nombre;
		String categoria = hechizo.categoria;
		
		switch (orden) {
		case "Dicendorf":
			break;
		case "Meeplepuf":
			break;
		case "Tokenclau":
			break;
		case "Sleeverin":
			break;
		default:System.out.println("Error con la orden");
			break;
		}
		
		switch (categoria) {
		case "Sanacion":
			break;
		case "Ofensivo":
			break;
		case "Confusion":
			break;
		case "Defensivo":
			break;
		default:System.out.println("Error con el hechizo");
			break;
		}
		valor = 0;
		return valor;
	}
}
