import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class guiComponents
{
    private BorderPane bp = new BorderPane();
    private GridPane gp = new GridPane();//these really need to be moved to their own class somehow.
    private GridPane sprintsGP = new GridPane();//these really need to be moved to their own class somehow.
    private ScrollPane backlogScroll = new ScrollPane();
    
    private taskboardPane tp = new taskboardPane();
    private backlogPane bap = new backlogPane();
    private burndownPane bup = new burndownPane();
    private settingsPane sp = new settingsPane();


    private Menu themeMenu = new Menu("Theme");
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

    private MenuItem sprintView = new MenuItem("Sprints");
    private MenuItem backlogView = new MenuItem("backlog Items");

    //test variables to switch between panes via upper menu
    private MenuItem testBacklog = new MenuItem("test");
    private MenuItem testSprint = new MenuItem("test");
    private MenuItem testTaskboard = new MenuItem("test");
    private MenuItem testBurndown = new MenuItem("test");
    private MenuItem testSettings = new MenuItem("test");

    private MenuBar mb = new MenuBar();
 
    private Button newBIGbutton = new Button("New Item");
    

    private SprintOption so = new SprintOption("test sprint");
    private ArrayList<SprintOption> availableSprints = new ArrayList<SprintOption>();

    private backlogItemGrid big = new backlogItemGrid(1,this);
    private ArrayList<backlogItemGrid> backlogGridsArray = new ArrayList<backlogItemGrid>();


    private Scene guiComponentScene;

    public guiComponents(){
        //object constructor
        //initialization functions.
        setBorderPane();
        setScrollPane();
        setGridPane();//not ideal, maybe
        setMenu();
        setNewBIGButtonAction();
        //setDeleteBIGButtonAction();
        setupSprints();//not ideal
    }

    //credit to http://www.java2s.com/Tutorials/Java/JavaFX/0350__JavaFX_ScrollPane.htm for scroll pane help
    private void setScrollPane(){
        backlogScroll.setContent(gp);
        backlogScroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        backlogScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        backlogScroll.setFitToWidth(true);
    }

    public GridPane getGP(){
        return gp;
    }

    public ArrayList<SprintOption> getSprints(){
        return availableSprints;
    }

    public ArrayList<backlogItemGrid> getBacklogItems(){
        return backlogGridsArray;
    }

    public void setupSprints(){
        sprintsGP.setAlignment(Pos.CENTER);
        sprintsGP.setHgap(10);
        sprintsGP.setVgap(10);
        sprintsGP.add(so,0,0);
        availableSprints.add(so);
        //updateAllBacklogSprints();
    }

    //setters and getters for all the panes accessible via top menu
    public BorderPane getBorderPane(){
        return bp;
    }
    
    private void setBorderPane(){
        bp.setCenter(backlogScroll);
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
   
    private void setBacklogPane(){
        backlog.setOnAction(e -> {
            bp.setCenter(bap.getBacklog());
            bap.getBacklog();
    
        });
        
    }
    
    private void setTaskboardPane(){
        taskboard.setOnAction(e -> {
            bp.setCenter(tp.getTaskboard());
            tp.getTaskboard();
    
        });
    }
    private void setBurndownPane(){
        burndown.setOnAction(e -> {
            bp.setCenter(bup.getBurndown());
            bup.getBurndown();
        });
    }
    private void setSettingsPane(){
        settings.setOnAction(e -> {
            bp.setCenter(sp.getSettings());
            sp.getSettings();
        });
    }
    public void setBacklogItemsArray(ArrayList<backlogItemGrid> inputBacklogItems){
        backlogGridsArray = inputBacklogItems;
    }

    public void redrawAllBacklogItems(){
        for(backlogItemGrid x : backlogGridsArray){
            gp.getChildren().remove(x);
        }
        for(backlogItemGrid x : backlogGridsArray){
            gp.add((x), 0, backlogGridsArray.indexOf(x));
        }
    }

    private void setMenu(){

        //keep code organized
        themeMenu.getItems().add(darkMode);
        themeMenu.getItems().add(lightMode);    
        backlog.getItems();
        sprints.getItems();
        taskboard.getItems();
        burndown.getItems();
        
        settings.getItems().add(workAssigned);
        settings.getItems().add(teamOverlay);
        settings.getItems().add(backlogItemNumber);
        settings.getItems().add(additionalBacklogItems);
        
        mb.getMenus().add(themeMenu);
        mb.getMenus().add(backlog);
        mb.getMenus().add(sprints);
        mb.getMenus().add(taskboard);
        mb.getMenus().add(burndown);
        mb.getMenus().add(settings);

        sprints.getItems().add(sprintView);
        backlog.getItems().add(backlogView);
        setMenuFunction();//enable the theme menu items to be clicked

        //functionality of the test panes
        backlog.getItems().add(testBacklog);
        sprints.getItems().add(testSprint);
        taskboard.getItems().add(testTaskboard);
        burndown.getItems().add(testBurndown);
        settings.getItems().add(testSettings);

        //switches panes when menuItem is clicked
        testBacklog.setOnAction(( e -> setBacklogPane()) );
        testTaskboard.setOnAction(( e -> setTaskboardPane()) );
        testBurndown.setOnAction(( e -> setBurndownPane()) );
        testSettings.setOnAction(( e -> setSettingsPane()) );

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

        sprintView.setOnAction(e -> {
            switchToSprintView();
        });

        backlogView.setOnAction(e -> {
            switchToBacklogView();
        });
    }

    private void switchToSprintView(){
        bp.setCenter(sprintsGP);
    }
    private void switchToBacklogView(){
        bp.setCenter(gp);
    }

    //this is a test

    //set the scene based on the main class
    public void setScene(Scene inputScene){
        guiComponentScene = inputScene;
        //set the default theme
        guiComponentScene.getStylesheets().add("dark-theme.css");
    }

    //set the action for the add button on the backlog page
    //this function could possibly be in the backlogitem grid class
    private void setNewBIGButtonAction(){
        newBIGbutton.setOnAction(e -> 
        {
            //create a new backlog item 
            //Order matters in this function
            backlogItemGrid newBackLogItem = new backlogItemGrid(backlogGridsArray.size(),this);
            //add the new backlog item to the backlog item arraylist
            backlogGridsArray.add(newBackLogItem);
            //remove the delete button so that is can be replaced in the correct spot
            //add the delete button back in the correct spot
            //add the newest backlog item in the backlog array list to the grid
            gp.add(backlogGridsArray.get(backlogGridsArray.size()-1),0,backlogGridsArray.size()-1);
            //remove the add button 
            gp.getChildren().remove(newBIGbutton);
            //add the add button back in the correct spot.
            gp.add(newBIGbutton,1,backlogGridsArray.size()-1);

        });
    }

    //this function should ideally be in the backlogitemgrid class
    public void delete(backlogItemGrid DeletedBacklogItem){
        if(backlogGridsArray.size() > 1){
            gp.getChildren().remove(DeletedBacklogItem);
            backlogGridsArray.remove(DeletedBacklogItem);
            redrawAllBacklogItems();
            gp.getChildren().remove(newBIGbutton);
            gp.add(newBIGbutton,1,backlogGridsArray.size()-1);
        }
    }

}
