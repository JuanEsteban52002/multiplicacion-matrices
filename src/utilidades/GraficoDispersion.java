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

		String nombreArchivoResultados = "./src/resultados/TiempoPromedio.txt";

		ArrayList<String> temp = new ArrayList<>();
//		int[] tamanio = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};

		temp = Utilidades.leerArchivo(nombreArchivoResultados);

		String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		
		long[] cadenaTiempos = new long[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
		
		for (int i = 0; i < contenidoArchivo.length; i++) {
			//Promedios de tiempo de ejecucion de cada algoritmo
			cadenaTiempos[i] = Long.parseLong(Utilidades.separarCadena2(contenidoArchivo[i]));
			
		}
		
		
		

			
		
		
		
		

		XYDataset dataset = crearDataset(cadenaTiempos);
		JFreeChart chart = crearGrafico(dataset);
		guardarGrafico(chart, "Grafico de dispersion.png");





	}

	private static XYDataset crearDataset(long[] cadenaTiempos) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries serie = new XYSeries("Tiempo promedio de ejecucion por algoritmo");
		Long temp;
		
		
//		for (int i = 0; i < cadenaTiempos.length; i++) {

//			temp = cadenaTiempos[i];
			serie.add(4, cadenaTiempos[0]);
			serie.add(8, cadenaTiempos[1]);
			serie.add(16, cadenaTiempos[2]);
			serie.add(32, cadenaTiempos[3]);
			serie.add(64, cadenaTiempos[4]);
			serie.add(128, cadenaTiempos[5]);
			serie.add(256, cadenaTiempos[6]);
			serie.add(512, cadenaTiempos[7]);
			serie.add(1024, cadenaTiempos[8]);
			serie.add(2048, cadenaTiempos[9]);
			serie.add(4096, cadenaTiempos[10]);
			serie.add(8192, cadenaTiempos[11]);
			
//		}
		dataset.addSeries(serie);
		return dataset;
	}



	private static JFreeChart crearGrafico(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Grafico de dispersion", // Titulo
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
