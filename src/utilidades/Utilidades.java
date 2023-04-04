package utilidades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Utilidades {

	public Utilidades() {

	}

	public static void guardarResultado( String nombreAlgoritmo, long tiempo, String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write(nombreAlgoritmo + " - " + tiempo + "\n"); // agregar el resultado y el parametro adicional al final del archivo
			archivo.close(); // cerrar el archivo
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
			e.printStackTrace();
		}
	}
	
	public static void guardarEstadisticos( double media, double varianza, double desviacionEstandar, double rango,  String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write("Media" + " - " + media + "\n" ); // agregar el resultado y el parametro adicional al final del archivo
			archivo.write("Varianza" + " - " + varianza + "\n" );
			archivo.write("desviacionEstandar" + " - " + desviacionEstandar + "\n" );
			archivo.write("rango" + " - " + rango + "\n" );
			archivo.close(); // cerrar el archivo
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
			e.printStackTrace();
		}
	}

	public static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}


	public static int[][] generarMatriz(int n) {
		int[][] matriz = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
			}
		}
		return matriz;
	}

	public static void guardarMatriz(int[][] matriz, String archivo) {
		try {
			FileWriter writer = new FileWriter(archivo);
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					writer.write(matriz[i][j] + " ");
				}
				writer.write("\n");
			}
			writer.close();
			System.out.println("La matriz se ha guardado correctamente en el archivo " + archivo);
		} catch (IOException e) {
			System.out.println("Error al guardar la matriz en el archivo " + archivo);
			e.printStackTrace();
		}
	}



	public static double calcularMedia(ArrayList<Long> datos) {

		Long sumatoria = 0L;
		int cantidadDatos = datos.size();

		for (Long dato : datos) {
			sumatoria += dato;
		}
		


		double media = (double) sumatoria / cantidadDatos;
		
        String numeroFormateado = String.format("%.4f", media);
        System.out.println("La media de los datos es:  " + numeroFormateado);
        
		return media;	

	}
	
	
	public static double calcularRango(ArrayList<Long> datos) {
		
		long datoMayor, datoMenor, rango;
		ArrayList<Long> datosOrdenados = ordenarDeMayorAMenor(datos);
		
        datoMayor = datosOrdenados.get(0);
        datoMenor = datosOrdenados.get(datosOrdenados.size()-1);
        
       rango = datoMayor - datoMenor;
       
       System.out.println("El rango entre los datos es: " + rango);
       
	return rango;
  
	}
	
    public static ArrayList<Long> ordenarDeMayorAMenor(ArrayList<Long> datos) {
        Comparator<Long> comparador = Collections.reverseOrder();
        Collections.sort(datos, comparador);
        return datos;
    }
    
    
    public static double calcularVarianza(ArrayList<Long> datos, double media) {
        double sumaCuadrados = 0;
        double varianza; 
        for (long dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }
        
        varianza = sumaCuadrados / (datos.size() - 1);
        System.out.println("La varianza es: " + varianza);
        
        return varianza;
		
	}
    


}
