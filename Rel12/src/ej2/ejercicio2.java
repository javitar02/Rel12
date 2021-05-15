package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio2 {

	private static final String SEPARADOR_PALABRAS = " ";
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreFichero, palabra;

		System.out.println("Introduce el nombre del fichero");
		nombreFichero = teclado.nextLine();

		contarPalabras(nombreFichero);

		System.out.println("Introduce una palabra a buscar: ");
		palabra = teclado.nextLine();
		busquedaPalabraEnFichero(nombreFichero, palabra);

	}

	private static void contarPalabras(String nombreFichero) {
		String linea;
		int totalPalabras = 0;
		int palabrasEnLaLinea;

		try (FileReader flujoEntrada = new FileReader(nombreFichero);
				BufferedReader filtroEntrada = new BufferedReader(flujoEntrada)) {

			linea = filtroEntrada.readLine();

			while (linea != null) {

				// Contar cuantas palabras tiene esa línea
				if (linea.length() > 0)
					palabrasEnLaLinea = linea.split(SEPARADOR_PALABRAS).length;
				else
					palabrasEnLaLinea = 0;

				totalPalabras = totalPalabras + palabrasEnLaLinea;

				linea = filtroEntrada.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + nombreFichero);
		}

		System.out.println("Hay un total de " + totalPalabras + " palabras en el fichero");

	}

	private static void busquedaPalabraEnFichero(String nombreFichero, String palabra) {

		String linea;
		int numeroDeLinea = 1;
		String nombreFicheroResultado = "BuscandoPalabra" + palabra + ".txt";
		boolean palabraEncontrada=false;

		try (BufferedReader filtroEntrada = new BufferedReader(new FileReader(nombreFichero));
				PrintWriter filtroSalida = new PrintWriter(new FileWriter(nombreFicheroResultado));) {

			linea = filtroEntrada.readLine();

			while (linea != null) {
				// Si aparece dos veces en la línea solo lo pondra una vez
				
				if (linea.contains(palabra)) {
					filtroSalida.println("Encontrada en linea " + numeroDeLinea + " columna " + (linea.indexOf(palabra) + 1));
					palabraEncontrada=true;
				}

				linea = filtroEntrada.readLine();
				numeroDeLinea++;
			}

			
			if ( palabraEncontrada)
				System.out.println("Fichero " + nombreFicheroResultado + " creado correctamente.");
			else {
				System.out.println("No se encontr� la palabra xx");
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		File fichero=new File(nombreFicheroResultado);
		if ( !palabraEncontrada && fichero.isFile()) {
			fichero.delete();
		}
		
	}
	
	
	

}

