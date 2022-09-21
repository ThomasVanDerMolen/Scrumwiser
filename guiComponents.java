import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class guiComponents 
{
    private BorderPane bp = new BorderPane();
    private GridPane gp = new GridPane();
    private Menu menu = new Menu("Theme");
    private MenuItem darkMode = new MenuItem("Dark");
    private MenuItem lightMode = new MenuItem("Light");
    private MenuBar mb = new MenuBar();
    private Label testLabel = new Label("This is a label");
    private Button buttonTwo = new Button("Button");
    private Button testButton = new Button("Button");
    private TextField testTF = new TextField("Enter info");
    private Scene guiComponentScene;

    public guiComponents(){
        setBorderPane();
        setGridPane();
        setMenu();

    }

    public BorderPane getBorderPane(){
        return bp;
    }
    
    private void setBorderPane(){
        bp.setCenter(gp);
        bp.setTop(mb);
    }

    private void setGridPane(){
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.add(testLabel,0,0);
        gp.add(testTF,0,1);
        gp.add(buttonTwo,1,0);
        gp.add(testButton,1,1);
    }

    private void setMenu(){
        menu.getItems().add(darkMode);
        menu.getItems().add(lightMode);
        mb.getMenus().add(menu);
        setMenuFunction();
    }

    private void setMenuFunction(){
        darkMode.setOnAction(e -> {
            guiComponentScene.getStylesheets().add("dark-theme.css");
        });

        lightMode.setOnAction(e -> {
            guiComponentScene.getStylesheets().remove("dark-theme.css");
        });
    }

    public void setScene(Scene inputScene){
        guiComponentScene = inputScene;
    }
}
