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

    private String sprintName;
    //private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();
    private ObservableList<backlogItemGrid> backlogObservableList = FXCollections.observableArrayList();
    private TableView<backlogItemGrid> sp1_table= new TableView<backlogItemGrid>();
    private TableView<backlogItemGrid> u_assigned_backlog= new TableView<backlogItemGrid>();
    private TableView<backlogItemGrid> sp2_table= new TableView<backlogItemGrid>();
    private TableColumn<backlogItemGrid,String> sp1_backlog = new TableColumn<backlogItemGrid,String>("Backlog Item");
    private TableColumn<backlogItemGrid,String> sp1_points = new TableColumn<backlogItemGrid,String>("Points");
    private TableColumn<backlogItemGrid,String> sp2_backlog = new TableColumn<backlogItemGrid,String>("Backlog Item ");
    private TableColumn<backlogItemGrid,String> sp2_points = new TableColumn<backlogItemGrid,String>("Points");
    private TableColumn<backlogItemGrid,String> unassigned_backlog= new TableColumn<backlogItemGrid,String>("Unassigned Backlog");
    private TableColumn<backlogItemGrid,String> unassigned_points= new TableColumn<backlogItemGrid,String>("Points");


    public SprintOption(String inputSprintName) {
        sprintName = inputSprintName;
        //this.add(sprintLabel,0,0);
        setValueFactories();
        this.add(sp1_table,0,0);
        this.add(u_assigned_backlog, 1, 0);
        this.add(sp2_table,0,1);
        
    }

    private void setValueFactories(){
        sp1_backlog.setMinWidth(200);
        sp1_points.setMinWidth(100);
        unassigned_backlog.setMinWidth(200);
        unassigned_points.setMinWidth(100);
        sp2_backlog.setMinWidth(200);
        sp2_points.setMinWidth(100);
        unassigned_backlog.setCellValueFactory(new PropertyValueFactory<backlogItemGrid, String>("nameFieldValue"));
        unassigned_points.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
        sp1_backlog.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("nameFieldValue"));
        sp1_points.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
        sp2_backlog.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("nameFieldValue"));
        sp2_points.setCellValueFactory(new PropertyValueFactory<backlogItemGrid,String>("pointsFieldValue"));
        sp1_table.getColumns().add(sp1_backlog);
        sp1_table.getColumns().add(sp1_points);
        sp2_table.getColumns().add(sp2_backlog);
        sp2_table.getColumns().add(sp2_points);
        u_assigned_backlog.getColumns().add(unassigned_backlog);
        u_assigned_backlog.getColumns().add(unassigned_points);
        sp1_table.setColumnResizePolicy(sp1_table.CONSTRAINED_RESIZE_POLICY);
        sp1_table.getItems().addAll(backlogObservableList);
        
    }


    //this method is used exclusively by other classes
    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        //basically, we need to add the backlog items to the list but not show them on the screen until the view is switched
        backlogObservableList.add(inputBacklogItem);
        //this.add(inputBacklogItem,0,backlogItems.size());//important but not now
        //System.out.println(backlogItems);
        sp1_table.getItems().add(inputBacklogItem);
    }

    //this method is used exclusively by other classes
    public String getSprintName(){
        return sprintName;
    }

}