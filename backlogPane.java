import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
