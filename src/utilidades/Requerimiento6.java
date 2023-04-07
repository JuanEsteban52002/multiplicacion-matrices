package utilidades;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Requerimiento6 {

	public static void main(String[] args) {
		//      JFrame frame = new JFrame();
		//      DefaultTableModel model = new DefaultTableModel();
		//      JTable table = new JTable(model);
		//
		//      // Agregar títulos a las columnas
		//      model.setColumnIdentifiers(new Object[]{"Columna 1", "Columna 2", "Columna 3"});
		//
		//      // Agregar datos a la tabla
		//      model.addRow(new Object[]{"Fila 1, Columna 1", "Fila 1, Columna 2", "Fila 1, Columna 3"});
		//      model.addRow(new Object[]{"Fila 2, Columna 1", "Fila 2, Columna 2", "Fila 2, Columna 3"});
		//
		//      // Agregar títulos a las filas
		//      table.getColumnModel().getColumn(0).setHeaderValue("Título Fila 1");
		//      table.getColumnModel().getColumn(1).setHeaderValue("Título Fila 2");
		//      table.getTableHeader().repaint();
		//
		//      JScrollPane scrollPane = new JScrollPane(table);
		//      frame.add(scrollPane);
		//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//      frame.pack();
		//      frame.setVisible(true);



		//Calcular los estadisticos

		//media de cada algoritmo

		long[] promedioAlgoritmos = new long[16]; //se van a guardar los promedios de cada algoritmo
		long[] tiempos = new long[12];//son 12 tiempos
		String[] contenidoArchivo;

		ArrayList<String> naivStandard = Utilidades.leerArchivo("./src/tiemposIndividuales/naivStandard");
		//		System.out.println(naivStandard);


		contenidoArchivo = naivStandard.toArray(new String[naivStandard.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[0] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[0]);

		ArrayList<String> naivOnArray = Utilidades.leerArchivo("./src/tiemposIndividuales/naivOnArray");
		contenidoArchivo = naivOnArray.toArray(new String[naivOnArray.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[1] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[1]);

		ArrayList<String> naivKahan = Utilidades.leerArchivo("./src/tiemposIndividuales/naivKahan");
		contenidoArchivo = naivKahan.toArray(new String[naivKahan.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[2] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[2]);

		ArrayList<String> naivLoopUnrollingTwo = Utilidades.leerArchivo("./src/tiemposIndividuales/naivLoopUnrollingTwo");
		contenidoArchivo = naivLoopUnrollingTwo.toArray(new String[naivLoopUnrollingTwo.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[3] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[3]);

		ArrayList<String> naiveLoopUnrollingThree = Utilidades.leerArchivo("./src/tiemposIndividuales/naiveLoopUnrollingThree");
		contenidoArchivo = naiveLoopUnrollingThree.toArray(new String[naiveLoopUnrollingThree.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[4] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[4]);

		ArrayList<String> naivLoopUnrollingFour = Utilidades.leerArchivo("./src/tiemposIndividuales/naivLoopUnrollingFour");
		contenidoArchivo = naivLoopUnrollingFour.toArray(new String[naivLoopUnrollingFour.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[5] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[5]);

		ArrayList<String> winogradOriginal = Utilidades.leerArchivo("./src/tiemposIndividuales/winogradOriginal");
		contenidoArchivo = winogradOriginal.toArray(new String[winogradOriginal.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[6] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[6]);

		ArrayList<String> winogradScaled = Utilidades.leerArchivo("./src/tiemposIndividuales/winogradScaled");
		contenidoArchivo = winogradScaled.toArray(new String[winogradScaled.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[7] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[7]);

		ArrayList<String> StrassenNaiv = Utilidades.leerArchivo("./src/tiemposIndividuales/StrassenNaiv");
		contenidoArchivo = StrassenNaiv.toArray(new String[StrassenNaiv.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[8] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[8]);

		ArrayList<String> StrassenWinograd = Utilidades.leerArchivo("./src/tiemposIndividuales/StrassenWinograd");
		contenidoArchivo = StrassenWinograd.toArray(new String[StrassenWinograd.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[9] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[9]);

		ArrayList<String> iiisequentianblock = Utilidades.leerArchivo("./src/tiemposIndividuales/iiisequentianblock");
		contenidoArchivo = iiisequentianblock.toArray(new String[StrassenWinograd.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[10] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[10]);

		ArrayList<String> iiiParallelblock = Utilidades.leerArchivo("./src/tiemposIndividuales/iiiParallelblock");
		contenidoArchivo = iiiParallelblock.toArray(new String[iiiParallelblock.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[11] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[11]);

		ArrayList<String> ivSequentialblock = Utilidades.leerArchivo("./src/tiemposIndividuales/ivSequentialblock");
		contenidoArchivo = ivSequentialblock.toArray(new String[ivSequentialblock.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[12] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[12]);

		ArrayList<String> ivParallelBlock = Utilidades.leerArchivo("./src/tiemposIndividuales/ivParallelBlock");
		contenidoArchivo = ivParallelBlock.toArray(new String[ivParallelBlock.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[13] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[13]);

		ArrayList<String> vSequentialblock = Utilidades.leerArchivo("./src/tiemposIndividuales/vSequentialblock");
		contenidoArchivo = vSequentialblock.toArray(new String[vSequentialblock.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[14] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[14]);

		ArrayList<String> vParallelBlock = Utilidades.leerArchivo("./src/tiemposIndividuales/vParallelBlock");
		contenidoArchivo = vParallelBlock.toArray(new String[vParallelBlock.size()]);
		tiempos = toLong(contenidoArchivo);
		promedioAlgoritmos[15] = calcularPromedio(tiempos);
		System.out.println(promedioAlgoritmos[15]);


		//rango de cada algoritmo
		System.out.println("======================================RANGO=====================================================");

		long[] rangoAlgoritmos = new long[16]; //se van a guardar los promedios de cada algoritmo
		//utilizar el arreglo de tiempos de arriba

		contenidoArchivo =  naivStandard.toArray(new String[naivStandard.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[0] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[0]);

		contenidoArchivo =  naivOnArray.toArray(new String[naivOnArray.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[1] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[1]);

		contenidoArchivo =  naivKahan.toArray(new String[naivKahan.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[2] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[2]);

		contenidoArchivo =  naivLoopUnrollingTwo.toArray(new String[naivLoopUnrollingTwo.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[3] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[3]);

		contenidoArchivo =  naiveLoopUnrollingThree.toArray(new String[naiveLoopUnrollingThree.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[4] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[4]);

		contenidoArchivo =  naivLoopUnrollingFour.toArray(new String[naivLoopUnrollingFour.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[5] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[5]);

		contenidoArchivo =  winogradOriginal.toArray(new String[winogradOriginal.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[6] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[6]);


		contenidoArchivo =  winogradScaled.toArray(new String[winogradScaled.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[7] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[7]);

		contenidoArchivo =  StrassenNaiv.toArray(new String[StrassenNaiv.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[8] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[8]);

		contenidoArchivo =  StrassenWinograd.toArray(new String[StrassenWinograd.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[9] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[9]);	

		contenidoArchivo =  iiisequentianblock.toArray(new String[iiisequentianblock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[10] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[10]);	

		contenidoArchivo =  iiiParallelblock.toArray(new String[iiiParallelblock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[11] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[11]);	

		contenidoArchivo =  ivSequentialblock.toArray(new String[ivSequentialblock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[12] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[12]);	

		contenidoArchivo =  ivParallelBlock.toArray(new String[ivParallelBlock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[13] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[13]);	

		contenidoArchivo =  vSequentialblock.toArray(new String[vSequentialblock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[14] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[14]);

		contenidoArchivo =  vParallelBlock.toArray(new String[vParallelBlock.size()]);
		tiempos = toLong(contenidoArchivo);
		rangoAlgoritmos[15] = calcularRango(tiempos);
		System.out.println(rangoAlgoritmos[15]);


		//Varianza de cada algoritmo
		System.out.println("======================================Varianza=====================================================");
		long[] varianzaAlgoritmos = new long[16]; //se van a guardar los promedios de cada algoritmo
		long[] datos = new long[12];
		long promedio;

		contenidoArchivo =  naivStandard.toArray(new String[naivStandard.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[0];
		varianzaAlgoritmos[0] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[0]);

		contenidoArchivo =  naivOnArray.toArray(new String[naivOnArray.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[1];
		varianzaAlgoritmos[1] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[1]);

		contenidoArchivo =  naivKahan.toArray(new String[naivKahan.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[2];
		varianzaAlgoritmos[2] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[2]);

		contenidoArchivo =  naivLoopUnrollingTwo.toArray(new String[naivLoopUnrollingTwo.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[3];
		varianzaAlgoritmos[3] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[3]);

		contenidoArchivo =  naiveLoopUnrollingThree.toArray(new String[naiveLoopUnrollingThree.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[4];
		varianzaAlgoritmos[4] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[4]);

		contenidoArchivo =  naivLoopUnrollingFour.toArray(new String[naivLoopUnrollingFour.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[5];
		varianzaAlgoritmos[5] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[5]);

		contenidoArchivo =  winogradOriginal.toArray(new String[winogradOriginal.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[6];
		varianzaAlgoritmos[6] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[6]);

		contenidoArchivo =  winogradScaled.toArray(new String[winogradScaled.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[7];
		varianzaAlgoritmos[7] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[7]);

		contenidoArchivo =  StrassenNaiv.toArray(new String[StrassenNaiv.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[8];
		varianzaAlgoritmos[8] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[8]);

		contenidoArchivo =  StrassenWinograd.toArray(new String[StrassenWinograd.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[9];
		varianzaAlgoritmos[9] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[9]);

		contenidoArchivo =  iiisequentianblock.toArray(new String[iiisequentianblock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[10];
		varianzaAlgoritmos[10] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[10]);

		contenidoArchivo =  iiiParallelblock.toArray(new String[iiiParallelblock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[11];
		varianzaAlgoritmos[11] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[11]);

		contenidoArchivo =  ivSequentialblock.toArray(new String[ivSequentialblock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[12];
		varianzaAlgoritmos[12] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[12]);

		contenidoArchivo =  ivParallelBlock.toArray(new String[ivParallelBlock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[13];
		varianzaAlgoritmos[13] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[13]);

		contenidoArchivo =  vSequentialblock.toArray(new String[vSequentialblock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[14];
		varianzaAlgoritmos[14] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[14]);

		contenidoArchivo =  vParallelBlock.toArray(new String[vParallelBlock.size()]);
		datos = toLong(contenidoArchivo);
		promedio = promedioAlgoritmos[15];
		varianzaAlgoritmos[15] = calcularVarianza(datos, promedio);
		System.out.println(varianzaAlgoritmos[15]);
		
		
		
		//desviación estándar
		System.out.println("======================================Desviación Estándar=====================================================");
		long[] desviacionAlgoritmos = new long[16]; //se van a guardar los promedios de cada algoritmo
		
		for (int i = 0; i < varianzaAlgoritmos.length; i++) {
			desviacionAlgoritmos[i] = (long) Math.sqrt(varianzaAlgoritmos[i]);
			System.out.println(desviacionAlgoritmos[i]);
		}


		  	JFrame frame = new JFrame();
		  	DefaultTableModel model = new DefaultTableModel();
		  	JTable table = new JTable(model);
		
		      // Agregar títulos a las columnas
		      model.setColumnIdentifiers(new Object[]{"Nombre Algoritmo", "Media", "Rango", "Desviacion Estandar", "Varianza"});
		
		      // Agregar datos a la tabla
		      model.addRow(new Object[]{"NaivStandard", promedioAlgoritmos[0], rangoAlgoritmos[0], desviacionAlgoritmos[0], varianzaAlgoritmos[0]});
		      model.addRow(new Object[]{"NaivOnArray", promedioAlgoritmos[1], rangoAlgoritmos[1], desviacionAlgoritmos[1], varianzaAlgoritmos[1]});
		      model.addRow(new Object[]{"NaivKahan", promedioAlgoritmos[2], rangoAlgoritmos[2], desviacionAlgoritmos[2], varianzaAlgoritmos[2]});
		      model.addRow(new Object[]{"NaivLoopUnrollingTwo", promedioAlgoritmos[3], rangoAlgoritmos[3], desviacionAlgoritmos[3], varianzaAlgoritmos[3]});
		      model.addRow(new Object[]{"NaivLoopUnrollingThree", promedioAlgoritmos[4], rangoAlgoritmos[4], desviacionAlgoritmos[4], varianzaAlgoritmos[4]});
		      model.addRow(new Object[]{"NaivLoopUnrollingFour", promedioAlgoritmos[5], rangoAlgoritmos[5], desviacionAlgoritmos[5], varianzaAlgoritmos[5]});
		      model.addRow(new Object[]{"WinogradOriginal", promedioAlgoritmos[6], rangoAlgoritmos[6], desviacionAlgoritmos[6], varianzaAlgoritmos[6]});
		      model.addRow(new Object[]{"WinogradScaled", promedioAlgoritmos[7], rangoAlgoritmos[7], desviacionAlgoritmos[7], varianzaAlgoritmos[7]});
		      model.addRow(new Object[]{"StrassenNaiv", promedioAlgoritmos[8], rangoAlgoritmos[8], desviacionAlgoritmos[8], varianzaAlgoritmos[8]});
		      model.addRow(new Object[]{"StrassenWinograd", promedioAlgoritmos[9], rangoAlgoritmos[9], desviacionAlgoritmos[9], varianzaAlgoritmos[9]});
		      model.addRow(new Object[]{"III Sequential Block", promedioAlgoritmos[10], rangoAlgoritmos[10], desviacionAlgoritmos[10], varianzaAlgoritmos[10]});
		      model.addRow(new Object[]{"III Parallel Block", promedioAlgoritmos[11], rangoAlgoritmos[11], desviacionAlgoritmos[11], varianzaAlgoritmos[11]});
		      model.addRow(new Object[]{"IV Sequential Block", promedioAlgoritmos[12], rangoAlgoritmos[12], desviacionAlgoritmos[12], varianzaAlgoritmos[12]});
		      model.addRow(new Object[]{"IV Parallel Block", promedioAlgoritmos[13], rangoAlgoritmos[13], desviacionAlgoritmos[13], varianzaAlgoritmos[13]});
		      model.addRow(new Object[]{"V Sequential Block", promedioAlgoritmos[14], rangoAlgoritmos[14], desviacionAlgoritmos[14], varianzaAlgoritmos[14]});
		      model.addRow(new Object[]{"V Parallel Block", promedioAlgoritmos[15], rangoAlgoritmos[15], desviacionAlgoritmos[15], varianzaAlgoritmos[15]});
		      
		      JScrollPane scrollPane = new JScrollPane(table);
		      frame.add(scrollPane);
		      frame.pack();
		      frame.setVisible(true);
		
		      
		      try {
		          // Agregar un retraso para asegurarse de que la tabla se haya renderizado completamente
		          Thread.sleep(1000);
		
		          // Tomar una captura de pantalla del contenedor que contiene tanto la tabla como el encabezado de la tabla
		          Robot robot = new Robot();
		          Rectangle captureSize = new Rectangle(scrollPane.getSize());
		          Point locationOnScreen = scrollPane.getLocationOnScreen();
		          captureSize.setLocation(locationOnScreen);
		          BufferedImage image = robot.createScreenCapture(captureSize);
		
		          // Guardar la imagen en un archivo
		          ImageIO.write(image, "png", new File("Tabla de Estadisticos.png"));
		      } catch (Exception e) {
		          e.printStackTrace();
		      }
	}

	private static long calcularVarianza(long[] datos, long promedio) {

		long sumaCuadrados = 0;
		long varianza; 

		for (int i = 0; i < datos.length; i++) {
			sumaCuadrados += Math.pow(datos[i] - promedio, 2);
		}

		varianza = sumaCuadrados / 12;

		return varianza;
	}

	private static long[] toLong(String[] contenidoArchivo) {
		long[] tiempos = new long[12];


		for (int i = 0; i < contenidoArchivo.length; i++) {
			//			tiempos[i] = Double.parseDouble(contenidoArchivo[i]);
			tiempos[i] = Long.parseLong(contenidoArchivo[i]);
			//						System.out.println(tiempos[i] + " en long");
		}
		return tiempos;

	}

	private static long calcularPromedio(long[] tiempos) {

		//		for (long datos : tiempos) {
		//			System.out.println("tiempos en suma: "+ datos);
		//		}

		long suma = 0;
		for (int i = 0; i < tiempos.length; i++) {



			suma += tiempos[i];
			//			System.out.println("Suma Iter: " + suma);
		}
		//	    System.out.println("suma" +suma);

		long promedio = suma / 12;

		return promedio;

	}

	private static long calcularRango(long[] tiempos) {

		long[] datosOrdenados = ordenarMenorAMayor(tiempos);

		long rango = datosOrdenados[0] - datosOrdenados.length-1;


		return rango;


	}

	private static long[] ordenarMenorAMayor(long[] tiempos) {

		long temp;
		//		System.out.println("datos ordenados");
		for (int i = 0; i < tiempos.length - 1; i++) {
			for (int j = i + 1; j < tiempos.length; j++) {
				if (tiempos[i] > tiempos[j]) {
					temp = tiempos[i];
					tiempos[i] = tiempos[j];
					tiempos[j] = temp;
				}
			}
			//	        System.out.println(tiempos[i]);
		}

		return tiempos;

	}





}
