import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class loginPane {
    private Pane loginPane = new Pane();

    public void setup()
    {
        Label loginTitle = new Label("Login");
        loginPane.getChildren().addAll(loginTitle);
    }

    public Pane getLogin() {
        return loginPane;
    }
}
