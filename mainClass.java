import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mainClass extends Application{
    String username;
    String password;
    //private int valid = 0;
    User loggedInUser = null;

        // Create an empty list to hold users
    List<User> listOfUsers = new ArrayList<>();
    private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();
    private Button btLogin = new Button("Login");
    private Button btClear = new Button("Clear");

    private Button btSave = new Button("Save");
    private Button btLoad = new Button("Load");

    
    private static guiComponents guiComponents = new guiComponents();
    private docTemplate docTemplate = new docTemplate();
    private static backlogItemGrid big = new backlogItemGrid(guiComponents, null);
    //private static loginPane login = new loginPane();
    //private dataSerializer dataStorage = new dataSerializer(guiComponents);

    public static void main(String[] args) throws IOException
    {  
        
            launch(args);
        
    }
      
    
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(tfUsername, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(tfPassword, 1, 1);
        gridPane.add(btLogin, 1, 3);
        gridPane.add(btClear, 1, 3);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfUsername.setAlignment(Pos.BOTTOM_RIGHT);
        tfPassword.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane.setHalignment(btLogin, HPos.LEFT);
        GridPane.setHalignment(btClear, HPos.RIGHT);


        // Create an empty list to hold users
        List<User> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new User("user1","password1"));
        listOfUsers.add(new User("user2","password2"));
        listOfUsers.add(new User("user3","password3"));
        btLogin.setOnAction(e -> {

            String checkUser = tfUsername.getText();
            String checkPass = tfPassword.getText();
            System.out.println(checkUser);
            System.out.println(checkPass);
        for (User user : listOfUsers)
        {
            if (user.getUsername().equals(checkUser))
            {
                if (user.getPassword().equals(checkPass))
                {
                    Scene scene = new Scene(guiComponents.getBorderPane(),1000,400);
                    guiComponents.setScene(scene);    
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.setTitle("Scrumwiser");
                }
            }
        }
        });

        // Process events
        btClear.setOnAction(e -> {
            tfUsername.clear();
            tfPassword.clear();
        });   


        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setTitle("Login"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage





        //Scene scene = new Scene(guiComponents.getBorderPane(),1000,400);
        //login.setScene(scene);
        //guiComponents.setScene(scene);    
        //dataStorage.deserializeBacklogItems();
        //dataStorage.deserializeSprintObjects();    
        //guiComponents.setBacklogObjects(dataSerializer.deserializeBacklogItems)
        //guiComponents.setSprintObjects(dataSErializer.deserializesprintObjects)
        //primaryStage.setScene(scene);
        //primaryStage.show();
        //primaryStage.setTitle("Scrumwiser");
    }
    
    /*
    private int valid = 0;
    public void userPass() throws IOException
    {
        //valid = inputValid;
        

        // Get user input
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        username = br.readLine();   
    
        password = br.readLine();

        // Iterate through list of users to see if we have a match
        for (User user : listOfUsers)
        {
            if (user.getUsername().equals(username))
            {
                if (user.getPassword().equals(password))
                {
                    loggedInUser = user;

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            valid = 1;
            
        }
        else
        {
            valid = 0;
            
        }
        
    }

    public int getValid()
    {
        return valid;
    }
    */
}

