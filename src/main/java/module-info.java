module com.mycompany.scias {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.scias to javafx.fxml;
    exports com.mycompany.scias;
}
