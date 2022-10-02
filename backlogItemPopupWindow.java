import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class backlogItemPopupWindow extends Application
{
    private BorderPane borderPane = new BorderPane();
    private GridPane gp = new GridPane();
    private Scene newScene = new Scene(borderPane);
    private Button btn = new Button("test");
    private Stage newStage = new Stage();
    public backlogItemPopupWindow(){
        //this.getStylesheets().add(theme);
        borderPane.setCenter(gp);
        gp.add(btn,0,0);
        newStage.setScene(newScene);
    }
    
    public void popup(){
        newStage.show();
    }

    public void start(Stage unusedStage){
        
    }
}
