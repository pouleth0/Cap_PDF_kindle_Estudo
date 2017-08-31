package Principal;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.ResourceBundle;

import static Principal.MainAcessRootEbooks.webOpenLoad;

/** * Created by kn0w on 20/08/17. */
public class Menu implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton butEbooksPrincipalMenu;

    @FXML
    private ImageView imgPrincipalMenu;

    @FXML
    private VBox vboxPrincipalMenu;

    @FXML
    private VBox vboxPrincipalMenuEbooks;

    @FXML
    void loadBooks(MouseEvent event) {
        System.out.println("Dentro click carregar books" );
        MainAcessRootEbooks.setDrawerLoadWeb();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}