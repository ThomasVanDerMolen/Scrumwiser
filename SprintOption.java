import javafx.scene.layout.GridPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/*
 * Some credit is owed to https://www.youtube.com/watch?v=vego72w5kPU for the table feature.(as it is currently implemented)
 */

public class SprintOption extends GridPane{
    Label sprintLabel= new Label("Sprint");

    TableView<Backlog> table;

    private String sprintName;
    //private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();
    private ObservableList<backlogItemGrid> backlogObservableList = FXCollections.observableArrayList();
    private TableView<backlogItemGrid> backlogTable= new TableView<backlogItemGrid>();
    private TableColumn<backlogItemGrid,String> backlogName = new TableColumn<backlogItemGrid,String>("Name");
    private TableColumn<backlogItemGrid,String> backlogPoints = new TableColumn<backlogItemGrid,String>("points");


    public SprintOption(String inputSprintName) {
        sprintName = inputSprintName;
        //this.add(sprintLabel,0,0);
        setValueFactories();
        this.add(backlogTable,0,0);
    }

    private void setValueFactories(){
        backlogName.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("nameFieldValue"));
        backlogPoints.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
        backlogTable.getColumns().add(backlogName);
        backlogTable.getColumns().add(backlogPoints);
        backlogTable.setColumnResizePolicy(backlogTable.CONSTRAINED_RESIZE_POLICY);
        backlogTable.getItems().addAll(backlogObservableList);
    }


    //this method is used exclusively by other classes
    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        //basically, we need to add the backlog items to the list but not show them on the screen until the view is switched
        backlogObservableList.add(inputBacklogItem);
        //this.add(inputBacklogItem,0,backlogItems.size());//important but not now
        //System.out.println(backlogItems);
        backlogTable.getItems().add(inputBacklogItem);
    }

    //this method is used exclusively by other classes
    public String getSprintName(){
        return sprintName;
    }

}