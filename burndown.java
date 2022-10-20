import java.util.ArrayList;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

/*
 * credit to https://www.tutorialspoint.com/javafx/line_chart.htm for helping setup a line chart in javafx
 */

public class burndown
{
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private GridPane burndownGridPane = new GridPane();
    private LineChart linechart = new LineChart(xAxis,yAxis);
    private XYChart.Series series = new XYChart.Series();

    public burndown(){
        setChart();
        burndownGridPane.add(linechart,0,0);
    }

    private void setChart(){
        series.setName("Sprint X");
        series.getData().add(new XYChart.Data(0,25));
        series.getData().add(new XYChart.Data(10,0));
        linechart.getData().add(series);
    }

    public GridPane getBurndownGridPane(){
        return burndownGridPane;
    }
}
