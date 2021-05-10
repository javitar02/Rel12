package ej1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Menu {

	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {

		int opcion;
		do
		{
			opcion=mostrarMenu();
			tratarMenu(opcion);
		}while (opcion!=5);

	}

	private static void tratarMenu(int opc) {
		switch (opc)
		{
		case 1:
		{
			crearDirectorio();
			break;
		}
		case 2:
		{
			crearFichero();
			break;
		}
		case 3:
		{
			borrarFichero();
			break;
		}
		case 4:{
			mostrarLosFicherosDeUnaCarpetaOrdenados();
			break;
		}
		
		}
		
	}

	private static void mostrarLosFicherosDeUnaCarpetaOrdenados() {
		String nombreCarpeta;
		System.out.println("Introduce el nombre de la carpeta");
		nombreCarpeta=teclado.nextLine();
		File[] contenido;
		ArrayList<String> ficherosQueContiene=new ArrayList<String>();
		
		File enlaceCarpeta= new File (nombreCarpeta);
		if ( !enlaceCarpeta.exists() || !enlaceCarpeta.isDirectory()) {
			System.out.println("No existe o no es una carpeta");
		}
		else {
			
			contenido= enlaceCarpeta.listFiles();
			
			for (int i = 0; i < contenido.length; i++) {
				if (contenido[i].isFile()) {
					ficherosQueContiene.add(contenido[i].getName());
				}
			}
			Collections.sort(ficherosQueContiene);
			for (String fichero : ficherosQueContiene) {
				System.out.println(fichero);
			}
			
			
		}
	}

	private static void borrarFichero() {
		String nombreFichero;
		System.out.println("Introduce el nombre del fichero a borrar");
		nombreFichero=teclado.nextLine();
		File enlaceFichero= new File (nombreFichero);
		if (!(enlaceFichero.exists() && enlaceFichero.isFile()))
			System.out.println("Error. No existe un fichero con ese nombre.");
		else
		{
			if (enlaceFichero.delete())
				System.out.println("Fichero " + nombreFichero + " borrado corectamente");
			else
				System.out.println("No se ha podido borrar el fichero");
		}
		
	}

	private static void crearFichero() {
		String nombreFichero, contenido;
		System.out.println("Introduce el nombre del fichero");
		nombreFichero=teclado.nextLine();
		
		
		
		File enlaceFichero= new File (nombreFichero);
		if ( enlaceFichero.exists() && enlaceFichero.isFile())
			System.out.println("Error. Ya existe un fichero con ese nombre.");
		else
		{
			System.out.println("Introduce una cadena de texto que ser� el contenido del fichero: ");
			contenido=teclado.nextLine();
			
			try (FileWriter flujoEscritura=new FileWriter(nombreFichero);
					PrintWriter filtroEscritura=new PrintWriter(flujoEscritura)){
				filtroEscritura.print(contenido);
				System.out.println("Fichero creado correctamente");
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	private static void crearDirectorio() {
		
		String nombreCarpeta;
		boolean creado;
		System.out.println("Introduce el nombre del directorio");
		nombreCarpeta=teclado.nextLine();
		
		File enlaceCarpeta= new File (nombreCarpeta);
		
		if ( enlaceCarpeta.exists() && enlaceCarpeta.isDirectory())
			System.out.println("Error. Ya existe un directorio con ese nombre");
		else
		{
			creado=enlaceCarpeta.mkdir();
			if ( creado)
				System.out.println("Directorio creado correctamete");
			else
				System.out.println("No se pudo crear el directorio " + nombreCarpeta);
		}
	}

	private static int mostrarMenu() {
		int opc;
		System.out.println("1.Crear directorio\n2.Crear fichero\n3.Borrar fichero\n4.Mostrar los ficheros que contiene una carperta\n5.Salir");
		opc=Integer.parseInt(teclado.nextLine());
		return opc;
	}

}