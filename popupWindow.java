import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

/*
 * Credit to https://www.geeksforgeeks.org/javafx-popup-class/
 */

public class popupWindow extends Popup {
    private GridPane gp = new GridPane();
    private Label newlabel = new Label("Select Sprint");
    private ComboBox<String> sprints = new ComboBox<>();
    private HashMap<String,SprintOption> sprintNameHashMap = new HashMap<>();
    private ArrayList<SprintOption> sprintObjects = new ArrayList<SprintOption>();
    private backlogItemGrid parentBacklogItemGrid;
    private TextField pointsUsed = new TextField("Points");

    public popupWindow(backlogItemGrid callingItem){
        this.setAutoHide(true);
        parentBacklogItemGrid = callingItem;
        gp.add(newlabel,0,0);
        gp.add(sprints,0,1);
        gp.add(pointsUsed,0,2);
        this.getContent().add(gp);
        setChangeInput();
    }

    public void setSprints(ArrayList<SprintOption> inputSprints){
        sprintObjects = inputSprints;
        ArrayList<String> sprintNames = new ArrayList<>();
        for(SprintOption so : sprintObjects){
            sprintNameHashMap.put(so.getSprintName(), so);
            sprintNames.add(so.getSprintName());
        }
        sprints.setItems(FXCollections.observableList(sprintNames));
    }

    private void setChangeInput(){
        this.setOnAutoHide(e -> {
            if(sprints.getValue()!=null){
                sprintNameHashMap.get(sprints.getValue()).addBacklogItem(parentBacklogItemGrid);
            }
            parentBacklogItemGrid.addPoints(Integer.valueOf(pointsUsed.getText()));
        });
    }

}
