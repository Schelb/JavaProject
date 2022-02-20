package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application
{
    public static void main( String[] args ) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Scene scene = new Scene((Parent)loader.load());
        stage.setScene(scene);
        stage.setTitle("FX");
        Controller controller = loader.getController();
        DatabaseHandler dbHandler= new DatabaseHandler();
        FileHandler fileHandler= new FileHandler();
        controller.initialize(dbHandler,fileHandler);
        stage.show();
    }
}



