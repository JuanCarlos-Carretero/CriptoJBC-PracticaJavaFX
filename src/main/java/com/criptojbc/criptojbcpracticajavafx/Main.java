package com.criptojbc.criptojbcpracticajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase va a lanzar nuestra aplicacion.
 * @version v5
 * @author Jose Maria Becerra, Juan Carlos Carretero
 */
public class Main extends Application {
    /**
     * Este metodo nos permite llamar al hello-view.fxml y mostrarlo por pantalla.
     * @param stage Es la pantalla en la que se generara nuestra aplicacion.
     * @throws IOException es la clase base para excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CriptoJBC");
        stage.setScene(scene);
        stage.setMaxHeight(473);
        stage.setMaxWidth(655);
        stage.setMinHeight(473);
        stage.setMinWidth(655);
        stage.show();
    }

    /**
     * Este metodo sirve para ejecutar la aplicacion.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}