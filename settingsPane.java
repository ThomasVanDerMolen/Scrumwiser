

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;


public class settingsPane {
    private Pane settingsPane = new Pane();
    Label settingsTitle = new Label("Settings");
    TextField textField = new TextField ("Search");
    

    
    public void setup() {
        settingsTitle.setLayoutX(600);
        settingsPane.getChildren().addAll(settingsTitle);
        textField.setLayoutX(550);
        textField.setLayoutY(575);
        settingsPane.getChildren().addAll(textField);

    
    }


    public Pane getSettings() {
        return settingsPane;
    }
}
