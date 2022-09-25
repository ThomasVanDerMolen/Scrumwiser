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
import javafx.scene.text.Text;

public class guiComponents 
{

    private BorderPane bp = new BorderPane();
    private GridPane gp = new GridPane();

    private Menu menu = new Menu("Theme");
    private Menu overview = new Menu("Overview");
    private Menu projects = new Menu("Projects");
    private Menu people = new Menu("People");
    private Menu backlog = new Menu("Backlog");
    private Menu sprints = new Menu("Sprints");
    private Menu taskboard = new Menu( "Task Board");
    private Menu burndown = new Menu("Burndown");
    private Menu settings = new Menu("Settings");

    private MenuItem darkMode = new MenuItem("Dark");
    private MenuItem lightMode = new MenuItem("Light");
    private MenuItem workAssigned = new MenuItem("Show amount of work assigned to each person");
    private MenuItem teamOverlay = new MenuItem("Show overlay over teams that are left behind");
    private MenuItem backlogItemNumber = new MenuItem("Show item number on backlog items");
    private MenuItem additionalBacklogItems = new MenuItem("Add additional task in backlog items in some cases");


    private MenuBar mb = new MenuBar();
    private Label testLabel = new Label("This is a label");
    private Label scrumwiserLabel = new Label("Scrumwiser");
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
        //gp.add(scrumwiserLabel,0,0);
        //gp.setStyle("-fx-background-color: #ADD8E6");

    }

    private void setMenu(){
        menu.getItems().add(darkMode);
        menu.getItems().add(lightMode);
        mb.getMenus().add(menu);
        overview.getItems();
        mb.getMenus().add(overview);
        projects.getItems();
        mb.getMenus().add(projects);
        people.getItems();
        mb.getMenus().add(people);
        backlog.getItems();
        mb.getMenus().add(backlog);
        sprints.getItems();
        mb.getMenus().add(sprints);
        taskboard.getItems();
        mb.getMenus().add(taskboard);
        burndown.getItems();
        mb.getMenus().add(burndown);
        settings.getItems().add(workAssigned);
        settings.getItems().add(teamOverlay);
        settings.getItems().add(backlogItemNumber);
        settings.getItems().add(additionalBacklogItems);
        mb.getMenus().add(settings);

        setMenuFunction();

        overview.setOnAction( e -> transitionToOverview() );

    }

    

    public void transitionToOverview(){

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
