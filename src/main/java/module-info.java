module com.criptojbc.criptojbcpracticajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.criptojbc.criptojbcpracticajavafx to javafx.fxml;
    exports com.criptojbc.criptojbcpracticajavafx;
}