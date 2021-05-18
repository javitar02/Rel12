package ej6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio6 {

	private static final String pattern= "([A-Z]+\\s){3}[1-9]{1}[A-Z]+";
	private static Scanner keyboard= new Scanner (System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Write the file name:");
		String fileName = keyboard.nextLine();
		
		File file= new File (fileName);
		
		createDirectories(file);
	}

	private static void createDirectories(File file) {
		
		try (BufferedReader readFilter = new BufferedReader(new FileReader (file));) {
			
			String line = readFilter.readLine();
			
			while(line!=null) {
				
				lineTreatment(line);
				
				line = readFilter.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e1) {
			System.out.println("Error");
		}
		
		
	}
	
	private static void lineTreatment (String line) {
		if(line.matches(pattern)) {
			String[] lineWords = line.split(" ");
			boolean created=false;
			StringBuilder studentName = new StringBuilder();
			String courseName=lineWords[lineWords.length-1];
			
			if (lineWords.length==4) {
				studentName.append(lineWords[1]);
				studentName.append(lineWords[2]);
				studentName.append(lineWords[0]);
			}
//			}else {
//				if (lineWords.length==5) {
//					 //nombres compuestos
//					studentName.append(lineWords[2]);
//					studentName.append(lineWords[3]);
//					studentName.append(lineWords[0]);
//					studentName.append(lineWords[1]);
//					
//				}
//			}
			File mainDirectory = new File(courseName + "/"+studentName.toString());
			
			created = mainDirectory.mkdirs();
			
			if(created) {
				System.out.println("Folder sucessfully created " + studentName.toString());
			}
			
			try ( PrintWriter bufferW= new PrintWriter( new FileWriter ( courseName + "/" + courseName + ".txt" ,true ));){
				
				bufferW.println( lineWords[0] + " " + lineWords[1] + " " + lineWords[2]);
				
				
			}catch ( IOException e) {
				System.out.println("No se ha podido escribir en el archivo"  + courseName + ".txt");
			}
			
		}
	}
}



