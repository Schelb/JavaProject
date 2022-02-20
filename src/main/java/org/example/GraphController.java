package org.example;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphController {
    @FXML
    private LineChart lineChart;
    @FXML
    private NumberAxis xAxis ;
    @FXML
    private NumberAxis yAxis ;
    private ListOfRecords records;
    @FXML
    public void initialize(ListOfRecords records){
        this.records= records;
        //Defining the x axis
        lineChart.getXAxis().setAutoRanging(false);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(1.0);
        xAxis.setTickUnit(0.2);
        xAxis.setLabel("Recall");

        //Defining the y axis
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0.0);
        yAxis.setUpperBound(1.0);
        yAxis.setTickUnit(0.2);
        yAxis.setLabel("Precision");

        Point<Double>[] points = calculatePoints();
        setData(points);
    }
    private Point<Double>[] calculatePoints(){
        EfficiencyEvaluations efficiencyEvaluations= EfficiencyEvaluations.getInstance();
        Point<Double>[] points = efficiencyEvaluations.elevenPointMatrix(records);
        return points;
    }
    private void setData(Point<Double>[] points){
        //Prepare XYChart.Series objects by setting data
        XYChart.Series series = new XYChart.Series();
        series.setName("11pt precision");
        ;
        for (int i= 0 ; i< points.length-1 ; i++){
            series.getData().add(new XYChart.Data(points[i].getX(), points[i].getY()));
        }
        //Setting the data to Line chart
        lineChart.getData().add(series);
    }

}
