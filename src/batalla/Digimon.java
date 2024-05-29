package batalla;

import java.util.Random;

/**
 * La clase Digimon representa a los personajes del juego Digimon en el sistema de batalla.
 * Cada Digimon tiene un nombre, nivel, puntos de ataque, puntos de salud y puntos de poder de ataque.
 * Los Digimon pueden realizar dos tipos de ataques: uno común y otro especial.
 * 
 * @author Roberto
 * @version 1.0
 */
public class Digimon {
	
	
	private String nombre; // Nombre del Digimon
    private int nivel; // Nivel del Digimon
    private int puntos_ataque; // Puntos de ataque del Digimon
    private int puntos_salud; // Puntos de salud del Digimon
    private int dp1; // Puntos de poder de ataque para el ataque común del Digimon
    private int dp2; // Puntos de poder de ataque para el ataque especial del Digimon
    private Random random; // Generador de números aleatorios para el nivel del Digimon

	
    /**
     * Constructor de la clase Digimon.
     * Crea un nuevo Digimon con el nombre especificado y asigna valores aleatorios para el nivel, puntos de ataque y puntos de salud.
     * Los puntos de poder de ataque para los ataques común y especial se establecen inicialmente en 10.
     *
     * @param nombre El nombre del Digimon.
     */
	public Digimon(String nombre) {
		this.nombre = nombre;
		this.random = new Random();
		this.nivel = random.nextInt(5) + 1; // Genera un nivel aleatorio entre 1 y 5
		this.puntos_ataque = 5 * this.nivel; // Calcula los puntos de ataque basados en el nivel
		this.puntos_salud = 10 * this.nivel; // Calcula los puntos de salud basados en el nivel
		this.dp1 = 10; // Establece los puntos de poder de ataque para el ataque común, el ataque 1.
		this.dp2 = 10; // Establece los puntos de poder de ataque para el ataque especial, el ataque 2.
	}

	
	
	//Getters y setters
	
	/**
     * Obtiene el nombre del Digimon.
     *
     * @return El nombre del Digimon.
     */
	public String getNombre() { 
		return nombre;
	}

	/**
     * Establece el nombre del Digimon.
     *
     * @param nombre El nuevo nombre del Digimon.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Obtiene el nivel del Digimon.
     *
     * @return El nivel del Digimon.
     */
	public int getNivel() {
		return nivel;
	}
	
	/**
     * Establece el nivel del Digimon.
     *
     * @param nivel El nuevo nivel del Digimon.
     */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
     * Obtiene los puntos de ataque del Digimon.
     *
     * @return Los puntos de ataque del Digimon.
     */
	public int getPuntos_ataque() {
		return puntos_ataque;
	}

	/**
     * Establece los puntos de ataque del Digimon.
     *
     * @param puntos_ataque Los nuevos puntos de ataque del Digimon.
     */
	public void setPuntos_ataque(int puntos_ataque) {
		this.puntos_ataque = puntos_ataque;
	}

	/**
     * Obtiene los puntos de salud del Digimon.
     *
     * @return Los puntos de salud del Digimon.
     */
	public int getPuntos_salud() {
		return puntos_salud;
	}

	/**
     * Establece los puntos de salud del Digimon.
     *
     * @param puntos_salud Los nuevos puntos de salud del Digimon.
     */
	public void setPuntos_salud(int puntos_salud) {
		this.puntos_salud = puntos_salud;
	}

	/**
     * Obtiene los puntos de poder de ataque para el ataque común del Digimon.
     *
     * @return Los puntos de poder de ataque para el ataque común del Digimon.
     */
	public int getDp1() {
		return dp1;
	}

	/**
     * Establece los puntos de poder de ataque para el ataque común del Digimon.
     *
     * @param dp1 Los nuevos puntos de poder de ataque para el ataque común del Digimon.
     */
	public void setDp1(int dp1) {
		this.dp1 = dp1;
	}

	 /**
     * Obtiene los puntos de poder de ataque para el ataque especial del Digimon.
     *
     * @return Los puntos de poder de ataque para el ataque especial del Digimon.
     */
	public int getDp2() {
		return dp2;
	}

	/**
     * Establece los puntos de poder de ataque para el ataque especial del Digimon.
     *
     * @param dp2 Los nuevos puntos de poder de ataque para el ataque especial del Digimon.
     */
	public void setDp2(int dp2) {
		this.dp2 = dp2;
	}
	
	
	
	//Métodos
	
	/**
     * Realiza el ataque común del Digimon.
     * Si el Digimon tiene puntos de poder de ataque disponibles (dp1 > 0), realiza el ataque y devuelve los puntos de ataque.
     * Si no tiene puntos de poder de ataque disponibles, devuelve 0.
     *
     * @return Los puntos de ataque realizados con el ataque común.
     */
	public int ataque1() { //Ataque común
		if (dp1 > 0) {
            dp1--; //Los DP disminuirán en 1
            return puntos_ataque; //Causará daños igual a los puntos de ataque
        }
		return 0; //Si ya no hay más dp (puntos de poder) pues devuelve 0.
	}
	
	/**
     * Realiza el ataque especial del Digimon.
     * Si el Digimon tiene suficientes puntos de poder de ataque para el ataque especial (dp2 > 1), realiza el ataque y devuelve los puntos de ataque.
     * Si no tiene suficientes puntos de poder de ataque para el ataque especial, devuelve 0.
     *
     * @return Los puntos de ataque realizados con el ataque especial.
     */
	public int ataque2() { //Ataque de especie
		if (dp2 > 1) {
            dp2 -= 2; //Los DP disminuirán en 2
            return puntos_ataque * 2; //Causará daño igual al doble de los puntos de ataque
        }
        return 0;
	}
}
