package batalla;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase BatallaDigital representa una batalla entre el equipo de Digimon de un domador y un Digimon enemigo.
 * Proporciona métodos para elegir un Digimon del equipo del domador, iniciar una batalla y capturar Digimon enemigos.
 * 
 * @author Roberto
 * @version 1.0
 */
public class BatallaDigital {
	
	private Domador domador;
    private Digimon enemigo;
    Scanner leer = new Scanner(System.in);
    
    /**
     * Constructor de la clase BatallaDigital.
     * Inicializa la batalla con el domador proporcionado y genera un Digimon enemigo aleatorio.
     * 
     * @param domador El domador que participará en la batalla.
     */
	public BatallaDigital(Domador domador) {
		this.domador = domador;
        this.enemigo = generarDigimonAleatorio();
	}
	
	 /**
     * Genera un Digimon aleatorio para ser el enemigo en la batalla.
     * 
     * @return Un Digimon aleatorio.
     */
	private Digimon generarDigimonAleatorio() {
        String[] digimones = {"Agumon", "Gabumon", "Patamon"};
        String digimonElegido = digimones[new Random().nextInt(digimones.length)];
        return new Digimon(digimonElegido);
    }
	
	/**
     * Permite al usuario elegir un Digimon de su equipo para participar en la batalla.
     * 
     * @return El Digimon elegido por el usuario.
     */
	public Digimon elige() {  
        ArrayList<Digimon> equipo = domador.getEquipo();
        if (equipo.isEmpty()) {
            System.out.println("No tienes Digimons en tu equipo. No puedes iniciar una batalla.");
            return null;
        }
        for (int i = 0; i < equipo.size(); i++) {
            Digimon digimon = equipo.get(i);
            System.out.printf("\n" + (i + 1) + ". " + digimon.getNombre() + " (Nivel: " + digimon.getNivel() +  ", Salud: " + digimon.getPuntos_salud() +", Ataque: " + digimon.getPuntos_ataque() + ", DP1: " + digimon.getDp1() + ", DP2: " + digimon.getDp2() + ").");
        }
        
        boolean aux1 = true;
		String entrada1 = "";
		int digimonElegido = 0;

		while(aux1) {
			try {
				System.out.println("\nElige un Digimon de tu equipo: ");
				entrada1 = leer.nextLine();
				entrada1 = entrada1.replaceAll(" ", "");
				digimonElegido = Integer.parseInt(entrada1);

				if (digimonElegido<=0 || digimonElegido > equipo.size()) {
					System.out.println("Elige una opcion posible");
				} else {
					aux1 = false;
				}

			} catch(NumberFormatException e) {
				System.out.println("Error. Introduce un numero");
			}
		}
		
        int opcion = digimonElegido - 1; //Se le resta uno porque tienes que elegir del 1 al 3, pero en el ArratyList los digimones van del 0 al 2.
        return equipo.get(opcion); //Accede al Digimon en la posición choice dentro del ArrayList team.
    }
	
	/**
     * Inicia la batalla entre el Digimon del domador y el Digimon enemigo.
     */
	public void pelea() {
        Digimon miDigimon = elige();
        if (miDigimon == null) {
            return; // Si no hay Digimon disponible, termina la pelea.
        }
        while (miDigimon.getPuntos_salud() > 0 && enemigo.getPuntos_salud() > 0) {
            System.out.println("\nTu Digimon: " + miDigimon.getNombre() + " (Nivel: " + miDigimon.getNivel() + ", Salud: " + miDigimon.getPuntos_salud() + ", Ataque: " + miDigimon.getPuntos_ataque() + ", DP1: " + miDigimon.getDp1() + ", DP2: " + miDigimon.getDp2() + ").");
            System.out.println("Enemigo: " + enemigo.getNombre() + " (Nivel: " + enemigo.getNivel() + ", Salud: " + enemigo.getPuntos_salud() + ", Ataque: " + enemigo.getPuntos_ataque() + ", DP1: " + enemigo.getDp1() + ", DP2: " + enemigo.getDp2() + ").");
            System.out.println("\nOpciones:");
            System.out.println("1. Ataque 1");
            System.out.println("2. Ataque 2");
            System.out.println("3. Capturar enemigo");
            System.out.println("Elige una opcion: ");
            
            boolean aux1 = true;
    		String entrada1 = "";
    		int opcion = 0;

    		while(aux1) {
    			try {
    				entrada1 = leer.nextLine();
    				entrada1 = entrada1.replaceAll(" ", "");
    				opcion = Integer.parseInt(entrada1);

    				if (opcion<1 || opcion>3) {
    					System.out.println("Elige una opcion entre 1 y 3");
    				} else {
    					aux1 = false;
    				}

    			} catch(NumberFormatException e) {
    				System.out.println("Error. Introduce un numero");
    			}
    		}
    		
            int danio;
            switch (opcion) {
                case 1:
                	danio = miDigimon.ataque1();
                    enemigo.setPuntos_salud(enemigo.getPuntos_salud() - danio);
                    System.out.println(miDigimon.getNombre() + ", de tu equipo, ha hecho " + danio + " puntos de daño con Ataque 1.");
                    break;
                case 2:
                	danio = miDigimon.ataque2();
                    enemigo.setPuntos_salud(enemigo.getPuntos_salud() - danio);
                    System.out.println(miDigimon.getNombre() + ", de tu equipo, ha hecho " + danio + " puntos de daño con Ataque 2.");
                    break;
                case 3:
                    domador.captura(enemigo);
                    return;
            }
            if (enemigo.getPuntos_salud() > 0) {
            	danio = new Random().nextBoolean() ? enemigo.ataque1() : enemigo.ataque2(); //El digimon enemigo puede hacer cualquiera de los dos ataques, de forma random.
                miDigimon.setPuntos_salud(miDigimon.getPuntos_salud() - danio);
                System.out.println(enemigo.getNombre() + ", enemigo, ha hecho " + danio + " puntos de daño a tu Digimon.");
            }
        }
        if (miDigimon.getPuntos_salud() <= 0) {
            System.out.println("Tu Digimon " + miDigimon.getNombre() + " ha sido derrotado.");
            domador.removerDigimonDerrotados();
        } else if (enemigo.getPuntos_salud() <= 0) {
            System.out.println("El enemigo " + enemigo.getNombre() + " ha sido derrotado.");
        }
    }
}
