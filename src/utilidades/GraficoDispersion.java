package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
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

public class GraficoDispersion {



	public static void main(String[] args) throws Exception {























		//		int tamanio = 4;
		//		String[] datos = new String[11];
		////		ArrayList<String> temp = new ArrayList<>();
		//		String[] temp = new String[15];
		//		String archivoIndividual; 
		//
		//		for (int i = 0; i <= 11; i++) {
		//			
		//			String nombreArchivoResultados = "./src/resultados/Tiempos de Ejecucion "+ tamanio  +".txt";
		//
		//			archivoIndividual = Utilidades.leerArchivo(nombreArchivoResultados);
		//			
		//			
		//			
		//			tamanio *=2;
		//
		//		}
		//		
		//	
		//		
		//		System.out.println(temp.get(1));




		//			String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		//			
		//			String linea = contenidoArchivo[i]; //necesito 16 i´s pero solamente tengo 12 (buscar solucion)
		//			
		//			String nombre = Utilidades.separarCadena1(linea);
		//			
		//			datos[i] = Utilidades.separarCadena2(linea);
		//			
		//			System.out.println(datos[i]);

		//			XYDataset dataset = crearDataset(datos, nombre, tamanio);
		//			JFreeChart chart = crearGrafico(dataset);
		//			guardarGrafico(chart, nombre + ".png");
		//			guardarGrafico(chart, "ejemplo.png");





	}

	private static XYDataset crearDataset(String[] datos, String nombre, int tamanio) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries serie = new XYSeries(nombre);
		Long temp;
		for (int i = 0; i < datos.length; i++) {

			temp = Long.parseLong(datos[i]);
			serie.add(tamanio, temp);
		}
		dataset.addSeries(serie);
		return dataset;
	}



	private static JFreeChart crearGrafico(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Grafico de dispersion", // Titulo
				"Eje X", // Etiqueta del eje X
				"Eje Y", // Etiqueta del eje Y
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
