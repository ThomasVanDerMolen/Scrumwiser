import java.util.ArrayList;

import javafx.collections.FXCollections;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

//I believe that it is not required to extend the grid pane functionality to this class
//We could instead create a gridpane which contains the other elements, and return that gridpane to the components class
//there, is would be added as a backlog item grid pane to the main gridpane 
public class backlogItemGrid extends GridPane
{
    private TextField desc = new TextField("Description");
    private TextField points = new TextField("Points");
    private ArrayList<String> sprintsNames = new ArrayList<String>();
    private ComboBox sprintSelector = new ComboBox<>(FXCollections.observableArrayList(sprintsNames)); //may want to research how to resolve these cautions
    private Button btUp = new Button("");
    private Button btDn = new Button("");

    public backlogItemGrid(int initialValue, ArrayList<sprints> inputSprints){
        this.add(desc,0,0);
        this.add(points,1,0);
        this.add(sprintSelector,3,0);
        this.add(btUp,2,0);
        this.add(btDn,2,1);
        setSprints(inputSprints);

        
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



}
