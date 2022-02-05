package com.criptojbc.criptojbcpracticajavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Data data;

    @FXML
    private ObservableList<Currencies> currenciesList;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currenciesList = FXCollections.observableArrayList();

        LectorJSON lectorJSON = new LectorJSON();
        try {
            data =  lectorJSON.JSONsimple();
            currenciesList.addAll(data.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}