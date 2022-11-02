import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;


/*
 * Some credit is owed to https://www.youtube.com/watch?v=vego72w5kPU for the table feature.(as it is currently implemented)
 */

 

public class SprintOption extends GridPane{
    Label sprint_label= new Label("");
    Label sprintpointcapacity= new Label("");
    private ContextMenu rightClickMenu = new ContextMenu();
    private MenuItem MIDeleteSprint = new MenuItem("Delete Sprint");
    private MenuItem SetSprintValue= new MenuItem("Set Available Points");
    private popupWindow popupWindow= new popupWindow(this);

    private String sprintName;
    //private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();
    private ObservableList<backlogItemGrid> backlogObservableList = FXCollections.observableArrayList();
    private TableView<backlogItemGrid> sp1_table= new TableView<backlogItemGrid>();
    private TableColumn<backlogItemGrid,String> sp1_backlog = new TableColumn<backlogItemGrid,String>("Backlog Item");
    public TableColumn<backlogItemGrid,String> sp1_points = new TableColumn<backlogItemGrid,String>("Points");
   // private TableColumn<backlogItemGrid,String> sp1_rempoints = new TableColumn<backlogItemGrid,String>("Remaining Points");

    //we need to keep track of the start and end dates for each sprint, as well as the total number of points for the sprint
    //and the points used in the spritn so far
    private LocalDate startDate;
    private LocalDate endDate;
    private double allocatedPoints = 20;
    private double usedPoints = 0;

    private guiComponents parentObject;

    public SprintOption(String inputSprintName, guiComponents inputParent, LocalDate inputStartDate, LocalDate inputEndDate) {
        parentObject = inputParent;
        sprintName = inputSprintName;
        startDate = inputStartDate;
        endDate = inputEndDate;
        //this.add(sprintLabel,0,0);
        setValueFactories();
        //this.add(sp1_table,0,0);
        setRightClickAction();
    }

    public void refreshBacklogItems(){
        ArrayList<backlogItemGrid>temp = parentObject.getBacklogItems();
        backlogObservableList = FXCollections.observableArrayList();
        for(backlogItemGrid x : temp){
            if(x.getAssignedSprint() == this){
                backlogObservableList.add(x);
            }
        }
        setValueFactories();
    }

    private void setValueFactories(){
        sp1_table= new TableView<backlogItemGrid>();
        sp1_backlog = new TableColumn<backlogItemGrid,String>("Backlog Item");
        //sp1_points = new TableColumn<backlogItemGrid,String>("Points Remaining");
       // sp1_rempoints = new TableColumn<backlogItemGrid, String>("Remaining Points");

        sp1_backlog.setMinWidth(200);
        sp1_points.setMinWidth(130);
     //   sp1_rempoints.setMinWidth(100);
        sp1_backlog.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("nameFieldValue"));
        sp1_points.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
       // sp1_rempoints.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("rempointsFieldValue"));
        sp1_table.getColumns().add(sp1_backlog);
        sp1_table.getColumns().add(sp1_points);
       // sp1_table.getColumns().add(sp1_rempoints);
        sp1_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        sp1_table.getItems().addAll(backlogObservableList);
        this.getChildren().remove(sp1_table);
        this.add(sp1_table,0,0);
        
    }


    //this method is used exclusively by other classes
    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        //basically, we need to add the backlog items to the list but not show them on the screen until the view is switched
        backlogObservableList.add(inputBacklogItem);
        //this.add(inputBacklogItem,0,backlogItems.size());//important but not now
        //System.out.println(backlogItems);
        sp1_table.getItems().add(inputBacklogItem);
    }

    public void setRightClickAction(){
        RightClickMenu();
        sp1_table.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY){
                sp1_table.setContextMenu(rightClickMenu);
            }
        });
        sprint_label.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY){
                sprint_label.setContextMenu(rightClickMenu);
            }
        });
    }

    public void RightClickMenu() {
        rightClickMenu.getItems().add(MIDeleteSprint);
        rightClickMenu.getItems().add(SetSprintValue);
        //find a way to set menu so it is always on top of other objects
        MIDeleteSprint.setOnAction(e -> {
            parentObject.deleteSprint(this);
        });
        SetSprintValue.setOnAction(e -> {
            popupWindow.show(this, 500, 400);
            
        });
        
    }

    //this method is used exclusively by other classes
    public String getSprintName(){
        return sprintName;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public double getAllocatedPoints(){
        return allocatedPoints;
    }
    
    public double getUsedPoints(){
        return usedPoints;
    }

    public void setAllocatedPoints(double inputPoints){
        allocatedPoints= inputPoints;
    }

  
}