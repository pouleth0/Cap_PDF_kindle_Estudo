/* * Autor: Paulo H A Moreira...
   * github.com/pouleth0
   * Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
   * Omitir créditos para o autor original, é vergonhoso...=)
   *
   * Created on : Jul 31, 2017, 9:32:04 AM
   * Author     : kn0w */
package Principal.principalPDF;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Principal.MainAcessRootEbooks;
import Principal.helpers.Routes;

/** * Created by kn0w on 20/08/17. */
public class principalPDFclass extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
        JFXDecorator decorator=new JFXDecorator(primaryStage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);

        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(MainAcessRootEbooks.class.getResource("/Principal/Styles-CSS/Estilo.css").toExternalForm());
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);

        primaryStage.setIconified(false);
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);
    }



}
