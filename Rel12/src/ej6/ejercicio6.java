package ej6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio6 {
	private static final String PATRON_LINEA = "([A-Z]+s\\)3[1-9]{1}[A-Z]";
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Nombre del fichero a usar: ");
		String nomFichero=teclado.nextLine();
		
		creadorDirectorios(nomFichero);

	}
	private static void creadorDirectorios(String nomFichero) {
			String line;
			String lineParts[];
			String nombre;
			String apellido1;
			String apellido2;
			String curso;
			boolean created = false;

			try (BufferedReader bw = new BufferedReader(new FileReader(nomFichero))) {
				line = bw.readLine();
				while (line != null) {
					if (line.matches(PATRON_LINEA)) {
						lineParts = line.split(" ");
						nombre = lineParts[0];
						apellido1 = lineParts[1];
						apellido2 = lineParts[2];
						String nomCompleto=nombre.concat(apellido1).concat(apellido2);
						File fichero = new File(nombre);
						if (!fichero.isFile()) {
							created = fichero.createNewFile();
							if (created) {
								System.out.println("Fichero " + nomFichero + " creado correctamente");
							} else {
								System.out.println("Fichero " + nomFichero + " no creado");
							}
						} else {
							System.out.println("Fichero " + nomFichero + " ya existente");
						}

					}
					line = bw.readLine();
				}

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
		
	}


