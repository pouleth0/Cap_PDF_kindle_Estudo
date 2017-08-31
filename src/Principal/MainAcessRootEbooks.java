/* * Autor: Paulo H A Moreira...
   * github.com/pouleth0
   * Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
   * Omitir créditos para o autor original, é vergonhoso...=)
   *
   * Created on : Jul 31, 2017, 9:32:04 AM
   * Author     : kn0w */
package Principal;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import Principal.helpers.Routes;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.misc.ClassLoaderUtil;

import javax.jws.WebService;
import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/*** Created by kn0w on 08/08/17.*/
public class MainAcessRootEbooks extends Application implements Initializable {
    public static WebDriver webDriverSL;
    public static String appTitle=null;
    public static boolean kindl3=false;
    public static boolean googl3=false;
    public static boolean outros=false;
    public static String URL=null;
    private static String name = null;
    private static String pass = null;
    public static TreeModelEvent holderPane;
    private boolean abreMenuClick = false;

    @FXML
    public VBox vboxWebLoad;

    @FXML
    public JFXDrawer drawerLoadWeb;

    @FXML
    private JFXHamburger menuHamb;

    @FXML
    private JFXDrawer drawerMenu;

    @FXML
    public static AnchorPane webOpenLoad;

    @FXML
    private Label lblTitle;

    public static  void main(String[] args) {launch(args);}

    @Override
    public void start(Stage rootPriPGWeb)  {
        System.out.println(" ! URL = "+getURL());
        System.out.println(" ! Nome = "+getName());
        System.out.println(" ! Pass = "+getPass());
        System.out.println(" ! kindl3 "+isKindl3());
        System.out.println(" ! Googl3 "+isGoogl3());
        System.out.println(" ! Outros "+isOutros());
        System.out.println(" RootBooks...1 ");
        System.out.println(" carregando books... Load " );

        // criamos a cena e adicionamos no nosso stage
        //rootPriPGWeb.setScene(new Scene(webView));
        // mostramos
        //rootPriPGWeb.show();
    }

    @Override
    public void initialize(java.net.URL urll, ResourceBundle rb) {
        try {
            VBox menuMainn =  FXMLLoader.load(getClass().getResource(Routes.DRAWERMENU));
            drawerMenu.setSidePane(menuMainn);
            HamburgerBackArrowBasicTransition burgerMenu = new HamburgerBackArrowBasicTransition(menuHamb);
            burgerMenu.setRate(-1);
            menuHamb.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                burgerMenu.setRate(burgerMenu.getRate() * -1);
                burgerMenu.play();
                if (this.isAbreMenuClick()==true) {
                    this.drawerLoadWeb.close();
                    drawerMenu.close();
                    setAbreMenuClick(false);
                } else {
                    this.drawerLoadWeb.open();
                    drawerMenu.open();
                    setAbreMenuClick(true);
                }});
                }catch (Exception ex){
                    Logger.getLogger(MainAcessRootEbooks.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"!! Erro Ao Trentar abrir Drower Hamburg... "+"\n"+"Metodo -> initialize(java.netnURL,ResorceBundle)");
                }
    }
    private void setNode(Node node) {
        webOpenLoad.getChildren().clear();
        webOpenLoad.getChildren().add((Node) node);
    }
    public void menuclick(MouseEvent mouseEvent) {

        /*
        try {
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
        }
        */
    }
    public void updateWebDrawer(){
        Stage newWebLoad = new Stage();
        System.out.println("URL: "+getURL());
        WebView webView = new WebView();
        webView.getEngine().load(MainAcessRootEbooks.getURL());
        newWebLoad.setScene(new Scene(webView));
        AnchorPane.setTopAnchor(webView,100.0);
        drawerLoadWeb.getChildren().addAll(webView);
    }
    /// Getes componentes e IS Boolean
    public static boolean isKindl3() {   return kindl3;   }
    public static boolean isGoogl3() {   return googl3;   }
    public static boolean isOutros() {   return outros;   }
    public static String getURL()    {   return URL;      }
    public static String getName()   {   return name;     }
    public static String getPass()   {   return pass;     }
    public boolean isAbreMenuClick() {   return abreMenuClick;   }
    /// seter componentes
    public static void setURL(String URL) {  MainAcessRootEbooks.URL = URL;  }
    public static void setKindl3(boolean kindl3) {  MainAcessRootEbooks.kindl3 = kindl3;   }
    public static void setGoogl3(boolean googl3) {  MainAcessRootEbooks.googl3 = googl3;   }
    public static void setOutros(boolean outros) {  MainAcessRootEbooks.outros = outros;   }
    public static void setName(String name) {  MainAcessRootEbooks.name = name;    }
    public static void setPass(String pass) {  MainAcessRootEbooks.pass = pass;    }
    public void setAbreMenuClick(boolean abreMenuClick) {    this.abreMenuClick = abreMenuClick;   }

    public static void getDrawerLoadWeb() {
    }
    public static void setDrawerLoadWeb() {
        new MainAcessRootEbooks().updateWebDrawer();
    }
}

