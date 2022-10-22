
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
    private ArrayList<String> dates = new ArrayList<String>();

    public burndown(){
        burndownGridPane.setAlignment(Pos.CENTER);
        burndownGridPane.add(linechart,0,0);
    }

    private void setChart(){
        series.setName(sprints.get(0).getSprintName());
        series.getData().add(new XYChart.Data(String.valueOf(sprints.get(0).getStartDate()),sprints.get(0).getAllocatedPoints()));
        series.getData().add(new XYChart.Data(String.valueOf(sprints.get(0).getEndDate()),0));
        linechart.getData().add(series);
        linechart.setCreateSymbols(false);
    }

    public GridPane getBurndownGridPane(){
        return burndownGridPane;
    }

    public void setSprints(ArrayList<SprintOption> inputSprints){
        sprints = inputSprints;
        LocalDate date1 = sprints.get(0).getStartDate();
        LocalDate date2 = sprints.get(0).getEndDate();
        LocalDate temp = date1;
        int daysBetween = date1.until(date2).getDays();
        dates.add(String.valueOf(date1.getMonthValue()) + "-" + String.valueOf(date1.getDayOfMonth()));
        for(int i=0; i<daysBetween;i++){
            temp = temp.plusDays(1);
            dates.add(String.valueOf(temp.getMonthValue()) + "-" + String.valueOf(temp.getDayOfMonth()));
        }
        System.out.println(dates);
        setChart();
    }
}
