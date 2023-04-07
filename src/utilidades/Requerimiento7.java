package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.transform.Templates;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Requerimiento7 {



	public static void main(String[] args) throws Exception {


		ArrayList<String> naivStandard  = Utilidades.leerArchivo("./src/tiemposIndividuales/naivStandard");
		ArrayList<String> naivOnArray  = Utilidades.leerArchivo("./src/tiemposIndividuales/naivOnArray");
		ArrayList<String> naivKahan  = Utilidades.leerArchivo("./src/tiemposIndividuales/naivKahan");
		ArrayList<String> naivLoopUnrollingTwo = Utilidades.leerArchivo("./src/tiemposIndividuales/naivLoopUnrollingTwo");
		ArrayList<String> naiveLoopUnrollingThree  = Utilidades.leerArchivo("./src/tiemposIndividuales/naiveLoopUnrollingThree");
		ArrayList<String> naivLoopUnrollingFour  = Utilidades.leerArchivo("./src/tiemposIndividuales/naivLoopUnrollingFour");
		ArrayList<String> winogradOriginal  = Utilidades.leerArchivo("./src/tiemposIndividuales/winogradOriginal");
		ArrayList<String> winogradScaled  = Utilidades.leerArchivo("./src/tiemposIndividuales/winogradScaled");
		ArrayList<String> StrassenNaiv  = Utilidades.leerArchivo("./src/tiemposIndividuales/StrassenNaiv");
		ArrayList<String> StrassenWinograd  = Utilidades.leerArchivo("./src/tiemposIndividuales/StrassenWinograd");
		ArrayList<String> iiisequentianblock  = Utilidades.leerArchivo("./src/tiemposIndividuales/iiisequentianblock");
		ArrayList<String> iiiParallelblock  = Utilidades.leerArchivo("./src/tiemposIndividuales/iiiParallelblock");
		ArrayList<String> ivSequentialblock  = Utilidades.leerArchivo("./src/tiemposIndividuales/ivSequentialblock");
		ArrayList<String> ivParallelBlock  = Utilidades.leerArchivo("./src/tiemposIndividuales/ivParallelBlock");
		ArrayList<String> vSequentialblock  = Utilidades.leerArchivo("./src/tiemposIndividuales/vSequentialblock");
		ArrayList<String> naivStavParallelBlockndard  = Utilidades.leerArchivo("./src/tiemposIndividuales/vParallelBlock");




		XYDataset dataset = crearDataset(naivStandard);
		JFreeChart chart = crearGrafico(dataset);
		guardarGrafico(chart, "Grafico de dispersion naivStandard.png");
		
		XYDataset dataset2 = crearDataset(naivOnArray);
		JFreeChart chart2 = crearGrafico(dataset2);
		guardarGrafico(chart2, "Grafico de dispersion naivOnArray.png");
		
		XYDataset dataset3 = crearDataset(naivOnArray);
		JFreeChart chart3 = crearGrafico(dataset3);
		guardarGrafico(chart3, "Grafico de dispersion naivKahan.png");
		
		XYDataset dataset4 = crearDataset(naivOnArray);
		JFreeChart chart4 = crearGrafico(dataset4);
		guardarGrafico(chart4, "Grafico de dispersion naivLoopUnrollingTwo.png");
		
		XYDataset dataset5 = crearDataset(naivOnArray);
		JFreeChart chart5 = crearGrafico(dataset5);
		guardarGrafico(chart5, "Grafico de dispersion naiveLoopUnrollingThree.png");
		
		XYDataset dataset6 = crearDataset(naivOnArray);
		JFreeChart chart6 = crearGrafico(dataset6);
		guardarGrafico(chart6, "Grafico de dispersion naivLoopUnrollingFour.png");
		
		XYDataset dataset7 = crearDataset(naivOnArray);
		JFreeChart chart7 = crearGrafico(dataset7);
		guardarGrafico(chart7, "Grafico de dispersion winogradOriginal.png");
		
		XYDataset dataset16 = crearDataset(naivOnArray);
		JFreeChart chart16 = crearGrafico(dataset16);
		guardarGrafico(chart16, "Grafico de dispersion winogradScaled.png");
		
		XYDataset dataset8 = crearDataset(naivOnArray);
		JFreeChart chart8 = crearGrafico(dataset8);
		guardarGrafico(chart8, "Grafico de dispersion StrassenNaiv.png");
		
		XYDataset dataset9 = crearDataset(naivOnArray);
		JFreeChart chart9 = crearGrafico(dataset9);
		guardarGrafico(chart9, "Grafico de dispersion StrassenWinograd.png");
		
		XYDataset dataset10 = crearDataset(naivOnArray);
		JFreeChart chart10 = crearGrafico(dataset10);
		guardarGrafico(chart10, "Grafico de dispersion iiisequentianblock.png");
		
		XYDataset dataset11 = crearDataset(naivOnArray);
		JFreeChart chart11 = crearGrafico(dataset11);
		guardarGrafico(chart11, "Grafico de dispersion iiiParallelblock.png");
		
		XYDataset dataset12 = crearDataset(naivOnArray);
		JFreeChart chart12 = crearGrafico(dataset12);
		guardarGrafico(chart12, "Grafico de dispersion ivSequentialblock.png");
		
		XYDataset dataset13 = crearDataset(naivOnArray);
		JFreeChart chart13 = crearGrafico(dataset13);
		guardarGrafico(chart13, "Grafico de dispersion ivParallelBlock.png");
		
		XYDataset dataset14 = crearDataset(naivOnArray);
		JFreeChart chart14 = crearGrafico(dataset14);
		guardarGrafico(chart14, "Grafico de dispersion vSequentialblock.png");
		
		XYDataset dataset15 = crearDataset(naivOnArray);
		JFreeChart chart15 = crearGrafico(dataset15);
		guardarGrafico(chart15, "Grafico de dispersion vParallelBlock.png");

	}



	private static XYDataset crearDataset(ArrayList<String> tiempos) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries serie = new XYSeries("Tiempo promedio de ejecucion por algoritmo");

		String[] contenidoString = tiempos.toArray(new String[tiempos.size()]);
		long contenidoArchivo;
		int tamanio = 4;

		for (int i = 0; i < contenidoString.length; i++) {
			contenidoArchivo = Long.parseLong(contenidoString[i]);


			serie.add(tamanio, contenidoArchivo);
			tamanio*=2;
		}
		dataset.addSeries(serie);
		return dataset;
	}



	private static JFreeChart crearGrafico(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Grafico de dispersion de los algoritmos con respecto a los tamaños de la matrices.", // Titulo
				"Tamaño matrices", // Etiqueta del eje X
				"Tiempos de ejecuacion", // Etiqueta del eje Y
				dataset, // Conjunto de datos
				PlotOrientation.VERTICAL, // Orientaci�n del gr�fico
				true, // Leyenda
				true, // Tooltips
				false // URLs
				);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(null);

		return chart;
	}

	private static void guardarGrafico(JFreeChart chart, String ruta) throws Exception {
		ChartUtilities.saveChartAsPNG(new File(ruta), chart, 600, 400);
	}

}
