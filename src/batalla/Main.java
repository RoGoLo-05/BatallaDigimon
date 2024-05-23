package batalla;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Domador: ");
        String nombreDomador = leer.nextLine();
        Domador domador = new Domador(nombreDomador);
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");
            int opcion = leer.nextInt();
            if (opcion == 1) {
                BatallaDigital batalla = new BatallaDigital(domador);
                batalla.pelea();
            } else if (opcion == 2) {
                System.out.println("Saliendo del juego.");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
		
	}

}
