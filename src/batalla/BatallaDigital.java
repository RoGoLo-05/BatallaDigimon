package batalla;

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
}
