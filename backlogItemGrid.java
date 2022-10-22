import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

/*
 * Credit owed to https://www.geeksforgeeks.org/javafx-progressbar/#:~:text=ProgressBar%20is%20a%20part%20of,of%20completion%20of%20a%20task%20.
 * 
 */

//I believe that it is not required to extend the grid pane functionality to this class
//We could instead create a gridpane which contains the other elements, and return that gridpane to the components class
//there, is would be added as a backlog item grid pane to the main gridpane 
public class backlogItemGrid extends GridPane implements java.io.Serializable
{
    private double pointsUsed = 0;
    private double totalpoints = 0;
    private String nameFieldValue;
    private String pointsFieldValue;
    private transient Label pointsLabel = new Label("");
    private transient TextField desc = new TextField("");
    private transient TextField points = new TextField();
    private transient Button btUp = new Button("");
    private transient Button btDn = new Button("");
    private transient guiComponents parentComponentsObject;
    private transient MenuItem MIopen = new MenuItem("open");
    private transient MenuItem MIDelete = new MenuItem("delete");
    private transient MenuItem MIMarkComplete = new MenuItem("Mark Complete");
    private transient MenuItem MIMarkIncomplete = new MenuItem("Mark Incomplete");
    private transient ContextMenu rightClickMenu = new ContextMenu();
    private transient ProgressBar backlogProgress = new ProgressBar(0);
    private transient popupWindow popupWindow = new popupWindow(this);

    public backlogItemGrid(guiComponents inputParentGuiComponents, double inputPointsUsed, double inputTotalPoints, String inputNameFieldValue, String inputpointsFieldValue){
        //credit to https://www.geeksforgeeks.org/constructor-chaining-java-examples/ 
        this(inputParentGuiComponents);
        pointsUsed = inputPointsUsed;
        totalpoints = inputTotalPoints;
        nameFieldValue = inputNameFieldValue;
        pointsFieldValue = inputpointsFieldValue;
        desc.setText(String.valueOf(inputNameFieldValue));
        pointsLabel.setText(String.valueOf(pointsFieldValue));
    }

    public backlogItemGrid(guiComponents inputParentGuiComponents){
        this.add(desc,0,0);
        this.add(points,1,0);
        this.add(btUp,2,0);
        this.add(btDn,2,1);
        this.add(backlogProgress,3,0);
        this.add(pointsLabel,3,0);
        points.setPrefWidth(125);
        points.setPromptText("points");
        desc.setPromptText("name");
        parentComponentsObject = inputParentGuiComponents;
        setUpDownFunctions();
        setRightClickAction();
        setTotalPoints();
    }

    public void setRightClickAction(){
        buildContextmenu();
        desc.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY){
                desc.setContextMenu(rightClickMenu);
            }
        });
    }

    private void buildContextmenu(){
        //some credit is owed to https://www.geeksforgeeks.org/javafx-contextmenu-with-examples/#:~:text=ContextMenu%20is%20a%20part%20of,several%20menuitems%20or%20sub%20menu.
        //where I read how to achieve this
        rightClickMenu.getItems().add(MIopen);
        rightClickMenu.getItems().add(MIDelete);
        rightClickMenu.getItems().add(MIMarkComplete);
        MIDelete.setOnAction(e -> {
            parentComponentsObject.delete(this);
        });
        MIMarkComplete.setOnAction(e -> {
            this.getStylesheets().add("mark-complete.css");
            this.setStyle("-fx-background-color:#33f561");
            rightClickMenu.getItems().remove(MIMarkComplete);
            rightClickMenu.getItems().add(MIMarkIncomplete);
            //honestly, quite incredible
        });
        MIMarkIncomplete.setOnAction(e -> {
            this.getStylesheets().remove("mark-complete.css");
            this.setStyle(null);
            rightClickMenu.getItems().remove(MIMarkIncomplete);
            rightClickMenu.getItems().add(MIMarkComplete);
        });
        MIopen.setOnAction(e -> {
            popupWindow.setSprints(this.parentComponentsObject.getSprints());
            popupWindow.show(this, 500, 400);
        });
    }

    public void moveUp(GridPane inputGP, ArrayList<backlogItemGrid> inputBacklogItems,backlogItemGrid callingBacklogItem){
        int callingBacklogItemIndex = inputBacklogItems.indexOf(callingBacklogItem);
        if(callingBacklogItemIndex > 0){
            backlogItemGrid temporary = inputBacklogItems.get(callingBacklogItemIndex);
        inputBacklogItems.set(callingBacklogItemIndex,inputBacklogItems.get(callingBacklogItemIndex-1));
        inputBacklogItems.set(callingBacklogItemIndex-1,temporary);
        parentComponentsObject.setBacklogItemsArray(inputBacklogItems);
        parentComponentsObject.redrawAllBacklogItems();
        }
        //now all that remains is the return this arraylist to the guicomponents obeject and redraw the grid accordingly
    }

    public void moveDown(GridPane inputGP, ArrayList<backlogItemGrid> inputBacklogItems, backlogItemGrid callingBacklogItem){
        int callingBacklogItemIndex = inputBacklogItems.indexOf(callingBacklogItem);
        if(callingBacklogItemIndex < inputBacklogItems.size()-1){
            backlogItemGrid temporary = inputBacklogItems.get(callingBacklogItemIndex);
            inputBacklogItems.set(callingBacklogItemIndex,inputBacklogItems.get(callingBacklogItemIndex+1));
            inputBacklogItems.set(callingBacklogItemIndex+1,temporary);
            parentComponentsObject.setBacklogItemsArray(inputBacklogItems);
            parentComponentsObject.redrawAllBacklogItems();
        }
    }

    private void setUpDownFunctions(){
        btUp.setOnAction(e -> {
            moveUp(parentComponentsObject.getGP(), parentComponentsObject.getBacklogItems(), this);
        });

        btDn.setOnAction(e -> {
            moveDown(parentComponentsObject.getGP(), parentComponentsObject.getBacklogItems(), this);
        });
    }

    public String getNameFieldValue(){
        nameFieldValue = desc.getText();
        return nameFieldValue;
    }

    public String getPointsFieldValue(){
        pointsFieldValue = points.getText();
        return pointsFieldValue;
    }

    public void addPoints(point inputPoint){
        pointsUsed += (inputPoint.getValue()/totalpoints);
        pointsLabel.setText(String.valueOf(pointsUsed*100) + "%");
        backlogProgress.setProgress(pointsUsed);
    }

    private void recalculatePoints(){
        pointsLabel.setText(String.valueOf(pointsUsed*100/totalpoints) + "%");
        backlogProgress.setProgress(pointsUsed/totalpoints);
    }

    private void setTotalPoints(){
        //credit to https://stackoverflow.com/questions/30160899/value-change-listener-for-javafxs-textfield
        points.textProperty().addListener(e -> {
            totalpoints = Integer.valueOf(points.getText());
            recalculatePoints();
        });
    }

    public void prepareForSerialization(){
        nameFieldValue = desc.getText();
        pointsFieldValue = points.getText();
    }

}
