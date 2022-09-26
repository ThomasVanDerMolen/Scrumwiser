import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class guiComponents 
{

    private BorderPane bp = new BorderPane();
    private GridPane gp = new GridPane();

    private Menu themeMenu = new Menu("Theme");
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
 
    private Button newBIGbutton = new Button("New Item");
    private Button deleteBIGbutton = new Button("Delete");
    private backlogItemGrid big = new backlogItemGrid();
    private ArrayList<backlogItemGrid> backlogGridsArray = new ArrayList<backlogItemGrid>();
    

    private Scene guiComponentScene;

    public guiComponents(){
        //object constructor
        //initialization functions.
        setBorderPane();
        setGridPane();
        setMenu();
        setNewBIGButtonAction();
        setDeleteBIGButtonAction();
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
        gp.add(newBIGbutton,1,0);
        gp.add(big,0,0);
        
        backlogGridsArray.add(0,big);//add the initial backlog item to the gridpane. this code might be moved elsewhere
        

    }

    private void setMenu(){

        //keep code organized
        themeMenu.getItems().add(darkMode);
        themeMenu.getItems().add(lightMode);    
        overview.getItems();
        projects.getItems();
        people.getItems();
        backlog.getItems();
        sprints.getItems();
        taskboard.getItems();
        burndown.getItems();
        
        settings.getItems().add(workAssigned);
        settings.getItems().add(teamOverlay);
        settings.getItems().add(backlogItemNumber);
        settings.getItems().add(additionalBacklogItems);
        
        mb.getMenus().add(themeMenu);
        mb.getMenus().add(overview);
        mb.getMenus().add(projects);
        mb.getMenus().add(people);
        mb.getMenus().add(backlog);
        mb.getMenus().add(sprints);
        mb.getMenus().add(taskboard);
        mb.getMenus().add(burndown);
        mb.getMenus().add(settings);

        setMenuFunction();//enable the theme menu items to be clicked

        overview.setOnAction( e -> transitionToOverview() );//what is this

    }

    
    //what is this
    public void transitionToOverview(){

    }

    //set the functions for the menu items
    //this could be changed to setThemeFucntions() in order to encapsulate code more
    private void setMenuFunction(){
        darkMode.setOnAction(e -> {
            //this is necessary to resolve som undesired behavior
            if(guiComponentScene.getStylesheets().size() ==0 ){
                guiComponentScene.getStylesheets().add("dark-theme.css");
            }
        });

        lightMode.setOnAction(e -> {
            guiComponentScene.getStylesheets().remove("dark-theme.css");
        });

    }

    //set the scene based on the main class
    public void setScene(Scene inputScene){
        guiComponentScene = inputScene;
        //set the default theme
        guiComponentScene.getStylesheets().add("dark-theme.css");
    }

    //set the action for the add button on the backlog page
    private void setNewBIGButtonAction(){
        newBIGbutton.setOnAction(e -> 
        {
            //create a new backlog item 
            //Order matters in this function
            backlogItemGrid newBackLogItem = new backlogItemGrid();
            //add the new backlog item to the backlog item arraylist
            backlogGridsArray.add(newBackLogItem);
            //remove the delete button so that is can be replaced in the correct spot
            gp.getChildren().remove(deleteBIGbutton);
            //add the delete button back in the correct spot
            gp.add(deleteBIGbutton,1,backlogGridsArray.size()-1);
            //add the newest backlog item in the backlog array list to the grid
            gp.add(backlogGridsArray.get(backlogGridsArray.size()-1),0,backlogGridsArray.size()-1);
            //remove the add button 
            gp.getChildren().remove(newBIGbutton);
            //add the add button back in the correct spot.
            gp.add(newBIGbutton,1,backlogGridsArray.size());

        });
    }

    //set the action for the delete button on the backlog item page
    private void setDeleteBIGButtonAction(){
        deleteBIGbutton.setOnAction(e -> 
        {

            if(backlogGridsArray.size() > 1)
            {
                //if the number of backlog items is greater than one, remove the last backlog item in the grid
                //also remove the last backlog item in the backlog item arraylist
                gp.getChildren().remove(backlogGridsArray.get(backlogGridsArray.size()-1));
                backlogGridsArray.remove(backlogGridsArray.get(backlogGridsArray.size()-1));
            }

        });
    }
}
