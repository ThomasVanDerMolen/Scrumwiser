import java.util.ArrayList;

import javafx.collections.FXCollections;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

//I believe that it is not required to extend the grid pane functionality to this class
//We could instead create a gridpane which contains the other elements, and return that gridpane to the components class
//there, is would be added as a backlog item grid pane to the main gridpane 
public class backlogItemGrid extends GridPane
{
    private TextField desc = new TextField("Name");
    private TextField points = new TextField("Estimate Points");
    private ArrayList<String> sprintsNames = new ArrayList<String>();
    private ComboBox sprintSelector = new ComboBox<>(FXCollections.observableArrayList(sprintsNames)); //may want to research how to resolve these cautions
    private Button btUp = new Button("");
    private Button btDn = new Button("");
    private guiComponents parentComponentsObject;
    private MenuItem MIopen = new MenuItem("open");
    private MenuItem MIDelete = new MenuItem("delete");
    private MenuItem MIMarkComplete = new MenuItem("Mark Complete");
    private ContextMenu rightClickMenu = new ContextMenu();


    public backlogItemGrid(int initialValue, ArrayList<sprints> inputSprints, guiComponents inputParentGuiComponents){
        this.add(desc,0,0);
        this.add(points,1,0);
        this.add(sprintSelector,3,0);
        this.add(btUp,2,0);
        this.add(btDn,2,1);
        points.setPrefWidth(125);
        parentComponentsObject = inputParentGuiComponents;
        setSprints(inputSprints);
        setUpDownFunctions();
        setRightClickAction();
        
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
        });
    }

    public void setSprints(ArrayList<sprints> input){
        for(sprints x : input){
            sprintsNames.add(x.getName());
        }
        setSprintSelectorSprints();
    }

    //this function converts the array list of sprints to an array list of sprint names which can be used to assignn sprints
    private void setSprintSelectorSprints(){
        sprintSelector.setItems(FXCollections.observableArrayList(sprintsNames));
    }

    public void moveUp(GridPane inputGP, ArrayList<backlogItemGrid> inputBacklogItems,backlogItemGrid callingBacklogItem){
        int callingBacklogItemIndex = inputBacklogItems.indexOf(callingBacklogItem);
        backlogItemGrid temporary = inputBacklogItems.get(callingBacklogItemIndex);
        inputBacklogItems.set(callingBacklogItemIndex,inputBacklogItems.get(callingBacklogItemIndex-1));
        inputBacklogItems.set(callingBacklogItemIndex-1,temporary);
        parentComponentsObject.setBacklogItemsArray(inputBacklogItems);
        parentComponentsObject.redrawAllBacklogItems();
        //now all that remains is the return this arraylist to the guicomponents obeject and redraw the grid accordingly
    }

    public void moveDown(GridPane inputGP, ArrayList<backlogItemGrid> inputBacklogItems, backlogItemGrid callingBacklogItem){
        int callingBacklogItemIndex = inputBacklogItems.indexOf(callingBacklogItem);
        backlogItemGrid temporary = inputBacklogItems.get(callingBacklogItemIndex);
        inputBacklogItems.set(callingBacklogItemIndex,inputBacklogItems.get(callingBacklogItemIndex+1));
        inputBacklogItems.set(callingBacklogItemIndex+1,temporary);
        parentComponentsObject.setBacklogItemsArray(inputBacklogItems);
        parentComponentsObject.redrawAllBacklogItems();
    }

    private void setUpDownFunctions(){
        btUp.setOnAction(e -> {
            moveUp(parentComponentsObject.getGP(), parentComponentsObject.getBacklogItems(), this);
        });

        btDn.setOnAction(e -> {
            moveDown(parentComponentsObject.getGP(), parentComponentsObject.getBacklogItems(), this);
        });
    }

}
