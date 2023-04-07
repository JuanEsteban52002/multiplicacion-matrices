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

		//media

		long[] promedioAlgoritmos = new long[16]; //se van a guardar los promedios de cada algoritmo
		long[] tiempos = new long[12];
		String[] contenidoArchivo;

		ArrayList<String> naivStandard = Utilidades.leerArchivo("./src/tiemposIndividuales/naivStandard");
		System.out.println(naivStandard);
		
		
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


		//  	JFrame frame = new JFrame();
		//  	DefaultTableModel model = new DefaultTableModel();
		//  	JTable table = new JTable(model);
		//
		//      // Agregar títulos a las columnas
		//      model.setColumnIdentifiers(new Object[]{"Nombre Algoritmo", "Media", "Rango", "Desviacion Estandar", "Varianza"});
		//
		//      // Agregar datos a la tabla
		//      model.addRow(new Object[]{"NaivStandard", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"NaivOnArray", "Fila 2, Columna 1", "Fila 2, Columna 2"});
		//      model.addRow(new Object[]{"NaivKahan", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"NaivLoopUnrollingTwo", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"NaivLoopUnrollingThree", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"NaivLoopUnrollingFour", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"WinogradOriginal", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"WinogradScaled", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"StrassenNaiv", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"StrassenWinograd", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"III Sequential Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"III Parallel Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"IV Sequential Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"IV Parallel Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"V Sequential Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      model.addRow(new Object[]{"V Parallel Block", "Fila 1, Columna 1", "Fila 1, Columna 2", "", ""});
		//      
		//      JScrollPane scrollPane = new JScrollPane(table);
		//      frame.add(scrollPane);
		//      frame.pack();
		//      frame.setVisible(true);
		//
		//      
		//      try {
		//          // Agregar un retraso para asegurarse de que la tabla se haya renderizado completamente
		//          Thread.sleep(1000);
		//
		//          // Tomar una captura de pantalla del contenedor que contiene tanto la tabla como el encabezado de la tabla
		//          Robot robot = new Robot();
		//          Rectangle captureSize = new Rectangle(scrollPane.getSize());
		//          Point locationOnScreen = scrollPane.getLocationOnScreen();
		//          captureSize.setLocation(locationOnScreen);
		//          BufferedImage image = robot.createScreenCapture(captureSize);
		//
		//          // Guardar la imagen en un archivo
		//          ImageIO.write(image, "png", new File("Tabla de Estadisticos.png"));
		//      } catch (Exception e) {
		//          e.printStackTrace();
		//      }
	}

	private static long[] toLong(String[] contenidoArchivo) {
		long[] tiempos = new long[12];


		for (int i = 0; i < contenidoArchivo.length; i++) {
			//			tiempos[i] = Double.parseDouble(contenidoArchivo[i]);
			tiempos[i] = Long.parseLong(contenidoArchivo[i]);
//						System.out.print(tiempos[i] + " ");
		}
		return tiempos;

	}

	private static long calcularPromedio(long[] tiempos) {

//		for (long datos : tiempos) {
//			System.out.println("tiempos en suma: "+ datos);
//		}

		int suma = 0;
		for (int i = 0; i < tiempos.length; i++) {
			
			

			suma += tiempos[i];
//			System.out.println("Suma Iter: " + suma);
		}
		//	    System.out.println("suma" +suma);

		long promedio = suma / 12;

		return promedio;

	}




}
