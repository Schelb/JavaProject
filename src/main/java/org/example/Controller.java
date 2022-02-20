package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button btnCreateData;
    @FXML
    private TableView tableData;
    @FXML
    private TextField countFindDocuments;
    @FXML
    private TextField countDocuments;
    @FXML
    private Label labelRecall;
    @FXML
    private Label labelPrecision;
    @FXML
    private Label labelF_Measure;
    private FileHandler fileHandler;
    private DatabaseHandler dbHandler;
    private ListOfRecords records;

    @FXML
    private void clickBtnCreateData(ActionEvent event) {
        int cntDoc =Integer.valueOf(countDocuments.getText());
        int cntFndDoc=Integer.valueOf(countFindDocuments.getText());
        if (cntDoc > cntFndDoc){
            tableData.getColumns().clear();
            CreatorRecords creatorRecord=new CreatorRecords();
            records= creatorRecord.createRecords(cntFndDoc, cntDoc);
            ArrayList<Record> result = records.getRecords();
            ObservableList<Record> observableList = FXCollections.observableList(result);
            tableData.setItems(observableList);
            // столбец для вывода типа
            TableColumn<Record, String> nameColumn = new TableColumn<Record, String>("Type");
            // определяем фабрику для столбца с привязкой к свойству type
            nameColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("type"));
            // добавляем столбец
            tableData.getColumns().add(nameColumn);
            Runnable r = ()->{
                System.out.println("Records: \n");
                try{
                    records.print();
                }
                catch(Exception e){
                    System.out.println("Exception");
                }
            };
            Thread printingThread = new Thread(r,"printingThread");
            printingThread.start();
            dbHandler.saveRecords(records);
            fileHandler.write(records.toString());
        }
        else btnCreateData.setText("countDocuments can be > countFindDocuments");
    }

    @FXML
    private void clickBtnEfficiencyEvaluations(ActionEvent event) {
        int cntDoc =Integer.valueOf(countDocuments.getText());
        int cntFndDoc=Integer.valueOf(countFindDocuments.getText());
        EfficiencyEvaluations evaluations= EfficiencyEvaluations.getInstance();
        double recall = evaluations.getRecall(records.getCountRelevantDocsFound() , records.getCountRelevantDocs());
        double precision = evaluations.getPrecision(records.getCountRelevantDocsFound(), records.getCountDocsFound());
        double fMeasure=evaluations.getF_Measure(precision,recall);
        labelRecall.setText("Recall="+Double.toString(recall));
        labelPrecision.setText("Precision="+Double.toString(precision));
        labelF_Measure.setText("F-Measure="+Double.toString(fMeasure));
    }

    @FXML
    public void clickBtnShowGraph(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Graph.fxml"));
        Scene scene = new Scene((Parent)loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Graph");
        GraphController controller = loader.getController();
        controller.initialize(records);
        stage.show();
    }

    @FXML
    public void initialize(DatabaseHandler dbHandler,FileHandler fileHandler){
        this.dbHandler= dbHandler;
        this.fileHandler= fileHandler;
    }
}
