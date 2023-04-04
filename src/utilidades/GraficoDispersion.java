package utilidades;

import java.io.File;

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
		XYDataset dataset = crearDataset();
		JFreeChart chart = crearGrafico(dataset);
		guardarGrafico(chart, "grafico_dispersion.png");
	}

	private static XYDataset crearDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries serie = new XYSeries("Datos de ejemplo");
		serie.add(4, 1);
		serie.add(8, 2);
		serie.add(16, 3);
		serie.add(32, 4);
		serie.add(64, 5);
		serie.add(128, 5);
		serie.add(256, 5);
		serie.add(512, 5);
		serie.add(1024, 5);
		serie.add(2048, 5);
		serie.add(4096, 5);
		serie.add(8192, 5);


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
