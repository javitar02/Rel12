package ej4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejerc4 {

	//Tenemos en cuenta nombres de modelo de más de una palabra
	private static final String PATRON_LINEA = "(([A-Za-z0-9]+) )+[0-9]{4}-[A-Z]{3}";
	private static final String MATRICULAS_NUEVAS_TXT = "MatriculasNuevas.txt";
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreFichero;
		System.out.println("Introduce el nombre del fichero con las matriculas");
		nombreFichero = teclado.nextLine();

		try {
			crearFicheroConMatriculasNuevas(nombreFichero);
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}

	}

	private static void crearFicheroConMatriculasNuevas(String nombreFichero) throws IOException {

		String linea;
		

		try (BufferedReader filtroLectura = new BufferedReader(new FileReader(nombreFichero));
			PrintWriter filtroEscritura = new PrintWriter( new FileWriter(MATRICULAS_NUEVAS_TXT)); ){
		
			linea = filtroLectura.readLine();
			while (linea != null) {
				escribirSiEsNueva(linea, filtroEscritura);

				linea = filtroLectura.readLine();

			}

			System.out.println("Se ha creado correctamente el fichero " + MATRICULAS_NUEVAS_TXT);
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} 

	}

	private static void escribirSiEsNueva(String linea, PrintWriter filtroEscritura) {

		String[] partesDeLinea;
		if (linea.matches(PATRON_LINEA)) {
			partesDeLinea=linea.split(" ");
			
			filtroEscritura.println(partesDeLinea[partesDeLinea.length -1 ]);
		
		}

	}

}