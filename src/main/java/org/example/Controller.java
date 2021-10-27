package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    @FXML
    private Button btnCreateData;
    @FXML
    private TableView tableData;

    @FXML
    private void clickBtnCreateData(ActionEvent event) {

        tableData.getItems().removeAll();

        CreatorRecords creatorRecord=new CreatorRecords();
        ArrayList<Record> result = creatorRecord.creatRecords(10, 15);

        ObservableList<Record> observableList = FXCollections.observableList(result);
        tableData.setItems(observableList);
        // столбец для вывода имени
        TableColumn<Record, String> nameColumn = new TableColumn<Record, String>("Type");
        // определяем фабрику для столбца с привязкой к свойству name
        nameColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("type"));
        // добавляем столбец
        tableData.getColumns().add(nameColumn);
    }
}
