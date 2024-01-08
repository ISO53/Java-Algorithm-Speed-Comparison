import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LineChart extends JFrame {

    public LineChart(String title, List<String> methodNames, List<List<Long>> executionTimes) {
        super(title);

        XYDataset dataset = createDataset(methodNames, executionTimes);
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(List<String> methodNames, List<List<Long>> executionTimes) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < methodNames.size(); i++) {
            XYSeries series = new XYSeries(methodNames.get(i));

            List<Long> times = executionTimes.get(i);
            for (int j = 0; j < times.size(); j++) {
                series.add(j + 1, times.get(j));
            }

            dataset.addSeries(series);
        }

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Method Execution Times",
                "Run Number",
                "Execution Time (ms)",
                dataset
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(1));

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }
}
