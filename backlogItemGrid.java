import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class backlogItemGrid extends GridPane
{
    private TextField desc = new TextField("Description");
    private TextField points = new TextField("Points");

    public backlogItemGrid(){
        this.add(desc,0,0);
        this.add(points,1,0);
    }

}
