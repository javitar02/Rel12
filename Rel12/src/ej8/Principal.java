package ej8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal {

	public static void main(String[] args) {
		
		leerArchivo("notas.txt");

	}

	private static void leerArchivo(String fileName) {
		String linea;
		
		try (BufferedReader lectura=new BufferedReader(new FileReader("notas.txt"))){
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
			linea=lectura.readLine();
			
			while (linea!=null) {
				tratarLinea(linea,oos);
				lectura.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e1) {
			System.out.println("Error");
		}
		
	}

	private static void tratarLinea(String linea,ObjectOutputStream oos) {
		String separador[]=linea.split(";");
		StringBuilder sb=new StringBuilder();
		String nomAlumno;
		String notas;
		CuentaSuspenso otro;
	
		nomAlumno=separador[0];
		
		for (int i = 0; i < separador.length; i++) {
			notas=separador[1].concat(separador[separador.length]);
			
		}
			
		for (String  : separador) {
			
		}
		
	}



}
