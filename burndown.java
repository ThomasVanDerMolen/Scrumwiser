
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/*
 * credit to https://www.tutorialspoint.com/javafx/line_chart.htm for helping setup a line chart in javafx
 * http://www.java2s.com/ref/java/java-localdate-set-to-future-day.html
 * https://docs.oracle.com/javafx/2/charts/line-chart.htm
 * https://docs.oracle.com/javafx/2/ui_controls/radio-button.htm
 */

public class burndown
{
    //private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private CategoryAxis xAxis = new CategoryAxis();
    private GridPane burndownGridPane = new GridPane();
    private LineChart<String,Number> linechart = new LineChart<String,Number>(xAxis,yAxis);
    private XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
    private XYChart.Series<String,Number> usedPointsSeries = new XYChart.Series<String,Number>();
    private ArrayList<SprintOption> sprints;
    private ArrayList<String> dates = new ArrayList<String>();

    private GridPane bottomMenu = new GridPane();
    private ToggleGroup toggleGroup = new ToggleGroup();
    private RadioButton fiveDayCycle = new RadioButton("Five Day");
    private RadioButton sevenDayCycle = new RadioButton("Seven Day");
    private ComboBox<String> sprintSelection = new ComboBox<>();
    private HashMap<String,SprintOption> sprintNames = new HashMap<>();
    private guiComponents parentObject;

    public burndown(guiComponents inputParentObject){
        parentObject = inputParentObject;
        sprints = parentObject.getSprints();
        burndownGridPane.setAlignment(Pos.CENTER);
        burndownGridPane.add(linechart,0,0);
        setSprints();
        setBottomMenu();
    }

    public void setSprints(){
        for(SprintOption x : sprints){
            sprintNames.put(x.getSprintName(),x);
        }
        sprintSelection.setItems(FXCollections.observableArrayList(sprintNames.keySet()));
        LocalDate date1 = sprints.get(0).getStartDate();
        LocalDate date2 = sprints.get(0).getEndDate();
        LocalDate temp = date1;
        int daysBetween = date1.until(date2).getDays();
        dates.add(String.valueOf(date1.getMonthValue()) + "-" + String.valueOf(date1.getDayOfMonth()));
        for(int i=0; i<daysBetween;i++){
            temp = temp.plusDays(1);
            dates.add(String.valueOf(temp.getMonthValue()) + "-" + String.valueOf(temp.getDayOfMonth()));
        }
        setChart();
    }

    private void setChart(){
        series.setName(sprints.get(0).getSprintName());
        //create the ideal burndown line
        String startDateString = String.valueOf(sprints.get(0).getStartDate().getMonthValue()) + "-" + String.valueOf(sprints.get(0).getStartDate().getDayOfMonth());
        String endDateString = String.valueOf(sprints.get(0).getEndDate().getMonthValue() + "-" + String.valueOf(sprints.get(0).getEndDate().getDayOfMonth()));
        LocalDate startDate = sprints.get(0).getStartDate();
        LocalDate endDate = sprints.get(0).getEndDate();
        int daysBetween = startDate.until(endDate).getDays();
        double idealPointTrackerTemp = sprints.get(0).getAllocatedPoints();
        double pointsToSubtract = idealPointTrackerTemp/daysBetween;

        for(int i = 0; i < dates.size(); i++){
            series.getData().add(new XYChart.Data<String,Number>(dates.get(i),idealPointTrackerTemp));
            idealPointTrackerTemp -= pointsToSubtract;
        }

        usedPointsSeries.getData().add(new XYChart.Data<String,Number>(startDateString,10));
        usedPointsSeries.getData().add(new XYChart.Data<String,Number>(endDateString,10));

        linechart.setLegendVisible(false);
        linechart.getData().add(series);
        linechart.getData().add(usedPointsSeries);
        linechart.setCreateSymbols(false);
    }

    private void setBottomMenu(){
        bottomMenu.add(sprintSelection,0,0);
        bottomMenu.add(fiveDayCycle,1,0);
        bottomMenu.add(sevenDayCycle,2,0);
        fiveDayCycle.setToggleGroup(toggleGroup);
        sevenDayCycle.setSelected(true);
        sevenDayCycle.setToggleGroup(toggleGroup);
    }

    public GridPane getBurndownGridPane(){
        return burndownGridPane;
    }

    public GridPane getBottomMenu(){
        return bottomMenu;
    }
}
