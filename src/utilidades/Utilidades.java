package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Utilidades {

	public Utilidades() {

	}

	public static void guardarResultado( String nombreAlgoritmo, long tiempo, String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write(nombreAlgoritmo + "-" + tiempo + "\n"); // agregar el resultado y el parametro adicional al final del archivo
			archivo.close(); // cerrar el archivo
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
			e.printStackTrace();
		}
	}
	
	public static void guardarResultado2(long tiempo, String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write(tiempo + "\n"); // agregar el resultado y el parametro adicional al final del archivo
			archivo.close(); // cerrar el archivo
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
			e.printStackTrace();
		}
	}

	public static void guardarEstadisticos( double media, double varianza, double desviacionEstandar, double rango,  String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write("Media" + "-" + media + "\n" ); // agregar el resultado y el parametro adicional al final del archivo
			archivo.write("Varianza" + "-" + varianza + "\n" );
			archivo.write("desviacionEstandar" + "-" + desviacionEstandar + "\n" );
			archivo.write("rango" + "-" + rango + "\n" );
			archivo.close(); // cerrar el archivo
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
			e.printStackTrace();
		}
	}


	public static void guardarPromedio( String nombreAlgoritmo, long promedio, String nombreArchivo) {
		try {
			FileWriter archivo = new FileWriter(nombreArchivo, true); // true para abrir en modo de append
			archivo.write(nombreAlgoritmo + "-" + promedio + "\n"); // agregar el resultado y el parametro adicional al final del archivo
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


	public static  ArrayList<String> leerArchivo(String ruta) {


		String nombreArchivo = ruta;
		ArrayList<String> texto = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

			String linea;

			while ((linea = br.readLine()) != null) {
				//				System.out.println(linea);
				texto.add(linea);

			}
			return texto;

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
		return texto;

	}

	public static String separarCadena1(String cadena) {


		String[] arregloCadena = cadena.split("-");

		String cadenaSeparada = arregloCadena[0];

		return cadenaSeparada;

	}

	public static String separarCadena2(String cadena) {


		String[] arregloCadena = cadena.split("-");

		String cadenaSeparada = arregloCadena[1];

		return cadenaSeparada;

	}



	public static void calcularPromedio() {


		String nombreArchivo = "./src/resultados/TiempoPromedio.txt";


		ArrayList<String> archivos = new ArrayList<String>();
		File[] files = {new File("./src/resultados/Tiempos de Ejecucion 4.txt"), new File("./src/resultados/Tiempos de Ejecucion 8.txt"),
				new File("./src/resultados/Tiempos de Ejecucion 16.txt"), new File("./src/resultados/Tiempos de Ejecucion 32.txt"),
				new File("./src/resultados/Tiempos de Ejecucion 64.txt"), new File("./src/resultados/Tiempos de Ejecucion 128.txt"),
				new File("./src/resultados/Tiempos de Ejecucion 256.txt"), new File("./src/resultados/Tiempos de Ejecucion 512.txt"),
				new File("./src/resultados/Tiempos de Ejecucion 1024.txt"), new File("./src/resultados/Tiempos de Ejecucion 2048.txt"),
				new File("./src/resultados/Tiempos de Ejecucion 4096.txt"), new File("./src/resultados/Tiempos de Ejecucion 8192.txt")};

		for (File file : files) {
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					archivos.add(Utilidades.separarCadena2(line));
					//					archivos.add(line);

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}


		//		int i=1;
		//		for (String indice : archivos) {
		//			System.out.print(i + " ");
		//			System.out.println(indice);
		//			i++;
		//		}



		long algoritmo1 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo1 =  algoritmo1 + Long.parseLong(archivos.get(i));
			//			System.out.println(algoritmo1);
		}
		algoritmo1/=12;

		long algoritmo2 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo2 =  algoritmo2 + Long.parseLong(archivos.get(i+1));
			//			System.out.println(algoritmo2);
		}
		algoritmo2/=12;

		long algoritmo3 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo3 = algoritmo3 +  Long.parseLong(archivos.get(i+2));
			//			System.out.println(algoritmo3);
		}
		algoritmo3/=12;

		long algoritmo4 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo4 =  algoritmo4 + Long.parseLong(archivos.get(i+3));
			//			System.out.println(algoritmo4);
		}
		algoritmo4/=12;

		long algoritmo5 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo5 =  algoritmo5 + Long.parseLong(archivos.get(i+4));
			//			System.out.println(algoritmo5);
		}
		algoritmo5/=12;

		long algoritmo6 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo6 = algoritmo6 +  Long.parseLong(archivos.get(i+5));
			//			System.out.println(algoritmo6);
		}
		algoritmo6/=12;

		long algoritmo7 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo7 = algoritmo7 +  Long.parseLong(archivos.get(i+6));
			//			System.out.println(algoritmo7);
		}
		algoritmo7/=12;

		long algoritmo8 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo8 = algoritmo8 +  Long.parseLong(archivos.get(i+7));
			//			System.out.println(algoritmo8);
		}
		algoritmo8/=12;

		long algoritmo9 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo9 = algoritmo9 +  Long.parseLong(archivos.get(i+8));
			//			System.out.println(algoritmo9);
		}
		algoritmo9/=12;

		long algoritmo10 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo10 = algoritmo10 +  Long.parseLong(archivos.get(i+9));
			//			System.out.println(algoritmo10);
		}
		algoritmo10/=12;

		long algoritmo11 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo11 = algoritmo11 +  Long.parseLong(archivos.get(i+10));
			//			System.out.println(algoritmo11);
		}
		algoritmo11/=12;

		long algoritmo12 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo12 = algoritmo12 +  Long.parseLong(archivos.get(i+11));
			//			System.out.println(algoritmo12);
		}
		algoritmo12/=12;

		long algoritmo13 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo13 = algoritmo13 +  Long.parseLong(archivos.get(i+12));
			//			System.out.println(algoritmo13);
		}
		algoritmo13/=12;

		long algoritmo14 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo14 = algoritmo14 +  Long.parseLong(archivos.get(i+12));
			//			System.out.println(algoritmo14);
		}
		algoritmo14/=12;

		long algoritmo15 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo15 = algoritmo15 +  Long.parseLong(archivos.get(i+14));
			//			System.out.println(algoritmo15);
		}
		algoritmo15/=12;

		long algoritmo16 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo16 = algoritmo16 +  Long.parseLong(archivos.get(i+15));
			//			System.out.println(algoritmo16);
		}
		algoritmo16/=12;


		Utilidades.guardarPromedio("naivStandard", algoritmo1, nombreArchivo);
		Utilidades.guardarPromedio("naivOnArray", algoritmo2, nombreArchivo);
		Utilidades.guardarPromedio("naivKahan", algoritmo3, nombreArchivo);
		Utilidades.guardarPromedio("naivLoopUnrollingTwo", algoritmo4, nombreArchivo);
		Utilidades.guardarPromedio("naiveLoopUnrollingThree", algoritmo5, nombreArchivo);
		Utilidades.guardarPromedio("naivLoopUnrollingFour", algoritmo6, nombreArchivo);
		Utilidades.guardarPromedio("winogradOriginal", algoritmo7, nombreArchivo);
		Utilidades.guardarPromedio("winogradScaled", algoritmo8, nombreArchivo);
		Utilidades.guardarPromedio("StrassenNaiv", algoritmo9, nombreArchivo);
		Utilidades.guardarPromedio("StrassenWinograd", algoritmo10, nombreArchivo);
		Utilidades.guardarPromedio("iiisequentianblock", algoritmo11, nombreArchivo);
		Utilidades.guardarPromedio("iiiParallelblock", algoritmo12, nombreArchivo);
		Utilidades.guardarPromedio("ivSequentialblock", algoritmo13, nombreArchivo);
		Utilidades.guardarPromedio("ivParallelBlock", algoritmo14, nombreArchivo);
		Utilidades.guardarPromedio("vSequentialblock", algoritmo15, nombreArchivo);
		Utilidades.guardarPromedio("vParallelBlock", algoritmo16, nombreArchivo);

		System.out.println("Se guardo el archivo de los promedios");


	}
	
	public static void menorAMayorUltimaMatriz() {
		
		String ruta = "./src/resultados/Tiempos de Ejecucion 8192.txt";
		
		ArrayList<String> temp = new ArrayList<>();
		
		temp = leerArchivo(ruta);
		
		String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		
	
	}
	

	
	public static void calcularEstadisticos() {
		
		String ruta ="./src/resultados/TiempoPromedio.txt";
		ArrayList<String> temp = new ArrayList<>();
		
		//La media, que es lo mismo que el promedio ya esta calculada en un archivo. Por lo que
		//solamente voy a tomar los datos del archivo
		
		//para calcular la varianza
		
		double varianza = 0; 
		
		temp = Utilidades.leerArchivo(ruta);
		
		String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		
		double[] cadenaTiempos = new double[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
//		String[] cadenaNombres = new String[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
		
		for (int i = 0; i < contenidoArchivo.length; i++) {
			
			cadenaTiempos[i] = Double.parseDouble(Utilidades.separarCadena2(contenidoArchivo[i]));
//			cadenaNombres[i]= Utilidades.separarCadena1(contenidoArchivo[i]);
			System.out.println(cadenaTiempos[i]);
		}
		
	}
	


}







