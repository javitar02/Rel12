package ej7;

import java.io.FileInputStream;
import java.io.ObjectOutput;


public class Principal {

	public static void main(String[] args)  {
		int[]cantidadNueva=new int[12];
		Stock nuevo=new Stock("STOCK PISCINAS","JARDIN",cantidadNueva);
		crearFichero(nuevo);
	}

	private static void crearFichero(Stock nuevo) {
		try (FileInputStream lectura=new FileInputStream("stock.dat")){
			
			byte fis[]=lectura.readAllBytes();
			for (int i = 0; i < fis.length; i++) {
				System.out.println(fis[i]);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
