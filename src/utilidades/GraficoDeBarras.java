package utilidades;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoDeBarras {

	public GraficoDeBarras() {

	}
	public static void main(String[] args) throws IOException {

		String nombreArchivoResultados = "./src/resultados/TiempoPromedio.txt";

		ArrayList<String> temp = new ArrayList<>();

		temp = Utilidades.leerArchivo(nombreArchivoResultados);

		String[] contenidoArchivo = temp.toArray(new String[temp.size()]);
		
		long[] cadenaTiempos = new long[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
		String[] cadenaNombres = new String[16]; // el tamaño es 16, ya que sabemos que no tenemos mas de esos algoritmos
		
		for (int i = 0; i < contenidoArchivo.length; i++) {
			
			cadenaTiempos[i] = Long.parseLong(Utilidades.separarCadena2(contenidoArchivo[i]));
			cadenaNombres[i]= Utilidades.separarCadena1(contenidoArchivo[i]);

		}
		



		// Crear un conjunto de datos para el gr�fico 
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i < cadenaTiempos.length; i++) {
			dataset.addValue(cadenaTiempos[i], "Algoritmos", cadenaNombres[i]);
			
		}

		

		// Crear el gr�fico de barras
		JFreeChart chart = ChartFactory.createBarChart(
				"Tiempos de ejecucion",
				"Algoritmos",
				"Tiempo (ms)",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
				);
		// Configurar el color de fondo del gr�fico
		chart.setBackgroundPaint(Color.white);

		// Guardar el gr�fico en un archivo PNG
		File archivo = new File("Promedio de tiempo de ejecucion de los algoritmos.png");
		ChartUtilities.saveChartAsPNG(archivo, chart, 1200, 800);
	}
	
	
	
}
