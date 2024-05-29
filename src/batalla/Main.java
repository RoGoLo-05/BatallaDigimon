package batalla;

import java.util.Scanner;

/**
 * Esta clase Main permite al usuario interactuar con el sistema de batalla de Digimon.
 * El usuario puede ingresar el nombre del Domador y elegir entre iniciar una batalla o salir del programa.
 *
 * @author Roberto
 * @version 1.0
 */
public class Main {

	/**
     * Método principal que inicia la aplicación.
     * Permite al usuario interactuar con el sistema de batalla de Digimon.
     *
     * @param args Argumentos de la línea de comandos (no utilizado en este programa).
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // Inicialización del scanner para leer la entrada del usuario
		Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Domador: ");
        // Solicitar al usuario que ingrese el nombre del Domador
        String nombreDomador = leer.nextLine();
        // Crear un nuevo Domador con el nombre proporcionado por el usuario
        Domador domador = new Domador(nombreDomador);
        
        boolean bucle = true;
        
        // Bucle principal que permite al usuario interactuar con el sistema hasta que decida salir
        do {
        	// Mostrar las opciones disponibles al usuario
            System.out.println("\nOpciones:");
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");
            
            boolean aux1 = true;
    		String entrada1 = "";
    		int opcion = 0;

    		while(aux1) {
    			try {
    				System.out.println("Elige una opcion: ");
    				entrada1 = leer.nextLine();
    				entrada1 = entrada1.replaceAll(" ", "");
    				opcion = Integer.parseInt(entrada1);

    				if (opcion<1 || opcion>2) {
    					System.out.println("Elige una opcion entre 1 y 2");
    				} else {
    					aux1 = false;
    				}

    			} catch(NumberFormatException e) {
    				System.out.println("Error. Introduce un numero");
    			}
    		}
    		
    		// Procesar la opción seleccionada por el usuario
    		switch(opcion) {
    		case 1:
    			// Si el Domador no tiene Digimons en su equipo, mostrar un mensaje de advertencia
    			if (domador.getEquipo().isEmpty()) {
                    System.out.println("No tienes Digimons en tu equipo. No puedes iniciar una batalla.");
                } else {
                	// Si el Domador tiene Digimons en su equipo, iniciar una batalla
                    BatallaDigital batalla = new BatallaDigital(domador);
                    batalla.pelea();
                }
                break;
    		case 2:
                // Si el usuario elige salir, mostrar un mensaje de despedida y salir del bucle
                System.out.println("Fin del programa.");
                bucle = false;
                break;
    		}
          
        } while (bucle); // Continuar ejecutando el bucle mientras el usuario no elija salir
	}

}
