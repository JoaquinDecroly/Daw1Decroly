module com.decroly.practicaexamen1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.decroly.practicaexamen1 to javafx.fxml;
    exports com.decroly.practicaexamen1;
}