package Principal;

import Principal.helpers.Routes;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/** * Created by kn0w on 20/08/17. */
public class Menu implements Initializable{

    public JFXButton homeBtn;
    public JFXButton doctorBtn;
    public JFXButton appointmentBtn;
    public JFXButton paymentBtn;
    public JFXButton logoutBtn;
    public JFXButton exitBtn;

    public void logOut(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}