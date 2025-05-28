module com.decroly.vetdawexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jdk.xml.dom;


    opens com.decroly.vetdawexam to javafx.fxml;
    exports com.decroly.vetdawexam;
}