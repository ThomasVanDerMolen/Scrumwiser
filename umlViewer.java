import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

//credit to https://o7planning.org/11151/javafx-webview

public class umlViewer
{
    private GridPane gp = new GridPane();
    private WebView wv = new WebView();
    private WebEngine we = wv.getEngine();

    public umlViewer(){
        we.setJavaScriptEnabled(true);
        we.load("https://draw.io");
        gp.add(wv, 0,0);
        gp.setAlignment(Pos.CENTER);
    }

    public GridPane getGrid(){
        return gp;
    }
}