import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.net.URL;
import java.awt.*;

public class guiComponents
{
    private docTemplate docTemplate = new docTemplate();

    private BorderPane primaryBorderPane = new BorderPane();
    private GridPane backlogGridPane = new GridPane();//these really need to be moved to their own class somehow.
    private GridPane sprintsGP = new GridPane();//these really need to be moved to their own class somehow.
    private ScrollPane backlogScroll = new ScrollPane();
    private GridPane backlogBottomMenu = new GridPane();
    private GridPane sprintscrollGP= new GridPane();
    private GridPane unassignedGP = new GridPane();

    private ScrollPane sprintScroll= new ScrollPane();
    private ScrollPane unassignedScroll= new ScrollPane();

    private Menu themeMenu = new Menu("Theme");

    private MenuItem darkMode = new MenuItem("Dark");
    private MenuItem lightMode = new MenuItem("Light");

    private MenuBar primaryMenuBar = new MenuBar();
    private GridPane navigationBar = new GridPane();
    private Button sprintViewButton = new Button("Sprints");
    private Button backlogViewButton = new Button("Backlog");
    private Button burndownViewButton = new Button("Burndown");
 
    private Button newBacklogItemButton = new Button("New Item");
    private Button add_sprintButton= new Button("Add Sprint");

    private Label unassigned_title= new Label("Unassigned Backlog");
    private Label sp1_title= new Label ("Sprint 1");
    private Label startDate = new Label("Sprint start");
    private Label endDate = new Label("Sprint end");

    private Hyperlink link = new Hyperlink("FAQ Website");
    private Hyperlink emailAddress = new Hyperlink("Customer Support Email");

    private int sprint_counter= -1;
      
    private SprintOption unassigned_sp= new SprintOption("Undetermined",this,java.time.LocalDate.now(),java.time.LocalDate.now());
    private ArrayList<SprintOption> availableSprints = new ArrayList<SprintOption>(){
        {
            add(unassigned_sp);//this initializes the available sprints list with the unassigned sprint in it
        }
    };
    private ArrayList<Label> sprint_titles = new ArrayList<Label>();
    private ArrayList<backlogItemGrid> backlogGridsArray = new ArrayList<backlogItemGrid>();
    private ArrayList<Label> point_capacities= new ArrayList<Label>();
    
    private GridPane sprintViewLeftGrid = new GridPane();
    private DatePicker sprintStartDatePicker = new DatePicker(java.time.LocalDate.now());
    private DatePicker sprintEndDatePicker = new DatePicker(java.time.LocalDate.now().plusDays(14));

    private burndown burndownObject = new burndown(this);

    private Scene guiComponentScene;

    public guiComponents(){
        //object constructor
        //initialization functions.
        setBorderPane();
        setScrollPane();
        setGridPane();
        setMenu();
        setNewBIGButtonAction();
        setNewSprintButtonAction();
        setupSprints();
        
        //docTemplate.open(null);
       
    }

    private void setBorderPane(){
        primaryBorderPane.setCenter(backlogScroll);

        navigationBar.add(primaryMenuBar,0,0);
        navigationBar.add(backlogViewButton,1,0);
        navigationBar.add(sprintViewButton,2,0);
        navigationBar.add(burndownViewButton,3,0);
        navigationBar.add(link, 4, 0);
        navigationBar.add(emailAddress, 5, 0);

        backlogViewButton.setStyle("-fx-background-color : transparent");
        sprintViewButton.setStyle("-fx-background-color : transparent");
        burndownViewButton.setStyle("-fx-background-color : transparent");
        link.setStyle("-fx-background-color : transparent");
        emailAddress.setStyle("-fx-background-color : transparent");

        primaryBorderPane.setTop(navigationBar);
        backlogBottomMenu.add(newBacklogItemButton,0,0);
        primaryBorderPane.setBottom(backlogBottomMenu);
    }

