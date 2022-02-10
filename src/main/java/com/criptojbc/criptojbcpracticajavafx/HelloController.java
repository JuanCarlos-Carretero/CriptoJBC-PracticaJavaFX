package com.criptojbc.criptojbcpracticajavafx;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Esta clase es donde tenemos todo lo relacionado con el archivo.fxml .
 */
public class HelloController implements Initializable {
    Data data;
    Archivo archivo = new Archivo();
    private boolean cambio = true;

    XYChart.Data<String, Number> EUR = new XYChart.Data<>("EUR", 0.01);
    XYChart.Data<String, Number> USD = new XYChart.Data<>("USD", 0.01);

    @FXML
    VBox vBox;

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

    /**
     * Este metodo sirve para que cuando en el menu le demos a File - Close se cierre la aplicacion.
     */
    @FXML
    public void onClickClose(){
        System.exit(0);
    }

    /**
     * Este metodo sirve para que refresque toda la informacion de la aplicacion y la pongamos de 0.
     */
    @FXML
    public void onClickRefresh(){
        checkboxEuro.setSelected(false);
        checkboxDollar.setSelected(false);

        barChart.getData().clear();
        currenciesList.getItems().clear();

        currenciesChar = new XYChart.Series<>();
        archivo.Descargar();
        try {
            data = archivo.Leer();
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

    /**
     * Este metodo sirve para que cuando el checkBox este checked nos añada Euro al Barchar y si no lo esta lo quite de la lista.
     * @param event Recibe el evento osea la accion.
     */
    @FXML
    public void onClickEuro(Event event){
        if (!checkboxEuro.isSelected()){
            currenciesChar.getData().remove(EUR);
        } else{
            currenciesChar.getData().add(EUR);
        }
    }

    /**
     * Este metodo sirve para que cuando el checkBox este checked nos añada Dollar al Barchar y si no lo esta lo quite de la lista.
     * @param event Recibe el evento osea la accion.
     */
    @FXML
    public void onClickDollar(Event event){
        if (!checkboxDollar.isSelected()){
            currenciesChar.getData().remove(USD);
        } else{
            currenciesChar.getData().add(USD);
        }
    }

    /**
     * Este metodo sirve para que nos de la informacion de la currencie seleccionada en la listView.
     * @param event Recibe el evento osea la accion.
     */
    @FXML
    public void onClickList(Event event){
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

    /**
     * Este metodo nos permite cambiar entre dos style.css uno dark y otro light.
     */
    @FXML
    private void handleCambiEstilo(){
        if (cambio){
            vBox.getStylesheets().clear();
            vBox.getStylesheets().add(Main.class.getResource("theme-light.css").toExternalForm());
            cambio = false;
        }else {
            vBox.getStylesheets().clear();
            vBox.getStylesheets().add(Main.class.getResource("theme-dark.css").toExternalForm());
            cambio = true;
        }
    }

    /**
     * Este metodo nos permite ver a los incleibles creadores de esta aplicacion XD.
     */
    @FXML
    private void handleAbout() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("CriptoJBC");
        a.setHeaderText("About");
        a.setContentText("Author's: Best Team Forever Werever Tomorrow (Jose Maria Becerra - Juan Carlos Carretero)");
        a.show();
    }

    /**
     * Este metodo nos permite lanzar el controller. (Es como el main pero para el controller)
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       currenciesChar = new XYChart.Series<>();
        try {
            data = archivo.Leer();
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