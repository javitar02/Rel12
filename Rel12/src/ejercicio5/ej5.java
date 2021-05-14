package ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ej5 {
	private static Scanner teclado=new Scanner(System.in);
	private static final String PATRON_LINEA = "[F][ ]([A-Za-z]){3,}\\.[a-z]{3}";
	public static void main(String[] args) {
		String fileName;
	
		
		System.out.println("Write the file name: ");
		fileName=teclado.nextLine();
		
		checkFile(fileName);
		
		
	}
	private static void checkFile(String fileName) {
		String line;
		String lineParts[];
		String validPart;
		boolean created=false;
		
		try(BufferedReader bw=new BufferedReader(new FileReader(fileName))) {
			line=bw.readLine();
			while (line!=null) {
				if(line.matches(PATRON_LINEA)) {
					lineParts=line.split(" ");
					validPart=lineParts[1];
					File fichero=new File(validPart);
					if(!fichero.isFile()) {
						created=fichero.createNewFile();
						if(created) {
							System.out.println("Fichero "+validPart+ " creado correctamente");
						}else {
							System.out.println("Fichero " +validPart+ " no creado");
						}
					}else {
						System.out.println("Fichero " +validPart+ " ya existente");
					}
					
						
				}
				line=bw.readLine();
			}
		
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
		
		
	}

}
