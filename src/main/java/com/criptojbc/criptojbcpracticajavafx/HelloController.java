package com.criptojbc.criptojbcpracticajavafx;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Data data;
    Archivo archivo = new Archivo();
    LectorJSON lectorJSON = new LectorJSON();

    XYChart.Data<String, Number> EUR = new XYChart.Data<>("EUR", 0.01);
    XYChart.Data<String, Number> USD = new XYChart.Data<>("USD", 0.01);

    @FXML
    MenuItem menuClose;

    @FXML
    CategoryAxis yAxis;
    @FXML
    NumberAxis xAxis;

    @FXML
    private Button refreshList;

    @FXML
    private BarChart barChart;

    @FXML
    private ListView<String> currenciesList;

    @FXML
    private Label nombreAbreviado;

    @FXML
    private Label nombreCompleto;

    @FXML
    private CheckBox checkboxEuro;

    @FXML
    private CheckBox checkboxDollar;

    XYChart.Series<String, Number> currenciesChar;

    @FXML
    public void onClickClose(){
        System.exit(0);
    }

    @FXML
    public void onClickRefresh(){
        checkboxEuro.setSelected(false);
        checkboxDollar.setSelected(false);

        barChart.getData().clear();
        currenciesList.getItems().clear();

        currenciesChar = new XYChart.Series<>();
        archivo.descargar();
        try {
            data = lectorJSON.JSONsimple();
            for (Currencies cur : data.getData()){
                currenciesList.getItems().add(cur.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        barChart.setTitle("Currencies's Values");
        barChart.getData().add(currenciesChar);
        currenciesChar.setName("Currencies");
    }

    @FXML
    public void onClickEuro(Event event){
        if (!checkboxEuro.isSelected()){
            currenciesChar.getData().remove(EUR);
        } else{
            currenciesChar.getData().add(EUR);
        }
    }

    @FXML
    public void onClickDollar(Event event){
        if (!checkboxDollar.isSelected()){
            currenciesChar.getData().remove(USD);
        } else{
            currenciesChar.getData().add(USD);
        }
    }

    @FXML
    public void onClickListener(Event event){
        ListView<String> listView = (ListView<String>) event.getSource();
        for (Currencies cur : data.getData()) {
            //Si el Nombre de la moneda es igual al seleccionado en la lista.
            if (cur.getName().equals(listView.getSelectionModel().selectedItemProperty().get())){
                nombreAbreviado.textProperty().set(cur.getId());
                nombreCompleto.textProperty().set(cur.getName());
                float n = Float.parseFloat(cur.getMinSize());
                currenciesChar.getData().add(new XYChart.Data<>(cur.getId(), n));
                break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       currenciesChar = new XYChart.Series<>();
        try {
            data =  lectorJSON.JSONsimple();
            for (Currencies cur : data.getData()){
                currenciesList.getItems().add(cur.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        barChart.setTitle("Currencies's Values");
        barChart.getData().add(currenciesChar);
        currenciesChar.setName("Currencies");
    }
}