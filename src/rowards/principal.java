 package rowards;

import java.util.ArrayList;

public class principal {
	
	public static void main(String[] args) {
		
		ArrayList <Hechizo> hechizos = new ArrayList <Hechizo>();
		ArrayList <Mago> magos = new ArrayList <Mago>();
		
		hechizos.add(new Hechizo("Sablazo en la factura", "Ataca al mago rival", 1, 1, "Ofensivo"));
		hechizos.add(new Hechizo("La ultima y pa casa", "Ataca al mago rival", 1, 1, "Ofensivo"));
		hechizos.add(new Hechizo("Por los pelos", "Ataca al mago rival", 1, 1, "Ofensivo"));
		hechizos.add(new Hechizo("No sin mis oros", "Ataca al mago rival", 1, 1, "Ofensivo"));
		hechizos.add(new Hechizo("restaurarSalud", "Restaura vida al mago", 1, 1, "Sanacion"));
		hechizos.add(new Hechizo("restaurarAfinidad", "Restaura afinidad al mago", 1, 1, "Sanacion"));
		hechizos.add(new Hechizo("ataqueMagico", "Ataca al mago rival", 1, 1, "Ofensivo"));
		hechizos.add(new Hechizo("confundirMago", "Confunde al mago rival", 1, 1, "Confusion"));
		hechizos.add(new Hechizo("defensaMagica", "Defensa contra hechizos", 1, 1, "Defensivo"));
		
		Orden dicendorf = new Orden("Dicendorf",hechizos.get(0));
		Orden meeplepuf = new Orden("Meeplepuf",hechizos.get(1));
		Orden tokenclau = new Orden("Tokenclau",hechizos.get(2));
		Orden sleeverin = new Orden("Sleeverin",hechizos.get(3));
		
		magos.add(new Mago("Ron", 1000, 100, 100, dicendorf));
		magos.add(new Mago("Kim", 1000, 100, 100, meeplepuf));
		magos.add(new Mago("Peter", 1000, 100, 100, tokenclau));
		magos.add(new Mago("Drake", 1000, 100, 100, sleeverin));
		
		metodos.añadirHechizosBasicos(magos.get(0), hechizos, dicendorf);
		metodos.añadirHechizosBasicos(magos.get(1), hechizos, meeplepuf);
		metodos.añadirHechizosBasicos(magos.get(2), hechizos, tokenclau);
		metodos.añadirHechizosBasicos(magos.get(3), hechizos, sleeverin);
		
		
	}

}
