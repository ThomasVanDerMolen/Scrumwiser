

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;


public class taskboardPane {
    
    private Pane taskboardPane = new Pane();
    Label taskboardTitle = new Label("Taskboard");
    Button completeSprint = new Button("Complete Sprint");
    Button editBoard = new Button("Edit board");
    TextField textField = new TextField ("Search");
    

    
    public void setup() {
        taskboardTitle.setLayoutX(600);
        taskboardPane.getChildren().addAll(taskboardTitle);
        completeSprint.setLayoutX(300);
        completeSprint.setLayoutY(575);
        taskboardPane.getChildren().addAll(completeSprint);
        editBoard.setLayoutX(850);
        editBoard.setLayoutY(575);
        taskboardPane.getChildren().addAll(editBoard);
        textField.setLayoutX(550);
        textField.setLayoutY(575);
        taskboardPane.getChildren().addAll(textField);

    
    }

    public Pane getTaskboard() {
        return taskboardPane;
    }
}
