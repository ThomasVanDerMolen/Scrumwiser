

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application{
    static String user;
    static String password;
    
    private static guiComponents guiComponents = new guiComponents();
    private docTemplate docTemplate = new docTemplate();
    private static backlogItemGrid big = new backlogItemGrid(guiComponents, null);
    private static loginInfo login = new loginInfo();
    //private static userAuthenticationAction login = new userAuthenticationAction(user,password);
    //private dataSerializer dataStorage = new dataSerializer(guiComponents);

    public static void main(String[] args) throws IOException
    {  

        login.userPass();
        if (login.getValid() == 1)
        {
            launch(args);
        }
        else
        {
            System.out.println("bruh");
        }
    }
    
    public void start(Stage primaryStage){
        Scene scene = new Scene(guiComponents.getBorderPane(),1000,400);
        guiComponents.setScene(scene);    
        //dataStorage.deserializeBacklogItems();
        //dataStorage.deserializeSprintObjects();    
        //guiComponents.setBacklogObjects(dataSerializer.deserializeBacklogItems)
        //guiComponents.setSprintObjects(dataSErializer.deserializesprintObjects)
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Scrumwiser");
    }
    
    
}
