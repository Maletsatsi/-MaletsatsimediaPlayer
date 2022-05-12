module com.example.kojoana {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.kojoana to javafx.fxml;
    exports com.example.kojoana;
}