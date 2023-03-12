 package rowards;
 
import java.util.ArrayList;

public class principal {
	
	public static void main(String[] args) {
				
		ArrayList <Hechizo> hechizos = new ArrayList <Hechizo>();
		ArrayList <Mago> magos = new ArrayList <Mago>();
		ArrayList <Orden> ordenes = new ArrayList <Orden>();
		
		
		//crear hechizos
		hechizos.add(new Hechizo("Sablazo en la factura", "Ataca al mago rival", 1, 1, 2, 2, "Ofensivo"));
		hechizos.add(new Hechizo("La ultima y pa casa", "Ataca al mago rival", 1, 1, 2, 2, "Ofensivo"));
		hechizos.add(new Hechizo("Por los pelos", "Ataca al mago rival", 0, 1, 2, 2, "Ofensivo"));
		hechizos.add(new Hechizo("No sin mis oros", "Ataca al mago rival", 0, 1, 2, 2, "Ofensivo"));
		hechizos.add(new Hechizo("restaurarSalud", "Restaura vida al mago", 1, 0, "Sanacion"));
		hechizos.add(new Hechizo("restaurarAfinidad", "Restaura afinidad al mago", 1, 0, "Sanacion"));
		hechizos.add(new Hechizo("ataqueMagico", "Ataca al mago rival", 0, 1, "Ofensivo"));
		hechizos.add(new Hechizo("confundirMago", "Confunde al mago rival", 0, 1, "Confusion"));
		hechizos.add(new Hechizo("defensaMagica", "Defensa contra hechizos", 1, 0, "Defensivo"));
		
		//crear ordenes
		Orden dicendorf = new Orden("Dicendorf",hechizos.get(0));
		Orden meeplepuf = new Orden("Meeplepuf",hechizos.get(1));
		Orden tokenclau = new Orden("Tokenclau",hechizos.get(2));
		Orden sleeverin = new Orden("Sleeverin",hechizos.get(3));
		ordenes.add(dicendorf);
		ordenes.add(meeplepuf);
		ordenes.add(tokenclau);
		ordenes.add(sleeverin);
		
		//cargar los personajes de RowardsPegacy.bkp
		metodos.leerPersonajes(magos, ordenes);
		
		//añadir los hechizos basicos para cada mago
		for(int i=0;i<magos.size();i++) {
			metodos.añadirHechizosBasicos(magos.get(i), hechizos, magos.get(i).orden);
		}
		
		//inicio del programa
		System.out.println("Bienvenido a Rowards Pegacy");
		
		metodos.menu(hechizos, magos, ordenes);
		
		//guardar los magos en RowardsPegacy.bkp antes de salir
		metodos.guardarPersonajes(magos);
		System.out.println("**Salida//FIN**");
	}
}
