package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
//        stage.initStyle(StageStyle.TRANSPARENT); Quita la barra de cerrar, maximizar y minimizar
        Scene scene = new Scene(fxmlLoader.load());
//        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void signUpScreen(Stage stage) throws IOException {
//
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
////        stage.initStyle(StageStyle.TRANSPARENT); Quita la barra de cerrar, maximizar y minimizar
//        Scene scene = new Scene(fxmlLoader.load());
////        scene.setFill(Color.TRANSPARENT);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }


    public static void main(String[] args) {
        launch();
    }
}
