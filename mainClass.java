import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application{
    static String user;
    static String password;
    private static guiComponents guiComponents = new guiComponents();
    private docTemplate docTemplate = new docTemplate();
    private static backlogItemGrid big = new backlogItemGrid(guiComponents, null);
    //private static userAuthenticationAction login = new userAuthenticationAction(user,password);
    //private dataSerializer dataStorage = new dataSerializer(guiComponents);
    //private Backlog bl = new Backlog(null, 0);
    public static void main(String[] args)
    {
        //big.open();
       // userAuthenticationAction();
        launch(args);
    }
    
    public void start(Stage primaryStage){
        Scene scene = new Scene(guiComponents.getBorderPane(),1000,400);
        guiComponents.setScene(scene);    
        //dataStorage.deserializeBacklogItems();
        //dataStorage.deserializeSprintObjects();    
        //guiComponents.setBacklogObjects(dataSerializer.deserializeBacklogItems)
        //guiComponents.setSprintObjects(dataSerializer.deserializesprintObjects)
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Scrumwiser");
    }
    
    
}
