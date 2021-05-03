package ej1;

import java.io.File;
import java.util.Scanner;

public class Menu {
private static final int OPCION_SALIR = 5;
	
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		
		int opcion;
		
		
		do{
			opcion=mostrarMenu();
			tratarMenu(opcion);
		}while (opcion!=OPCION_SALIR);

	}
	
	private static void tratarMenu(int opc) {
		String nomDirectorio;
		String nomFichero;
		String cadena;
		boolean creado=false;
		
		nomDirectorio=solicitarNombreFichero();
		try{
			switch (opc){
			case 1:{
				
				
				File directorio=new File(nomDirectorio);
			
				break;
			}
			case 2:{
				System.out.println("Introduce el nombre del fichero: ");
				nomFichero=teclado.nextLine();
				
				File fichero=new File(nomFichero);
				
				System.out.println("Introduce una cadena: ");
				cadena=teclado.nextLine();
				
				File fichero=new File(cadena);
				
				System.out.println("Se ha cerrado la caja correctamente");
				break;
			}
			case 3:{
				System.out.println(almacen.nuevoCliente());
				System.out.println("Se ha annadido un nuevo cliente");
				break;
			}
			case 4:{
				numeroCaja=introducirNumeroEntero("Introduzca el numero de caja donde desea atender:");
				numeroCliente=almacen.atenderCliente(numeroCaja);
				System.out.println("Se ha atendido al cliente " + numeroCliente);
				break;
			}
		
			case 5:{
				System.out.println("FIN DEL PROGRAMA");
				break;
			}
			}
		}catch (CajaException ex){
			System.out.println(ex.getMessage());
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
		String cadena;
		
		System.out.println("Introduce una cadena: ");
		cadena=teclado.nextLine();
		
		return cadena;
	}
	
	
	
}
