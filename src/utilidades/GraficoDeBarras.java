package utilidades;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoDeBarras {
	
	public GraficoDeBarras() {
		
	}
    public static void main(String[] args) throws IOException {
        // Crear un conjunto de datos para el gr�fico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Tiempo", "Algoritmo 1");
        dataset.addValue(15, "Tiempo", "Algoritmo 2");
        dataset.addValue(8, "Tiempo", "Algoritmo 3");
        dataset.addValue(12, "Tiempo", "Algoritmo 4");

        // Crear el gr�fico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Tiempos de ejecuci�n",
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
        File archivo = new File("grafico.png");
        ChartUtilities.saveChartAsPNG(archivo, chart, 600, 400);
    }
}
