package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio2 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException{

	}

	public void contaPalabras(String nombreFichero) {
		int palabrasEnLinea;
		int totalPalabras = 0;
		String linea;

		try (FileReader flujoLectura = new FileReader(nombreFichero);
				BufferedReader filtroEntrada = new BufferedReader(flujoLectura)) {

			linea = filtroEntrada.readLine();

			while (linea != null) {
				if (linea.length() > 0) {
					palabrasEnLinea = linea.split(" ").length;
				} else
					palabrasEnLinea = 0;

				totalPalabras = totalPalabras + palabrasEnLinea;

				linea = filtroEntrada.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}

		System.out.println("El fichero " + nombreFichero + " contiene " + totalPalabras + " palabras");
	}

	public void encontrarPalabraEnFichero(String nomFichero, String palabra) {
		String linea;
		int numLinea=1;
		String nombreFicheroResultado="Buscando palabra "+palabra+".txt";
		boolean encontrada=false;
		
		try (BufferedReader filtroEntrada = new BufferedReader(new FileReader(nomFichero));
				 PrintWriter filtroSalida=new PrintWriter(new FileWriter(nombreFicheroResultado));){
					
					linea = filtroEntrada.readLine();

			while (linea != null) {
				if (linea.contains(palabra)) {
					filtroSalida.println("Encontrada en linea "+numLinea+" columna "+linea.indexOf(palabra)+1);
					encontrada=true;
				} else
					linea=filtroEntrada.readLine();
					numLinea++;
			}
			
			if(encontrada) {
				System.out.println("Fichero "+nombreFicheroResultado+" creado correctamente");
			}
			System.out.println("No se encontro la palabra");

		} catch (IOException e) {
			System.out.println("Error "+e.getMessage());
		}
		
		File fichero=new File(nombreFicheroResultado);
		if(fichero.isFile()) {
			fichero.delete();
		}
	}
}
