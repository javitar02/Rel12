package ejercicio1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;


public class Principal {

	public static void main(String[] args) {
		File file=new File("ReponerProductosAlmacen.txt");
		if(file.isFile()) {
			System.out.println("Error, fichero ya existente");
		}else {
			leerArchivoBinario("ficheros/stock.dat");
		}
		

	}

	private static void leerArchivoBinario(String fileName) {
		
		//FileInputStream ObjectInputStream
		Stock objetoStock;
		boolean fin=false;
		
		try(PrintWriter almacen=new PrintWriter(new FileWriter("ReponerProductosAlmacen.txt"));
				ObjectInputStream lectura=new ObjectInputStream(new FileInputStream(fileName))){
			
			while ( !fin) {
				try {
					objetoStock=(Stock) lectura.readObject();
					
					tratarObjetoStock( objetoStock,almacen);
					
					System.out.println(objetoStock);
				}catch(EOFException e) {
					fin=true;
				}
			}
			
		}catch( IOException e) {
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private static void tratarObjetoStock(Stock objetoStock,PrintWriter almacen) throws IOException {
		int []cantidades=objetoStock.getCantidadesEnAlmacen();
			for (int i = 0; i < cantidades.length; i++) {
				if(cantidades[i]<20) {
					almacen.println("Producto "+objetoStock.getNombre()+" Reponer "
							+ " en el almacen numero "+(i+1)+" por tener stock = "+cantidades[i]);
				}
			}
		
				
		}
	}

