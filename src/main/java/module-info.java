module com.mycompany.scias {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.scias to javafx.fxml;
    exports com.mycompany.scias;
    opens com.mycompany.scias.view to javafx.fxml;
    exports com.mycompany.scias.view;
    opens com.mycompany.scias.presenter to javafx.fxml;
    exports com.mycompany.scias.presenter;
    opens com.mycompany.scias.model to javafx.fxml;
    exports com.mycompany.scias.model;
}
