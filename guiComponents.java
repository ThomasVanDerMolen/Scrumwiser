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
    SprintOption sprint_option= new SprintOption();
    overviewPane op = new overviewPane();
    projectPane prp = new projectPane();
    peoplePane pep = new peoplePane();
    backlogPane bap = new backlogPane();
    taskboardPane tp = new taskboardPane();
    burndownPane bup = new burndownPane();
    settingsPane sp = new settingsPane();

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

    private ArrayList<sprints> availableSprints = new ArrayList<sprints>();

    private backlogItemGrid big = new backlogItemGrid(1,availableSprints,this);
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
        setSprintAction();
    }

    public GridPane getGP(){
        return gp;
    }

    public ArrayList<sprints> getSprints(){
        return availableSprints;
    }

    public ArrayList<backlogItemGrid> getBacklogItems(){
        return backlogGridsArray;
    }

    public void testSprintsFeature(){
        sprints sprint1 = new sprints("sprint1");
        sprints sprint2 = new sprints("Sprint 2");
        availableSprints.add(sprint1);
        availableSprints.add(sprint2);
        updateAllBacklogSprints();
    }

    /*
     * public void initializeSprints(){
     *  
     * }
     */

    //this is used when the list of sprints is changed.
    private void updateAllBacklogSprints(){
        for(backlogItemGrid x : backlogGridsArray){
            x.setSprints(availableSprints);
        }
    }

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

    private Button testButton = new Button("test");
    
   
    private void setOverviewPane() {
        overview.setOnAction(e -> {
            bp.setCenter(op.getOverview());
            op.getOverview();
    
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

        sprints.getItems().add(sprint_1);
        sprints.getItems().add(sprint_2);
        sprints.getItems().add(sprint_3);
        sprints.getItems().add(sprint_4);
        sprints.getItems().add(sprint_5);
        sprints.getItems().add(sprint_6);

        setMenuFunction();//enable the theme menu items to be clicked

        //functionality of the test panes
        overview.getItems().add(testOverview);
        projects.getItems().add(testProjects);
        people.getItems().add(testPeople);
        backlog.getItems().add(testBacklog);
        sprints.getItems().add(testSprint);
        taskboard.getItems().add(testTaskboard);
        burndown.getItems().add(testBurndown);
        settings.getItems().add(testSettings);

        //switches panes when menuItem is clicked
        overview.setOnAction( e -> setOverviewPane() );
        testProjects.setOnAction(( e -> setProjectsPane()) );
        testPeople.setOnAction(( e -> setPeoplePane()) );
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
    private void setNewBIGButtonAction(){
        newBIGbutton.setOnAction(e -> 
        {
            //create a new backlog item 
            //Order matters in this function
            backlogItemGrid newBackLogItem = new backlogItemGrid(backlogGridsArray.size(),availableSprints,this);
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

    public void delete(backlogItemGrid DeletedBacklogItem){
        if(backlogGridsArray.size() > 1){
            gp.getChildren().remove(DeletedBacklogItem);
            backlogGridsArray.remove(DeletedBacklogItem);
            redrawAllBacklogItems();
            gp.getChildren().remove(newBIGbutton);
            gp.add(newBIGbutton,1,backlogGridsArray.size()-1);
        }
    }

    private void setSprintAction() {
        sprint_1.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint1());
            sprint_option.sprint_1();
    
        });
        sprint_2.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint2());
            sprint_option.sprint_2();
    
        });
        sprint_3.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint3());
            sprint_option.sprint_3();
    
        });
        sprint_4.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint4());
            sprint_option.sprint_4();
    
        });
        sprint_5.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint5());
            sprint_option.sprint_5();
    
        });
        sprint_6.setOnAction(e -> {
            bp.setCenter(sprint_option.get_sprint6());
            sprint_option.sprint_6();
    
        });
    }

    //set the action for the delete button on the backlog item page
    /* 
    private void setDeleteBIGButtonAction(){
        deleteBIGbutton.setOnAction(e -> 
        {
            if(backlogGridsArray.size() > 1)
            {
                //if the number of backlog items is greater than one, remove the last backlog item in the grid
                //also remove the last backlog item in the backlog item arraylist
                gp.getChildren().remove(backlogGridsArray.get(backlogGridsArray.size()-1));
                backlogGridsArray.remove(backlogGridsArray.get(backlogGridsArray.size()-1));
                gp.getChildren().remove(deleteBIGbutton);
                gp.getChildren().remove(newBIGbutton);
                gp.add(newBIGbutton,1,backlogGridsArray.size());
                gp.add(deleteBIGbutton,1,backlogGridsArray.size()-1);
            }
        });
    }
    */
}
