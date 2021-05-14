package ej4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejerc4 {
	private static Scanner teclado=new Scanner(System.in);
	private static final String PATRON_LINEA = "[A-Za-z0-9\\s]+[ ][1-9]{4}[-][A-Z]{3}";
	
	public static void main(String[] args) {
		String nomFichero;
		String linea;
		String matricula;
		int ultimoEspacio;
		boolean esCorrecto=true;
		
		System.out.println("Introduce el nombre del fichero: ");
		nomFichero=teclado.nextLine();
		
		
		try (BufferedReader filtroLectura=new BufferedReader(new FileReader(nomFichero));
				PrintWriter filtroEscritura=new PrintWriter(new FileWriter("MatriculasCorrectas.txt"))) {;
			
			linea=filtroLectura.readLine();
			
			while(linea!=null && esCorrecto) {
				esCorrecto=comprobarMatricula(linea);
				
				if(esCorrecto) {
					ultimoEspacio=linea.indexOf(" ");
					matricula=linea.substring(ultimoEspacio+1);
					filtroEscritura.println(matricula);
				}
				linea=filtroLectura.readLine();
				
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static boolean comprobarMatricula(String linea) {
		
		return linea.matches(PATRON_LINEA);
	}
	
	
	
	
	
}
