import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Backlog{
    private String backlog_item;
    private double points;

    public Backlog(String backlog_item, double points) {
        this.backlog_item= backlog_item;
        this.points= points;
        }

    public String get_backlog_item() {
        return backlog_item;
    }

    public double get_points() {
        return points;
        }
        


   
    public void set_backlog_item(String backlog_item){
        this.backlog_item= backlog_item;
    }

    public void set_points(double points) {
        this.points= points;
    }


}
