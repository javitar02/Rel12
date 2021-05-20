package ej8;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal {

	private static final int NOTA_MIN_APROBADO = 5;
	public static final int SUSPENSOS_MAX = 2;

	public static void main(String[] args) {
		leerFicheroPrincipal("notas.txt");
	}

	
	private static void leerFicheroPrincipal(String nomFichero) {
		int suspensos;
		String nomAlumno,linea;
		String lineaPorPartes[];
		
		try (BufferedReader lectura=new BufferedReader(new FileReader(nomFichero));
				ObjectOutputStream escritura=new ObjectOutputStream(new FileOutputStream("SuspensosObjetos.dat"))){
			linea=lectura.readLine();
			while (linea!=null) {
				suspensos=0;
				lineaPorPartes=linea.split(";");
				nomAlumno=lineaPorPartes[0];
				for (int i = 1; i < lineaPorPartes.length; i++) {
					if(Integer.parseInt(lineaPorPartes[i])<NOTA_MIN_APROBADO) {
						suspensos++;
					}
				}
			crearFicheroObjeto(nomAlumno,suspensos, escritura);	
			crearCarpetaConRepetidores("Repetidores", nomAlumno, suspensos);
			linea=lectura.readLine();
			}
		} catch (EOFException e) {
			System.out.println(e.getMessage());
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void crearFicheroObjeto(String nomFichero, int suspensos, ObjectOutputStream escritura) throws IOException {
		CuentaSuspenso alumno=new CuentaSuspenso(nomFichero, suspensos);
		escritura.writeObject(alumno);	
	}
	
	private static void crearCarpetaConRepetidores(String nomCarpeta,String nomAlumno, int suspensos) {
		File directorio=new File(nomCarpeta);
		if(suspensos>SUSPENSOS_MAX) {
			File alumnoSuspenso=new File(directorio + "/" + nomAlumno);
			alumnoSuspenso.mkdirs();
		}		
	}
}
