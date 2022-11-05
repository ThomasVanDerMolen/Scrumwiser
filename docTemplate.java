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
        
        System.out.println("test");
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
    try {
        System.out.println("Begin");
        FileWriter fileTest = new FileWriter("test2.txt");
        fileTest.write("gsdfghjkhgfdsdfghj");
        fileTest.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}  
}  

    
   


