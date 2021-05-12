package ej5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio5 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		System.out.println("Nombre del fichero a crear: ");
		String nomFichero=teclado.nextLine();
		
		editorTexto(nomFichero);
		
	}
	public static void editorTexto(String nomFichero) throws IOException {
		String linea;
		File fichero=new File(nomFichero);
		int contador=1;
		String nomNuevo=nomFichero;
		
		while(fichero.isFile()) {
			System.out.println("Ya existe el fichero "+nomFichero);
			nomFichero=nomFichero+contador;
			contador++;
			fichero=new File(nomNuevo);
			
		}
		
		
		try (PrintWriter salida=new PrintWriter(new FileWriter(nomNuevo));){
			
			
			for (int i = 1; i <= 5; i++) {
				System.out.println("Introduce la linea "+i+":");
				linea=teclado.nextLine();
				salida.println(linea);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	

}
