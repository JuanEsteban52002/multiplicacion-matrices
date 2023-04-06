package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {		
		
		String ruta ="./src/resultados/TiempoPromedio.txt";
		ArrayList<String> temp = new ArrayList<>();
		
		//La media, que es lo mismo que el promedio ya esta calculada en un archivo. Por lo que
		//solamente voy a tomar los datos del archivo
		
		//para calcular la varianza
		
		double varianza = 0; 
		
		temp = Utilidades.leerArchivo(ruta);
		
		long[] tiemposAlgoritmos;
		
		String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		
		long[] cadenaTiempos = new long[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
//		String[] cadenaNombres = new String[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
		
		for (int i = 0; i < contenidoArchivo.length; i++) {
			
			cadenaTiempos[i] = Long.parseLong(Utilidades.separarCadena2(contenidoArchivo[i]));
//			cadenaNombres[i]= Utilidades.separarCadena1(contenidoArchivo[i]);
			System.out.println(cadenaTiempos[i]);
		}
		
		tiemposAlgoritmos = Utilidades.obtenerTiemposAlgoritmos();
		
		
		

	}
	
	
	public static long[] obtenerTiemposAlgoritmos() {

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

			algoritmo1 = Long.parseLong(archivos.get(i));
			//			System.out.println(algoritmo1);
		}

		long algoritmo2 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo2 =  Long.parseLong(archivos.get(i+1));
			//			System.out.println(algoritmo2);
		}

		long algoritmo3 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo3 =  Long.parseLong(archivos.get(i+2));
			//			System.out.println(algoritmo3);
		}
		algoritmo3/=12;

		long algoritmo4 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo4 =  Long.parseLong(archivos.get(i+3));
			//			System.out.println(algoritmo4);
		}

		long algoritmo5 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo5 =  algoritmo5 + Long.parseLong(archivos.get(i+4));
			//			System.out.println(algoritmo5);
		}
		algoritmo5/=12;

		long algoritmo6 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo6 = Long.parseLong(archivos.get(i+5));
			//			System.out.println(algoritmo6);
		}
		algoritmo6/=12;

		long algoritmo7 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo7 = algoritmo7 +  Long.parseLong(archivos.get(i+6));
			//			System.out.println(algoritmo7);
		}

		long algoritmo8 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo8 = Long.parseLong(archivos.get(i+7));
			//			System.out.println(algoritmo8);
		}

		long algoritmo9 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo9 = Long.parseLong(archivos.get(i+8));
			//			System.out.println(algoritmo9);
		}

		long algoritmo10 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo10 = Long.parseLong(archivos.get(i+9));
			//			System.out.println(algoritmo10);
		}
		algoritmo10/=12;

		long algoritmo11 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo11 =  Long.parseLong(archivos.get(i+10));
			//			System.out.println(algoritmo11);
		}

		long algoritmo12 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo12 = Long.parseLong(archivos.get(i+11));
			//			System.out.println(algoritmo12);
		}

		long algoritmo13 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo13 = Long.parseLong(archivos.get(i+12));
			//			System.out.println(algoritmo13);
		}

		long algoritmo14 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo14 = Long.parseLong(archivos.get(i+12));
			//			System.out.println(algoritmo14);
		}

		long algoritmo15 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo15 = Long.parseLong(archivos.get(i+14));
			//			System.out.println(algoritmo15);
		}

		long algoritmo16 = 0; 

		for (int i = 0; i < archivos.size(); i+=16) {

			algoritmo16 = Long.parseLong(archivos.get(i+15));
			//			System.out.println(algoritmo16);
		}
		
		
		return null;
	}



	
	
	
	

}
