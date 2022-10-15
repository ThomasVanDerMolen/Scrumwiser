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
    TableView<Backlog> backlog_table;

    private String sprintName;
    //private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();
    private ObservableList<backlogItemGrid> backlogObservableList = FXCollections.observableArrayList();
    private TableView<backlogItemGrid> backlogTable= new TableView<backlogItemGrid>();
    private TableView<backlogItemGrid> u_assigned_backlog= new TableView<backlogItemGrid>();
    private TableColumn<backlogItemGrid,String> backlogName = new TableColumn<backlogItemGrid,String>("Backlog Item");
    private TableColumn<backlogItemGrid,String> backlogPoints = new TableColumn<backlogItemGrid,String>("Points");
    private TableColumn<backlogItemGrid,String> unassigned_backlog= new TableColumn<backlogItemGrid,String>("Unassigned Backlog");
    private TableColumn<backlogItemGrid,String> unassigned_points= new TableColumn<backlogItemGrid,String>("Points");


    public SprintOption(String inputSprintName) {
        sprintName = inputSprintName;
        //this.add(sprintLabel,0,0);
        setValueFactories();
        this.add(backlogTable,0,0);
    }

    private void setValueFactories(){
        backlogName.setMinWidth(200);
        backlogPoints.setMinWidth(100);
        unassigned_backlog.setCellValueFactory(new PropertyValueFactory<backlogItemGrid, String>("nameFieldValue"));
        backlogName.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("nameFieldValue"));
        backlogPoints.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
        backlogTable.getColumns().add(backlogName);
        backlogTable.getColumns().add(backlogPoints);
        u_assigned_backlog.getColumns().add(unassigned_backlog);
        u_assigned_backlog.getColumns().add(unassigned_points);
        backlogTable.setColumnResizePolicy(backlogTable.CONSTRAINED_RESIZE_POLICY);//we just have to ignore this warning for now
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