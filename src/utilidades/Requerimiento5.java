package utilidades;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Requerimiento5 {

	public Requerimiento5() {

	}
	
	public static void main(String[] args) throws IOException {
		

		String ruta = "./src/resultados/Tiempos de Ejecucion 8192.txt";
		
		ArrayList<String> temp = new ArrayList<>();
		
		temp = Utilidades.leerArchivo(ruta);
		
		Comparator<String> comparador = new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        long num1 = Long.parseLong(s1.replaceAll("\\D", ""));
		        long num2 = Long.parseLong(s2.replaceAll("\\D", ""));
		        return Long.compare(num1, num2);
		    }
		};

		Collections.sort(temp, comparador);
		
//		System.out.println(temp);
		
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
		File archivo = new File("Oeden creciente los tiempos de ejecución.png");
		ChartUtilities.saveChartAsPNG(archivo, chart, 1200, 800);
	}
	

	
	
	
}