    //credit to http://www.java2s.com/Tutorials/Java/JavaFX/0350__JavaFX_ScrollPane.htm for scroll pane help
    private void setScrollPane(){
        backlogScroll.setContent(backlogGridPane);
        backlogScroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        backlogScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        backlogScroll.setFitToWidth(true);
    }

    private void setGridPane(){
        backlogGridPane.setAlignment(Pos.CENTER);
        backlogGridPane.setHgap(10);
        backlogGridPane.setVgap(10);
    }

    private void setMenu(){

        //keep code organized
        themeMenu.getItems().add(darkMode);
        themeMenu.getItems().add(lightMode);    
        
        
        primaryMenuBar.getMenus().add(themeMenu);
        setMenuFunction();//enable the theme menu items to be clicked
    }

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

        sprintViewButton.setOnAction(e -> {
            switchToSprintView();
        });

        backlogViewButton.setOnAction(e -> {
            switchToBacklogView();
            primaryBorderPane.setLeft(null);
        });
        burndownViewButton.setOnAction(e -> {
            switchToBurndownView();
        });
        link.setOnAction(e -> {
            openWebPage("https://scrumwisercustomer.wixsite.com/scrumwiser-faq");
        });
        emailAddress.setOnAction(e -> {
            openWebPage("https://mail.google.com/mail/u/0/#inbox?compose=GTvVlcSBptGjCGqNqwjVBNwlTKMdhKLCFNxFWcTSsBPpflfJPNFckzMRNQdTwjLnxZdPgRfDfrcXz");
        });
    }

    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void switchToSprintView(){
        primaryBorderPane.setCenter(sprintsGP);
        primaryBorderPane.setLeft(sprintViewLeftGrid);
        primaryBorderPane.setBottom(null);
        sprintScroll.setContent(sprintscrollGP);
        unassignedScroll.setContent(unassignedGP);
        refreshAllSprints();
        // adds children every time, needs to be resolved
        
        unassigned_title.setFont(new Font("Aldhabi",15));
    }

    private void switchToBacklogView(){
        primaryBorderPane.setCenter(backlogScroll);
        primaryBorderPane.setBottom(backlogBottomMenu);
    }
    
    private void switchToBurndownView(){
        burndownObject.updateSprints();
        primaryBorderPane.setCenter(burndownObject.getBurndownGridPane());
        primaryBorderPane.setBottom(burndownObject.getBottomMenu());
        primaryBorderPane.setLeft(null);
    }

    public void setupSprints(){
        sprintsGP.setAlignment(Pos.CENTER);
        sprintsGP.setHgap(10);
        sprintsGP.setVgap(10);
        sprintScroll.setContent(sprintscrollGP);
        sprintScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        unassignedScroll.setHbarPolicy(ScrollBarPolicy.NEVER);

        sprintStartDatePicker.setMaxWidth(120);
        sprintEndDatePicker.setMaxWidth(120);
        sprintViewLeftGrid.add(add_sprintButton,0,0);
        sprintViewLeftGrid.add(startDate,0,1);
        sprintViewLeftGrid.add(sprintStartDatePicker,0,2);
        sprintViewLeftGrid.add(endDate,0,3);
        sprintViewLeftGrid.add(sprintEndDatePicker,0,4);
        unassigned_sp.sp1_points.setText("Points");
        sprintsGP.add(sprintScroll, 0, 0);
        sprintsGP.add(unassignedScroll, 1, 0);
        unassignedGP.add(unassigned_sp, 0, 1);
        unassignedGP.add(unassigned_title, 0, 0);

        GridPane.setHalignment(unassigned_title, HPos.CENTER);//not sure if this is poor code practice because it was manipulated to prevent some static/nonstatic field errors
        GridPane.setHalignment(sp1_title, HPos.CENTER);//https://www.delftstack.com/howto/java/javafx-gridpane-alignment/
    }

    public GridPane getGP(){
        return backlogGridPane;
    }

    public ArrayList<SprintOption> getSprints(){
        return availableSprints;
    }

    public ArrayList<backlogItemGrid> getBacklogItems(){
        return backlogGridsArray;
    }

    //setters and getters for all the panes accessible via top menu
    public BorderPane getBorderPane(){
        return primaryBorderPane;
    }
   
    public void setBacklogItemsArray(ArrayList<backlogItemGrid> inputBacklogItems){
        backlogGridsArray = inputBacklogItems;
    }

    public void redrawAllBacklogItems(){
        for(backlogItemGrid x : backlogGridsArray){
            backlogGridPane.getChildren().remove(x);
        }
        for(backlogItemGrid x : backlogGridsArray){
            backlogGridPane.add((x), 0, backlogGridsArray.indexOf(x));
        }
    }
    
    private void refreshAllSprints(){
        for(SprintOption so : availableSprints){
            so.refreshBacklogItems();
        }
    }

    //set the scene based on the main class
    public void setScene(Scene inputScene){
        guiComponentScene = inputScene;
        //set the default theme
        guiComponentScene.getStylesheets().add("dark-theme.css");
    }

    //set the action for the add button on the backlog page
    //this function could possibly be in the backlogitem grid class
    private void setNewBIGButtonAction(){
        newBacklogItemButton.setOnAction(e -> 
        {
            //create a new backlog item 
            //Order matters in this function
            backlogItemGrid newBackLogItem = new backlogItemGrid(this,unassigned_sp);
            unassigned_sp.addBacklogItem(newBackLogItem);
            //add the new backlog item to the backlog item arraylist
            backlogGridsArray.add(newBackLogItem);
            //add the newest backlog item in the backlog array list to the grid
            backlogGridPane.add(backlogGridsArray.get(backlogGridsArray.size()-1),0,backlogGridsArray.size()-1);
        });
    }

    private void setNewSprintButtonAction(){
        add_sprintButton.setOnAction(e -> {
            sprint_counter= sprint_counter + 3;
            SprintOption newSprint = new SprintOption("Sprint " + availableSprints.size(),this,sprintStartDatePicker.getValue(),sprintEndDatePicker.getValue());
            availableSprints.add(newSprint);
            //Label sprint_label= new Label("Sprint " + String.valueOf(availableSprints.indexOf(newSprint) ));
            newSprint.sp1_points.setText("Remaining Points");
            newSprint.sprint_label.setText("Sprint " + String.valueOf(availableSprints.indexOf(newSprint)));
            newSprint.sprint_label.setFont(new Font("Aldhabi",15));
            GridPane.setHalignment(newSprint.sprint_label, HPos.CENTER);
            GridPane.setHalignment(newSprint.sprintpointcapacity, HPos.CENTER);
            sprint_titles.add(newSprint.sprint_label);
            sprintscrollGP.add(newSprint.sprint_label, 0, sprint_counter-1);
            sprintscrollGP.add(newSprint.sprintpointcapacity, 0, sprint_counter);
            sprintscrollGP.add(newSprint, 0, sprint_counter+1);
        });
    }

    //this function should ideally be in the backlogitemgrid class
    public void delete(backlogItemGrid DeletedBacklogItem){
        if(backlogGridsArray.size() > 1){
            backlogGridPane.getChildren().remove(DeletedBacklogItem);
            backlogGridsArray.remove(DeletedBacklogItem);
            redrawAllBacklogItems();
        }
    }

    public void deleteSprint(SprintOption deletedSprintOption) {
        availableSprints.remove(deletedSprintOption);
        sprintscrollGP.getChildren().remove(deletedSprintOption);
        sprintscrollGP.getChildren().remove(deletedSprintOption.sprint_label);
        sprintscrollGP.getChildren().remove(deletedSprintOption.sprintpointcapacity);
        for(SprintOption x : availableSprints){
            x.sprint_label.setText("Sprint " + (String.valueOf(availableSprints.indexOf(x))));

        }

    }
}
