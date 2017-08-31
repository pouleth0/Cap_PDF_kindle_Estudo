package sample.menu;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Principal.helpers.Routes;

/** * Created by kn0w on 20/08/17.
 */
public class HospitalFX extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
        JFXDecorator decorator=new JFXDecorator(primaryStage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);

        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(HospitalFX.class.getResource("/Principal/Styles-CSS/Estilo.css").toExternalForm());
       primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);

        primaryStage.setIconified(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
