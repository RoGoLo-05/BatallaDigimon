package batalla;

import java.util.ArrayList;
import java.util.Random;

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
        if (digimon.getPuntos_salud() <= (digimon.getPuntos_salud() - 20)) { //Se captura el Digimon si tiene 20 puntos menos de salud que al principio
            this.equipo.add(digimon); //Añado el digimon al equipo
            System.out.println(digimon.getNombre() + " se ha unido a su equipo.");
        } else {
            System.out.println("No se puede unir.");
        }
    }
	
	public void removerDigimonDerrotados() {
	    for (int i = 0; i < equipo.size(); i++) {
	        if (equipo.get(i).getPuntos_salud() <= 0) {
	        	equipo.remove(i);
	            i--; // Decrementar el índice para no omitir el siguiente elemento
	        }
	    }
	}
}
