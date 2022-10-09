import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class backlogPane{
    

    private Pane backlogPane = new Pane();
    Label backlogTitle = new Label("Backlog");
    Button addBacklog = new Button("Add a Backlog Item");
    Button editBacklog = new Button("Edit backlog");
    TextField textField = new TextField ("Search");
    

    
    public void setup() {
        backlogTitle.setLayoutX(600);
        backlogPane.getChildren().addAll(backlogTitle);
        addBacklog.setLayoutX(300);
        addBacklog.setLayoutY(575);
        backlogPane.getChildren().addAll(addBacklog);
        editBacklog.setLayoutX(850);
        editBacklog.setLayoutY(575);
        backlogPane.getChildren().addAll(editBacklog);
        textField.setLayoutX(550);
        textField.setLayoutY(575);
        backlogPane.getChildren().addAll(textField);

    
        
    }
    


    public Pane getBacklog() {
        return backlogPane;
    }

  
    
    

    

    
}
