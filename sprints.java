import java.util.ArrayList;

public class sprints {
    private String name;
    private ArrayList<backlogItemGrid> allBacklogItems = new ArrayList<backlogItemGrid>();
    //a sprint may have other properties

    public sprints(String inputName){
        name = inputName;
    }

    public String getName(){
        return name;
    }
}
