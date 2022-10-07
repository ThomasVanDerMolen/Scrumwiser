import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;



public class SprintOption extends GridPane{
    Label sprintLabel= new Label("Sprint");

    TableView<Backlog> table;

    private String sprintName;
    private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();

    public SprintOption(String inputSprintName) {
        sprintName = inputSprintName;
        this.add(sprintLabel,0,0);
        this.add(table,0,1);
    }

    //this method is used exclusively by other classes
    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        backlogItems.add(inputBacklogItem);
        //System.out.println(backlogItems);
    }

    //this method is used exclusively by other classes
    public String getSprintName(){
        return sprintName;
    }

}