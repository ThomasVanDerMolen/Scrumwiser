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
    private Menu menu = new Menu("Theme");
    private MenuItem darkMode = new MenuItem("Dark");
    private MenuItem lightMode = new MenuItem("Light");
    private MenuBar mb = new MenuBar();
    private Button newBIGbutton = new Button("New Item");
    private Button deleteBIGbutton = new Button("Delete");
    private backlogItemGrid big = new backlogItemGrid();
    private ArrayList<backlogItemGrid> backlogGridsArray = new ArrayList<backlogItemGrid>();
    

    private Scene guiComponentScene;

    public guiComponents(){
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
        backlogGridsArray.add(0,big);
        gp.add(big,0,0);


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

    private void setNewBIGButtonAction(){
        newBIGbutton.setOnAction(e -> 
        {

            backlogItemGrid newBackLogItem = new backlogItemGrid();
            backlogGridsArray.add(newBackLogItem);
            gp.getChildren().remove(deleteBIGbutton);
            gp.add(deleteBIGbutton,1,backlogGridsArray.size()-1);
            gp.add(backlogGridsArray.get(backlogGridsArray.size()-1),0,backlogGridsArray.size()-1);
            gp.getChildren().remove(newBIGbutton);
            gp.add(newBIGbutton,1,backlogGridsArray.size());

        });
    }

    private void setDeleteBIGButtonAction(){
        deleteBIGbutton.setOnAction(e -> 
        {

            if(backlogGridsArray.size() > 1)
            {
                gp.getChildren().remove(backlogGridsArray.get(backlogGridsArray.size()-1));
                backlogGridsArray.remove(backlogGridsArray.get(backlogGridsArray.size()-1));
            }

        });
    }
}
