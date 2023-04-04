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
		serie.add(1012548, 41552447);
		serie.add(1120459368, 124578631);
		serie.add(74125871, 114520365);
		serie.add(1145233699, 1474125086);
		serie.add(448821153, 112547893);
		dataset.addSeries(serie);
		return dataset;
	}


	private static JFreeChart crearGrafico(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createScatterPlot(
				"Gráfico de dispersión", // Título
				"Eje X", // Etiqueta del eje X
				"Eje Y", // Etiqueta del eje Y
				dataset, // Conjunto de datos
				PlotOrientation.VERTICAL, // Orientación del gráfico
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
