package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.util.ArrayList;

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

        CreatorRecord creatorRecord=new CreatorRecord();
        int n = 10;
        int m = 15;
        ArrayList<Record> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double j = Math.random();
            if (j > 0.5) {
                result.add(creatorRecord.createRelevantRecord());
            } else {
                result.add(creatorRecord.createIrrelevantRecord());
            }
        }
        for (int i = n; i < m; i++) {
            result.add(creatorRecord.createRelevantNotFoundRecord());
        }
        ListOfRecords records= new ListOfRecords(result);

    }
}



