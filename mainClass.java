import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application{
    
    private guiComponents guiComponents = new guiComponents();

    public static void main(String[] args)
    {
        launch(args);
    }
    
    public void start(Stage primaryStage){
        Scene scene = new Scene(guiComponents.getBorderPane(),1000,400);
        guiComponents.setScene(scene);        

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Scrumwiser");
    }
    
}
