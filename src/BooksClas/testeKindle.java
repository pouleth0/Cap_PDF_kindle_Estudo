package BooksClas;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
/***Created by kn0w on 26/08/17.*/
public class testeKindle extends Application {

    @Override
    public void start(Stage rootPrimario) throws Exception {
        WebView webView = new WebView();
        // A engine é do tipo WebEngine
        webView.getEngine().load("http://aprendendo-javafx.blogspot.com");
        // criamos a cena e adicionamos no nosso stage
        rootPrimario.setScene(new Scene(webView));
        // mostramos
        rootPrimario.show();
    }
}
