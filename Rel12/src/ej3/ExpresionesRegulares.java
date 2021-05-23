package ej3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.util.Scanner;

public class ExpresionesRegulares {
	
	//Suponemos que admitimos may�sculas solo
	private static final String PATRON_LINEA = "([A-Z]{2,}[ ]){3}[1-9][0-9]?";
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		String nombreFichero;
		boolean correcto;
		System.out.println("Introduce el nombre del fichero: ");
		nombreFichero= teclado.nextLine();
		
		try {
			correcto=comprobarSiCumpleFormato(nombreFichero);
			if (correcto) {
				System.out.println("El formato del fichero es correcto");
			}
			else {
				System.out.println("El formato del fichero no es correcto");
			}
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		
		
	}

	private static boolean comprobarSiCumpleFormato(String nombreFichero) throws IOException {
	
		String linea;
		boolean correcto=true;
	
		try (BufferedReader filtroLectura=new BufferedReader(new FileReader(nombreFichero));)
		{

			linea=filtroLectura.readLine();
			while (linea!=null && correcto){
				correcto= comprobarLineaCorrecta(linea);
				
				if (!correcto) {
					System.out.println("Error en la linea " + linea);
				}
				else {
					linea=filtroLectura.readLine();
				}
			}
			
			
		}
		catch(FileNotFoundException e){
			System.out.println("No existe el fichero " + nombreFichero);
		}
		
		
		return correcto;
		
	}

	private static boolean comprobarLineaCorrecta(String linea) {
		

		return linea.matches(PATRON_LINEA);
	}

	
		
		
	

}

