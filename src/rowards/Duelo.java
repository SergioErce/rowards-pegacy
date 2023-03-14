package rowards;

import java.util.ArrayList;
import java.util.Scanner;

public class Duelo {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * inicio del duelo
	 * @param magos
	 */
	public static void iniciarDuelo(ArrayList <Mago> magos) {
		
		ArrayList <Duelista> duelistas = new ArrayList <Duelista>();
		for(int i=0;i<magos.size();i++) {
			duelistas.add(new Duelista(magos.get(i)));
		}
		
		Duelista retador,retado;
		int turno = 0;
		int dañoRetador = 0, dañoRetado = 0;
		
		System.out.println("**DUELO DE MAGOS**");
		System.out.println("Mago retador, seleccione a su mago:");
		retador = duelistas.get(metodos.buscarMago(magos));
		System.out.println("Mago retado, seleccione a su mago:");
		retado = duelistas.get(metodos.buscarMago(magos));
		quitarHechizo(retador);
		quitarHechizo(retado);
		System.out.println("Empieza el duelo");
		System.out.println("----------------");
		System.out.println("Retador----Retado");
		System.out.println("");
		System.out.println(retador.mago.nombre+"--VS--"+retado.mago.nombre);
		System.out.println("");
		
		do {
			turno++;
			System.out.println("--------");
			System.out.println("Turno "+turno);
			System.out.println("--------");
			System.out.println("");
			
			if(retador.mago.vida > 0 && retado.mago.vida > 0 && retador.aturdido == false) {
				System.out.println("Turno del retador");
				dañoRetador = turno(retador);
			}else if(retador.aturdido == true) {
				dañoRetador = 0;
				System.out.println("Pierde turno");
				retador.aturdido = false;
			}
			if(retado.mago.vida > 0 && retador.mago.vida > 0  && retado.aturdido == false) {
				System.out.println("Turno del retado");
				dañoRetado = turno(retado);
			}else if(retado.aturdido == true) {
				dañoRetado = 0;
				System.out.println("Pierde turno");
				retado.aturdido = false;
			}
			
			if (dañoRetado<0) {
				dañoRetador = dañoRetador + dañoRetado;
			}
			if (dañoRetador<0) {
				dañoRetado = dañoRetado + dañoRetador;
			}
			
			if (dañoRetador>1000) {
				retado.aturdido = true;
			}
			if (dañoRetado>1000) {
				retador.aturdido = true;
			}
			
			if(dañoRetador >0 && dañoRetador<1000) {
				retado.mago.vida = retado.mago.vida-dañoRetador;
			}
			if(dañoRetado >0 && dañoRetado <1000) {
				retador.mago.vida = retador.mago.vida-dañoRetado;
			}
			
		}while(retador.mago.vida > 0 && retado.mago.vida > 0);
		if (retado.mago.vida <=0 ) {
			System.out.println("");
			System.out.println("El mago retado: "+retado.mago.nombre+" se ha quedado sin vida.");
			System.out.println("---------------------------");
			System.out.println("GANADOR MAGO RETADOR: "+retador.mago.nombre);
			System.out.println("---------------------------");
		}else if (retador.mago.vida <=0 ) {
			System.out.println("");
			System.out.println("El mago retador: "+retador.mago.nombre+" se ha quedado sin vida.");
			System.out.println("---------------------------");
			System.out.println("GANADOR MAGO RETADO: "+retado.mago.nombre);
			System.out.println("---------------------------");
		}
		
		
	}
	
	/**
	 * turno de un duelista
	 * @param atacante
	 * @return
	 */
	public static int turno(Duelista atacante) {
		int opcion, valor = 0;
		Hechizo hechizo = null;
		
		metodos.mostrarMago(atacante.mago);
		
		do {
			System.out.println("-----------------");
			System.out.println("1. Lanzar Hechizo");
			System.out.println("2. Rendirse");
			System.out.println("-----------------");
			opcion = sc.nextInt();
		}while(opcion<1 || opcion>2);
		
		switch (opcion) {
		case 1:
			hechizo = seleccionarHechizo(atacante);
			if (hechizo.nombre.equals(atacante.mago.orden.hechizo.nombre) == true ) atacante.habilidadOrden = false;
			
			valor = lanzarHechizo(atacante, hechizo);
			atacante.mago.afinidad = atacante.mago.afinidad - hechizo.coste;
			break;
		case 2:
			atacante.mago.vida = 0;
			System.out.println("El Mago "+atacante.mago.nombre+" se ha rendido");
			valor = 0;
			break;
		}
		if (valor<0) {
			if(hechizo.nombre.equals("restaurarSalud") == true) {
				atacante.mago.vida = atacante.mago.vida - valor;
				valor = 0;
			}
			if(hechizo.nombre.equals("restaurarAfinidad") == true) {
				atacante.mago.afinidad = atacante.mago.afinidad - valor;
				valor = 0;
			}
		}
		return valor;
	}
	
