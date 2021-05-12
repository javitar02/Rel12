package ej4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class ejerc4 {
	private static Scanner teclado=new Scanner(System.in);
	private static final String PATRON_LINEA = ("^[0-9]{4}[A-Z]{3}$");
	
	public static void main(String[] args) {
		String nomFichero;
		String linea;
		boolean esCorrecto=true;
		
		System.out.println("Introduce un fichero: ");
		nomFichero=teclado.nextLine();
		
		
		try (BufferedReader salida=new BufferedReader(new FileReader(nomFichero));){
			linea=salida.readLine();
			
			while(linea!=null && esCorrecto) {
				esCorrecto=comprobarMatricula(linea);
				
				if(esCorrecto) {
					System.out.println("Formato correcto");
					
				}
				System.out.println("Formato incorrecto");
				
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static boolean comprobarMatricula(String linea) {
		
		return linea.matches(PATRON_LINEA);
	}
	
	
	
	
	
}
