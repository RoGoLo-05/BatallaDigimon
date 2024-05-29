package batalla;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Domador {

	private String nombre;
	private ArrayList<Digimon> equipo; //ArrayList de Digimones, de la clase Digimon
	
	public Domador(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
		this.equipo.add(generarDigimonAleatorio()); //Tendrá un digimon aleatorio en su equipo desde el principio.
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Digimon> getEquipo() {
		return equipo;
	}

	public void setEquipo(ArrayList<Digimon> equipo) {
		this.equipo = equipo;
	}

	private Digimon generarDigimonAleatorio() {
        String[] digimones = {"Agumon", "Gabumon", "Patamon"};
        String digimonElegido = digimones[new Random().nextInt(digimones.length)];
        return new Digimon(digimonElegido);
    }
	
	public void captura(Digimon digimon) {
		Scanner leer = new Scanner(System.in);
	    if (equipo.size() < 3) { // Verifica si el equipo tiene menos de 3 Digimon
	        if (digimon.getPuntos_salud() <= 20) { // Se captura el Digimon si tiene 20 puntos menos de salud que al principio
	            equipo.add(digimon); // Añade el Digimon al equipo
	            System.out.println(digimon.getNombre() + " se ha unido a su equipo.");
	        } else {
	            System.out.println("No se puede unir. El Digimon tiene demasiada salud.");
	        }
	    } else {
	    	if(digimon.getPuntos_salud() > 20) {
	    		System.out.println("Tu equipo está completo. Aún así no puedes reemplazarlo por alguno de tus Digimon, ya que el Digimon tiene demasiada salud.");
	    	} else {
	    		// Si ya tienes 3 Digimon en tu equipo, muestra los Digimon actuales y solicita al usuario que elija uno para reemplazar
	    		System.out.println("Tu equipo está completo. ¿Quieres reemplazar a alguno de tus Digimon? (s/n)");
	    		String respuesta = leer.nextLine().toLowerCase();
	    		if (respuesta.equals("s")) {
	    			// Muestra los Digimon actuales en el equipo
	    			System.out.println("Selecciona el Digimon que deseas reemplazar:");
	    			for (int i = 0; i < equipo.size(); i++) {
	    				Digimon dig = equipo.get(i);
	    				System.out.println((i + 1) + ". " + dig.getNombre() + " (Nivel: " + dig.getNivel() +  ", Salud: " + dig.getPuntos_salud() +", Ataque: " + dig.getPuntos_ataque() + ", DP1: " + dig.getDp1() + ", DP2: " + dig.getDp2() + ")");
	    			}
	    			boolean aux = true;
	    			while (aux) {
	    				try {
	    					System.out.print("Ingrese el número del Digimon que deseas reemplazar: ");
	    					int opcion = Integer.parseInt(leer.nextLine());
	    					if (opcion < 1 || opcion > 3) {
	    						System.out.println("Por favor, ingresa un número válido.");
	    					} else {
	    						// Reemplaza el Digimon seleccionado con el nuevo Digimon si cumple con el requisito de vida
	    							Digimon digimonAnterior = equipo.get(opcion - 1);
	    							equipo.set(opcion - 1, digimon);
	    							System.out.println(digimon.getNombre() + " ha reemplazado a " + digimonAnterior.getNombre() + " en tu equipo.");
	                            	aux = false;
	    					}
	    				} catch (NumberFormatException e) {
	    					System.out.println("Por favor, ingresa un número válido.");
	    				}
	    			}
	    		} else {
	    			System.out.println("No se ha añadido ningún Digimon a tu equipo.");
	    		}
	    		
	    	}
	    }
	}
	
	public void removerDigimonDerrotados() {
	    equipo.removeIf(digimon -> digimon.getPuntos_salud() <= 0);
	}
}
