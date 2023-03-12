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
			if(retador.vida != 0 ) {
				System.out.println("Turno del retador");
				turno(retador, retado, hretador);
			}
			if(retado.vida != 0 ) {
				System.out.println("Turno del retado");
				turno(retado, retador, hretado);
			}
		}while(retador.vida != 0 || retado.vida != 0);
	}
	
	public static void turno(Mago atacante, Mago defensor, boolean habilidad) {
		int opcion;
		
		metodos.mostrarMago(atacante);
		
		do {
			System.out.println("1. Lanzar Hechizo");
			System.out.println("2. Rendirse");
			opcion = sc.nextInt();
		}while(opcion<1 || opcion>2);
		switch (opcion) {
		case 1:
			lanzarHechizo(atacante, defensor, habilidad);
			break;
		case 2:
			atacante.vida = 0;
			System.out.println("El Mago "+atacante.nombre+" se ha rendido");
			break;
		}
	}
	
	public static void lanzarHechizo(Mago atacante, Mago defensor, boolean habilidad) {
		int opcion;
		String categoria;
		
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
		categoria = atacante.libro.hechizos.get(opcion).categoria;
		
		switch (categoria) {
			//falta llenar
		}
	}
}
