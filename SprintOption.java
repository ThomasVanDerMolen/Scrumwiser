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
    }

    /*
     * 
     * 
     * 
     */


    //this method is used exclusively by other classes
    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        //basically, we need to add the backlog items to the list but not show them on the screen until the view is switched
        backlogItems.add(inputBacklogItem);
        this.add(inputBacklogItem,0,backlogItems.size());
        //System.out.println(backlogItems);
    }

    //this method is used exclusively by other classes
    public String getSprintName(){
        return sprintName;
    }

}