package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args ) {
        System.out.println(System.getProperty("java.class.path"));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FX");
        stage.setWidth(1500);
        stage.setHeight(500);
        stage.show();
    }
}



