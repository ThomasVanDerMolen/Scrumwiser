import java.util.ArrayList;

public class sprints {
    private String name;
    private ArrayList<backlogItemGrid> backlogItems = new ArrayList<backlogItemGrid>();
    //a sprint may have other properties

    public void addBacklogItem(backlogItemGrid inputBacklogItem){
        backlogItems.add(inputBacklogItem);
    }

    public void removeBacklogItem(backlogItemGrid inputBacklogItemGrid){
        backlogItems.remove(inputBacklogItemGrid);
    }

    public sprints(String inputName){
        name = inputName;
    }

    public String getName(){
        return name;
    }
}
