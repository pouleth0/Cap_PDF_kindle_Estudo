/* * Autor: Paulo H A Moreira...
   * github.com/pouleth0
   * Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
   * Omitir créditos para o autor original, é vergonhoso...=)
   *
   * Created on : Jul 31, 2017, 9:32:04 AM
   * Author     : kn0w */
package Principal;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.openqa.selenium.WebDriver;

import javax.swing.event.TreeModelEvent;
import java.io.IOException;
import java.util.ResourceBundle;

import Principal.helpers.Routes;

/*** Created by kn0w on 08/08/17.*/
public class MainBookContr extends Application implements Initializable {
    public static WebDriver webDriverSL;
    public static String appTitle=null;
    public static boolean kindl3=false;
    public static boolean googl3=false;
    public static boolean outros=false;
    public static String URL=null;
    private static String name = null;
    private static String pass = null;
    public static TreeModelEvent holderPane;
    @FXML
    public Label lblTitle;

    @FXML
    public static JFXDrawer drawerMenu;

    public AnchorPane PrincipalPane;
    public JFXHamburger menuHamb;

    private boolean habutgClic = false;
    private JFXHamburger ba;

    public static  void main(String[] args) {
        System.out.println(" ! URL = "+getURL());
        System.out.println(" ! Nome = "+getName());
        System.out.println(" ! Pass = "+getPass());
        System.out.println(" ! kindl3 "+isKindl3());
        System.out.println(" ! Googl3 "+isGoogl3());
        System.out.println(" ! Outros "+isOutros());
        System.out.println("RootBooks...1");
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void start(Stage rootFXMLPDF) throws Exception {
        System.out.println("Denstor do Costrutor RootBooks...2");
        Parent rootPDFLoad = FXMLLoader.load(getClass().getResource(Routes.MAIN));
        Scene rootScenePDF = new Scene(rootPDFLoad);
        rootScenePDF.setFill(Color.TRANSPARENT);
        rootFXMLPDF.setScene(rootScenePDF);
        rootFXMLPDF.show();
    }
    public void menuclick(MouseEvent mouseEvent) {
        System.out.println("Cliock no Hamburg  1");

   System.out.println("Cliock no Hamburg 2 ");

    }

    /// Getes componentes e IS Boolean
    public static boolean isKindl3() {   return kindl3;   }
    public static boolean isGoogl3() {   return googl3;   }
    public static boolean isOutros() {   return outros;   }

    public static String getURL() {      return URL;      }
    public static String getName() {     return name;     }
    public static String getPass() {     return pass;     }
    public static JFXDrawer getDrawerMenu() {  return drawerMenu;  }


    /// seter componentes
    public static void setURL(String URL) {  MainBookContr.URL = URL;  }
    public static void setDrawerMenu() {   MainBookContr.drawerMenu = drawerMenu; }
    public static void setKindl3(boolean kindl3) {  MainBookContr.kindl3 = kindl3;   }
    public static void setGoogl3(boolean googl3) {  MainBookContr.googl3 = googl3;   }
    public static void setOutros(boolean outros) {  MainBookContr.outros = outros;   }

    public static void setName(String name) {  MainBookContr.name = name;    }
    public static void setPass(String pass) {  MainBookContr.pass = pass;    }

    public JFXHamburger getMenuHambug() {
        return menuHamb;
    }

    public void setMenuHambug(JFXHamburger backArrow) {

        this.menuHamb = backArrow;
    }

    @Override
    public void initialize(java.net.URL urll, ResourceBundle rb) {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menuHamb);
        transition.setRate(-1);
        menuHamb.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (drawerMenu.isShown()) {
                drawerMenu.close();
            } else {
                drawerMenu.open();
            }

        });
       /* try {
            VBox sidePane = FXMLLoader.load(getClass().getResource("/Principal/FXML/menu.fxml"));
            AnchorPane doctorsPane = FXMLLoader.load(getClass().getResource(Routes.DOCTORSVIEW));
            AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
            AnchorPane payments = FXMLLoader.load(getClass().getResource(Routes.PAYMENTSVIEW));
            AnchorPane appointment = FXMLLoader.load(getClass().getResource(Routes.APPOINTMENTSVIEW));
            AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
            setNode(welcome);
            drawerMenu.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawerMenu.close();
                                setNode(welcome);
                                break;
                            case "doctorMenu":
                                drawerMenu.close();
                                setNode(doctorsPane);
                                break;
                            case "paymentMenu":
                                drawerMenu.close();
                                setNode(payments);
                                break;
                            case "appointmentMenu":
                                drawerMenu.close();
                                setNode(appointment);
                                break;
                        }
                    });
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(MainAcessRootEbooks.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    private void setNode(final Node node) {
        PrincipalPane.getChildren().clear();
        PrincipalPane.getChildren().add((Node) node);
    }

}

