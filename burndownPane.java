
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class burndownPane {
    private Pane burndownPane = new Pane();
    Label burndownTitle = new Label("Taskboard");
    Button completeSprint = new Button("Complete Sprint");
    Button editChart = new Button("Edit Chart");
    TextField textField = new TextField ("Search");
    

    
    public void setup() {
        burndownTitle.setLayoutX(600);
        burndownPane.getChildren().addAll(burndownTitle);
        completeSprint.setLayoutX(300);
        completeSprint.setLayoutY(575);
        burndownPane.getChildren().addAll(completeSprint);
        editChart.setLayoutX(850);
        editChart.setLayoutY(575);
        burndownPane.getChildren().addAll(editChart);
        textField.setLayoutX(550);
        textField.setLayoutY(575);
        burndownPane.getChildren().addAll(textField);

    
    }

    public Pane getBurndown() {
        return burndownPane;
    }
    }

