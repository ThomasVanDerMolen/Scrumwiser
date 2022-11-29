import java.util.ArrayList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class loginPane {
    private int valid = 0;
    
    //private int valid = 0;
  

        // Create an empty list to hold users
    List<User> listOfUsers = new ArrayList<>();
    private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();
    private Button btLogin = new Button("Login");
    private Button btClear = new Button("Clear");
    private Scene loginScene;
    public void login(){
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

        String username;
        String password;

        // Used to hold the instance of a user who successfully logged in
        User loggedInUser = null;

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
                   System.out.println("let's go");
                }
            }
        }

        // Process events
        

        // Create a scene and place it in the stage   

});
// Process events
        btClear.setOnAction(e -> {
        tfUsername.clear();
        tfPassword.clear();
});   

}

public int getValid()
{
    return valid;
}

public void setScene(Scene inputScene) {
    loginScene = inputScene;
    //set the default theme
    loginScene.getStylesheets().add("dark-theme.css");
}
}