package batalla;

import java.util.Random;

public class Digimon {
	
	
	private String nombre; //Variables
	private int nivel;
	private int puntos_ataque;
	private int puntos_salud;
	private int dp1;
	private int dp2;
	private Random random;
	
	
	public Digimon(String nombre) { //Constructor, recibe el nombre del digimon
		this.nombre = nombre;
		this.random = new Random();
		this.nivel = random.nextInt(5) + 1;
		this.puntos_ataque = 5 * this.nivel;
		this.puntos_salud = 10 * this.nivel;
		this.dp1 = 10; //Para el ataque 1
		this.dp2 = 10; //Para el ataque 2
	}

	//Getters y setters
	public String getNombre() { 
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPuntos_ataque() {
		return puntos_ataque;
	}

	public void setPuntos_ataque(int puntos_ataque) {
		this.puntos_ataque = puntos_ataque;
	}

	public int getPuntos_salud() {
		return puntos_salud;
	}

	public void setPuntos_salud(int puntos_salud) {
		this.puntos_salud = puntos_salud;
	}

	public int getDp1() {
		return dp1;
	}

	public void setDp1(int dp1) {
		this.dp1 = dp1;
	}

	public int getDp2() {
		return dp2;
	}

	public void setDp2(int dp2) {
		this.dp2 = dp2;
	}
	
	//Métodos
	public int ataque1() { //Ataque común
		if (dp1 > 0) {
            dp1--; //Los DP disminuirán en 1
            return puntos_ataque; //Causará daños igual a los puntos de ataque
        }
		return 0; //Si ya no hay más dp pues devuelve 0.
	}
	
	public int ataque2() { //Ataque de especie
		if (dp2 > 1) {
            dp2 -= 2; //Los DP disminuirán en 2
            return puntos_ataque * 2; //Causará daño igual al doble de los puntos de ataque
        }
        return 0;
	}
}
