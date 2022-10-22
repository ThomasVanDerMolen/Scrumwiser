
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

/*
 * credit to https://www.tutorialspoint.com/javafx/line_chart.htm for helping setup a line chart in javafx
 */

public class burndown
{
    //private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private CategoryAxis xAxis = new CategoryAxis();
    private GridPane burndownGridPane = new GridPane();
    private LineChart<String,Number> linechart = new LineChart(xAxis,yAxis);
    private XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
    private ArrayList<SprintOption> sprints;

    public burndown(){
        burndownGridPane.setAlignment(Pos.CENTER);
        burndownGridPane.add(linechart,0,0);
    }

    private void setChart(){
        series.setName(sprints.get(0).getSprintName());
        series.getData().add(new XYChart.Data("one",1));
        series.getData().add(new XYChart.Data("test",0));
        linechart.getData().add(series);
        linechart.setCreateSymbols(false);
    }

    public GridPane getBurndownGridPane(){
        return burndownGridPane;
    }

    public void setSprints(ArrayList<SprintOption> inputSprints){
        sprints = inputSprints;
        System.out.println(sprints.get(0).getStartDate());
        System.out.println(sprints.get(0).getStartDate().getClass());
        String thedate = String.valueOf(sprints.get(0).getStartDate());
        System.out.println(thedate);
        System.out.println(thedate.getClass());

        System.out.println(sprints.get(0).getEndDate());
        setChart();
    }
}
