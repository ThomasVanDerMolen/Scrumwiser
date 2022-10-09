import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class guiComponents
{
    private BorderPane bp = new BorderPane();
    private GridPane gp = new GridPane();
    private SprintOption sprint_option= new SprintOption("test sprint");//will not be needed
    
    private  overviewPane op = new overviewPane();
    private projectPane prp = new projectPane();
    private peoplePane pep = new peoplePane();
    private taskboardPane tp = new taskboardPane();
    private backlogPane bap = new backlogPane();
    private burndownPane bup = new burndownPane();
    private settingsPane sp = new settingsPane();

    private Label yourProjects = new Label("Your Projects");


    private Menu themeMenu = new Menu("Theme");
    /*private Menu overview = new Menu("Overview");
    private Menu projects = new Menu("Projects");
    private Menu people = new Menu("People");*/
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
    private MenuItem sprint_1= new MenuItem("Sprint 1");
    private MenuItem sprint_2= new MenuItem("Sprint 2");
    private MenuItem sprint_3= new MenuItem("Sprint 3");
    private MenuItem sprint_4= new MenuItem("Sprint 4");
    private MenuItem sprint_5= new MenuItem("Sprint 5");
    private MenuItem sprint_6= new MenuItem("Sprint 6");

    //test variables to switch between panes via upper menu
    private MenuItem testOverview = new MenuItem("test");
    private MenuItem testProjects = new MenuItem("test");
    private MenuItem testPeople = new MenuItem("test");
    private MenuItem testBacklog = new MenuItem("test");
    private MenuItem testSprint = new MenuItem("test");
    private MenuItem testTaskboard = new MenuItem("test");
    private MenuItem testBurndown = new MenuItem("test");
    private MenuItem testSettings = new MenuItem("test");

    private MenuBar mb = new MenuBar();
 
    private Button newBIGbutton = new Button("New Item");
    //private Button deleteBIGbutton = new Button("Delete");

    private Label backlogTitle = new Label("Backlog Page");
    

    private ArrayList<SprintOption> availableSprints = new ArrayList<SprintOption>();

    private backlogItemGrid big = new backlogItemGrid(1,this);
    private ArrayList<backlogItemGrid> backlogGridsArray = new ArrayList<backlogItemGrid>();


    private Scene guiComponentScene;

    public guiComponents(){
        //object constructor
        //initialization functions.
        setBorderPane();
        setGridPane();
        setMenu();
        setNewBIGButtonAction();
        //setDeleteBIGButtonAction();
        testSprintsFeature();//this may be important
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

    public void testSprintsFeature(){
        SprintOption so1 = new SprintOption("so1");
        SprintOption so2 = new SprintOption("so2");
        availableSprints.add(so1);
        availableSprints.add(so2);
        //updateAllBacklogSprints();
    }

    /*
     * public void initializeSprints(){
     *  
     * }
     */

    //this is used when the list of sprints is changed.

    /* 
    private void updateAllBacklogSprints(){
        for(backlogItemGrid x : backlogGridsArray){
            ;
            //x.setSprints(availableSprints);
        }
    }
    */

    //setters and getters for all the panes accessible via top menu
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
    
   
   
    /*private void setOverviewPane() {
        overview.setOnAction(e -> {
            bp.setCenter(op.getOverview());
            op.getOverview();
            gp.add(yourProjects,1,1);
            
    
        });
    }
    private void setProjectsPane() {
        projects.setOnAction(e -> {
            bp.setCenter(prp.getProject());
            prp.getProject();
    
        });
    }
    private void setPeoplePane(){
        people.setOnAction(e -> {
            bp.setCenter(pep.getPeople());
            pep.getPeople();
    
        });
    }*/
    private void setBacklogPane(){
        backlog.setOnAction(e -> {
            bp.setCenter(bap.getBacklog());
            bap.setup();
            //bap.getBacklog();
            
            
    
        });
        
    }
    
    private void setTaskboardPane(){
        taskboard.setOnAction(e -> {
            bp.setCenter(tp.getTaskboard());
            tp.setup();
    
        });
    }
    private void setBurndownPane(){
        burndown.setOnAction(e -> {
            bp.setCenter(bup.getBurndown());
            bup.setup();
        });
    }
    private void setSettingsPane(){
        settings.setOnAction(e -> {
            bp.setCenter(sp.getSettings());
            sp.setup();
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
        /*overview.getItems();
        projects.getItems();
        people.getItems();*/
        backlog.getItems();
        sprints.getItems();
        taskboard.getItems();
        burndown.getItems();
        
        settings.getItems().add(workAssigned);
        settings.getItems().add(teamOverlay);
        settings.getItems().add(backlogItemNumber);
        settings.getItems().add(additionalBacklogItems);
        
        mb.getMenus().add(themeMenu);
        /*mb.getMenus().add(overview);
        mb.getMenus().add(projects);
        mb.getMenus().add(people);*/
        mb.getMenus().add(backlog);
        mb.getMenus().add(sprints);
        mb.getMenus().add(taskboard);
        mb.getMenus().add(burndown);
        mb.getMenus().add(settings);

        sprints.getItems().add(sprint_1);
        sprints.getItems().add(sprint_2);
        sprints.getItems().add(sprint_3);
        sprints.getItems().add(sprint_4);
        sprints.getItems().add(sprint_5);
        sprints.getItems().add(sprint_6);

        setMenuFunction();//enable the theme menu items to be clicked

        //functionality of the test panes
        /*overview.getItems().add(testOverview);
        projects.getItems().add(testProjects);
        people.getItems().add(testPeople);*/
        backlog.getItems().add(testBacklog);
        sprints.getItems().add(testSprint);
        taskboard.getItems().add(testTaskboard);
        burndown.getItems().add(testBurndown);
        settings.getItems().add(testSettings);

        //switches panes when menuItem is clicked
        /*overview.setOnAction( e -> setOverviewPane() );
        testProjects.setOnAction(( e -> setProjectsPane()) );
        testPeople.setOnAction(( e -> setPeoplePane()) );*/
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
            ////////////////////////////////////////UNCOMMENT THISgp.getChildren().remove(deleteBIGbutton);
            //add the delete button back in the correct spot
            ////////////////////////////////////////UNCOMMENT THISgp.add(deleteBIGbutton,1,backlogGridsArray.size()-1);
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
