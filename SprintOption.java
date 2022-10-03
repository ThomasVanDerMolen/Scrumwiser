import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;


public class SprintOption {
    Pane sprint_1= new Pane();
    Pane sprint_2= new Pane();
    Pane sprint_3= new Pane();
    Pane sprint_4= new Pane();
    Pane sprint_5= new Pane();
    Pane sprint_6= new Pane();
    Label sprint_1l= new Label("Sprint 1");
    Label sprint_2l= new Label("Sprint 2");
    Label sprint_3l= new Label("Sprint 3");
    Label sprint_4l= new Label("Sprint 4");
    Label sprint_5l= new Label("Sprint 5");
    Label sprint_6l= new Label("Sprint 6");
    Label unassigned_backlog1= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog2= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog3= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog4= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog5= new Label("Remaining backlog items not yet assigned to a sprint");
    Label unassigned_backlog6= new Label("Remaining backlog items not yet assigned to a sprint");

    TableView<Backlog> table;

    public SprintOption() {
        sprint_1.getChildren().addAll(sprint_1l, unassigned_backlog1);
        sprint_2.getChildren().addAll(sprint_2l, unassigned_backlog2);
        sprint_3.getChildren().addAll(sprint_3l, unassigned_backlog3);
        sprint_4.getChildren().addAll(sprint_4l, unassigned_backlog4);
        sprint_5.getChildren().addAll(sprint_5l, unassigned_backlog5);
        sprint_6.getChildren().addAll(sprint_6l, unassigned_backlog6);
    }

    public void sprint_1() {
        unassigned_backlog1.setLayoutX(80);
        TableColumn<Backlog, String> nameColumn = new TableColumn<>("Backlog Item");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("backlog_item"));

        TableColumn<Backlog, Double> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setMinWidth(200);
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        table = new TableView<>();
        table.setItems(getbacklog());
        table.getColumns().addAll(nameColumn, pointsColumn);
        table.setLayoutY(25);
        sprint_1.getChildren().add(table);
    }

    public ObservableList<Backlog> getbacklog() {
        ObservableList<Backlog> backlogs= FXCollections.observableArrayList();
        backlogs.add(new Backlog("Test", 1.0));
        backlogs.add(new Backlog("Test2", 2.0));
        backlogs.add(new Backlog("Test3", 3.0));
        return backlogs;
    }

    public void sprint_2() {
        unassigned_backlog2.setLayoutX(80);
    }

    public void sprint_3() {
        unassigned_backlog3.setLayoutX(80);
    }

    public void sprint_4() {
        unassigned_backlog4.setLayoutX(80);
    }

    public void sprint_5() {
        unassigned_backlog5.setLayoutX(80);
    }

    public void sprint_6() {
        unassigned_backlog6.setLayoutX(80);
    }


    

    public Pane get_sprint1() {
        return sprint_1;
    }

    public Pane get_sprint2() {
        return sprint_2;
    }

    public Pane get_sprint3() {
        return sprint_3;
    }

    public Pane get_sprint4() {
        return sprint_4;
    }

    public Pane get_sprint5() {
        return sprint_5;
    }

    public Pane get_sprint6() {
        return sprint_6;
    }
}