	/**
	 * seleccionar un hechizo de su libro
	 * @param atacante
	 * @param habilidad
	 * @return
	 */
	public static Hechizo seleccionarHechizo(Duelista atacante) {
		int opcion;
		
		do {
			do {
				System.out.println("Selecciona un hechizo por su numero:");
				if (atacante.habilidadOrden == true) {
					for(int i=0;i<atacante.mago.libro.hechizos.size();i++) {
						System.out.println((i+1)+". "+atacante.mago.libro.hechizos.get(i).nombre);
					}
				}
				if (atacante.habilidadOrden == false) {
					for(int i=1;i<atacante.mago.libro.hechizos.size();i++) {
						System.out.println(i+". "+atacante.mago.libro.hechizos.get(i).nombre);
					}
				}
				opcion = sc.nextInt();
			}while(opcion<1 || opcion>atacante.mago.libro.hechizos.size());
			if (atacante.habilidadOrden == true) opcion--;
		}while(comprobarHechizo(atacante, atacante.mago.libro.hechizos.get(opcion)) == false);

		return atacante.mago.libro.hechizos.get(opcion);
	}
	
	/**
	 * quitar hechizos de sanacion de los magos Sleeverin
	 * @param duelista
	 */
	public static void quitarHechizo(Duelista duelista) {
		boolean existencia = false;
		do {
			if (duelista.mago.orden.nombre.equals("Sleeverin")) {
				existencia = false;
				for(int i=0;i<duelista.mago.libro.hechizos.size();i++) {
					if(duelista.mago.libro.hechizos.get(i).categoria.equals("Sanacion") == true) {
						existencia = true;
						duelista.mago.libro.hechizos.remove(i);
					}
				}
			}
		}while (existencia == true);
		
	}
	
	/**
	 * comprobar si un mago puede lanzar un hechizo
	 * @param duelista
	 * @param hechizo
	 * @return
	 */
	public static boolean comprobarHechizo(Duelista duelista, Hechizo hechizo) {
		boolean lanzar = false;
		if(duelista.mago.afinidad - hechizo.coste < 0) System.out.println("No tienes Afinidad para lanzar este hechizo");
		else {
			lanzar = true;
		}
		return lanzar;
	}
	
	/**
	 * lanza el hechizo seleccionado
	 * @param atacante
	 * @param hechizo
	 * @return
	 */
	public static int lanzarHechizo(Duelista atacante, Hechizo hechizo) {
		int valor = 0, base = 0 ,bonificacion = 0, b1, b2, b3;
		
		String orden = atacante.mago.orden.nombre;
		String categoria = hechizo.categoria;
		
		b1 = atacante.mago.orden.atributo1;
		b2 = atacante.mago.orden.atributo2;
		b3 = atacante.mago.orden.atributo3;
		
		switch (orden) {
		case "Dicendorf":
			switch (categoria) {
			case "Sanacion":
				bonificacion = b1+b3;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			case "Ofensivo":
				bonificacion = b2+b3;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion;
				break;
			case "Confusion":
				bonificacion = b2;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion + 1000;
				break;
			case "Defensivo":
				bonificacion = b3-b2;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			default:System.out.println("Error con el hechizo");
				break;
			}
			break;
		case "Meeplepuf":
			switch (categoria) {
			case "Sanacion":
				bonificacion = b1+b2;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			case "Ofensivo":
				bonificacion = b1+b2;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion;
				break;
			case "Confusion":
				bonificacion = b1-b2;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion + 1000;
				break;
			case "Defensivo":
				bonificacion = b1;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			default:System.out.println("Error con la bonificacion");
				break;
			}
			break;
		case "Tokenclau":
			switch (categoria) {
			case "Sanacion":
				bonificacion = b1+b2;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			case "Ofensivo":
				bonificacion = b1+b2;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion;
				break;
			case "Confusion":
				bonificacion = b1-b2;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion + 1000;
				break;
			case "Defensivo":
				bonificacion = b2-b1;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			default:System.out.println("Error con el hechizo");
				break;
			}
			break;
		case "Sleeverin":
			switch (categoria) {
			case "Ofensivo":
				bonificacion = b1+b2+b3;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion;
				break;
			case "Confusion":
				bonificacion = b1+b3;
				base = aleatorio(hechizo.ataque);
				valor = base + bonificacion + 1000;
				break;
			case "Defensivo":
				bonificacion = b1;
				base = aleatorio(hechizo.defensa);
				valor = -(base + bonificacion);
				break;
			default:System.out.println("Error con el hechizo");
				break;
			}
			break;
		default:System.out.println("Error con la orden");
			break;
		}
		
		if (base < bonificacion/10) {
			System.out.println("El hechizo fallo");
			valor = 0;
		}else {
			System.out.println("Valor del hechizo: "+valor);
		}
		return valor;
	}
	
	/**
	 * numero aleatorio entre 1 y num
	 * @param num
	 * @return int aleatorio
	 */
	public static int aleatorio(int num) {
		int aleatorio = (int) (Math.random()*num+1);
		return aleatorio;
	}
}

