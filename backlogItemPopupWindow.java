import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class backlogItemPopupWindow extends Application
{
    private BorderPane borderPane = new BorderPane();
    private GridPane gp = new GridPane();
    private Scene newScene = new Scene(borderPane);
    private Button addBtn = new Button("add");
    private Stage newStage = new Stage();
    private ComboBox<String> sprints = new ComboBox<>();
    //private ArrayList<SprintOption> listOfSprints = new ArrayList<>();
    private HashMap<String,SprintOption> unideal = new HashMap<>();
    private backlogItemGrid parentBacklogItem;

    public backlogItemPopupWindow(backlogItemGrid callingBacklogItem){
        parentBacklogItem = callingBacklogItem;
    }

    private void setScene(){
        borderPane.setCenter(gp);
        gp.add(addBtn,0,0);
        gp.add(sprints,1,0);
        newStage.setScene(newScene);
    }

    private void setButtonAction(){
        addBtn.setOnAction(e -> {
            unideal.get(sprints.getValue()).addBacklogItem(parentBacklogItem);
        });
    }

    public void setSprints(ArrayList<SprintOption> inputSprints){
        ArrayList<String> sprintNames = new ArrayList<>();
        for(SprintOption so : inputSprints){
            sprintNames.add(so.getSprintName());
            unideal.put(so.getSprintName(),so);
        }
        sprints.setItems(FXCollections.observableList(sprintNames));
    }

    public void popup(ArrayList<SprintOption> sprintsFromGUI){
        //listOfSprints = sprintsFromGUI;
        setScene();
        newStage.show();
        setSprints(sprintsFromGUI);
        setButtonAction();
    }

    public void start(Stage unusedStage){
        
    }
}
