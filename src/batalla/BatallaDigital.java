package batalla;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
	
	private Domador domador;
    private Digimon enemigo;
    Scanner leer = new Scanner(System.in);
    
	public BatallaDigital(Domador domador) {
		this.domador = domador;
        this.enemigo = generarDigimonAleatorio();
	}
	
	private Digimon generarDigimonAleatorio() {
        String[] digimones = {"Agumon", "Gabumon", "Patamon"};
        String digimonElegido = digimones[new Random().nextInt(digimones.length)];
        return new Digimon(digimonElegido);
    }
	
	public Digimon elige() {
        System.out.println("Elige un Digimon de tu equipo: ");
        ArrayList<Digimon> equipo = domador.getEquipo();
        for (int i = 0; i < equipo.size(); i++) {
            Digimon digimon = equipo.get(i);
            System.out.printf((i + 1) + ". " + digimon.getNombre() + " (Nivel: " + digimon.getNivel() +  ", Salud: " + digimon.getPuntos_salud() + ", DP1: " + digimon.getDp1() + ", DP2: " + digimon.getDp2() + ").");
        }
        int opcion = leer.nextInt() - 1; //Se le resta uno porque tienes que elegir del 1 al 3, pero en el ArratyList los digimones van del 0 al 2.
        return equipo.get(opcion); //Accede al Digimon en la posición choice dentro del ArrayList team.
    }
	
	public void pelea() {
        Digimon miDigimon = elige();
        while (miDigimon.getPuntos_salud() > 0 && enemigo.getPuntos_salud() > 0) {
            System.out.println("\nTu Digimon: " + miDigimon.getNombre() + " (Nivel: " + miDigimon.getNivel() + ", Salud: " + miDigimon.getPuntos_salud() + ", Ataque: " + miDigimon.getPuntos_ataque() + ", DP1: " + miDigimon.getDp1() + ", DP2: " + miDigimon.getDp2() + ").");
            System.out.println("Enemigo: " + enemigo.getNombre() + " (Nivel: " + miDigimon.getNivel() + ", Salud: " + enemigo.getPuntos_salud() + ", Ataque: " + miDigimon.getPuntos_ataque() + ", DP1: " + enemigo.getDp1() + ", DP2: " + enemigo.getDp2() + ").");
            System.out.println("\nOpciones:");
            System.out.println("1. Ataque 1");
            System.out.println("2. Ataque 2");
            System.out.println("3. Capturar enemigo");
            int opcion = leer.nextInt();
            int danio;
            switch (opcion) {
                case 1:
                	danio = miDigimon.ataque1();
                    enemigo.setPuntos_salud(enemigo.getPuntos_salud() - danio);
                    System.out.println(miDigimon.getNombre() + " ha hecho " + danio + " puntos de daño con Ataque 1.");
                    break;
                case 2:
                	danio = miDigimon.ataque2();
                    enemigo.setPuntos_salud(enemigo.getPuntos_salud() - danio);
                    System.out.println(miDigimon.getNombre() + " ha hecho " + danio + " puntos de daño con Ataque 2.");
                    break;
                case 3:
                    domador.captura(enemigo);
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }
            if (enemigo.getPuntos_salud() > 0) {
            	danio = new Random().nextBoolean() ? enemigo.ataque1() : enemigo.ataque2();
                miDigimon.setPuntos_salud(miDigimon.getPuntos_salud() - danio);
                System.out.println(enemigo.getNombre() + " ha hecho " + danio + " puntos de daño a tu Digimon.");
            }
        }
        if (miDigimon.getPuntos_salud() <= 0) {
            System.out.println("Tu Digimon " + miDigimon.getNombre() + " ha sido derrotado.");
        } else if (enemigo.getPuntos_salud() <= 0) {
            System.out.println("El enemigo " + enemigo.getNombre() + " ha sido derrotado.");
        }
    }
}
