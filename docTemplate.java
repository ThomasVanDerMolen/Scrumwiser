import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class docTemplate extends Object {

    private backlogItemGrid item = new backlogItemGrid(null, 0, 0, null, null, null);
    File fileTest = new File("test2.txt");

    public void open() throws IOException
    {
        //Desktop.getDesktop().open(new File("C:\\folder"));
        
        System.out.println("write");
    try {
        File myObj = new File("filename.txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

      try {
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write("Files in Java might be tricky, but it is fun enough!");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        boolean result;  

try   
{  
result = fileTest.createNewFile();  //creates a new file  
if(result)      // test if successfully created a new file  
{  
System.out.println("file created "+fileTest.getCanonicalPath()); //returns the path string  
}  
else  
{  
System.out.println("File already exist at location: "+fileTest.getCanonicalPath());  
}  
}   
catch (IOException e)   
{  
e.printStackTrace();    //prints exception if any  
}       
  
}

    private File open(String string, String string2) {
        return null;
    }
public void write(){
    System.out.println("write");
    try {
        File myObj = new File("filename.txt");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}  
}  

    
   


