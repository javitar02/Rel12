package ej1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
private static final int OPCION_SALIR = 5;
	
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		int opcion;
		
		
		do{
			opcion=mostrarMenu();
			tratarMenu(opcion);
		}while (opcion!=OPCION_SALIR);

	}
	
	private static void tratarMenu(int opc) throws IOException {
		String nomDirectorio;
		String nomCarpeta;
		String nomFichero;
		String nomFicheroABorrar;
		String contenidoFichero;
		File contenidoFiles[];
		
		File fichero;
		File directorio;
		
		boolean creada;
		boolean borrado;
		
			switch (opc){
			case 1:
				nomDirectorio=solicitarNombreFichero();
				directorio=new File(nomDirectorio);
				
				if(directorio.isDirectory()) {
					System.out.println("Carpeta ya existente");
				}else {
					creada=directorio.mkdirs();
					if(creada) {
						System.out.println("Carpeta creada exitosamente");
					}
					System.out.println("Error, carpeta no creada");
				}
			
				break;
			case 2:
				nomFichero=solicitarNombreFichero();
				contenidoFichero=llenarFichero();
				
				fichero=new File(nomFichero,contenidoFichero);
				
				if(fichero.isFile()) {
					System.out.println("Fichero de texto ya existente");
				}
				
				fichero.createNewFile();
				System.out.println("Fichero creado correctamente");
				
				break;
			case 3:
				nomFicheroABorrar=solicitarNombreFichero();
				File aBorrar=new File(nomFicheroABorrar);
				
				borrado=aBorrar.delete();
				
				if(borrado) {
					System.out.println("Fichero borrado correctamente");
				}else {
					System.out.println("Error, no se pudo borrar el fichero");
				}
				
				break;
				
			case 4:
				nomCarpeta=solicitarNombreFichero();
				File carpetaCreada=new File(nomCarpeta);
				
				
				
				contenidoFiles=carpetaCreada.listFiles();
				
				for (int i = 0; i < contenidoFiles.length; i++) {
					if (contenidoFiles[i].isFile()) {
						System.out.println(contenidoFiles[i]);
					}
				}
				
				break;
				
			case 5:
				System.out.println("Has seleccionado salir del menu. Tenga un buen dia");
			}
		
	}

	private static int mostrarMenu() {
		
		int opcion;
		
		do{
			System.out.println("--BIENVENIDO AL MENU--");
			System.out.println("1. Crear directorio");
			System.out.println("2. Crear fichero texto");
			System.out.println("3. Borrar fichero texto");
			System.out.println("4. Mostrar ficheros que contiene la carpeta");
			System.out.println("5. Salir");
			opcion=introducirNumeroEntero("Introduzca la opcion:");
		}while (opcion<=0 || opcion> OPCION_SALIR);
		
		return opcion;
	}
	
	private static int introducirNumeroEntero(String enunciado) {
		
		int numero=0;
		boolean hayFallo;
		
		do{
			try{
				System.out.print(enunciado);
				numero=Integer.parseInt(teclado.nextLine());
				hayFallo=false;
			}catch (NumberFormatException ex){
				hayFallo=true;
				System.out.println("ERROR. Solo puedes introducir numeros");
			}
		}while (hayFallo);
		
		return numero;
	}
	
	public static String solicitarNombreFichero() {
		String carpeta;
		
		System.out.println("Introduce el nombre del fichero o de la carpeta a crear: ");
		carpeta=teclado.nextLine();
		
		return carpeta;
	}
	
	public static String llenarFichero() {
		String rellenoFichero;
		
		System.out.println("Introduce una cadena para rellenar el fichero: ");
		rellenoFichero=teclado.nextLine();
		
		return rellenoFichero;
	}
	
	
}
