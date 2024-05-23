package batalla;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Domador: ");
        String nombreDomador = leer.nextLine();
        Domador domador = new Domador(nombreDomador);
        
        boolean bucle = true;
        
        do {
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
    		
    		switch(opcion) {
    		case 1:
    			BatallaDigital batalla = new BatallaDigital(domador);
                batalla.pelea();
                break;
    		case 2:
                System.out.println("Saliendo del juego.");
                bucle = false;
                break;
    		}
          
        } while (bucle);
	}

}
