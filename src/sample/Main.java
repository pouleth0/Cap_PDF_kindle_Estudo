/*
*Autor: Paulo H A Moreira...
*github.com/pouleth0
*Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
*Omitir créditos para o autor original, sé torna plagio, é vergonhoso...=)
*
*    Created on : Jul 31, 2017, 9:32:04 AM
*    Author     : kn0w
*/
package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {
    @Override
    public void start(Stage rootStage) throws Exception{
        Parent rootFXML = FXMLLoader.load(getClass().getResource("rootFXMLconf.fxml"));
        Scene sceneRoot = new Scene(rootFXML);
        sceneRoot.setFill(Color.TRANSPARENT);
        //sceneRoot = new Scene(rootFXML);
        rootStage.initStyle(StageStyle.TRANSPARENT);
        rootStage.setScene(sceneRoot);

        rootStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
