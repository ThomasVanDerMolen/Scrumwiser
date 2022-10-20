import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
 * Much credit is owed to https://www.tutorialspoint.com/java/java_serialization.htm
 */
public class dataSerializer 
{
    private guiComponents parentObject;
    public dataSerializer(guiComponents inputParentObject){
        parentObject = inputParentObject;
    }
    public void serializeBacklogItems(){
        ArrayList<backlogItemGrid> backlogItems = parentObject.getBacklogItems();
        try{
            FileOutputStream fileOut = new FileOutputStream("./database/backlogitems.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for(backlogItemGrid bi : backlogItems){
                objectOut.writeObject(bi);
            }
            objectOut.close();
            fileOut.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void deserializeBacklogItems(){
        ArrayList<backlogItemGrid> importedBacklogItems = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("./database/backlogitems.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            //create a new backlog item with the values of the old one
            //the values of the old one are deserialized and stored in inputObject
            //create a new backlog object called tmp and get the values from the deserialized object, pass a list of these objects to the parent object
            backlogItemGrid inputObject = (backlogItemGrid) objectIn.readObject();
            //backlogItemGrid tmp = new backlogItemGrid(parentObject,inputObject.getPoints(),inputObject.get)
            //---------------------------------------------------------------------------------------------this is where I left off----------
            parentObject.setBacklogItemsArray(importedBacklogItems);
            parentObject.initBacklogItems();
            objectIn.close();
            fileIn.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException c){
            c.printStackTrace();
        }
    }
    public void serializeSprintObjects(){
        System.out.println("serializing sprints");
    }
    public void deserializeSprintObjects(){
        System.out.println("deserializing sprints");
    }
}
